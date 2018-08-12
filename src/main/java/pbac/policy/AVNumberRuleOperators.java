package pbac.policy;

public enum AVNumberRuleOperators {
	EQUAL ("="),
	NOT_EQUAL ("≠"),
	BIG_EQUAL ("≥"),
	BIG (">"),
	SMALL_EQUAL ("≤"),
	SMALL ("<");
	
	private String pose;
	
	AVNumberRuleOperators(String pose) {
		this.pose = pose;
	}

	public String getPose() {
		return this.pose;
	}
}
