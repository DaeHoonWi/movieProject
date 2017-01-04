package com.MovieProject.dto;

//import org.apache.commons.lang3.builder.ToStringBuilder;

/************************************************
 * <pre>
 *
 * </pre>
 * @Company : (주)한국이디에스
 * @Author  : 위대훈
 * @Date    : 2017. 1. 4. 오후 1:39:41
 * @Version : 1.0
 * @MovieTeamProject 게시판
 *************************************************/
public class CinemaDTO {

	int cNum;						//영화 번호
	int couNum;						//나라 번호
	String cTitle;					//영화 제목
	int cRunningtime;				//러닝타임
	String cSummary;				//줄거리
	
	int cCount;						//리뷰 수
	String cAge;					//시청연령제한
	String cOriginalFileName;		//원본 파일명
	String cStoredFileName;			//저장 파일명
	int cPlaydate;					//개봉일
	
	/**
	 * Desc : Constructor of CinemaDTO.java class
	 */
	public CinemaDTO() {		//디폴트 생성자
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Desc : Constructor of CinemaDTO.java class
	 * CinemaDTO 모든 변수를 파라미터로 갖는 생성자
	 */
	public CinemaDTO(int cNum, int couNum, String cTitle, int cRunningtime
			, String cSummary, int cCount, String cAge, String cOriginalFileName
			, String cStoredFileName, int cPlaydate) {
		this.cNum = cNum;
		this.couNum = couNum;
		this.cTitle = cTitle;
		this.cRunningtime = cRunningtime;
		this.cSummary = cSummary;
		this.cCount = cCount;
		this.cAge =  cAge;
		this.cOriginalFileName = cOriginalFileName;
		this.cStoredFileName = cStoredFileName;
		this.cPlaydate = cPlaydate;
	}

	/**
	 * <pre>
	 * return the cNum
	 * </pre>
	 * @return 
	 */
	public int getcNum() {
		return cNum;
	}

	/**
	 * <pre>
	 * the cNum to set
	 * </pre>
	 * @param cNum 
	 */
	public void setcNum(int cNum) {
		this.cNum = cNum;
	}

	/**
	 * <pre>
	 * return the couNum
	 * </pre>
	 * @return 
	 */
	public int getcouNum() {
		return couNum;
	}

	/**
	 * <pre>
	 * the couNum to set
	 * </pre>
	 * @param couNum 
	 */
	public void setcouNum(int couNum) {
		this.couNum = couNum;
	}

	/**
	 * <pre>
	 * return the cTitle
	 * </pre>
	 * @return 
	 */
	public String getcTitle() {
		return cTitle;
	}

	/**
	 * <pre>
	 * the cTitle to set
	 * </pre>
	 * @param cTitle 
	 */
	public void setcTitle(String cTitle) {
		this.cTitle = cTitle;
	}

	/**
	 * <pre>
	 * return the cRunningtime
	 * </pre>
	 * @return 
	 */
	public int getcRunningtime() {
		return cRunningtime;
	}

	/**
	 * <pre>
	 * the cRunningtime to set
	 * </pre>
	 * @param cRunningtime 
	 */
	public void setcRunningtime(int cRunningtime) {
		this.cRunningtime = cRunningtime;
	}

	/**
	 * <pre>
	 * return the cSummary
	 * </pre>
	 * @return 
	 */
	public String getcSummary() {
		return cSummary;
	}

	/**
	 * <pre>
	 * the cSummary to set
	 * </pre>
	 * @param cSummary 
	 */
	public void setcSummary(String cSummary) {
		this.cSummary = cSummary;
	}

	/**
	 * <pre>
	 * return the cCount
	 * </pre>
	 * @return 
	 */
	public int getcCount() {
		return cCount;
	}

	/**
	 * <pre>
	 * the cCount to set
	 * </pre>
	 * @param cCount 
	 */
	public void setcCount(int cCount) {
		this.cCount = cCount;
	}

	/**
	 * <pre>
	 * return the cAge
	 * </pre>
	 * @return 
	 */
	public String getcAge() {
		return cAge;
	}

	/**
	 * <pre>
	 * the cAge to set
	 * </pre>
	 * @param cAge 
	 */
	public void setcAge(String cAge) {
		this.cAge = cAge;
	}

	/**
	 * <pre>
	 * return the cOriginalFileName
	 * </pre>
	 * @return 
	 */
	public String getcOriginalFileName() {
		return cOriginalFileName;
	}

	/**
	 * <pre>
	 * the cOriginalFileName to set
	 * </pre>
	 * @param cOriginalFileName 
	 */
	public void setcOriginalFileName(String cOriginalFileName) {
		this.cOriginalFileName = cOriginalFileName;
	}

	/**
	 * <pre>
	 * return the cStoredFileName
	 * </pre>
	 * @return 
	 */
	public String getcStoredFileName() {
		return cStoredFileName;
	}

	/**
	 * <pre>
	 * the cStoredFileName to set
	 * </pre>
	 * @param cStoredFileName 
	 */
	public void setcStoredFileName(String cStoredFileName) {
		this.cStoredFileName = cStoredFileName;
	}

	/**
	 * <pre>
	 * return the cPlaydate
	 * </pre>
	 * @return 
	 */
	public int getcPlaydate() {
		return cPlaydate;
	}

	/**
	 * <pre>
	 * the cPlaydate to set
	 * </pre>
	 * @param cPlaydate 
	 */
	public void setcPlaydate(int cPlaydate) {
		this.cPlaydate = cPlaydate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/*@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}*/
	
	
}
