package sr.unasat.libraryapp.service;

import sr.unasat.libraryapp.config.JPAConfig;
import sr.unasat.libraryapp.dao.AuthorDAO;
import sr.unasat.libraryapp.entities.Author;
import sr.unasat.libraryapp.entities.Book;

import java.util.List;

public class AuthorService {

   private final AuthorDAO authorDAO;

   public AuthorService(){this.authorDAO = new AuthorDAO(JPAConfig.getEntityManager());}

    public List<Author> retrieveAuthorlist(){return authorDAO.retrieveAuthorList();}

    public Author insertAuthor(Author author) {return authorDAO.insertAuthor(author);}

    public Author updateAuthor(Author author) {return authorDAO.updateAuthor(author);}

    public boolean deleteAuthor(long id){return authorDAO.deleteAuthor(id);}

    public Author findAuthorById(Long authorId) {return authorDAO.findAuthorById(authorId);}

    public Author findAuthorByLastName(String lastName) {return authorDAO.findAuthorByLastName(lastName);}

}
