package pbac.dependency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import pbac.base.Base;
import pbac.provenance.Provenance;

public class DependencyPath {
	private List<Object> dependencyPath; // Should be built only from PathRule, DependencyPath and DependencyOperator
	private String name;
	boolean isReverse;
	
	public DependencyPath(String name, boolean isReverse) {
		this.dependencyPath = null;
		this.name = name;
		this.isReverse = isReverse;
	}
	
	public DependencyPath(List<Object> dependencyPath) {
		this.dependencyPath = dependencyPath;
		this.isReverse = false;
	}
	
	public DependencyPath(List<Object> dependencyPath, boolean isReverse) {
		this.dependencyPath = dependencyPath;
		this.isReverse = isReverse;
	}
	
	public DependencyPath(DependencyPath dependencyPath) {
		this(dependencyPath.getDependencyPath(), dependencyPath.isReverse());
	}

	public List<Base> getObjectsByPath(DependencyList dependencyList, List<Provenance> provenanceData, List<? extends Base> inputObjects) {
		
		List<Base> outObjects = new ArrayList<>();
		List<Base> originalInputObjects = new ArrayList<>(inputObjects);
		
		// get dependency path by name
		while (this.dependencyPath == null) {
			this.dependencyPath = dependencyList.getDepencency(this.name).getDependencyPath();
		}
		
		for (int i = (this.isReverse ? dependencyPath.size() - 1 : 0); 
			(this.isReverse && i >= 0) || (!this.isReverse && i < dependencyPath.size()); 
			i = (this.isReverse ? i - 1 : i +1)) { // Depending on reversing going forward or backward
			if (dependencyPath.get(i) instanceof DependencyOperator) {
				if ((DependencyOperator)dependencyPath.get(i) == DependencyOperator.ANY_OBJECT) {
					if (outObjects.isEmpty()) {
						return outObjects;
					}
					inputObjects = outObjects; 
				}	
				if ((DependencyOperator)dependencyPath.get(i) == DependencyOperator.OR) {
					if (outObjects.isEmpty()) {
						inputObjects = originalInputObjects;
					} else {
						return outObjects;
					}
				}
				if ((DependencyOperator)dependencyPath.get(i) == DependencyOperator.GROUP_START) { // only in non reverse mood
					for (int j = i +1; j < dependencyPath.size(); j++) {
						if (dependencyPath.get(j)  instanceof DependencyOperator && 
							(DependencyOperator)dependencyPath.get(j) == DependencyOperator.GROUP_END) {
							
							outObjects = new DependencyPath(dependencyPath.subList(i +1, j)).getObjectsByPath(dependencyList, provenanceData, inputObjects);
							i = j;
							break;
						}
					}
				}
				if ((DependencyOperator)dependencyPath.get(i) == DependencyOperator.GROUP_END) { // only in reverse mood
					for (int j = i -1; j >= 0; j--) {
						if (dependencyPath.get(j)  instanceof DependencyOperator && 
							(DependencyOperator)dependencyPath.get(j) == DependencyOperator.GROUP_START) {
							
							outObjects = new DependencyPath(dependencyPath.subList(j + 1, i), this.isReverse).getObjectsByPath(dependencyList, provenanceData, inputObjects);
							i = j;
							break;
						}
					}
				}
			} else {
				int nextIndex = (this.isReverse ? i - 1 : i +1);
				if (((this.isReverse && nextIndex >= 0) || (!this.isReverse && nextIndex < dependencyPath.size())) &&
						dependencyPath.get(nextIndex) instanceof DependencyOperator) { // checking if next object is multiplication operation
					if ((DependencyOperator)dependencyPath.get(nextIndex) == DependencyOperator.ZERO_OR_MORE) {
						outObjects = processZeroOrMore(dependencyPath.get(i), dependencyList, provenanceData, inputObjects);
						i = (this.isReverse ? i - 1 : i +1);
						continue;
					}
					if ((DependencyOperator)dependencyPath.get(nextIndex) == DependencyOperator.ZERO_OR_ONE) {
						outObjects = processZeroOrOne(dependencyPath.get(i), dependencyList, provenanceData, inputObjects);
						i = (this.isReverse ? i - 1 : i +1);
						continue;
					}
					if ((DependencyOperator)dependencyPath.get(nextIndex) == DependencyOperator.ONE_OR_MORE) {
						outObjects = processOneOrMore(dependencyPath.get(i), dependencyList, provenanceData, inputObjects);
						i = (this.isReverse ? i - 1 : i +1);
						continue;
					}
				} 
					
				outObjects = processOne(dependencyPath.get(i), dependencyList, provenanceData, inputObjects);
			}
		}
		
		return outObjects;
	}
	
