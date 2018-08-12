package pbac.provenance;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import pbac.base.ActingUser;
import pbac.base.Action;
import pbac.base.ActionType;
import pbac.base.EntityCreator;
import pbac.base.ObjectData;
import pbac.base.Request;

public class Transaction {

	private ActingUser user;
	private Action action;
	private List<ObjectData> inputObjects;
	private List<ObjectData> outputObjects;
	
	public Transaction(ActingUser user, Action action, List<ObjectData> inputObjects, List<ObjectData> outputObjects) {
		this.user = user;
		this.action = action;
		this.inputObjects = inputObjects;
		this.outputObjects = outputObjects;
	}
	
	public Transaction(Request req) {
		this.user = req.getUser();
		this.action = req.getAction();
		if (req.getObjects() == null || req.getObjects().size() == 0) {
			this.inputObjects = new ArrayList<>();
		} else {
			this.inputObjects = req.getObjects().stream().map(o -> o.getObject()).collect(Collectors.toList());
		}
		
		this.outputObjects = new ArrayList<>();
		ActionType type = this.action.getType();
		int[] idx = { 0 };
		type.getRoles().stream().filter(r -> !r.isInput()).forEach(role -> {
			if (type.isIncreaseObjetVersion() && !inputObjects.isEmpty()) {
				outputObjects.add(EntityCreator.objectVersion(inputObjects.get(idx[0]++))); 
			} else {
				outputObjects.add(EntityCreator.object()); 
			}
		});
	}

	public ActingUser getUser() {
		return user;
	}
	public void setUser(ActingUser user) {
		this.user = user;
	}
	public Action getAction() {
		return action;
	}
	public void setAction(Action action) {
		this.action = action;
	}
	public List<ObjectData> getInputObjects() {
		return inputObjects;
	}
	public void setInputObjects(List<ObjectData> inputObjects) {
		this.inputObjects = inputObjects;
	}
	public List<ObjectData> getOutputObjects() {
		return outputObjects;
	}
	public void setOutputObjects(List<ObjectData> outputObjects) {
		this.outputObjects = outputObjects;
	}
	
	@Override
	public String toString() {
		String str = "(" + user.toString() + ", " + action.toString();
		
		if (inputObjects != null && !inputObjects.isEmpty()) {
			for (ObjectData objectData : inputObjects) {
				str += ", " + objectData.toString();
			}
		}
		
		if (outputObjects != null && !outputObjects.isEmpty()) {
			for (ObjectData objectData : outputObjects) {
				str += ", " + objectData.toString();
			}
		}
		
		str += ")";
		return str;
	}
}