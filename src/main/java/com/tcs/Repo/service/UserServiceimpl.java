package com.tcs.Repo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcs.Repo.mapper.QueryMapper;
import com.tcs.Repo.model.ImportVO;
import com.tcs.Repo.model.MasterVO;
import com.tcs.Repo.model.ProjectionVO;
import com.tcs.Repo.model.UserVO;

@Service("userService")
public class UserServiceimpl implements UserService{
	
	@Autowired
	private QueryMapper querymapper;
	
	@Transactional
	public List<UserVO> getuser(String user){
		System.out.println("inside service");
		return querymapper.getuserprof();
		
	}

	@Override
	public UserVO createuser(UserVO uservo) {
		// TODO Auto-generated method stub
		querymapper.createuser(uservo);
		return uservo;
	}

	@Override
	public UserVO updateuser(int id, UserVO uservo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO deleteuser(int id) {
		// TODO Auto-generated method stub
		System.out.println("inside delete service");
		return null;	
	}

	@Override
	public UserVO getuserprofile(int id) {
		// TODO Auto-generated method stub
		return querymapper.getuserprofile(id);
	}

	@Override
	public List<MasterVO> getmasterdata() {
		// TODO Auto-generated method stub
		return querymapper.getmasterdata();
	}

	@Override
	public MasterVO updatemasterdata (MasterVO mastervo) {
		// TODO Auto-generated method stub
		
		querymapper.updatemasterdata(mastervo);
		return mastervo;
	}
	
	@Override
	public MasterVO createproj (MasterVO mastervo) {
		// TODO Auto-generated method stub
		System.out.println("Entered Project create method");
		querymapper.createprojdata(mastervo);
		return mastervo;
	}
	
	@Override
	public List<ProjectionVO> getProjectionData() {
		// TODO Auto-generated method stub
		return querymapper.getProjectionData();
	}
	
	@Override
	public ProjectionVO updateProjection (ProjectionVO projectionVO) {
		// TODO Auto-generated method stub
		
		querymapper.createProjectonData(projectionVO);
		return projectionVO;
	}
	
	@Override
	public ProjectionVO createProjecton (ProjectionVO projectionVO) {
		// TODO Auto-generated method stub
		System.out.println("Entered Projection create method");
		querymapper.createProjectonData(projectionVO);
		return projectionVO;
	}

	@Override
	public void insertImportdata(List<ImportVO> importlist) {
		try {
			querymapper.insertImport(importlist);
		}
		catch(Exception ex){
			
			ex.printStackTrace();
		}
		
	}

}
