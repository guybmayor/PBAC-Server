package pbac.base;

import pbac.base.Request;
import pbac.cases.CaseStudy;
import pbac.policy.ActionValidationRules;
import pbac.policy.Policy;
import pbac.policy.UserAuthorizationRules;

public class AccessEvaluation {

	public static boolean validateAccess(CaseStudy conf, Request req) {
		Policy policy = conf.getPolicy(req.getAction().getType());
		
		UserAuthorizationRules UARules = policy.getUARules();
		if (UARules != null && !UARules.validate(conf.getDependencyList(), conf.getProvenanceData(), req.getUser(), req.getObjects())) {
				return false;
		}
		
		ActionValidationRules AVRules = policy.getAVRules();
		if (AVRules != null && !AVRules.validate(conf.getDependencyList(), conf.getProvenanceData(), req.getObjects())) {
				return false;
		}
		
		return true;
	}
}
