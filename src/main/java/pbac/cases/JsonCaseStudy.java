package pbac.cases;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import pbac.base.ActionType;
import pbac.base.ObjectRole;
import pbac.dependency.DependencyList;
import pbac.dependency.DependencyPath;
import pbac.dependency.DependencyOperator;
import pbac.dependency.PathRule;
import pbac.policy.AVNumberRuleOperators;
import pbac.policy.AVObjectRuleOperators;
import pbac.policy.ActionValidationNumberRule;
import pbac.policy.ActionValidationObjectRule;
import pbac.policy.ActionValidationRuleValidation;
import pbac.policy.ActionValidationRules;
import pbac.policy.Policy;
import pbac.policy.RulesConnectOperations;
import pbac.policy.UARuleOperators;
import pbac.policy.UserAuthorizationRule;
import pbac.policy.UserAuthorizationRules;
import pbac.policy.UserAuthorizationValidation;
import pbac.provenance.ProvenanceDependencyType;

public class JsonCaseStudy extends CaseStudy {
	
	private String caseName;
	
	public JsonCaseStudy(String string) throws Exception {
		super();

		JSONObject object = new JSONObject(string);
		load(object);
	}
		
	
	public JsonCaseStudy(Path path) {
		super();
		
	    StringBuilder data = new StringBuilder();
	    try (Stream<String> lines = Files.lines(path)) {
		    lines.forEach(line -> data.append(line).append("\n"));
		    lines.close();
		    
		    JSONObject object = new JSONObject(data.toString());
		    
		    load(object);
		   
	    } catch (Exception e) {
	    	System.out.println("Failed to load case from path " + path.getFileName() + ". " + e.getMessage());
	    }
	}
	
	private void load(JSONObject object) throws Exception {
	    caseName = object.getString("name");
	    if (caseName == null) {
	    	throw new Exception("Case name is invaild.");
	    }
	    
	    // dependency list 
	    this.dependencyList = loadDependencyList(object.getJSONObject("dependencyList"));
	    
		// Load actions types
	    this.actionTypes = loadActionTypes(object.getJSONObject("actionTypes"));
	   
	}

	private DependencyList loadDependencyList(JSONObject dependencyListObj) throws JSONException {
		DependencyList dependencyList = new DependencyList();
	    Map<String, JSONObject> dependencyListMap = new HashMap<>();

	    @SuppressWarnings("unchecked")
		Iterator<String> keysItr = dependencyListObj.keys();
	    while(keysItr.hasNext()) {
	        String key = keysItr.next();
	        JSONObject value = dependencyListObj.getJSONObject(key);
	        dependencyListMap.put(key, value);
	    }
	    
	    for (Entry<String, JSONObject> dep : dependencyListMap.entrySet()) {
	    	ArrayList<Object> dependencyPath = loadDepencencyPathList(dep.getValue().getJSONArray("dependencyPath"));

	    	dependencyList.addDependency(dep.getKey(), 
	    			new DependencyPath(dependencyPath, 
	    					dep.getValue().has("isReverse") ? dep.getValue().getBoolean("isReverse") : false));
		}

	    return dependencyList;
	}
	
	private List<ActionType> loadActionTypes(JSONObject actionTypesObject) throws JSONException {
		List<ActionType> actionTypes = new ArrayList<>();
		Map<String, JSONObject> actionTypesMap = new HashMap<>();

	    @SuppressWarnings("unchecked")
		Iterator<String> keysItr = actionTypesObject.keys();
	    while(keysItr.hasNext()) {
	        String key = keysItr.next();
	        JSONObject value = actionTypesObject.getJSONObject(key);
	        actionTypesMap.put(key, value);
	    }
	    
	    for (Entry<String, JSONObject> dep : actionTypesMap.entrySet()) {
	    	// name
	    	String name = dep.getKey();
	    	
	    	// roles
	    	ArrayList<ObjectRole> roles = new ArrayList<>();
	    	JSONArray rolesArr = dep.getValue().getJSONArray("roles");
	    	for (int i = 0 ; i < rolesArr.length(); i++) {
	    		JSONObject element = (JSONObject) rolesArr.get(i);
	    		roles.add(new ObjectRole(
	    				element.getString("name"),
	    				element.has("isInput") ? element.getBoolean("isInput") : false));
	    	}
    
		    // policy
	    	Policy policy = new Policy();
	    	if (dep.getValue().has("policy")) {
		    	JSONObject policyObj = dep.getValue().getJSONObject("policy");
		    	UserAuthorizationRules UARules = null;
		    	ActionValidationRules AVRules = null;
		    	if (policyObj.has("UARules")) {
		    		UARules = loadUserAuthorizationRules(policyObj.getJSONObject("UARules"));
		    	}
		    	if (policyObj.has("AVRules")) {
		    		AVRules = loadActionValidationRules(policyObj.getJSONObject("AVRules"));
		    	}
		    	
		    	policy = new Policy(UARules, AVRules);
	    	}
	    	
	    	// isIncreaseObjetVersion
	    	boolean isIncreaseObjetVersion = dep.getValue().has("isIncreaseObjetVersion") ? 
	    			dep.getValue().getBoolean("isIncreaseObjetVersion") : false;
	    			
	    			
			actionTypes.add(new ActionType(name, roles, policy, isIncreaseObjetVersion));
	    }
	    
	    return actionTypes;
	}
	
