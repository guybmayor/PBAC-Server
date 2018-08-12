package pbac.dependency;

public enum DependencyOperator {
	OR ("|"),
	GROUP_START ("("),
	GROUP_END (")"),
	ZERO_OR_MORE ("*"),
	ZERO_OR_ONE ("?"),
	ONE_OR_MORE ("+"),
	ANY_OBJECT (".");
	
	private String pose;
	
	DependencyOperator(String pose) {
		this.pose = pose;
	}

	public String getPose() {
		return this.pose;
	}
}
