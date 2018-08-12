package pbac.policy;

public enum AVObjectRuleOperators {
	EQUAL ("="),
	NOT_EQUAL ("≠"),
	CONTAINED ("⊆");
	
	private String pose;
	
	AVObjectRuleOperators(String pose) {
		this.pose = pose;
	}

	public String getPose() {
		return this.pose;
	}
}
