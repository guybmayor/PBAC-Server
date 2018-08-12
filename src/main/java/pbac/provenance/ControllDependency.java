package pbac.provenance;

import pbac.base.ActingUser;
import pbac.base.Action;

public class ControllDependency {

	private Action action;
	private ActingUser user;
	
	public ControllDependency(Action action, ActingUser user) {
		super();
		this.action = action;
		this.user = user;
	}
	
	public Action getAction() {
		return action;
	}
	public void setAction(Action action) {
		this.action = action;
	}
	public ActingUser getUser() {
		return user;
	}
	public void setUser(ActingUser user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "< " + action + ", " + user + ", C >";
	}
}
