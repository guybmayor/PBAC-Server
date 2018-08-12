package pbac.dependency;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class DependencyList {
	private Map<String, DependencyPath> depencencies;

	public DependencyList() {
		this.depencencies = new HashMap<>();
	}

	public void addDependency(String name, DependencyPath dependencyPath) {
		this.depencencies.put(name, dependencyPath);
	}
	
	public DependencyPath getDepencency(String name) {
		return this.depencencies.get(name);
	}
	
	public DependencyPath getReversedDepencency(String name) {
		DependencyPath dep = new DependencyPath(depencencies.get(name));
		dep.setReverse(true);
		
		return dep;
	}

	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this);
		if (depencencies != null)
			builder.append("depencencies", depencencies);
		return builder.toString();
	}
}
