package io.abnd.rvep.security.service.intf;

import java.util.List;

import io.abnd.rvep.security.model.impl.RoleCategory;
import io.abnd.rvep.security.model.impl.RvepRole;

public interface ServiceTest {

	List<RvepRole> testGetRoles();
	List<RoleCategory> testGetRoleCategories();

}
