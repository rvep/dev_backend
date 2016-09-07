package io.abnd.rvep.security.rest;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import io.abnd.rvep.security.model.RoleCategory;
import io.abnd.rvep.security.model.RvepRole;
import io.abnd.rvep.security.service.intf.ServiceTest;

@RestController
@RequestMapping("/api/test")
public class TestController {

	private ServiceTest serviceTest;

	public TestController(ServiceTest serviceTest) {
		this.serviceTest = serviceTest;
	}
	
	@RequestMapping(value="/get/roles", method=RequestMethod.GET, produces="application/json")
	public String testGetRoles() {
		JsonObject roles = new JsonObject();
		JsonArray roleArray = new JsonArray();
		
		List<RvepRole> result = serviceTest.testGetRoles();
		
		for (RvepRole role : result) {
			JsonObject o = new JsonObject();
			o.addProperty("name", role.getName());
			roleArray.add(o);
		}
		
		roles.add("rvepRole", roleArray);
		
		return roles.toString();
	}
	
	@RequestMapping(value="/get/rolecategories", method=RequestMethod.GET, produces="application/json")
	public String testGetRoleCategories() {
		JsonObject categories = new JsonObject();
		JsonArray categoryArray = new JsonArray();
	
		List<RoleCategory> result = serviceTest.testGetRoleCategories();
		
		for (RoleCategory category : result) {
			JsonObject o = new JsonObject();
			o.addProperty("name", category.getName());
			categoryArray.add(o);
		}

		categories.add("roleCategory", categoryArray);
		
		return categories.toString();
	}
	
}
