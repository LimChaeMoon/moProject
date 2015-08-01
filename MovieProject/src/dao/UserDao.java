package dao;

import java.sql.Connection;

import vo.UserVo;

public interface UserDao {
	
	public void setConnection(Connection con);

	public int joinUser(UserVo userVo) throws Exception;

	public UserVo selectLoginUser(UserVo userVo) throws Exception;

	public int idSelect(String id) throws Exception;


}
