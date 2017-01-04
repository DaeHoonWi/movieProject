/**
 * 
 */
package com.MovieProject.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.MovieProject.dto.CinemaDTO;
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
	public String cinemaWriteVeiw(Model model) throws Exception {
		logger.debug("================cinemaWriteVeiw================");
		return "cinemaInfo/cinemaWriteVeiw";
	}
	
	/**
	  * <pre>
	  * 영화 상세보기 컨트롤러
	  * 하나의 영화 정보를 상세보기 페이지로 넘기고,
	  * 해당 영화 Data를 보여주는 컨트롤러
	  * 
	  * **감독/배우/장르 추가해야함.(170104)
	  * **예외처리 추가해야함(cNum이 null일 경우)(170104)
	  * </pre>
	  * @param cNum
	  * @param model
	  * @return
	  * @throws Exception
	*/
	@RequestMapping(value = "cinemaDetailView.do")
	public String cinemaDetailView(int cNum, Model model) throws Exception {
		logger.debug("================cinemaDetailView================");
		CinemaService cinemaService = sqlSession.getMapper(CinemaService.class);
		model.addAttribute("cinemaDetail", cinemaService.selectCinemaDetail(cNum));
		return "cinemaInfo/cinemaDetailView";
	}
	
	/**
	  * <pre>
	  * 영화 정보 삭제 컨트롤러
	  * cNum에 해당하는 영화 Data 삭제
	  * 
	  * **예외처리 추가해야함(cNum이 null일 경우)(170104)
	  * </pre>
	  * @param cNum
	  * @param model
	  * @return
	  * @throws Exception
	*/
	@RequestMapping(value = "cinemaDelete.do")
	public String cinemaDelete(int cNum, Model model) throws Exception {
		logger.debug("================cinemaDelete================");
		CinemaService cinemaService = sqlSession.getMapper(CinemaService.class);
		cinemaService.deleteCinema(cNum);
		return "redirect:cinemaList.do";
	}
	
	
	/**
	  * <pre>
	  * 영화추가 DB입력 컨트롤러
	  * View에서 작성된 정보를 post 방식으로 request에 받아오고,
	  * 받아온 정보를 서비스객체를 통해 DB에 입력
	  * 1. 각 변수를 입력받음, 값이 있는지 value값을 체크한다. 없을 시 null.
	  * 2. 받은 변수를 DTO 객체에 저장한다.
	  * 3. 저장된 정보는 서비스객체를 통해 쿼리되고, DB에 저장된다.
	  * 
	  * **cCount는 입력하지 않는다. 디폴트 값인 0이 들어간다.
	  * **cStoredFileName은 setcOriginalFileName을 변조하여 입력될 에정이다. 현재는 null (170104)
	  * **감독/배우/장르 추가해야함.(170104)
	  * </pre>
	  * @param request
	  * @param model
	  * @return
	  * @throws Exception
	*/
	@RequestMapping(value = "cinemaWrite.do")
	public String cinemaWrite(HttpServletRequest request, Model model) throws Exception {
		logger.debug("================cinemaWrite================");
	
		CinemaDTO cinemaDTO = new CinemaDTO();
		CinemaService cinemaService = sqlSession.getMapper(CinemaService.class);
		
		//VALIDATION CHECK START
		//int cNum = Integer.valueOf(request.getParameter("cNum"));
		int couNum = Integer.valueOf(request.getParameter("couNum"));
		String cTitle = String.valueOf(request.getParameter("cTitle"));
		int cRunningtime = Integer.valueOf(request.getParameter("cRunningtime"));
		String cSummary = String.valueOf(request.getParameter("cSummary"));
		String cAge = String.valueOf(request.getParameter("cAge"));
		String cOriginalFileName = String.valueOf(request.getParameter("cOriginalFileName"));
		int cPlaydate = Integer.valueOf(request.getParameter("cPlaydate"));
		//VALIDATION CHECK END
		cinemaDTO.setcouNum(couNum);
		cinemaDTO.setcTitle(cTitle);
		cinemaDTO.setcRunningtime(cRunningtime);
		cinemaDTO.setcSummary(cSummary);
		cinemaDTO.setcAge(cAge);
		cinemaDTO.setcOriginalFileName(cOriginalFileName);
		cinemaDTO.setcPlaydate(cPlaydate);
		
		
		cinemaService.writeCinema(cinemaDTO);
		
		return "redirect:cinemaList.do";
	}
	
	
	
	/**
	  * <pre>
	  * updateFormView 페이지 보여주는 컨트롤러
	  * 선택한 영화 번호(cNum)에 해당하는 정보를 view 페이지에 나타냄
	  * 
	  * **예외처리 추가해야함(cNum이 null일 경우)(170104)
	  * </pre>
	  * @param cNum
	  * @param model
	  * @return
	  * @throws Exception
	*/
	@RequestMapping(value = "cinemaUpdateFormView.do")
	public String cinemaUpdateFormView(int cNum, Model model) throws Exception {
		logger.debug("================cinemaUpdateForm================");
		CinemaService cinemaService = sqlSession.getMapper(CinemaService.class);
		model.addAttribute("cinemaDetail", cinemaService.selectCinemaDetail(cNum));
		return "cinemaInfo/cinemaUpdateFormView";
	}
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  * @param request
	  * @param model
	  * @return
	  * @throws Exception
	*/
	@RequestMapping(value = "cinemaUpdate.do")
	public String cinemaUpdate(HttpServletRequest request, Model model) throws Exception {
		logger.debug("================cinemaUpdate================");
		
		CinemaDTO cinemaDTO = new CinemaDTO();
		CinemaService cinemaService = sqlSession.getMapper(CinemaService.class);
		
		//VALIDATION CHECK START
		int cNum = Integer.valueOf(request.getParameter("cNum"));
		int couNum = Integer.valueOf(request.getParameter("couNum"));
		String cTitle = String.valueOf(request.getParameter("cTitle"));
		int cRunningtime = Integer.valueOf(request.getParameter("cRunningtime"));
		String cSummary = String.valueOf(request.getParameter("cSummary"));
		String cAge = String.valueOf(request.getParameter("cAge"));
		String cOriginalFileName = String.valueOf(request.getParameter("cOriginalFileName"));
		int cPlaydate = Integer.valueOf(request.getParameter("cPlaydate"));
		//VALIDATION CHECK END
		cinemaDTO.setcNum(cNum);
		cinemaDTO.setcouNum(couNum);
		cinemaDTO.setcTitle(cTitle);
		cinemaDTO.setcRunningtime(cRunningtime);
		cinemaDTO.setcSummary(cSummary);
		cinemaDTO.setcAge(cAge);
		cinemaDTO.setcOriginalFileName(cOriginalFileName);
		cinemaDTO.setcPlaydate(cPlaydate);
		
		
		cinemaService.updateCinema(cinemaDTO);
		
		return "redirect:cinemaDetailView.do?cNum="+cNum;
	}
		
}
