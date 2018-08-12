package server.controllers;

import java.util.List;

import pbac.base.RequestObject;

public class RequestWrapper {

	private Long userId; 
	private String actionTypeName;
	private List<RequestObject> objects;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getActionTypeName() {
		return actionTypeName;
	}
	public void setActionTypeName(String actionTypeName) {
		this.actionTypeName = actionTypeName;
	}
	public List<RequestObject> getObjects() {
		return objects;
	}
	public void setObjects(List<RequestObject> objects) {
		this.objects = objects;
	}
}
