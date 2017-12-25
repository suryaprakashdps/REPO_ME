package com.tcs.Repo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tcs.Repo.model.MasterVO;
import com.tcs.Repo.model.ProjectionVO;
import com.tcs.Repo.model.UserVO;

@Mapper
public interface QueryMapper {
	
	public List<UserVO> getuserprof();

	public UserVO getuserprofile(int id);

	public void createuser(UserVO uservo);

	public List<MasterVO> getmasterdata();

	public void updatemasterdata(MasterVO mastervo);

	public void createprojdata(MasterVO mastervo);
	
	public List<ProjectionVO> getProjectionData();
	
	public void updateProjectionData(ProjectionVO projectionVO);

	public void createProjectonData(ProjectionVO projectionVO);
	
	
}
