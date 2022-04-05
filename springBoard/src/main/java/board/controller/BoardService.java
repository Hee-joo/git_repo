package board.controller;

import java.util.List;
import board.bean.BoardDTO;

public interface BoardService {
	public List<BoardDTO> boardList(int startNum, int endNum);
	public BoardDTO boardView(int seq);
	public int getTotalA();
	public int boardWrite(BoardDTO dto);
	public int boardModify(BoardDTO dto);
	public int updateHit(int seq);
	public int boardDelete(int seq);
}
