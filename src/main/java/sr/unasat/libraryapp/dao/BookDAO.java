package sr.unasat.libraryapp.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import sr.unasat.libraryapp.config.JPAConfig;
import sr.unasat.libraryapp.entities.Book;
import sr.unasat.libraryapp.entities.Member;

import java.time.LocalDate;
import java.util.List;

public class BookDAO {
private EntityManager entityManager;
public BookDAO(EntityManager entityManager){this.entityManager = entityManager;}

    public BookDAO() { }

    public List<Book> retrieveBooklist(){
    entityManager.getTransaction().begin();
    String jpql = "select b from Book b";
    TypedQuery<Book> query = entityManager.createQuery(jpql, Book.class);
    List<Book> bookList = query.getResultList();
    entityManager.getTransaction().commit();
    return bookList;
}

public Book insertBook (Book book){
    entityManager.getTransaction().begin();
    entityManager.persist(book);
    entityManager.getTransaction().commit();
    return book;
}

public Book updateBook(Book book){
    try{
        entityManager.getTransaction().begin();
        entityManager.find(Book.class, book.getId());
        entityManager.merge(book);
        entityManager.getTransaction().commit();
    } catch (Exception e){
        throw new RuntimeException(e);
    }
    return book;
    }

public boolean deleteBook(long id){
    try{
        entityManager.getTransaction().begin();
        Book b = entityManager.find(Book.class, id);
        entityManager.remove(b);
        entityManager.getTransaction().commit();
    } catch (Exception e){
        e.printStackTrace();
        entityManager.getTransaction().rollback();
    }
    return false;
}

public Book findBookByTitle(String title){
    entityManager.getTransaction().begin();
    String jpql = "select b from Book b where b.title = :title";
    TypedQuery<Book> query = entityManager.createQuery(jpql, Book.class);
    Book book = query.setParameter("title", title).getSingleResult();
    entityManager.getTransaction().commit();
    return book;
}

public Book findBookById(Long bookId){
    String sqlquery = "SELECT b FROM Book b where b.id = :bookId";
    TypedQuery<Book> query = entityManager.createQuery(sqlquery, Book.class);
    query.setParameter("bookId", bookId);
    Book book = query.getSingleResult();
    return book;
}

}
