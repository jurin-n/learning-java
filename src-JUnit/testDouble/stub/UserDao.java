package testDouble.stub;

public interface UserDao {
	User find(String userId) throws UserNotFoundException;
}
