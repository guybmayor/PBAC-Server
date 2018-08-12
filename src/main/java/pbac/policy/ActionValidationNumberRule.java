package pbac.policy;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import pbac.base.*;
import pbac.dependency.DependencyList;
import pbac.dependency.DependencyPath;
import pbac.provenance.Provenance;

public class ActionValidationNumberRule extends Rule implements ActionValidationRuleValidation {

	private AVNumberRuleOperators operator;
	private int number;
	
	public ActionValidationNumberRule(AVNumberRuleOperators operator, int number, DependencyPath depencency) {
		super(depencency);
		this.operator = operator;
		this.number = number;
	}
	
	public ActionValidationNumberRule(AVNumberRuleOperators operator, int number, DependencyPath depencency, ObjectRole relevantObjectRole) {
		super(depencency, relevantObjectRole);
		this.operator = operator;
		this.number = number;
	}

	public boolean validate(DependencyList dependencyList, List<Provenance> provenanceData, List<RequestObject> objects) {
		ObjectData object = getRelevatObject(objects);
		if (object == null) {
			System.out.println("Error, failed to find relevant object");
			return false;	
		}
		
		List<Base> output = this.getDepencency().getObjectsByPath(dependencyList, provenanceData, Arrays.asList(object));
		
		int size = (output == null ? 0 : output.size());

		switch (operator) {
			case EQUAL:
				return size == this.number;
			case NOT_EQUAL:
				return size != this.number;
			case BIG_EQUAL:
				return size >= this.number;
			case BIG:
				return size > this.number;
			case SMALL_EQUAL:
				return size <= this.number;
			case SMALL:
				return size < this.number;
		}
		
		return false;
	}
	
	public AVNumberRuleOperators getOperator() {
		return operator;
	}
	public void setOperator(AVNumberRuleOperators operator) {
		this.operator = operator;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this);
		if (operator != null)
			builder.append("operator", operator);
		builder.append("number", number);
		return builder.toString();
	}
}
