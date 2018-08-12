package pbac.base;

public class ActingUser extends Base {

	public ActingUser() {
		super();
	}
	
	public ActingUser(Long id) {
		super(id);
	}

	@Override
	public String toString() {
		return "au" + super.getId();
	}
}
