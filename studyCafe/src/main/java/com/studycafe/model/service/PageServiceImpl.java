package com.studycafe.model.service;

import com.studycafe.model.dao.PageDao;
import com.studycafe.model.dto.Page;
import com.studycafe.model.dto.PageImage;
import com.studycafe.model.dto.PageMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("pageService")
public class PageServiceImpl implements PageService {

	@Autowired
	@Qualifier("oraclePageDao")
	private PageDao pageDao;
	
	@Override
	public List<Page> searchPageNoByMemberNo(int memberNo) {
		
		return pageDao.selectPageNoByMemberNo(memberNo);
	}

	@Override
	public List<PageMenu> selectPageMenuByPageNo(int pageNo) {
		
		return pageDao.selectPageMenuByPageNo(pageNo);
	}

	@Override
	public PageMenu selectMemberPageByMenuNo(int menuno) {
		return pageDao.selectMemberPageByMenuNo(menuno);
	}

	@Override
	public int insertPageMenuByAjax(PageMenu menu) {
		return pageDao.insertPageMenuByAjax(menu);
	}

	@Override
	public PageMenu selectPageMenuByPageNoNotice(int pageNo) {
		return pageDao.selectPageMenuByPageNoNotice(pageNo);
	}
	
	@Override
	public void registerImageFile(PageImage pi) {
		pageDao.insertImageFile(pi);
	}

	@Override
	public int selectMemberPageCountByMemberNo(int memberNo) {
		return pageDao.selectMemberPageCountByMemberNo(memberNo);
	}

	@Override
	public int insertPage(Page page) {
		return pageDao.insertPage(page);
	}

	@Override
	public void insertMemberPageByMemberNo(int memberNo, int pageNo, String name) {
		pageDao.insertMemberPageByMemberNo(memberNo, pageNo, name);
	}

	@Override
	public void insertPageMenuNotice(int pageNo) {
		pageDao.insertPageMenuNotice(pageNo);
	}

	@Override
	public int selectPageNo() {
		return pageDao.selectPageNo();
	}

}
