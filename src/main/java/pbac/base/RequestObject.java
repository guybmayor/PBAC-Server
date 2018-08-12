package pbac.base;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class RequestObject {
	private ObjectData object;
	private ObjectRole role;
	
	public RequestObject() {}
	
	public RequestObject(ObjectData object, ObjectRole role) {
		this.object = object;
		this.role = role;
		this.role.setInput(true); // all request object are considered as input.
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
		ToStringBuilder builder = new ToStringBuilder(this);
		if (object != null)
			builder.append("object", object);
		if (role != null)
			builder.append("role", role);
		return builder.toString();
	}
}
