package cn.itcast.oa.view.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.domain.Role;
import cn.itcast.oa.service.RoleService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class RoleAction extends ActionSupport implements ModelDriven<Role> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Resource
	private RoleService roleService;
	
	private Role model = new Role();

	public Role getModel() {
		return model;
	}
	

	public String execute(){
		return "success";
	}
	
	public String list() {
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		return "list";
	}

	public String delete() {
		roleService.delete(model.getId());
		return "toList";
	}

	public String addUI() {

		return "saveUI";
	}

	public String add() {
		//封装到对象中
		/*Role role = new Role();
		role.setName(model.getName());
		role.setDescription(model.getDescription());
		
		//保存到数据库中
		roleService.save(role);*/

		roleService.save(model);
		return "toList";
	}

	public String editUI() {
		Role role = roleService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(role);
		return "saveUI";
	}
	
	/*public String saveUI(){
		Role role = roleService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(role);
		return "saveUI";
	}*/

	public String edit() {
		Role role = roleService.getById(model.getId());
		role.setName(model.getName());
		role.setDescription(model.getDescription());
		roleService.update(role);

		return "toList";
	}

	

}
