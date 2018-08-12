package server.services;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import pbac.base.ActingUser;
import pbac.base.Action;
import pbac.base.ActionType;
import pbac.base.EntityCreator;
import pbac.base.Request;
import pbac.base.RequestObject;
import pbac.cases.CaseStudy;
import pbac.cases.JsonCaseStudy;
import pbac.provenance.Provenance;
import pbac.provenance.Transaction;

@Service
//@Scope("session")
public class PbacService {

	private Map<String, CaseStudy> cases;
//	private List<ActingUser> users = new ArrayList<>();

	private CaseStudy getCase(String caseName) {
		return cases.get(caseName);
	}
	
	public void setCases(Map<String, CaseStudy> cases) {
		this.cases = cases;
	}
	
	public List<ActionType> readAllActionTypes (String caseName) {
		CaseStudy cs = getCase(caseName);
		if (cs == null)
			return null;
		
		return cs.getAllActionTypes();
	}

	public Set<String> findAllName() {
		return this.cases.keySet();
	}

	public ActingUser createUser() {
		ActingUser user = EntityCreator.user();
		return user;
}

	public Transaction processRequest(String caseName, Long userId, String actionTypeName, List<RequestObject> objects) {
		CaseStudy cs = getCase(caseName);
		if (cs == null)
			return null;
		
		try {
			ActingUser user = new ActingUser(userId);
			Action action = EntityCreator.action(cs.getActionType(actionTypeName));
			Request request = new  Request(user, action, objects);
			return cs.addTransaction(request);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public Provenance getLastProvenanceData(String caseName) {
		CaseStudy cs = getCase(caseName);
		if (cs == null || cs.getProvenanceData() == null || cs.getProvenanceData().isEmpty()) {
			return null;
		}
		
		return cs.getProvenanceData().get(cs.getProvenanceData().size() - 1);
	}

	public boolean initAll() {
		EntityCreator.init();
		
		for (CaseStudy caseStusy : cases.values()) {
			caseStusy.initTransactions();
		}
		return true;
	}

	public void addCase(JsonCaseStudy cse) {
		cases.put(cse.getCaseName(), cse);
	}
}

