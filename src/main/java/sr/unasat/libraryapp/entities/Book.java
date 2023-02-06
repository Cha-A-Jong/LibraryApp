package sr.unasat.libraryapp.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Set;


@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String isbn;
    private String title;
    private String subtitle;

    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL)
    private Genre genre;

    @ManyToOne(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="author_id")
    private Author author;

    @ManyToOne(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name= "borrowReceipt_Id")
    private BorrowReceipt borrowReceipt;

    @ManyToMany(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable(name = "book_member"
                , joinColumns = {@JoinColumn(name ="book_id")},
                    inverseJoinColumns = @JoinColumn(name="member_id"))
    private Set<Member> members;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Author getAuthor() {return author;}

    public void setAuthor(Author author) {
        this.author = author;
    }

    public BorrowReceipt getBorrowReceipt() {
        return borrowReceipt;
    }

    public void setBorrowReceipt(BorrowReceipt borrowReceipt) {
        this.borrowReceipt = borrowReceipt;
    }

    public Set<Member> getMembers() {
        return members;
    }

    public void setMembers(Set<Member> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                '}';
    }
}
