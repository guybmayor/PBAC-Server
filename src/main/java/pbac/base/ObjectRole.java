package pbac.base;

public class ObjectRole {

	private String name;
	private boolean isInput;
	
	public ObjectRole() {}
	
	public ObjectRole(String name) {
		super();
		this.name = name;
	}
	
	public ObjectRole(String name, boolean isInput) {
		super();
		this.name = name;
		this.isInput = isInput;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isInput() {
		return isInput;
	}
	public void setInput(boolean isInput) {
		this.isInput = isInput;
	}
	
	// Only by name
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	// Only by name
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ObjectRole other = (ObjectRole) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return name; 
	}
}
