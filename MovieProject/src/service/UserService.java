package service;

import vo.UserVo;

public interface UserService {

	public boolean joinUser(UserVo userVo) throws Exception;
	// 회원가입

	public UserVo selectLoingUser(UserVo userVo) throws Exception;
	//로그인 + 회원정보
	
	public int idSelect(String id) throws Exception;
	//아이디중복검사

	


}
