 package com.app.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.hib.dao.BookDaoInterface;
import com.app.hib.entity.BookAuthorEntity;
import com.app.hib.entity.BookDetailEntity;
import com.app.hib.entity.BookPublisherEntity;
import com.app.hib.entity.BookSubjectEntity;
import com.app.spring.dto.BookAuthorDto;
import com.app.spring.dto.BookDetailDto;
import com.app.spring.dto.BookPublisherDto;
import com.app.spring.dto.BookSubjectDto;

@Service
@Transactional
public class BookService implements BookServiceInterface{

	@Autowired
	BookDaoInterface bookDao;
	
	@Override
	public void saveSubject(BookSubjectDto subject) {
		BookSubjectEntity subEntity=new BookSubjectEntity();
		
		BeanUtils.copyProperties(subject, subEntity);
		bookDao.saveSubject(subEntity);
		
	}

	@Override
	@Transactional(readOnly=true)
	public BookSubjectDto searchBySubject(String subjectName) {
		BookSubjectDto subDto=null;
		BookSubjectEntity subEntity=bookDao.searchBySubject(subjectName);
		if(subEntity!=null){
			subDto=new BookSubjectDto();
			BeanUtils.copyProperties(subEntity, subDto);
		}
		return subDto;
	}

	@Override
	@Transactional(readOnly=true)
	public List<BookSubjectDto> getAllSubject() {
		List<BookSubjectDto> subjectDto=new ArrayList<>();
		
		List<BookSubjectEntity> subjectEntity =bookDao.getAllSubject();
		if(!subjectEntity.isEmpty() && subjectEntity!=null){
			for(BookSubjectEntity subject : subjectEntity){
				BookSubjectDto dto=new BookSubjectDto();
				BeanUtils.copyProperties(subject, dto);
				subjectDto.add(dto);
			}
		}
		return subjectDto;
	}

	@Override
	public void saveBookDetail(BookDetailDto bookDetail) {
		
		BookPublisherDto publishDto=bookDetail.getBookPublisher();
		BookSubjectDto subjectDto=bookDetail.getBookSubject();
		List<BookAuthorDto> author=bookDetail.getBookAuthor();
		
		BookDetailEntity bookDetailEntity=new BookDetailEntity();
		BookPublisherEntity publishEntity=new BookPublisherEntity();
		List<BookAuthorEntity> authorEntity=new ArrayList<>();
		BookSubjectEntity subjectEntity=new BookSubjectEntity();
		
		if(bookDetail!=null && publishDto!=null && subjectDto!=null){
			BeanUtils.copyProperties(bookDetail, bookDetailEntity);
			BeanUtils.copyProperties(publishDto, publishEntity);
			BeanUtils.copyProperties(subjectDto, subjectEntity);
			
			for(BookAuthorDto ath : author){
				BookAuthorEntity athEntity = new BookAuthorEntity();
				BeanUtils.copyProperties(ath, athEntity);
				authorEntity.add(athEntity);
			}
			
			bookDetailEntity.setBookSubject(subjectEntity);
			bookDetailEntity.setBookPublisher(publishEntity);
			bookDetailEntity.setBookAuthor(authorEntity);
			
			bookDetailEntity.setBook_reg_date(new Date());
			bookDetailEntity.setBook_available(1);
			
			bookDao.saveBookDetail(bookDetailEntity);
		}
	}

	@Override
	@Transactional(readOnly=true)
	public BookDetailDto getBookDetailById(int bookId) {
		BookDetailDto bookDetailDto=null;
		BookDetailEntity bookDetailEntity=bookDao.getBookDetailById(bookId);
		
		if(bookDetailEntity!=null){
			bookDetailDto=new BookDetailDto();
			
			BookPublisherEntity publishEntity=bookDetailEntity.getBookPublisher();
			List<BookAuthorEntity> authorEntity=bookDetailEntity.getBookAuthor();
			BookSubjectEntity subjectEntity=bookDetailEntity.getBookSubject();
			
			BookPublisherDto publishDto=new BookPublisherDto();
			BookSubjectDto subjectDto=new BookSubjectDto();
			List<BookAuthorDto> author=new ArrayList<>();
			
			BeanUtils.copyProperties(bookDetailEntity,bookDetailDto);
			BeanUtils.copyProperties(publishEntity, publishDto);
			BeanUtils.copyProperties(subjectEntity,subjectDto);
			
			for(BookAuthorEntity authEntity : authorEntity){
				BookAuthorDto authDto=new BookAuthorDto();
				BeanUtils.copyProperties(authEntity, authDto);
				author.add(authDto);
			}
			
			bookDetailDto.setBookPublisher(publishDto);
			bookDetailDto.setBookSubject(subjectDto);
			bookDetailDto.setBookAuthor(author);
			
		}
		return bookDetailDto;
		
		
	}

	@Override
	public void updateBookAvailableOrNot(int book_id,String task) {
		BookDetailEntity book=bookDao.getBookDetailById(book_id);
		if(task.equals("notAvailable")){
			book.setBook_available(0);
		}else if(task.equals("available")){
			book.setBook_available(1);
		}
		
		bookDao.update(book);
	}

	@Override
	public List<BookDetailDto> searchBook(int bid, String bname,int startIndex) {
		List<BookDetailDto> listBookDto=null;
		
		List<BookDetailEntity> listBookEntity=bookDao.searchBook(bid,bname,startIndex);
		if(listBookEntity!=null){
			listBookDto=new ArrayList<>();
			for(BookDetailEntity bookEntity : listBookEntity){
				BookSubjectEntity subjectEntity=bookEntity.getBookSubject();  
				
				BookDetailDto bookDto=new BookDetailDto();
				BookSubjectDto subjectDto=new BookSubjectDto();
				
				BeanUtils.copyProperties(bookEntity, bookDto);
				BeanUtils.copyProperties(subjectEntity,subjectDto);
				
				bookDto.setBookSubject(subjectDto);
				listBookDto.add(bookDto);
			}
		}
		return listBookDto;
		
	}

	@Override
	public List<BookDetailDto> getAllBooks() {
List<BookDetailDto> listBookDto=null;
		
		List<BookDetailEntity> listBookEntity=bookDao.getAllBooks();
		if(listBookEntity!=null){
			listBookDto=new ArrayList<>();
			for(BookDetailEntity bookEntity : listBookEntity){
				BookSubjectEntity subjectEntity=bookEntity.getBookSubject();  
				
				BookDetailDto bookDto=new BookDetailDto();
				BookSubjectDto subjectDto=new BookSubjectDto();
				
				BeanUtils.copyProperties(bookEntity, bookDto);
				BeanUtils.copyProperties(subjectEntity,subjectDto);
				
				bookDto.setBookSubject(subjectDto);
				listBookDto.add(bookDto);
			}
		}
		return listBookDto;
	}

	@Override
	public void deleteBookbyId(int bid) {
		bookDao.deleteBookbyId(bid);
	}

	@Override
	public int searchBookCount(int bid, String bname) {
		int totalResult=bookDao.searchBookCount(bid,bname);
		return totalResult;
	}

	

}
