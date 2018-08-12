package pbac.policy;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import pbac.base.*;
import pbac.dependency.DependencyList;
import pbac.dependency.DependencyPath;
import pbac.provenance.Provenance;

public class ActionValidationObjectRule implements ActionValidationRuleValidation {

	private AVObjectRuleOperators operator;
	private Rule leftRule;
	private Rule rigthRule;
	
	public ActionValidationObjectRule(AVObjectRuleOperators operator, DependencyPath leftDepencency, DependencyPath rigthDepencency) {
		super();
		this.operator = operator;
		this.leftRule = new Rule(leftDepencency);
		this.rigthRule = new Rule(rigthDepencency);
	}
	
	public ActionValidationObjectRule(AVObjectRuleOperators operator, DependencyPath leftDepencency, ObjectRole leftRelevantObjectRole,
			DependencyPath rigthDepencency, ObjectRole rigthRelevantObjectRole) {
		super();
		this.operator = operator;
		this.leftRule = new Rule(leftDepencency, leftRelevantObjectRole);
		this.rigthRule = new Rule(rigthDepencency, rigthRelevantObjectRole);
	}
	
	public boolean validate(DependencyList dependencyList, List<Provenance> provenanceData, List<RequestObject> objects) {
		ObjectData leftObject = leftRule.getRelevatObject(objects);
		if (leftObject == null) {
			System.out.println("Error, failed to find relevant object of left rule");
			return false;	
		}
		List<Base> leftOutput = leftRule.getDepencency().getObjectsByPath(dependencyList, provenanceData, Arrays.asList(leftObject));
		int leftSize = (leftOutput == null ? 0 : leftOutput.size());

		ObjectData rigthObject = rigthRule.getRelevatObject(objects);
		if (rigthObject == null) {
			System.out.println("Error, failed to find relevant object of rigth rule");
			return false;	
		}
		List<Base> rigthOutput = rigthRule.getDepencency().getObjectsByPath(dependencyList, provenanceData, Arrays.asList(rigthObject));
		int rigthSize = (rigthOutput == null ? 0 : rigthOutput.size());

		switch (operator) {
			case EQUAL:
				if (leftSize == rigthSize && rigthSize == 0)
					return true;
				
				if (leftSize != rigthSize)
					return false;
				
				for (Base obj : leftOutput) {
					if (!rigthOutput.contains(obj)) {
						return false;
					}
				}
				return true;
				
			case NOT_EQUAL:
				if (leftSize == rigthSize && rigthSize == 0)
					return false;
				
				if (leftSize != rigthSize || leftOutput == null || rigthOutput == null)
					return true;
				
				for (Base obj : leftOutput) {
					if (!rigthOutput.contains(obj)) {
						return true;
					}
				}
				return false;
				
			case CONTAINED:
				if (leftSize == rigthSize && rigthSize == 0)
					return true;
				
				if (rigthSize == 0 || leftSize > rigthSize) 
					return false;

				for (Base obj : leftOutput) {
					if (!rigthOutput.contains(obj)) {
						return false;
					}
				}
				return true;
		}
		
		return false;
	}
	
	public AVObjectRuleOperators getOperator() {
		return operator;
	}
	public void setOperator(AVObjectRuleOperators operator) {
		this.operator = operator;
	}
	public Rule getLeftRule() {
		return leftRule;
	}
	public void setLeftRule(Rule leftRule) {
		this.leftRule = leftRule;
	}
	public Rule getRigthRule() {
		return rigthRule;
	}

	public void setRigthRule(Rule rigthRule) {
		this.rigthRule = rigthRule;
	}

	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this);
		if (operator != null)
			builder.append("operator", operator);
		if (leftRule != null)
			builder.append("leftRule", leftRule);
		if (rigthRule != null)
			builder.append("rigthRule", rigthRule);
		return builder.toString();
	}
}
