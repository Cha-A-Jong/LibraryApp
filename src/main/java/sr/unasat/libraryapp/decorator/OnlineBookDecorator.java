package sr.unasat.libraryapp.decorator;

import sr.unasat.libraryapp.entities.Book;

public abstract class OnlineBookDecorator implements OnlineBook{
    protected OnlineBook bookDecorator;

    public OnlineBookDecorator(OnlineBook bookDecorator) {
        this.bookDecorator = bookDecorator;
    }
    public void getBook(Book insertBook) {
        bookDecorator.getBook(insertBook);
    }
}
