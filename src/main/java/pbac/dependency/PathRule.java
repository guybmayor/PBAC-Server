package pbac.dependency;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import pbac.base.Action;
import pbac.base.Base;
import pbac.base.ObjectData;
import pbac.base.ObjectRole;
import pbac.provenance.Provenance;
import pbac.provenance.ProvenanceDependencyType;

public class PathRule {
	private ObjectRole objectRole;
	private ProvenanceDependencyType depandencyName;
	
	public PathRule(ObjectRole objectRole, ProvenanceDependencyType depandencyName) {
		super();
		this.objectRole = objectRole;
		this.depandencyName = depandencyName;
	}
	
	public List<Base> find(List<Provenance> provenanceData, Base inputObject, boolean isReverse) {
		List<Base> objects = new ArrayList<>();
		Base object = null;
		
		for (Provenance provenance : provenanceData) {
			object = null;
			
			switch (depandencyName) {
			case CONTROLL:
				if (isReverse && (object  = provenance.getReverseControlled((ObjectData)inputObject)) != null) 
					objects.add(object);
				if (!isReverse && (object  = provenance.getControlled((Action)inputObject)) != null) 
					objects.add(object);
				break;
			case USE:
				if (isReverse && (object  = provenance.getReverseUsed((ObjectData)inputObject, this.objectRole)) != null)
					objects.add(object);
				if (!isReverse && (object  = provenance.getUsed((Action)inputObject, this.objectRole)) != null)
					objects.add(object);
				break;
			case GENERATE:
				if (isReverse && (object  = provenance.getReverseGenerated((Action)inputObject, this.objectRole)) != null)
					objects.add(object);
				if (!isReverse && (object  = provenance.getGenerated((ObjectData)inputObject, this.objectRole)) != null)
					objects.add(object);
				break;
			}
		}

		return objects;
	}
	
	public ProvenanceDependencyType getDepandencyName() {
		return depandencyName;
	}
	public void setDepandencyName(ProvenanceDependencyType depandencyName) {
		this.depandencyName = depandencyName;
	}
		
	public ObjectRole getObjRole() {
		return objectRole;
	}

	public void setObjRole(ObjectRole objRole) {
		this.objectRole = objRole;
	}

	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this);
		if (objectRole != null)
			builder.append("objectRole", objectRole);
		if (depandencyName != null)
			builder.append("depandencyName", depandencyName);
		return builder.toString();
	}
}
