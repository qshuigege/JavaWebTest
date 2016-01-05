package cn.itcast.oa.view.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.domain.Department;
import cn.itcast.oa.service.DepartmentService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Resource
	private DepartmentService departmentService;
	
	private Department model = new Department();

	public Department getModel() {
		return model;
	}
	
	public String execute(){
		return "success";
	}
	

	
	public String list() {
		List<Department> departmentList = departmentService.findAll();
		ActionContext.getContext().put("departmentList", departmentList);
		return "list";
	}

	public String delete() {
		departmentService.delete(model.getId());
		return "toList";
	}

	public String addUI() {

		return "saveUI";
	}

	public String add() {

		departmentService.save(model);
		return "toList";
	}

	public String editUI() {
		Department department = departmentService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(department);
		return "saveUI";
	}
	

	public String edit() {
		Department department = departmentService.getById(model.getId());
		department.setName(model.getName());
		department.setDescription(model.getDescription());
		departmentService.update(department);

		return "toList";
	}

	

}
