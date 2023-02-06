package sr.unasat.libraryapp.service;

import sr.unasat.libraryapp.dao.BookDAO;
import sr.unasat.libraryapp.decorator.AudioBook;
import sr.unasat.libraryapp.decorator.EBook;
import sr.unasat.libraryapp.decorator.OnlineBook;

public class DecoratorService {
    BookService bookService = new BookService();

    public void decoratorApp(){
        bookService.findBookByTitle("Hoe duur was de suiker?");

        OnlineBook audioBook = new AudioBook(); //casting ->creating an onlinebook object but referencing it to the audiobook
        OnlineBook eBook = new EBook(new AudioBook());

        System.out.println("Customer request to purchase an Audio Book");
        audioBook.getBook(bookService.findBookByTitle("Hoe duur was de suiker?"));

        System.out.println("\n ");
        eBook.getBook(bookService.findBookByTitle("The Hobbit"));

    }
}
