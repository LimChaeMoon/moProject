package service;

import java.util.ArrayList;
import java.util.List;

import vo.MovieBooKingVo;
import vo.MovieInfoVo;

public interface MovieService {
	
	public List<MovieInfoVo> selectMovie(String movieName) throws Exception;

	public List<MovieBooKingVo> selectSeatNum(int movieNo) throws Exception;
	
	public MovieInfoVo MovieInfo(int movieNo) throws Exception;

	public int MoviePay(int movieNo, String[] sList) throws Exception;

}