	private List<Base> processOneOrMore(Object path, DependencyList dependencyList, List<Provenance> provenanceData, List<? extends Base> inputObjects) {
		List<Base> outputObjects  = new ArrayList<>();
		
		for (Base input : inputObjects) {
			List<Base> subOutputObjects = proccessPath(path, dependencyList, provenanceData, input);
			
			if (!subOutputObjects.isEmpty()) {
				outputObjects.addAll(processZeroOrMore(path, dependencyList, provenanceData, subOutputObjects));
			}
		}
			
		return outputObjects;
	}
	
	private List<Base> processZeroOrOne(Object path, DependencyList dependencyList, List<Provenance> provenanceData, List<? extends Base> inputObjects) {
		List<Base> outputObjects  = new ArrayList<>();
		
		for (Base input : inputObjects) {
			List<Base> subOutputObjects = proccessPath(path, dependencyList, provenanceData, input);	
		
			if (subOutputObjects.isEmpty()) {
				outputObjects.add(input);
			} else {
				outputObjects.addAll(subOutputObjects);
			}
		}
		
		return outputObjects;
	}

	private List<Base> processZeroOrMore(Object path, DependencyList dependencyList, List<Provenance> provenanceData, List<? extends Base> inputObjects) {
		List<Base> outputObjects  = new ArrayList<>();
		
		for (Base input : inputObjects) {
			List<Base> subOutputObjects = proccessPath(path, dependencyList, provenanceData, input);	
			
			if (subOutputObjects.isEmpty()) {
				outputObjects.add(input);
			} else {
				outputObjects.addAll(processZeroOrMore(path, dependencyList, provenanceData, subOutputObjects)); 
			}
		}
		
		return outputObjects;
	}

	private List<Base> processOne(Object path, DependencyList dependencyList, List<Provenance> provenanceData, List<? extends Base> inputObjects) {
		List<Base> outputObjects = new ArrayList<>();
		
		for (Base input : inputObjects) {
			outputObjects.addAll(proccessPath(path, dependencyList, provenanceData, input));
		}	
		
		return outputObjects;
	}
	
	private List<Base> proccessPath(Object path, DependencyList dependencyList, List<Provenance> provenanceData, Base inputObject) {
		if (path instanceof PathRule) {
			return ((PathRule)path).find(provenanceData, inputObject, this.isReverse);
		}
		if (path instanceof DependencyPath) {
			return ((DependencyPath)path).getObjectsByPath(dependencyList, provenanceData, Arrays.asList(inputObject));
		}
		
		return new ArrayList<>();
	}

	public List<Object> getDependencyPath() {
		return dependencyPath;
	}

	public void setDependencyPath(List<Object> dependencyPath) {
		this.dependencyPath = dependencyPath;
	}

	public boolean isReverse() {
		return isReverse;
	}

	public void setReverse(boolean isReverse) {
		this.isReverse = isReverse;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this);
		if (dependencyPath != null)
			builder.append("dependencyPath", dependencyPath);
		builder.append("isReverse", isReverse);
		return builder.toString();
	}
}
