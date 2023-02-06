package sr.unasat.libraryapp.service;

import org.hibernate.boot.archive.internal.JarProtocolArchiveDescriptor;
import sr.unasat.libraryapp.config.JPAConfig;
import sr.unasat.libraryapp.dao.GenreDAO;
import sr.unasat.libraryapp.entities.Book;
import sr.unasat.libraryapp.entities.Genre;

import java.util.List;

public class GenreService {

    private final GenreDAO genreDAO;

    public GenreService(){this.genreDAO = new GenreDAO(JPAConfig.getEntityManager());}

    public List<Genre> retrieveGenrelist(){return genreDAO.retrieveGenreList();}

    public Genre insertGenre(Genre genre) {return genreDAO.insertGenre(genre);}

    public Genre updateGenre(Genre genre) {return genreDAO.updateGenre(genre);}

    public boolean deleteGenre(long id){return genreDAO.deleteGenre(id);}

    public Genre findGenreById(Long genreId) {return genreDAO.findGenreById(genreId);}

    public Genre findGenreByName(String name) {return genreDAO.findGenreByName(name);}
}
