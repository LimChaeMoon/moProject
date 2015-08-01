package dao;

import java.sql.Connection;
import java.util.List;

import vo.MovieBooKingVo;
import vo.MovieInfoVo;

public interface MovieDao {
	
	public void setConnection(Connection con);
	
	public List<MovieInfoVo> selectMovie(String movieName) throws Exception;

	public List<MovieBooKingVo> selectSeatMun(int movieNo) throws Exception;

	public MovieInfoVo MovieInfo(int movieNo) throws Exception;

	public int MoviePay(int movieNo, String sList) throws Exception;
	
	

}
