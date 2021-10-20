package com.app.service;

import java.util.List;

import com.app.spring.dto.BookDetailDto;
import com.app.spring.dto.BookSubjectDto;

public interface BookServiceInterface {
	public void saveSubject(BookSubjectDto subject);
	public BookSubjectDto searchBySubject(String subjectName);
	public List<BookSubjectDto> getAllSubject();
	public void saveBookDetail(BookDetailDto bookDetail);
	public BookDetailDto getBookDetailById(int bookId);
	public void updateBookAvailableOrNot(int book_id, String task);
	public List<BookDetailDto> searchBook(int bid, String bname,int startIndex);
	public List<BookDetailDto> getAllBooks();
	public void deleteBookbyId(int bid);
	public int searchBookCount(int bid, String bname);
}
