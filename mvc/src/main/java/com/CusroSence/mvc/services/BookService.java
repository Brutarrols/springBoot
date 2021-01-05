package com.CusroSence.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.CusroSence.mvc.models.Book;
import com.CusroSence.mvc.repositories.BookRepository;

@Service
public class BookService {
	  private final BookRepository bookRepository;
	    
	    public BookService(BookRepository bookRepository) {
	        this.bookRepository = bookRepository;
	    }
	    //Devolviendo todos los libros.
	    public List<Book> allBooks() {
	        return bookRepository.findAll();
	    }
	    //Creando un libro.
	    public Book createBook(Book b) {
	        return bookRepository.save(b);
	    }
	    //Obteniendo la información de un libro
	    public Book findBook(Long id) {
	        Optional<Book> optionalBook = bookRepository.findById(id);
	        if(optionalBook.isPresent()) {
	            return optionalBook.get();
	        } else {
	            return null;
	        }
	    }
	    
	    public Book updateBook(Long id,String title,String desc,String lang, int numOfPages)
	    {	
	    	Book update = new Book(title,desc,lang,numOfPages);
	    	update.setId(id);
	    	return bookRepository.save(update);
	    }
	    
	    public void deleteBook(Long id)
	    {
	    	bookRepository.deleteById(id);
	    }
}
