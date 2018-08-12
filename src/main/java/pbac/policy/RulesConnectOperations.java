package pbac.policy;

public enum RulesConnectOperations {
	AND ("∧"),
	OR("∨");
	
	private String pose;
	
	RulesConnectOperations(String pose) {
		this.pose = pose;
	}

	public String getPose() {
		return this.pose;
	}
}
