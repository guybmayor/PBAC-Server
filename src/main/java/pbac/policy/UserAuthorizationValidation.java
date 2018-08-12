package pbac.policy;

import java.util.List;

import pbac.base.ActingUser;
import pbac.base.RequestObject;
import pbac.dependency.DependencyList;
import pbac.provenance.Provenance;

public interface UserAuthorizationValidation {
	public boolean validate(DependencyList dependencyList, List<Provenance> provenanceData, ActingUser user,  List<RequestObject> objects);
}
