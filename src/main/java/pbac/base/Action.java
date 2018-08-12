package pbac.base;

public class Action extends Base {

	private ActionType type;
	
	public Action() {
		super();
	}
	
	public Action(Long id, ActionType type) {
		super(id);
		this.type = type;
	}

	public ActionType getType() {
		return type;
	}
	public void setType(ActionType type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Action other = (Action) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return type.getName() + super.getId();
	}
}
