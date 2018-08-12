package pbac.policy;

public class Policy {
	private UserAuthorizationRules UARules;
	private ActionValidationRules AVRules;

	public Policy() {}
	
	public Policy(UserAuthorizationRules UARules, ActionValidationRules AVRules) {
		this.UARules = UARules;
		this.AVRules = AVRules;
	}

	public UserAuthorizationRules getUARules() {
		return UARules;
	}

	public void setUARules(UserAuthorizationRules UARules) {
		this.UARules = UARules;
	}

	public ActionValidationRules getAVRules() {
		return AVRules;
	}

	public void setAVRules(ActionValidationRules AVRules) {
		this.AVRules = AVRules;
	}
}
