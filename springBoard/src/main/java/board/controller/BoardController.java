package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import board.bean.BoardDTO;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;

	// boardList
	@RequestMapping(value = "/board/boardList.do")
	public ModelAndView boardList(HttpServletRequest request) {
		int pg = 1;
		if (request.getParameter("pg") != null)
			pg = Integer.parseInt(request.getParameter("pg"));

		int totalA = boardService.getTotalA(); 
		int totalP = (totalA + 4) / 5; 
		if (pg > totalP) pg = totalP;

		int endNum = pg * 5;
		int startNum = endNum - 4;

		List<BoardDTO> list = boardService.boardList(startNum, endNum);

		int startPage = (pg - 1) / 3 * 3 + 1;
		int endPage = startPage + 2;
		if (endPage > totalP) endPage = totalP;

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("pg", pg);
		modelAndView.addObject("list", list);
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);
		modelAndView.addObject("totalP", totalP);
		modelAndView.addObject("req_sec", "../board/boardList.jsp");
		modelAndView.setViewName("../main/index.jsp");

		return modelAndView;
	}

	// boardWriteForm
	@RequestMapping(value = "/board/boardWriteForm.do")
	public ModelAndView boardWriteForm() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("req_sec", "../board/boardWriteForm.jsp");
		modelAndView.setViewName("../main/index.jsp");

		return modelAndView;
	}
	
	// boardWrite
	@RequestMapping(value="/board/boardWrite.do")
	public ModelAndView boardWrite(HttpServletRequest request) throws IOException {
		request.setCharacterEncoding("utf-8");
		
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		HttpSession session = request.getSession();
		String name = (String)session.getAttribute("memName");
		String id = (String)session.getAttribute("memId");

		BoardDTO dto = new BoardDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setSubject(subject);
		dto.setContent(content);

		int result = boardService.boardWrite(dto);

		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("result", result);
		modelAndView.addObject("req_sec", "../board/boardWrite.jsp");
		modelAndView.setViewName("../main/index.jsp");
		return modelAndView;
	}
	
	// boardView
	@RequestMapping(value = "/board/boardView.do")
	public ModelAndView boardView(HttpServletRequest request) {
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));

		boardService.updateHit(seq);
		BoardDTO dto = boardService.boardView(seq);

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("dto", dto);
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("req_sec", "../board/boardView.jsp");
		modelAndView.setViewName("../main/index.jsp");
		
		return modelAndView;
	}
	
	// boardModifyForm
	@RequestMapping(value="/board/boardModifyForm.do")
	public ModelAndView boardModifyForm(HttpServletRequest request) {
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		BoardDTO dto = boardService.boardView(seq);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("dto", dto);
		modelAndView.addObject("req_sec", "../board/boardModifyForm.jsp");
		modelAndView.setViewName("../main/index.jsp");
		
		return modelAndView;
	}
	
	// boardModify
	@RequestMapping(value="/board/boardModify.do")
	public ModelAndView boardModify(HttpServletRequest request) throws IOException {
		request.setCharacterEncoding("utf-8");

		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		BoardDTO dto = new BoardDTO(); 	
		dto.setSeq(seq);
		dto.setSubject(subject);
		dto.setContent(content);
		
		int result = boardService.boardModify(dto);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("result", result);
		modelAndView.addObject("req_sec", "../board/boardModify.jsp");
		modelAndView.setViewName("../main/index.jsp");
		return modelAndView;
	}
	
	// boardDelete
	@RequestMapping(value="/board/boardDelete.do")
	public ModelAndView boardDelete(HttpServletRequest request) {
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		int result = boardService.boardDelete(seq);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("result", result);
		modelAndView.addObject("req_sec", "../board/boardDelete.jsp");
		modelAndView.setViewName("../main/index.jsp");
		return modelAndView;
	}
}
