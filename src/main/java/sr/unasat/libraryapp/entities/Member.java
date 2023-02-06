package sr.unasat.libraryapp.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.util.Set;


@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate date_of_birth;
    private String library_number;
    private String cbb_id_number;

    @OneToOne(cascade = CascadeType.ALL)
    private BorrowReceipt borrowReceipt;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name= "book_member"
               ,joinColumns = {@JoinColumn(name = "member_id")},
                inverseJoinColumns = {@JoinColumn(name = "book_id")})
    private Set<Book> books;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getLibrary_number() {
        return library_number;
    }

    public void setLibrary_number(String library_number) {
        this.library_number = library_number;
    }

    public String getCbb_id_number() {
        return cbb_id_number;
    }

    public void setCbb_id_number(String cbb_id_number) {
        this.cbb_id_number = cbb_id_number;
    }

    public BorrowReceipt getBorrowReceipt() {
        return borrowReceipt;
    }

    public void setBorrowReceipt(BorrowReceipt borrowReceipt) {
        this.borrowReceipt = borrowReceipt;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Member{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
