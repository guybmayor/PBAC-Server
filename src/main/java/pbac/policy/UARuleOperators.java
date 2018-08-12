package pbac.policy;

public enum UARuleOperators {
	INCLUDE ("∈"),
	NOT_INCLUDE ("∉");
	
	private String pose;
	
	UARuleOperators(String pose) {
		this.pose = pose;
	}

	public String getPose() {
		return this.pose;
	}
}
