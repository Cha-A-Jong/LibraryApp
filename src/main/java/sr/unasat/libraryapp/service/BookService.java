package sr.unasat.libraryapp.service;

import sr.unasat.libraryapp.config.JPAConfig;
import sr.unasat.libraryapp.dao.BookDAO;
import sr.unasat.libraryapp.entities.Book;

import java.util.List;

public class BookService {

    private final BookDAO bookDAO;

    public BookService(){this.bookDAO = new BookDAO(JPAConfig.getEntityManager());}

    public List<Book> retrieveBooklist(){return bookDAO.retrieveBooklist();}

    public Book insertBook(Book book) {return bookDAO.insertBook(book);}

    public Book updateBook(Book book) {return bookDAO.updateBook(book);}

    public boolean deleteBook(long id){return bookDAO.deleteBook(id);}

    public Book findBookById(Long bookId) {return bookDAO.findBookById(bookId);}

    public Book findBookByTitle(String title) {return bookDAO.findBookByTitle(title);}

}
