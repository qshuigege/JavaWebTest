package cn.itcast.oa.servicel.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.dao.DepartmentDao;
import cn.itcast.oa.domain.Department;
import cn.itcast.oa.service.DepartmentService;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	@Resource
	private DepartmentDao<Department> departmentDao;

	public List<Department> findAll() {
		return departmentDao.findAll();
	}
	
	public void delete(Long id){
		departmentDao.delete(id);
	}

	public void save(Department department) {
		departmentDao.save(department);
	}

	public Department getById(Long id) {
		return departmentDao.getById(id);		
		
	}

	public void update(Department department) {
		departmentDao.update(department);
	}
}
