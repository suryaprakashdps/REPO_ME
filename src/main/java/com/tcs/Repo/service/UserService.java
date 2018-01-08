package com.tcs.Repo.service;

import java.math.BigInteger;
import java.util.List;

import com.tcs.Repo.model.ImportVO;
import com.tcs.Repo.model.MasterVO;
import com.tcs.Repo.model.ProjectionVO;
import com.tcs.Repo.model.UserVO;

public interface UserService {
	
	List<UserVO> getuser(String username);

	UserVO createuser(UserVO uservo);

	UserVO updateuser(int id, UserVO uservo);

	UserVO deleteuser(int id);

	UserVO getuserprofile(String id);

	List<MasterVO> getmasterdata();

	MasterVO updatemasterdata(MasterVO mastervo);
	
	MasterVO createproj(MasterVO mastervo);
	
	List<ProjectionVO> getProjectionData();
	
	ProjectionVO updateProjection(ProjectionVO projectionVO);
	
	ProjectionVO createProjecton(ProjectionVO projectionVO);

	void insertImportdata(List<ImportVO> importlist);

	Double getRate(BigInteger rec_key);

	void updateProjectiondata(ProjectionVO pvo);
	
	

}
