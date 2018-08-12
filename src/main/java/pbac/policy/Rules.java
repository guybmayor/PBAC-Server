package pbac.policy;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Rules<T> {

	private List<T> rules;
	private RulesConnectOperations oper;
	
	public Rules(T rule) {
		super();
		this.rules = Arrays.asList(rule);
		this.oper = null;
	}
	
	@SuppressWarnings("unchecked")
	public Rules(List<? extends T> rules, RulesConnectOperations oper) {
		super();
		this.rules = (List<T>) rules;
		this.oper = oper;
	}

	public List<T> getRules() {
		return rules;
	}

	public void setRules(List<T> rules) {
		this.rules = rules;
	}

	public RulesConnectOperations getOper() {
		return oper;
	}

	public void setOper(RulesConnectOperations oper) {
		this.oper = oper;
	}

	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this);
		if (rules != null)
			builder.append("rules", rules);
		if (oper != null)
			builder.append("oper", oper);
		return builder.toString();
	}
}
