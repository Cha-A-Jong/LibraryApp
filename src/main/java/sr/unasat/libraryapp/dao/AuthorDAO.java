package sr.unasat.libraryapp.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import sr.unasat.libraryapp.config.JPAConfig;
import sr.unasat.libraryapp.entities.Author;
import sr.unasat.libraryapp.entities.Book;

import java.util.List;

public class AuthorDAO {
    private EntityManager entityManager;
    public AuthorDAO(EntityManager entityManager){this.entityManager = entityManager;}

    public List<Author> retrieveAuthorList() {
        entityManager.getTransaction().begin();
        String jpql = "select a from Author a";
        TypedQuery<Author> query = entityManager.createQuery(jpql, Author.class);
        List<Author> authorList = query.getResultList();
        entityManager.getTransaction().commit();
        return authorList;
    }

    public Author insertAuthor(Author author){
        entityManager.getTransaction().begin();
        entityManager.persist(author);
        entityManager.getTransaction().commit();
        return author;
    }

    public Author updateAuthor(Author author){
        try{
            entityManager.getTransaction().begin();
            entityManager.find(Author.class, author.getId());
            entityManager.merge(author);
            entityManager.getTransaction().commit();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        return author;
    }

    public boolean deleteAuthor(long id){
        try{
            entityManager.getTransaction().begin();
            Author a = entityManager.find(Author.class, id);
            entityManager.remove(a);
            entityManager.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return false;
    }


    public Author findAuthorByLastName(String lastName){
        entityManager.getTransaction().begin();
        String query = "select a from Author a where a.lastName = :lastName";
        TypedQuery<Author> typedQuery = entityManager.createQuery(query,Author.class);
        Author author = typedQuery.setParameter("lastName", lastName).getSingleResult();
        entityManager.getTransaction().commit();
        return author;
    }

    public Author findAuthorById(Long authorId){
        String sqlquery = "SELECT a FROM Author a where a.id = :authorId";
        TypedQuery<Author> query = entityManager.createQuery(sqlquery, Author.class);
        query.setParameter("authorId", authorId);
        Author author = query.getSingleResult();
        return author;
    }
}
