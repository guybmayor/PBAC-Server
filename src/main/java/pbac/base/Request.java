package pbac.base;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Request {

	private ActingUser user;
	private Action action;
	private List<RequestObject> objects;
	
	public Request() {}
	
	public Request(ActingUser user, Action action, List<RequestObject> objects) {
		super();
		this.user = user;
		this.action = action;
		this.objects = objects;
	}
	
	public ActingUser getUser() {
		return user;
	}
	public void setUser(ActingUser user) {
		this.user = user;
	}
	public Action getAction() {
		return action;
	}
	public void setAction(Action action) {
		this.action = action;
	}
	public List<RequestObject> getObjects() {
		return objects;
	}
	public void setObjects(List<RequestObject> objects) {
		this.objects = objects;
	}
	
	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this);
		if (user != null)
			builder.append("user", user);
		if (action != null)
			builder.append("action", action);
		if (objects != null)
			builder.append("objects", objects);
		return builder.toString();
	}
}
