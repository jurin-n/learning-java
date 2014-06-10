package testDouble.mockito;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import static org.junit.Assert.assertThat;

public class MockitoTest {
	@Test
	public void testモックオブジェクト作成しただけの場合(){
		@SuppressWarnings("unchecked")
		List<String> mock = mock(List.class);
		assertThat(mock.get(0),is(nullValue()));
		assertThat(mock.contains("Hello"),is(false));
	}
	
	@Test
	public void testスタブメソッドの定義(){
		@SuppressWarnings("unchecked")
		List<String> stub = mock(List.class);
		when(stub.get(0)).thenReturn("Hello"); //スタブメソッドの定義
		assertThat(stub.get(0),is("Hello"));
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void test例外の送出(){
		@SuppressWarnings("unchecked")
		List<String> stub = mock(List.class);
		when(stub.get(0)).thenReturn("Hello");
		when(stub.get(1)).thenReturn("world");
		when(stub.get(2)).thenThrow(new IndexOutOfBoundsException());
		stub.get(2);//例外が送出される
	}

}
