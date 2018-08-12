package pbac.policy;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import pbac.base.ActingUser;
import pbac.base.Base;
import pbac.base.ObjectData;
import pbac.base.ObjectRole;
import pbac.base.RequestObject;
import pbac.dependency.DependencyList;
import pbac.dependency.DependencyPath;
import pbac.provenance.Provenance;

public class UserAuthorizationRule extends Rule implements UserAuthorizationValidation {

	private UARuleOperators operator;
	
	public UserAuthorizationRule(UARuleOperators operator, DependencyPath depencency) {
		super(depencency);
		this.operator = operator;
	}
	
	public UserAuthorizationRule(UARuleOperators operator, DependencyPath depencency, ObjectRole relevantObjectRole) {
		super(depencency, relevantObjectRole);
		this.operator = operator;
	}

	public boolean validate(DependencyList dependencyList, List<Provenance> provenanceData, ActingUser user, List<RequestObject> objects) {
		ObjectData object = getRelevatObject(objects);
		if (object == null) {
			System.out.println("Error, failed to find relevant object");
			return false;	
		}
		
		List<Base> output = this.getDepencency().getObjectsByPath(dependencyList, provenanceData, Arrays.asList(object));
		
		switch (operator) {
			case INCLUDE:
				if (output == null || output.isEmpty()) {
					return false;
				}
				
				for (Base outUser : output) {
					if ((user.equals((ActingUser)outUser))) {
						return true;
					}
				}
				return false;
	
			case NOT_INCLUDE:
				if (output == null || output.isEmpty()) {
					return true;
				}
				
				for (Base outUser : output) {
					if ((user.equals((ActingUser)outUser))) {
						return false;
					}
				}
				return true;
		}
		
		return false;
	}

	public UARuleOperators getOperator() {
		return operator;
	}
	public void setOperator(UARuleOperators operator) {
		this.operator =operator;
	}

	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this);
		if (operator != null)
			builder.append("operator", operator);
		return builder.toString();
	}
}
