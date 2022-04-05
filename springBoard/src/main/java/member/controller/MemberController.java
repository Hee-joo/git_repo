package member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import member.bean.MemberDTO;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;

	// index
	@RequestMapping(value = "/main/index.do")
	public String index() {
		return "../main/index.jsp";
	}

	// loginForm
	@RequestMapping(value = "/member/loginForm.do")
	public ModelAndView loginForm() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("req_nav", "../member/loginForm.jsp");
		modelAndView.setViewName("../main/index.jsp");

		return modelAndView;
	}

	// login
	@RequestMapping(value = "/member/login.do")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		String name = memberService.login(id, pwd);
		
		ModelAndView modelAndView = new ModelAndView();
		if (name != null) { // 로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("memName", name);
			session.setAttribute("memId", id);
			modelAndView.setViewName("../main/index.jsp");
		} else { 
			modelAndView.addObject("req_nav", "../member/loginFail.jsp");
			modelAndView.setViewName("../main/index.jsp");
		}
		return modelAndView;
	}

	// logout
	@RequestMapping(value = "/member/logout.do")
	public ModelAndView logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("memName");
		session.removeAttribute("memId");

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("req_nav", "../member/logout.jsp");
		modelAndView.setViewName("../main/index.jsp");

		return modelAndView;
	}

	// writeForm
	@RequestMapping(value = "/member/writeForm.do")
	public ModelAndView writeForm() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("req_sec", "../member/writeForm.jsp");
		modelAndView.setViewName("../main/index.jsp");

		return modelAndView;
	}

	// checkId
	@RequestMapping(value = "/member/checkId.do")
	public ModelAndView checkId(HttpServletRequest request) {
		String id = request.getParameter("id");

		boolean exist = memberService.isExistId(id); 

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("id", id);
		modelAndView.addObject("exist", exist);
		modelAndView.setViewName("../member/checkId.jsp");

		return modelAndView;
	}

	// write
	@RequestMapping(value = "/member/write.do")
	public ModelAndView write(HttpServletRequest request) throws IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String gender = request.getParameter("gender");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		String addr = request.getParameter("addr");

		MemberDTO dto = new MemberDTO();
		dto.setName(name);
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setGender(gender);
		dto.setEmail1(email1);
		dto.setEmail2(email2);
		dto.setTel1(tel1);
		dto.setTel2(tel2);
		dto.setTel3(tel3);
		dto.setAddr(addr);

		int result = memberService.write(dto);

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("result", result);
		modelAndView.addObject("req_sec", "../member/write.jsp");
		modelAndView.setViewName("../main/index.jsp");
		return modelAndView;
	}

	// modifyForm
	@RequestMapping(value = "/member/modifyForm.do")
	public ModelAndView modifyForm(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("memId");

		MemberDTO dto = memberService.getMember(id);

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("dto", dto);
		modelAndView.addObject("req_sec", "../member/modifyForm.jsp");
		modelAndView.setViewName("../main/index.jsp");

		return modelAndView;
	}

	// modify
	@RequestMapping(value = "/member/modify.do")
	public ModelAndView modify(HttpServletRequest request) throws IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("memId");
		String pwd = request.getParameter("pwd");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		String addr = request.getParameter("addr");

		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setEmail1(email1);
		dto.setEmail2(email2);
		dto.setTel1(tel1);
		dto.setTel2(tel2);
		dto.setTel3(tel3);
		dto.setAddr(addr);

		int result = memberService.modify(dto);

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("result", result);
		modelAndView.addObject("req_sec", "../member/modify.jsp");
		modelAndView.setViewName("../main/index.jsp");
		return modelAndView;
	}

	// memberList
	@RequestMapping(value = "/member/memberList.do")
	public ModelAndView memberList(HttpServletRequest request) {
		int pg = 1;
		if (request.getParameter("pg") != null)
			pg = Integer.parseInt(request.getParameter("pg"));

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("memId");

		int totalA = memberService.getTotalMember(); 
		int totalP = (totalA + 4) / 5; 
		if (pg > totalP)
			pg = totalP;

		int endNum = pg * 5;
		int startNum = endNum - 4;

		List<MemberDTO> list = memberService.selectList(startNum, endNum);

		int startPage = (pg - 1) / 3 * 3 + 1;
		int endPage = startPage + 2;
		if (endPage > totalP)
			endPage = totalP; 

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("pg", pg);
		modelAndView.addObject("list", list);
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);
		modelAndView.addObject("totalP", totalP);
		modelAndView.addObject("req_sec", "../member/memberList.jsp");
		modelAndView.setViewName("../main/index.jsp");

		return modelAndView;
	}

	// deleteForm
	@RequestMapping(value = "/member/deleteForm.do")
	public ModelAndView deleteForm() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("req_sec", "../member/deleteForm.jsp");
		modelAndView.setViewName("../main/index.jsp");

		return modelAndView;
	}

	// delete
	@RequestMapping(value = "/member/delete.do")
	public ModelAndView delete(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("memId");

		int result = memberService.delete(id);

		if (result > 0) {
			session.removeAttribute("memName");
			session.removeAttribute("memId");
		}

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("result", result);
		modelAndView.addObject("req_sec", "../member/delete.jsp");
		modelAndView.setViewName("../main/index.jsp");
		return modelAndView;
	}

}
