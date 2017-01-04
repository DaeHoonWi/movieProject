/**
 * 
 */
package com.MovieProject.controller;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.MovieProject.service.CinemaService;

/************************************************
 * <pre>
 *
 * </pre>
 * @Company : (주)한국이디에스
 * @Author  : 위대훈
 * @Date    : 2017. 1. 4. 오후 1:43:12
 * @Version : 1.0
 * @MovieTeamProject 게시판
 *************************************************/
@Controller
public class CinemaController {

	private static final Logger logger = LoggerFactory.getLogger(CinemaController.class);

	@Autowired
	private SqlSession sqlSession;
	
	
	/**
	  * <pre>
	  * 영화 리스트 컨트롤러
	  * DB에 있는 모든 영화들과 영화들의 정보를 불러온다.
	  * 1. 서비스 인터페이스를 통하여 서비스 클래스를 호출한다.
	  * 2. 서비스 클래스에서는 cinemaDAO.cinemaList() 메소드를 실행한다.
	  * 3. 실행된 메소드는 list 이름의 ArrayList<cinemaDTO> 객체를 생성한다.
	  * 4. 이 객체에 sqlSession.selectLsit() 메소드를 이용한다.
	  * 5. cinema_SQL.xml에 매핑된 id값인 selectCinemaList sql을 실행하여 select문을 실행 한다.
	  * 6. 결과값이 반환된다.
	  * </pre>
	  * @param model
	  * @return
	  * @throws Exception
	*/
	@RequestMapping(value = "cinemaList.do")
	public String cinemaList(Model model) throws Exception {
		logger.debug("================cinemaList================");
	
		CinemaService cinemaService = sqlSession.getMapper(CinemaService.class);
		model.addAttribute("cinemaList", cinemaService.selectCinemaList());
		
		return "cinemaInfo/cinemaList";
	}
	
	/**
	  * <pre>
	  * 영화추가 화면 컨트롤러
	  * 영화추가 View로 넘기는 역할
	  * 1. jsp page 주소를 리턴한다.
	  * 2. 리턴값을 받아서 매핑된 주소로 이동한다.
	  * </pre>
	  * @param model
	  * @return
	*/
	@RequestMapping(value = "cinemaWriteVeiw.do")
	public String cinemaWriteVeiw(Model model) {
		logger.debug("================cinemaWriteVeiw================");
		return "cinemaInfo/cinemaWriteVeiw";
	}
	
	/*@RequestMapping(value = "cinemaDetailView.do")
	public String cinemaDetailView(int cNum, Model model) throws Exception {
		logger.debug("================cinemaDetailView================");
		
		CinemaService cinemaService = sqlSession.getMapper(CinemaService.class);
		cinemaService.deleteCinema(cNum);
		
		return "redirect:cinemaList.do";
	}*/
}
