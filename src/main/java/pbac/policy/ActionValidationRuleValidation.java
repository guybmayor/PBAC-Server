package pbac.policy;

import java.util.List;

import pbac.base.RequestObject;
import pbac.dependency.DependencyList;
import pbac.provenance.Provenance;

public interface ActionValidationRuleValidation {

	public boolean validate(DependencyList dependencyList, List<Provenance> provenanceData, List<RequestObject> objects);
}
