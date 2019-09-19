package id.co.bri.dce.CRUD;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getHome() throws Exception {
		String uri = "/home";
		MvcResult mvcResult = this.mockMvc.perform(get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

	}

	@Test
	public void getAddUser() throws Exception {

	}

	@Test

}
