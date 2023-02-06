package sr.unasat.libraryapp.service;

import sr.unasat.libraryapp.entities.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class DummyDataService {

    public static void createDummyData(){

        //create book

        BookService bookService = new BookService();
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        Book book4 = new Book();
        Book book5 = new Book();

        book1.setIsbn("152663788X");
        book1.setTitle("Harry Potter and the Chamber of Secrets");
        bookService.insertBook(book1);

        book2.setIsbn("9054294485");
        book2.setTitle("Hoe duur was de suiker?");
        bookService.insertBook(book2);

        book3.setIsbn("0312022824");
        book3.setTitle("The Silence of the lambs");
        bookService.insertBook(book3);

        book4.setIsbn("0670813028");
        book4.setTitle("IT");
        bookService.insertBook(book4);

        book5.setIsbn("9798622644122");
        book5.setTitle("Sweet temptation");
        bookService.insertBook(book5);

        //create genre
        GenreService genreService = new GenreService();
        Genre genre1 = new Genre();
        Genre genre2 = new Genre();
        Genre genre3 = new Genre();
        Genre genre4 = new Genre();
        Genre genre5 = new Genre();

        genre1.setName("Fantasy");
        Genre genres1 = genreService.insertGenre(genre1);
        book1.setGenre(genres1);
        genre1.setBook(book1);

        genre2.setName("Roman");
        Genre genres2 = genreService.insertGenre(genre2);
        book2.setGenre(genres2);
        genre2.setBook(book2);

        genre3.setName("Thriller");
        Genre genres3 = genreService.insertGenre(genre3);
        book3.setGenre(genres3);
        genre3.setBook(book3);

        genre4.setName("Horror");
        Genre genres4 = genreService.insertGenre(genre4);
        book4.setGenre(genres4);
        genre4.setBook(book4);

        genre5.setName("Fiction");
        Genre genres5 = genreService.insertGenre(genre5);
        book5.setGenre(genres5);
        genre5.setBook(book5);

        //create author
        AuthorService authorService = new AuthorService();
        Author author1 = new Author();
        Author author2 = new Author();
        Author author3 = new Author();
        Author author4 = new Author();
        Author author5 = new Author();

        author1.setFirstName("Joanna");
        author1.setLastName("Rowling");
        Author authors1 = authorService.insertAuthor(author1);
        authorService.insertAuthor(author1);
        book1.setAuthor(authors1);

        author2.setFirstName("Cynthia");
        author2.setLastName("McLeod");
        Author authors2 = authorService.insertAuthor(author2);
        authorService.insertAuthor(author2);
        book2.setAuthor(authors2);

        author3.setFirstName("Thomas");
        author3.setLastName("Harris");
        Author authors3 = authorService.insertAuthor(author3);
        authorService.insertAuthor(author3);
        book3.setAuthor(authors3);

        author4.setFirstName("Stephen");
        author4.setLastName("King");
        Author authors4 = authorService.insertAuthor(author4);
        authorService.insertAuthor(author4);
        book4.setAuthor(authors4);

        author5.setFirstName("Cora");
        author5.setLastName("Reilly");
        Author authors5 = authorService.insertAuthor(author5);
        authorService.insertAuthor(author5);
        book5.setAuthor(authors5);

        //create member
        Set<Member> memberSet = new HashSet<>();
        MemberService memberService = new MemberService();
        Member member1 = new Member();
        Member member2 = new Member();
        Member member3 = new Member();
        Member member4 = new Member();
        Member member5 = new Member();

        member1.setFirstName("Chanelle");
        member1.setLastName("Cha-A-Jong");
        member1.setDate_of_birth(LocalDate.of(1990,2,14));
        member1.setLibrary_number("202212001");
        member1.setCbb_id_number("FI000794");
        memberSet.add(member1);
        memberService.insertMember(member1);
        book1.setMembers(memberSet);

        member2.setFirstName("Ashwin");
        member2.setLastName("Adhin");
        member2.setDate_of_birth(LocalDate.of(1980,6,10));
        member2.setLibrary_number("202212002");
        member2.setCbb_id_number("BA080211");
        memberSet.add(member2);
        memberService.insertMember(member2);
        book2.setMembers(memberSet);

        member3.setFirstName("Bronto");
        member3.setLastName("Somohardjo");
        member3.setDate_of_birth(LocalDate.of(1980,1,20));
        member3.setLibrary_number("202212003");
        member3.setCbb_id_number("DA000123");
        memberSet.add(member3);
        memberService.insertMember(member3);
        book3.setMembers(memberSet);

        member4.setFirstName("Chan");
        member4.setLastName("Santokhi");
        member4.setDate_of_birth(LocalDate.of(1959,2,03));
        member4.setLibrary_number("202212004");
        member4.setCbb_id_number("AB000111");
        memberSet.add(member4);
        memberService.insertMember(member4);
        book4.setMembers(memberSet);

        member5.setFirstName("Ronnie");
        member5.setLastName("Brunswijk");
        member5.setDate_of_birth(LocalDate.of(1961,3,07));
        member5.setLibrary_number("202212005");
        member5.setCbb_id_number("BO004587");
        memberSet.add(member5);
        memberService.insertMember(member5);
        book5.setMembers(memberSet);

        //create borrowreceipt
        BorrowReceiptService borrowReceiptService = new BorrowReceiptService();
        BorrowReceipt receipt1= new BorrowReceipt();
        BorrowReceipt receipt2 = new BorrowReceipt();
        BorrowReceipt receipt3 = new BorrowReceipt();
        BorrowReceipt receipt4 = new BorrowReceipt();
        BorrowReceipt receipt5 = new BorrowReceipt();

        receipt1.setReceipt_number("2022-001");
        receipt1.setBorrow_date(LocalDate.of(2022,1,8));
        receipt1.setDue_date(LocalDate.of(2022,1,15));

        receipt2.setReceipt_number("2022-002");
        receipt2.setBorrow_date(LocalDate.of(2022,1,8));
        receipt2.setDue_date(LocalDate.of(2022,1,15));
        receipt2.setRemark("laat ingeleverd");

        receipt3.setReceipt_number("2022-003");
        receipt3.setBorrow_date(LocalDate.of(2022,1,8));
        receipt3.setDue_date(LocalDate.of(2022,1,15));
        receipt3.setRemark("laat ingeleverd");

        receipt4.setReceipt_number("2022-004");
        receipt4.setBorrow_date(LocalDate.of(2022,4,12));
        receipt4.setDue_date(LocalDate.of(2022,4,19));
        receipt4.setRemark("boek gescheurd");

        receipt5.setReceipt_number("2022-005");
        receipt5.setBorrow_date(LocalDate.of(2022,4,12));
        receipt5.setDue_date(LocalDate.of(2022,4,19));
        receipt5.setRemark("boek gescheurd");

        //relatie tussen receipt en book
        BorrowReceipt borrowReceiptbook1 = borrowReceiptService.insertReceipt(receipt1);
        book1.setBorrowReceipt(borrowReceiptbook1);
        BorrowReceipt borrowReceiptbook2 = borrowReceiptService.insertReceipt(receipt2);
        book2.setBorrowReceipt(borrowReceiptbook2);
        BorrowReceipt borrowReceiptbook3 = borrowReceiptService.insertReceipt(receipt3);
        book3.setBorrowReceipt(borrowReceiptbook3);
        BorrowReceipt borrowReceiptbook4 = borrowReceiptService.insertReceipt(receipt4);
        book4.setBorrowReceipt(borrowReceiptbook4);
        BorrowReceipt borrowReceiptbook5 = borrowReceiptService.insertReceipt(receipt5);
        book5.setBorrowReceipt(borrowReceiptbook5);

        //relatie tussen borrowreceipt + member
        BorrowReceipt borrowReceipts1 = borrowReceiptService.insertReceipt(receipt1);
        member1.setBorrowReceipt(borrowReceipts1);
        receipt1.setMember(member1);

        BorrowReceipt borrowReceipts2 = borrowReceiptService.insertReceipt(receipt2);
        member2.setBorrowReceipt(borrowReceipts2);
        receipt2.setMember(member2);

        BorrowReceipt borrowReceipts3 = borrowReceiptService.insertReceipt(receipt3);
        member3.setBorrowReceipt(borrowReceipts3);
        receipt3.setMember(member3);

        BorrowReceipt borrowReceipts4 = borrowReceiptService.insertReceipt(receipt4);
        member4.setBorrowReceipt(borrowReceipts4);
        receipt4.setMember(member4);

        BorrowReceipt borrowReceipts5 = borrowReceiptService.insertReceipt(receipt5);
        member5.setBorrowReceipt(borrowReceipts5);
        receipt5.setMember(member5);

        //create receipt
        borrowReceiptService.insertReceipt(receipt1);
        borrowReceiptService.insertReceipt(receipt2);
        borrowReceiptService.insertReceipt(receipt3);
        borrowReceiptService.insertReceipt(receipt4);
        borrowReceiptService.insertReceipt(receipt5);

    }
}

