package sr.unasat.libraryapp.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.util.Set;

@Entity
public class BorrowReceipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String receipt_number;
    private LocalDate borrow_date;
    private LocalDate due_date;
    private String remark;

    @OneToOne(mappedBy = "borrowReceipt", cascade = CascadeType.ALL)
    private Member member;

    @OneToMany(mappedBy = "borrowReceipt", cascade = CascadeType.ALL)
    private Set<Book> books;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReceipt_number() {
        return receipt_number;
    }

    public void setReceipt_number(String receipt_number) {
        this.receipt_number = receipt_number;
    }

    public LocalDate getBorrow_date() {
        return borrow_date;
    }

    public void setBorrow_date(LocalDate borrow_date) {
        this.borrow_date = borrow_date;
    }

    public LocalDate getDue_date() {
        return due_date;
    }

    public void setDue_date(LocalDate due_date) {
        this.due_date = due_date;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "BorrowReceipt{" +
                "receipt_number='" + receipt_number + '\'' +
                ", borrow_date='" + borrow_date + '\'' +
                '}';
    }

}
