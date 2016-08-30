package io.abnd.rvep.security.rest;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import io.abnd.rvep.security.model.impl.RoleCategory;
import io.abnd.rvep.security.model.impl.RvepRole;
import io.abnd.rvep.security.service.intf.ServiceTest;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class TestControllerTest {

	@Autowired
	private ServiceTest serviceTest;

	@Autowired
	private WebApplicationContext webAppContext;

	private MockMvc mockMvc;

	private List<RvepRole> roleList = new ArrayList<RvepRole>();
	private List<RoleCategory> roleCategoryList = new ArrayList<RoleCategory>();

	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(webAppContext).build();
		roleList.addAll(serviceTest.testGetRoles());
		roleCategoryList.addAll(serviceTest.testGetRoleCategories());
	}

	@Test
	@Transactional
	public void findAllRoleCategories() throws Exception {
		mockMvc.perform(get("/api/test/get/rolecategories"))
		.andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(jsonPath("$.roleCategory", hasSize(2)))
		.andExpect(jsonPath("$.roleCategory[0].name").value(roleCategoryList.get(0).getName()))
		.andExpect(jsonPath("$.roleCategory[1].name").value(roleCategoryList.get(1).getName()));
	}

	@Test
	@Transactional
	public void findAllRoles() throws Exception {
		mockMvc.perform(get("/api/test/get/roles"))
		.andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(jsonPath("$.rvepRole", hasSize(8)))
		.andExpect(jsonPath("$.rvepRole[0].name").value(roleList.get(0).getName()))
		.andExpect(jsonPath("$.rvepRole[1].name").value(roleList.get(1).getName()))
		.andExpect(jsonPath("$.rvepRole[2].name").value(roleList.get(2).getName()))
		.andExpect(jsonPath("$.rvepRole[3].name").value(roleList.get(3).getName()))
		.andExpect(jsonPath("$.rvepRole[4].name").value(roleList.get(4).getName()))
		.andExpect(jsonPath("$.rvepRole[5].name").value(roleList.get(5).getName()))
		.andExpect(jsonPath("$.rvepRole[6].name").value(roleList.get(6).getName()))
		.andExpect(jsonPath("$.rvepRole[7].name").value(roleList.get(7).getName()));
	}

}
