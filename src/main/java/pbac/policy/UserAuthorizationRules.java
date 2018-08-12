package pbac.policy;

import java.util.List;

import pbac.base.ActingUser;
import pbac.base.RequestObject;
import pbac.dependency.DependencyList;
import pbac.provenance.Provenance;

public class UserAuthorizationRules extends Rules<UserAuthorizationValidation> implements UserAuthorizationValidation {

	public UserAuthorizationRules(UserAuthorizationValidation rule) {
		super(rule);
	}
	
	public UserAuthorizationRules(List<? extends UserAuthorizationValidation> rules, RulesConnectOperations oper) {
		super(rules, oper);
	}
	
	public boolean validate(DependencyList dependencyList, List<Provenance> provenanceData, ActingUser user,  List<RequestObject> objects) {
		for (UserAuthorizationValidation rule : getRules()) {
			if (rule.validate(dependencyList, provenanceData, user, objects)) {
				if (getOper() == null || getOper() == RulesConnectOperations.OR) {
					return true;
				}
			} else {
				if (getOper() == null || getOper() == RulesConnectOperations.AND) {
					return false;
				}
			}
		}
		
		return true;
	}
}
