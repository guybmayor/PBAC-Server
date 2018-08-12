package pbac.base;

import java.util.HashMap;
import java.util.Map;

public class EntityCreator {

	private static Long userNextId = (long) 0;
	private static Long objectNextId = (long) 0;
	private static Map<ActionType, Long> actionNextId = new HashMap<>();
	
	public static ActingUser user() {
		return new ActingUser(++userNextId);
	}
	
	public static ObjectData object() {
		return new ObjectData(++objectNextId);
	}
	
	public static ObjectData objectVersion(ObjectData oldVersion) {
		return new ObjectData(oldVersion.getId(), oldVersion.getVersion() + 1);
	}
	
	public static Action action(ActionType actionType) {
		Long id = actionNextId.get(actionType);
		id = (id == null ? 1 : id +1); 

		actionNextId.put(actionType, id);
		return new  Action(id, actionType);
	}

	public static void init() {
		userNextId = (long) 0;
		objectNextId = (long) 0;
		actionNextId = new HashMap<>();
	}
}