	private UserAuthorizationRules loadUserAuthorizationRules(JSONObject UARulesObject) throws JSONException {
		List<UserAuthorizationValidation> rules = new ArrayList<>();
		
		JSONArray UARulesArr = UARulesObject.getJSONArray("rules");
    	for (int i = 0 ; i < UARulesArr.length(); i++) {
    		JSONObject element = (JSONObject) UARulesArr.get(i);
    		
    		if (element.names().getString(0).equals("rule")) {
    			JSONObject tmpElemet = element.getJSONObject("rule");
    			rules.add(new UserAuthorizationRule(
    					UARuleOperators.valueOf(tmpElemet.getString("operator")), 
    					(DependencyPath) loadDependencey(tmpElemet.getJSONObject("depencency")),
    					tmpElemet.has("relevantObjectRole") ? new ObjectRole(tmpElemet.getString("relevantObjectRole")) : null));
    			
    		} else if (element.names().getString(0).equals("UARules")) {
    			rules.add(loadUserAuthorizationRules(element.getJSONObject("UARules")));
    		}		
    	}
    	
    	return new UserAuthorizationRules(rules,
    			UARulesObject.has("operator") ? RulesConnectOperations.valueOf(UARulesObject.getString("operator")) : null);
    			
	}
	
	private ActionValidationRules loadActionValidationRules(JSONObject AVRulesObject) throws JSONException {
		List<ActionValidationRuleValidation> rules = new ArrayList<>();
		
		JSONArray AVRulesArr = AVRulesObject.getJSONArray("rules");
    	for (int i = 0 ; i < AVRulesArr.length(); i++) {
    		JSONObject element = (JSONObject) AVRulesArr.get(i);
    		
    		if (element.names().getString(0).equals("rule")) {
    			JSONObject tmpElemet = element.getJSONObject("rule");
    			
    			if (tmpElemet.has("depencency")) {
    				rules.add(new ActionValidationNumberRule(
    						AVNumberRuleOperators.valueOf(tmpElemet.getString("operator")),
    						tmpElemet.getInt("number"),
        					(DependencyPath) loadDependencey(tmpElemet.getJSONObject("depencency")),
        					tmpElemet.has("relevantObjectRole") ? new ObjectRole(tmpElemet.getString("relevantObjectRole")) : null));
    				
    			} else if (tmpElemet.has("leftDepencency") && tmpElemet.has("rigthDepencency")) {
        			rules.add(new ActionValidationObjectRule(
        					AVObjectRuleOperators.valueOf(tmpElemet.getString("operator")), 
        					(DependencyPath) loadDependencey(tmpElemet.getJSONObject("leftDepencency")),
        					tmpElemet.has("leftRelevantObjectRole") ? new ObjectRole(tmpElemet.getString("leftRelevantObjectRole")) : null,
        					(DependencyPath) loadDependencey(tmpElemet.getJSONObject("rigthDepencency")),
        					tmpElemet.has("rigthRelevantObjectRole") ? new ObjectRole(tmpElemet.getString("rigthRelevantObjectRole")) : null));
    			}

    		} else if (element.names().getString(0).equals("AVRules")) {
    			rules.add(loadActionValidationRules(element.getJSONObject("AVRules")));
    		}		
    	}
    	
    	return new ActionValidationRules(rules,
    			AVRulesObject.has("operator") ? RulesConnectOperations.valueOf(AVRulesObject.getString("operator")) : null);
	}
	
	private Object loadDependencey(JSONObject dependencyObject) throws JSONException {
		if (dependencyObject.names().getString(0).equals("dependencyRole")) {
			JSONObject depElem = dependencyObject.getJSONObject("dependencyRole");
			return new PathRule(
				depElem.has("name") ? new ObjectRole(depElem.getString("name")) : null,
				ProvenanceDependencyType.valueOf(depElem.getString("depandencyName")));
		} else if (dependencyObject.names().getString(0).equals("dependencyPath")) {
			Object depencencyPath = dependencyObject.get("dependencyPath");
			
			if (depencencyPath instanceof JSONArray) {
				return new DependencyPath(
						loadDepencencyPathList(dependencyObject.getJSONArray("dependencyPath")),
						dependencyObject.has("isReverse") ? dependencyObject.getBoolean("isReverse") : false);
			}
			else if (depencencyPath instanceof JSONObject) {
				JSONObject depElem = dependencyObject.getJSONObject("dependencyPath");
				return new DependencyPath(
						depElem.getString("name"),
						depElem.has("isReverse") ? depElem.getBoolean("isReverse") : false);
			}
		}
		
		return null;
	}
	
	private ArrayList<Object> loadDepencencyPathList(JSONArray dependencyPathArr) throws JSONException {
    	ArrayList<Object> dependencyPath = new ArrayList<>();
    	for (int i = 0 ; i < dependencyPathArr.length(); i++) {
    		Object element = dependencyPathArr.get(i);
    		
    		if (element instanceof String) {
    			dependencyPath.add(DependencyOperator.valueOf((String)element));
    		} else if (element instanceof JSONObject) {
    			Object obj = loadDependencey((JSONObject) element);
    			if (obj != null) {
    				dependencyPath.add(obj);
    			}
			}
		}
    	
    	return dependencyPath;
	}

	public String getCaseName() {
		return caseName;
	}

	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}

}
