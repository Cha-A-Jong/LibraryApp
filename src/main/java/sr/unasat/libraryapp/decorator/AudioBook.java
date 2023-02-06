package sr.unasat.libraryapp.decorator;

import sr.unasat.libraryapp.entities.Book;

public class AudioBook implements OnlineBook{
    @Override
    public void getBook(Book insertBook) {
        System.out.println(insertBook.getTitle());
    }
}
