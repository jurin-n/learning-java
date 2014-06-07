import static org.junit.Assert.assertEquals;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class HelloServletTest {
	@Test
	public void doGetテスト() throws Exception{
		//SetUp
		HelloServlet sut = new HelloServlet();
		HttpServletRequest request = mock(HttpServletRequest.class);
		when(request.getParameter("name")).thenReturn("JUnit");
		ServletOutputStream output = mock(ServletOutputStream.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		when(response.getOutputStream()).thenReturn(output);
		
		//Exercise
		sut.doGet(request,response);
		
		//Verify
		verify(output).println("Hello JUnit");
		verify(response).setContentType("text/plain; charset=UTF-8");
		verify(response).flushBuffer();
		
	}
}
