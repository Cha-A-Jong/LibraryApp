package sr.unasat.libraryapp.chainofresponsibilities;

import sr.unasat.libraryapp.dao.BookDAO;
import sr.unasat.libraryapp.entities.Book;
import sr.unasat.libraryapp.service.BookService;

public class FirstMemberHandler implements ReceiverInterface{

    private ReceiverInterface nextReceiver;
    BookService bookService = new BookService();

    @Override
    public void setNextChain(ReceiverInterface nextReceiver) {
        this.nextReceiver = nextReceiver;

    }
    @Override
    public boolean processMessage(Message msg) {
        if (msg.text.contains("Chanelle"))  {
            Book book = bookService.findBookById(1l);
            System.out.println("The following book for member Chanelle has been requested: " + book + "\n" +msg.priority + "" + "priority issue: "+ msg.text);
            return true;
        }
        else { if (nextReceiver != null) { nextReceiver.processMessage(msg); } }
        return false;
    }

}
