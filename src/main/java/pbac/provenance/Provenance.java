package pbac.provenance;

import java.util.ArrayList;
import java.util.List;

import pbac.base.ActingUser;
import pbac.base.Action;
import pbac.base.ObjectData;
import pbac.base.ObjectRole;

public class Provenance {

	private ControllDependency controllDependency;
	private List<UsedDependency> usedDependencies;
	private List<GeneratedDependency> generatedDependencies;
	
	public Provenance(Transaction transaction) {
		this.usedDependencies = new ArrayList<>();
		this.generatedDependencies = new ArrayList<>();
		
		try {
			this.setControllDependency(new ControllDependency(transaction.getAction(), transaction.getUser()));
			List<ObjectRole> roles = transaction.getAction().getType().getRoles();
			int roleIndex = 0;
			for (ObjectData object : transaction.getInputObjects()) {
				this.usedDependencies.add(new UsedDependency(transaction.getAction(), object, roles.get(roleIndex)));
				roleIndex++;
			}
			
			for (ObjectData object : transaction.getOutputObjects()) {
				this.generatedDependencies.add(new GeneratedDependency(object, transaction.getAction(), roles.get(roleIndex)));
				roleIndex++;
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	public ObjectData getUsed(Action action, ObjectRole role) {
		for (UsedDependency usedDependency : usedDependencies) {
			if (usedDependency.getAction().equals(action) && usedDependency.getRole().equals(role)) {
				return usedDependency.getObject();
			}
		}
		
		return null;
	}
	
	public Action getReverseUsed(ObjectData obj, ObjectRole role) {
		for (UsedDependency usedDependency : usedDependencies) {
			if (usedDependency.getObject().equals(obj) && usedDependency.getRole().equals(role)) {
				return usedDependency.getAction();
			}
		}
		
		return null;
	}
	
	public Action getGenerated(ObjectData obj, ObjectRole role) {
		for (GeneratedDependency generatedDependency : generatedDependencies) {
			if (generatedDependency.getObject().equals(obj) && generatedDependency.getRole().equals(role)) {
				return generatedDependency.getAction();
			}
		}
		
		return null;
	}

	public ObjectData getReverseGenerated(Action action, ObjectRole role) {
		for (GeneratedDependency generatedDependency : generatedDependencies) {
			if (generatedDependency.getAction().equals(action) && generatedDependency.getRole().equals(role)) {
				return generatedDependency.getObject();
			}
		}
		
		return null;
	}
	
	public ActingUser getControlled(Action action) {
		if (controllDependency.getAction().equals(action)) {
			return controllDependency.getUser();
		}
		
		return null;
	}
	
	public Action getReverseControlled(ObjectData obj) {
		if (controllDependency.getUser().equals(obj)) {
			return controllDependency.getAction();
		}
		
		return null;
	}

	public ControllDependency getControllDependency() {
		return controllDependency;
	}

	public void setControllDependency(ControllDependency controllDependency) {
		this.controllDependency = controllDependency;
	}

	public List<UsedDependency> getUseDependencies() {
		return usedDependencies;
	}

	public void setUseDependencies(List<UsedDependency> useDependencies) {
		this.usedDependencies = useDependencies;
	}

	public List<GeneratedDependency> getGeneratedDependencies() {
		return generatedDependencies;
	}

	public void setGeneratedDependencies(List<GeneratedDependency> generatedDependencies) {
		this.generatedDependencies = generatedDependencies;
	}

	@Override
	public String toString() {
		String str = controllDependency.toString();
		
		if (usedDependencies != null && !usedDependencies.isEmpty()) {
			for (UsedDependency dependency : usedDependencies) {
				str += ", " + dependency.toString();
			}
		}
		
		if (generatedDependencies != null && !generatedDependencies.isEmpty()) {
			for (GeneratedDependency dependency : generatedDependencies) {
				str += ", " + dependency.toString();
			}
		}

		return str;
	}
}
