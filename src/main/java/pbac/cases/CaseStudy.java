package pbac.cases;

import java.util.ArrayList;
import java.util.List;

import pbac.base.AccessEvaluation;
import pbac.base.ActionType;
import pbac.base.ObjectData;
import pbac.base.Request;
import pbac.dependency.DependencyList;
import pbac.policy.Policy;
import pbac.provenance.Provenance;
import pbac.provenance.Transaction;

public abstract class CaseStudy {

	protected DependencyList dependencyList;
	protected List<ActionType> actionTypes;
	protected List<Provenance> provenanceData;
	
	protected CaseStudy() {
		actionTypes = new ArrayList<>();
		provenanceData = new ArrayList<>();
	}
		
	public Policy getPolicy(ActionType at) {
		for (ActionType actionType : actionTypes) {
			if (at.equals(actionType))
				return at.getPolicy();
		}
		
		return null;
	}
	
	public List<Provenance> getProvenanceData() {
		return provenanceData;
	}
	
	public DependencyList getDependencyList() {
		return dependencyList;
	}

	public ActionType getActionType(String name) {
		for (ActionType actionType : actionTypes) {
			if (actionType.getName().equals(name))
				return actionType;
		}
		
		return null;
	}

	public Transaction addTransaction(Request req) {
		Transaction output = null;
				
		if (AccessEvaluation.validateAccess(this, req)) {
			output = new Transaction(req);
//			output = transaction.getOutputObjects();
			Provenance provenance = new Provenance(output);
			provenanceData.add(provenance);
//			System.out.printf("%d) %s: %s%n", provenanceData.size(), transaction, provenance);
		} else {
			System.out.println("Request is not vaild.");
		}
		
		return output;
	}
	
	public List<ObjectData> addTransactionAndGetObjects(Request req) {
		List<ObjectData> output = null;
				
		if (AccessEvaluation.validateAccess(this, req)) {
			Transaction transaction = new Transaction(req);
			output = transaction.getOutputObjects();
			Provenance provenance = new Provenance(transaction);
			provenanceData.add(provenance);
			System.out.printf("%d) %s: %s%n", provenanceData.size(), transaction, provenance);
		} else {
			System.out.println("Request is not vaild.");
		}
		
		return output;
	}
	public List<ActionType> getAllActionTypes() {
		return this.actionTypes;
	}

	public void initTransactions() {
		provenanceData = new ArrayList<>();
	}
}
