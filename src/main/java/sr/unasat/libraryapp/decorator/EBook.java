package sr.unasat.libraryapp.decorator;

import sr.unasat.libraryapp.dao.BookDAO;
import sr.unasat.libraryapp.entities.Book;
import sr.unasat.libraryapp.service.BookService;

public class EBook extends OnlineBookDecorator implements OnlineBook{

    BookService bookService = new BookService();

    public EBook(OnlineBook bookDecorator) {
        super(bookDecorator);
    }

    @Override
    public void getBook(Book insertBook) {
        requestBook(bookDecorator);
        Book eBookInsert = new Book();
        eBookInsert.setTitle("The Hobbit");
        bookService.insertBook(eBookInsert);
        bookDecorator.getBook(eBookInsert);

    }

    private void requestBook(OnlineBook bookDecorator) {
        System.out.println("Customer request to purchase a Ebook version of: ");
    }

}
