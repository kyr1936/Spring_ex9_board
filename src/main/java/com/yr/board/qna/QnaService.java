package com.yr.board.qna;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yr.board.BoardDTO;
import com.yr.board.BoardService;
import com.yr.file.FileDAO;
import com.yr.file.FileDTO;
import com.yr.util.FileSaver;
import com.yr.util.PageMaker;

@Service
public class QnaService implements BoardService {

	@Inject
	private QnaDAO qnaDAO;
	@Inject
	private FileDAO fileDAO;
	@Inject
	private FileSaver fileSaver;
	
	
	// 답글 
	public int setReply(QnaDTO qnaDTO) throws Exception {
		// 1. 사전작업
		int result = qnaDAO.setReplyUpdate(qnaDTO);
		
		// 2. insert
		result = qnaDAO.setReply(qnaDTO);
		
		return result;
	}
	
	@Override
	public int setDelete(int num) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.setDelete(num);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setWrite(BoardDTO boardDTO, List<MultipartFile> multipartFiles, HttpSession session) throws Exception {
		// qna Insert
		int result = qnaDAO.setWrite(boardDTO);
		
		//files Insert
		String realPath = session.getServletContext().getRealPath("/resources/qna");
		// 매개변수 List타입의 files를 setting 해줘야 함
		
		// num = boardDTO.getNum();
		// oname=multipartFile.getOriginalName();
		// fname=? file을 HDD에 저장하고 저장된 파일명을 가져와야함 -> FileSaver에서 처리
		//			fileSaver.saveFile(realPath, multipartFile)
		ArrayList<FileDTO> files= new ArrayList<FileDTO>();
		for(MultipartFile file : multipartFiles) {	//multipartFiles 의 변수명을  file로
			if(file.getOriginalFilename().length()>0) {
				FileDTO fileDTO = new FileDTO();
				fileDTO.setNum(boardDTO.getNum());
				fileDTO.setOname(file.getOriginalFilename());
				fileDTO.setFname(fileSaver.saveFile(realPath, file));
				files.add(fileDTO);
			}
		}
		
		result = fileDAO.setWrite(files);
		
		return result;
	}

	@Override
	public List<BoardDTO> getList(PageMaker pageMaker) throws Exception {
		// 1.startRow, lastRow
		pageMaker.makeRow();
		List<BoardDTO> lists = qnaDAO.getList(pageMaker);
		// 2. paging , totalCount
		int totalCount = qnaDAO.getTotalCount(pageMaker);
		pageMaker.makePage(totalCount);
		
		return lists;
	}

	@Override
	public BoardDTO getSelect(int num) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.getSelect(num);
	}

}
