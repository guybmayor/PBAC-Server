package pbac.policy;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import pbac.base.ObjectData;
import pbac.base.ObjectRole;
import pbac.base.RequestObject;
import pbac.dependency.DependencyPath;

public class Rule {
	
	private DependencyPath depencency;
	private ObjectRole relevantObjectRole;
	
	public Rule() {}
	
	public Rule(DependencyPath depencency) {
		super();
		this.depencency = depencency;
		this.relevantObjectRole = null;
	}

	public Rule(DependencyPath depencency, ObjectRole relevantObjectRole) {
		super();
		this.depencency = depencency;
		this.relevantObjectRole = relevantObjectRole;
	}
	
	public ObjectData getRelevatObject( List<RequestObject> objects) {
		if (this.relevantObjectRole == null) {
			if (objects.size() == 1) {
				return (ObjectData) objects.get(0).getObject();
			} else {
				return null;
			}
		}
		
		for (RequestObject element : objects) {
			if (element.getRole().equals(this.relevantObjectRole)) {
				return element.getObject();
			}
		}
		return null;
	}

	public DependencyPath getDepencency() {
		return depencency;
	}

	public void setDepencency(DependencyPath depencency) {
		this.depencency = depencency;
	}

	public ObjectRole getRelevantObjectRole() {
		return relevantObjectRole;
	}

	public void setRelevantObjectRole(ObjectRole relevantObjectRole) {
		this.relevantObjectRole = relevantObjectRole;
	}

	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this);
		if (depencency != null)
			builder.append("depencency", depencency);
		if (relevantObjectRole != null)
			builder.append("relevantObjectRole", relevantObjectRole);
		return builder.toString();
	}	
}
