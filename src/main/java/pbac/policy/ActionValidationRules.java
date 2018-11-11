package pbac.policy;

import java.util.List;

import pbac.base.RequestObject;
import pbac.dependency.DependencyList;
import pbac.provenance.Provenance;

public class ActionValidationRules extends Rules<ActionValidationRuleValidation> implements ActionValidationRuleValidation {

	public ActionValidationRules(ActionValidationRuleValidation rule) {
		super(rule);
	}
	
	public ActionValidationRules(List<? extends ActionValidationRuleValidation> rules, RulesConnectOperations oper) {
		super(rules, oper);
	}
	
	public boolean validate(DependencyList dependencyList, List<Provenance> provenanceData, List<RequestObject> objects) {
		for (ActionValidationRuleValidation rule : getRules()) {
			if (rule.validate(dependencyList, provenanceData, objects)) {
				if (getOper() == null || getOper() == RulesConnectOperations.OR) {
					return true;
				}
			} else {
				if (getOper() == null || getOper() == RulesConnectOperations.AND) {
					return false;
				}
			}
		}
		
		if (getOper() == RulesConnectOperations.OR) // all the rules are false
			return false;
		
		return true;
	}
}
