package testDouble;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import java.util.Date;

public class DateDependencyExampleTest {

	@Test
	public void doSomethingでdateに現在時刻が設定される() throws InterruptedException {
		DateDependencyExample sut = new DateDependencyExample();
		sut.doSomething();

		//このアサーションはタイミングにより成功にも失敗にもなる
		assertThat(sut.date, is(new Date()));
	}

}
