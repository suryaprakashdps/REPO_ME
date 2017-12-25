package com.tcs.Repo.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.Repo.model.MasterVO;
import com.tcs.Repo.model.ProjectionVO;
import com.tcs.Repo.model.UserVO;
import com.tcs.Repo.service.UserService;

@RestController
@RequestMapping("api/v1")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "projects", method = RequestMethod.GET)
	public List<MasterVO> masterList() {
		
		List<MasterVO> master_data = userService.getmasterdata();

		//String username = "testid@gmail.com";

		//List<UserVO> userlist = userService.getuser(username);

		//System.out.println("user name" + userlist);
		return master_data;
	}

	@RequestMapping(value = "projects", method = RequestMethod.POST)
	public MasterVO create(@RequestBody MasterVO mastervo) {
		return userService.createproj(mastervo);
	}

	@RequestMapping(value = "projects/{id}", method = RequestMethod.GET)
	public UserVO get(@PathVariable int id) {
		return userService.getuserprofile(id);
	}

	@RequestMapping(value = "projects", method = RequestMethod.PUT)
	public void updateuser( @RequestBody MasterVO mastervo) {
		System.out.println("inside update user controller java"+mastervo.getRec_key());
		System.out.println("inside update user controller java"+mastervo.getProject());
		//return "success";
		
	
				
				userService.updatemasterdata(mastervo);
	}

	@RequestMapping(value = "projects/{id}",method = RequestMethod.DELETE)
	public UserVO delete(@PathVariable int id) {
		System.out.println("id for delete is"+id);
		
		return userService.deleteuser(id);
	}
	
	@RequestMapping(value = "projection", method = RequestMethod.GET)
	public List<ProjectionVO> projectionList() {
		
		List<ProjectionVO> master_data = userService.getProjectionData();

		return master_data;
	}
	
	@RequestMapping(value = "projection", method = RequestMethod.POST)
	public void create(@RequestBody ProjectionVO projectionvo) {
		System.out.println("inside update user controller java"+projectionvo.getRec_key());
		System.out.println("inside update user controller java"+projectionvo.getTower());
		
		Date StartDate = projectionvo.getStartdt();
		Date EndDate = DateUtils.addMonths(projectionvo.getEnddt(),1);
		
		
		projectionvo.setMonth(new SimpleDateFormat("MMM").format(projectionvo.getStartdt()));
		projectionvo.setYear(new SimpleDateFormat("yyyy").format(projectionvo.getStartdt()));
		
		while(StartDate.before(EndDate))
		{
			projectionvo.setMonth(new SimpleDateFormat("MMM").format(StartDate));
			projectionvo.setYear(new SimpleDateFormat("yyyy").format(StartDate));
			projectionvo.setRevenue(projectionvo.getResource_count()*projectionvo.getRate());
			userService.createProjecton(projectionvo);
			StartDate = DateUtils.addMonths(StartDate,1);
		}
		
		
	}


	@RequestMapping(value = "projection", method = RequestMethod.PUT)
	public void updateprojection( @RequestBody ProjectionVO projectionvo) {
		System.out.println("inside update user controller java"+projectionvo.getRec_key());
		System.out.println("inside update user controller java"+projectionvo.getTower());
		//return "success";
		
	
				
				userService.updateProjection(projectionvo);
	}


}
