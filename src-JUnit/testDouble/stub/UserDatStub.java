package testDouble.stub;

public class UserDatStub implements UserDao{

	@Override
	public User find(String userId) throws UserNotFoundException{
		throw new UserNotFoundException("Connection Error");
	}
	
}
