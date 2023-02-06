package sr.unasat.libraryapp.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import sr.unasat.libraryapp.config.JPAConfig;
import sr.unasat.libraryapp.entities.Book;
import sr.unasat.libraryapp.entities.Genre;

import java.util.List;


public class GenreDAO {
    private EntityManager entityManager;
    public GenreDAO(EntityManager entityManager){this.entityManager = entityManager;}


    public List<Genre> retrieveGenreList() {
        entityManager.getTransaction().begin();
        String jpql = "select g from Genre g";
        TypedQuery<Genre> query = entityManager.createQuery(jpql, Genre.class);
        List<Genre> genreList = query.getResultList();
        entityManager.getTransaction().commit();
        return genreList;
    }

    public Genre insertGenre(Genre genre) {
        entityManager.getTransaction().begin();
        entityManager.persist(genre);
        entityManager.getTransaction().commit();
        return genre;
    }

    public Genre updateGenre(Genre genre) {
        try{
            entityManager.getTransaction().begin();
            entityManager.find(Genre.class, genre.getId());
            entityManager.merge(genre);
            entityManager.getTransaction().commit();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        return genre;
    }

    public boolean deleteGenre(long id) {
        try{
            entityManager.getTransaction().begin();
            Genre g = entityManager.find(Genre.class, id);
            entityManager.remove(g);
            entityManager.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return false;
    }

    public Genre findGenreByName(String name) {
        entityManager.getTransaction().begin();
        String query = "select g from Genre g where g.name = :name";
        TypedQuery<Genre> typedQuery = entityManager.createQuery(query, Genre.class);
        Genre genre = typedQuery.setParameter("name", name).getSingleResult();
        entityManager.getTransaction().commit();
        return genre;
    }

    public Genre findGenreById(Long genreId){
        String sqlquery = "SELECT g FROM Genre g where g.id = :genreId";
        TypedQuery<Genre> query = entityManager.createQuery(sqlquery, Genre.class);
        query.setParameter("genreId", genreId);
        Genre genre = query.getSingleResult();
        return genre;
    }
}
