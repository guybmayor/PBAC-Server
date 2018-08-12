package pbac.base;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import pbac.policy.Policy;

public class ActionType {
	
	private String name;
	private List<ObjectRole> roles;
	private Policy policy;
	private boolean isIncreaseObjetVersion;
	
	public ActionType() {}
	
	public ActionType(String name, List<ObjectRole> roles, Policy policy, boolean isIncreaseObjetVersion) {
		super();
		this.name = name;
		this.roles = roles;
		this.policy = policy;
		this.isIncreaseObjetVersion = isIncreaseObjetVersion;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<ObjectRole> getRoles() {
		return roles;
	}
	public void setRoles(List<ObjectRole> roles) {
		this.roles = roles;
	}
	public Policy getPolicy() {
		return policy;
	}
	public void setPolicy(Policy policy) {
		this.policy = policy;
	}
		
	public boolean isIncreaseObjetVersion() {
		return isIncreaseObjetVersion;
	}

	public void setIncreaseObjetVersion(boolean isIncreaseObjetVersion) {
		this.isIncreaseObjetVersion = isIncreaseObjetVersion;
	}

	// Only by name
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	// Only by name
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ActionType other = (ActionType) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this);
		if (name != null)
			builder.append("name", name);
		if (roles != null)
			builder.append("roles", roles);
		if (policy != null)
			builder.append("policy", policy);
		builder.append("isIncreaseObjetVersion", isIncreaseObjetVersion);
		return builder.toString();
	}
}
