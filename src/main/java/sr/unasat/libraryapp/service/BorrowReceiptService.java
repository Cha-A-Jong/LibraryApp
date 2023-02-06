package sr.unasat.libraryapp.service;

import sr.unasat.libraryapp.config.JPAConfig;
import sr.unasat.libraryapp.dao.BookDAO;
import sr.unasat.libraryapp.dao.BorrowReceiptDAO;
import sr.unasat.libraryapp.entities.Book;
import sr.unasat.libraryapp.entities.BorrowReceipt;
import sr.unasat.libraryapp.entities.Member;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BorrowReceiptService {

    private final BorrowReceiptDAO borrowReceiptDAO;

    public BorrowReceiptService(){this.borrowReceiptDAO = new BorrowReceiptDAO(JPAConfig.getEntityManager());}

    public List<BorrowReceipt>retrieveReceiptList (){return borrowReceiptDAO.retrieveReceiptList();}

    public BorrowReceipt insertReceipt(BorrowReceipt borrowReceipt) {return borrowReceiptDAO.insertReceipt(borrowReceipt);}

    public BorrowReceipt updateReceipt(BorrowReceipt borrowReceipt) {return borrowReceiptDAO.updateReceipt(borrowReceipt);}

    public boolean deleteReceipt(long id){return borrowReceiptDAO.deleteReceipt(id);}

    public BorrowReceipt findBorrowReceiptById(Long borrowreceiptId) {return borrowReceiptDAO.findBorrowReceiptById(borrowreceiptId);}

    public BorrowReceipt findReceiptByNumber(String receipt_number) {return  borrowReceiptDAO.findReceiptByNumber(receipt_number);}

    public List<Book> findBorrowDateByQuarter(LocalDate borrow_date) {return borrowReceiptDAO.findBorrowDateByQuarter(borrow_date);}

    public List<Book> findBorrowDateByYear(LocalDate borrow_date) {return borrowReceiptDAO.findBorrowDateByYear(borrow_date);}

}
