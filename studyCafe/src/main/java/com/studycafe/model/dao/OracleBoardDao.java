package com.studycafe.model.dao;

import com.studycafe.model.dto.Board;
import com.studycafe.model.dto.BoardFile;
import com.studycafe.model.dto.SmallCategory;
import com.studycafe.model.mapper.BoardMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("oracleBoardDao")
public class OracleBoardDao implements BoardDao {

	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	@Qualifier("boardMapper")
	private BoardMapper boardMapper;
	
	public int insertBoard(Board board) {
		boardMapper.insertBoard(board);
		return board.getBoardNo();		
	}

	@Override
	public void insertBoardFile(BoardFile file) {
		boardMapper.insertBoardFile(file);
	}
	
	public List<Board> selectBoardList() {
		List<Board> boards = boardMapper.selectBoardList();
		return boards;
	}
	
	public Board selectBoardByBoardNo(int boardNo) {
		Board board = boardMapper.selectBoardByBoardNo(boardNo);
		return board;
	}

	public Board selectBoardByBoardNo2(int boardNo) {
		Board board = boardMapper.selectBoardByBoardNo2(boardNo);
		return board;
	}

	public Board selectByCategory(int categoryBoardNo){
		Board board = boardMapper.selectByCategory(categoryBoardNo);
		return board;
	}

    @Override
    public Board searchBoardByBoardNo(int boardNo) {
        return null;
    }

    public SmallCategory selectSmallCategoryByBoardNo(int smallCategoryNo){
		return boardMapper.selectSmallCategoryByBoardNo(smallCategoryNo);
	}
	
	public void deleteBoard(int boardNo) {
		boardMapper.deleteBoard(boardNo);
	}

	@Override
	public List<Board> selectBoardListBySmallCategoryNo() {
		List<Board> boards = boardMapper.selectBoardListBySmallCategoryNo();
		return boards;
	}

	@Override
	public List<Board> selectBoardListByTime() {
		return boardMapper.selectBoardListByTime();
	}

	@Override
	public int selectBoardCountByBoardNo(int boardNo) {
		return boardMapper.selectBoardCountByBoardNo(boardNo);
	}
}