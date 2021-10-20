package com.app.hib.dao;

import java.util.List;

import com.app.hib.entity.BookDetailEntity;
import com.app.hib.entity.BookSubjectEntity;

public interface BookDaoInterface {
	public void saveSubject(BookSubjectEntity subject);
	public BookSubjectEntity searchBySubject(String subjectName);
	public List<BookSubjectEntity> getAllSubject();
	public void saveBookDetail(BookDetailEntity bookDetailEntity);
	public BookDetailEntity getBookDetailById(int bookId);
	public void update(BookDetailEntity book);
	public List<BookDetailEntity> searchBook(int bid, String bname, int StartIndex);
	public List<BookDetailEntity> getAllBooks();
	public void deleteBookbyId(int bid);
	public int searchBookCount(int bid, String bname);
}
