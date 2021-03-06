package com.tcs.Repo.mapper;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tcs.Repo.model.ImportVO;
import com.tcs.Repo.model.MasterVO;
import com.tcs.Repo.model.ProjectionVO;
import com.tcs.Repo.model.UserVO;

@Mapper
public interface QueryMapper {
	
	public List<UserVO> getuserprof();

	public UserVO getuserprofile(String id);

	public void createuser(UserVO uservo);
	
	public void insertImport(@Param("importlist") List<ImportVO> importlist);

	public List<MasterVO> getmasterdata();

	public void updatemasterdata(MasterVO mastervo);

	public void createprojdata(MasterVO mastervo);
	
	public List<ProjectionVO> getProjectionData();
	
	public void updateProjectionData(ProjectionVO projectionVO);

	public void createProjectonData(ProjectionVO projectionVO);

	public Double getRate(BigInteger rec_key);
	
	
}
