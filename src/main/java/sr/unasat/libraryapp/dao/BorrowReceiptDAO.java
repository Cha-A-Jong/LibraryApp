package sr.unasat.libraryapp.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import sr.unasat.libraryapp.config.JPAConfig;
import sr.unasat.libraryapp.entities.Author;
import sr.unasat.libraryapp.entities.Book;
import sr.unasat.libraryapp.entities.BorrowReceipt;
import sr.unasat.libraryapp.entities.Member;

import java.time.LocalDate;
import java.util.List;

public class BorrowReceiptDAO {
    private EntityManager entityManager;
    public BorrowReceiptDAO(EntityManager entityManager){this.entityManager = entityManager;}

    public List<BorrowReceipt> retrieveReceiptList() {
        entityManager.getTransaction().begin();
        String jpql = "select b from BorrowReceipt b";
        TypedQuery<BorrowReceipt> query = entityManager.createQuery(jpql, BorrowReceipt.class);
        List<BorrowReceipt> receiptList = query.getResultList();
        entityManager.getTransaction().commit();
        return receiptList;
    }

    public BorrowReceipt insertReceipt(BorrowReceipt borrowReceipt) {
        entityManager.getTransaction().begin();
        entityManager.persist(borrowReceipt);
        entityManager.getTransaction().commit();
        return borrowReceipt;
    }

    public BorrowReceipt updateReceipt(BorrowReceipt borrowReceipt) {
        try{
            entityManager.getTransaction().begin();
            entityManager.find(BorrowReceipt.class, borrowReceipt.getId());
            entityManager.merge(borrowReceipt);
            entityManager.getTransaction().commit();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        return borrowReceipt;
    }

    public boolean deleteReceipt(long id) {
        try{
            entityManager.getTransaction().begin();
            BorrowReceipt br = entityManager.find(BorrowReceipt.class, id);
            entityManager.remove(br);
            entityManager.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return false;
    }

    public BorrowReceipt findReceiptByNumber(String receipt_number) {
        entityManager.getTransaction().begin();
        String query = "select b from BorrowReceipt b where b.receipt_number = :receipt_number";
        TypedQuery<BorrowReceipt> typedQuery = entityManager.createQuery(query, BorrowReceipt.class);
        BorrowReceipt borrowReceipt = typedQuery.setParameter("receipt_number", receipt_number).getSingleResult();
        entityManager.getTransaction().commit();
        return borrowReceipt;
    }

    public BorrowReceipt findBorrowReceiptById(Long borrowreceiptId){
        String sqlquery = "SELECT br FROM BorrowReceipt br where br.id = :borrowreceiptId";
        TypedQuery<BorrowReceipt> query = entityManager.createQuery(sqlquery, BorrowReceipt.class);
        query.setParameter("borrowreceiptId", borrowreceiptId);
        BorrowReceipt borrowReceipt = query.getSingleResult();
        return borrowReceipt;
    }

    public List<Book> findBorrowDateByQuarter(LocalDate borrow_date){
        entityManager.getTransaction().begin();
        String jpql = "select b from Book b join BorrowReceipt br on b.borrowReceipt.id = br.id where QUARTER(br.borrow_date) in (1) and br.remark =: remark ";
        TypedQuery<Book> query = entityManager.createQuery(jpql, Book.class);
        List<Book> bookList = query.setParameter("remark", "laat ingeleverd").getResultList();
        entityManager.getTransaction().commit();
        return bookList;
    }

    public List<Book> findBorrowDateByYear(LocalDate borrow_date) {
        entityManager.getTransaction().begin();
        String jpql = "select b from Book b join BorrowReceipt br on b.borrowReceipt.id =br.id where br.borrow_date = :borrow_date and YEAR(br.borrow_date) =:year";
        TypedQuery<Book> query = entityManager.createQuery(jpql, Book.class);
        List<Book> bookList = query.setParameter("borrow_date", borrow_date).setParameter("year", borrow_date.getYear()).getResultList();
        entityManager.getTransaction().commit();
        return bookList;
    }

}
