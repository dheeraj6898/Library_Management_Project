package com.app.service;

import java.util.List;

import com.app.spring.dto.BookDetailDto;
import com.app.spring.dto.BookIssuedDto;
import com.app.spring.dto.StudentDto;

public interface BookIssuedServiceInterface {

	public BookIssuedDto bookIssued(StudentDto student, BookDetailDto bookDetail);
	public BookIssuedDto bookReturn(StudentDto student, BookDetailDto book);
	public List<BookIssuedDto> getAllByStudentId(int sid);
	public List<BookIssuedDto> getAllByBookId(int bid);

}
