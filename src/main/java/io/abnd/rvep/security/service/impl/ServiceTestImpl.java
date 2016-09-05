package io.abnd.rvep.security.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.abnd.rvep.security.dao.intf.RoleCategoryDAO;
import io.abnd.rvep.security.model.RoleCategory;
import io.abnd.rvep.security.model.RvepRole;
import io.abnd.rvep.security.service.intf.ServiceTest;

@Service
public class ServiceTestImpl implements ServiceTest {
	
	@Autowired
	private RoleCategoryDAO roleCategoryDAO;
	
	@PersistenceContext
	private EntityManager em;
	
	public List<RvepRole> testGetRoles() {
		Query query = em.createNativeQuery("SELECT * from rvep_role", RvepRole.class);
		List<RvepRole> result = new ArrayList<RvepRole>();
		for (Object o : query.getResultList()) {
			result.add((RvepRole)o);
		}
		return result;
	}
	
	public List<RoleCategory> testGetRoleCategories() {
		return roleCategoryDAO.findAll();
	}
	
}
