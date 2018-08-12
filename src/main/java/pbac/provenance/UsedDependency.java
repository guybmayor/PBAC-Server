package pbac.provenance;

import pbac.base.Action;
import pbac.base.ObjectData;
import pbac.base.ObjectRole;

public class UsedDependency {

	private Action action;
	private ObjectData object;
	private ObjectRole role;
	
	public UsedDependency(Action action, ObjectData object, ObjectRole role) {
		super();
		this.action = action;
		this.object = object;
		this.role = role;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public ObjectData getObject() {
		return object;
	}

	public void setObject(ObjectData object) {
		this.object = object;
	}

	public ObjectRole getRole() {
		return role;
	}

	public void setRole(ObjectRole role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "< " + action + ", " + object + ", U" + role + " >";
	}
}
