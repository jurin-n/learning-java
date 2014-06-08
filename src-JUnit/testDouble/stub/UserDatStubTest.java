package testDouble.stub;

import org.junit.Test;

public class UserDatStubTest {

	@Test(expected=UserNotFoundException.class)
	public void 例外送出テスト() throws UserNotFoundException{
		UserDatStub sut = new UserDatStub();
		sut.find("test");
	}

}
