package pbac.base;

public class ObjectData extends Base {
	
	private Long version;
	
	public ObjectData() {
		super();
	}
	
	public ObjectData(Long id) {
		super(id);
		this.version = (long) 1;
	}

	public ObjectData(Long id,  Long version) {
		super(id);
		this.version = version;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((version == null) ? 0 : version.hashCode());
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
		ObjectData other = (ObjectData) obj;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "O" + getId() + "v" + getVersion();
	}
}
