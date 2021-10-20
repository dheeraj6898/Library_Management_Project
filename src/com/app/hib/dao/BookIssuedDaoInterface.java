package com.app.hib.dao;

import java.util.List;

import com.app.hib.entity.BookIssuedEntity;

public interface BookIssuedDaoInterface {

	public BookIssuedEntity bookIssued(BookIssuedEntity bookIssuedEntity);
	public BookIssuedEntity getByStudentIdAndBookId(int stu_Id, int book_id);
	public void update(BookIssuedEntity bookIssuedEntity);
	public BookIssuedEntity getBookIssuedById(int bookIssued_id);
	public List<BookIssuedEntity> getAllByStudentId(int sid);
	public List<BookIssuedEntity> getAllByBookId(int bid);

}
