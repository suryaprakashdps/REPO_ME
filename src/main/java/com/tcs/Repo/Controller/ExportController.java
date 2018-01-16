package com.tcs.Repo.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tcs.Repo.model.ProjectionVO;
import com.tcs.Repo.service.UserService;

@Controller
@RequestMapping("api/v1")
public class ExportController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "export", method = RequestMethod.GET)
	public String ExportList(Model model) {
		
List<ProjectionVO> master_data = userService.getProjectionData();
		
		String liststring=master_data.toString();
		System.out.println(liststring);
		
		List<ProjectionVO> uniqueprojectdata = new ArrayList<ProjectionVO>();
		
		
		
		Map<String, List<ProjectionVO> > map = new HashMap<>();
		Set<ProjectionVO> unique = new TreeSet<ProjectionVO>(new ProjectionCompartor());
		
		
		
		//gets unique data
		for (ProjectionVO projectvo : master_data) {
			if (unique.add(projectvo)) {
				uniqueprojectdata.add(projectvo);
			}
		}
			
			for (ProjectionVO uniquevo:uniqueprojectdata){
				List<ProjectionVO> finallist = new ArrayList<ProjectionVO>();
				for (ProjectionVO testvo : master_data) {
					ProjectionVO finalobj = new ProjectionVO();
					if (testvo.getProject().equals(uniquevo.getProject())) {
						
						finalobj.setTower(testvo.getTower());
						
						finalobj.setMonth(testvo.getMonth());
						finalobj.setResource_count(testvo.getResource_count());
						finalobj.setRevenue(testvo.getRevenue());
						finallist.add(finalobj);
						
					}
				}
				map.put(uniquevo.getProject(), finallist);

		}
			
			
			System.out.println("Fetching Keys and corresponding [Multiple] Values ");
	        for (Map.Entry<String, List<ProjectionVO>> entry : map.entrySet()) {
	            String key = entry.getKey();
	            List<ProjectionVO> values = entry.getValue();
	            System.out.println("Key = " + key);
	            System.out.println("Size = " + values.size() );
	          
	            for(ProjectionVO results:values){
	            	
	            System.out.println("Values = " + results.getMonth());
	            }
	        }
			

		
		 model.addAttribute("exportList",map);
		
		
		return "";
	}

}
