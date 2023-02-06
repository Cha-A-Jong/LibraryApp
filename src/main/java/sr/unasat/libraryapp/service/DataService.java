package sr.unasat.libraryapp.service;

import sr.unasat.libraryapp.entities.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DataService {

    public static void RetrieveBook(){
        BookService bookService = new BookService();
        List<Book> books = bookService.retrieveBooklist();
        System.out.println(
                "-----------------------------------------"
        );

        books.forEach(book ->
                System.out.format(
                                "\n" + "|| Book ISBN     :" + book.getIsbn() +
                                "\n" + "|| Book Title    :" + book.getTitle() +
                                "\n" + "|| Book Subtitle :" + book.getSubtitle() +
                                "\n" + "|| Author        :" + book.getAuthor() +
                                "\n" + "|| BorrowReceipt :" + book.getBorrowReceipt() +
                                "\n" + "|| Genre         :" + book.getGenre() +
                                "\n" + "|| Member        :" + book.getMembers() +
                                "\n\n"
                ));
        System.out.println(
                "-----------------------------------------");
        System.out.println("Retrieved records Book: " + "\n" + books);

    }

    public static void updateBook(){
        BookService bookService = new BookService();
        Book findBook = bookService.findBookByTitle("Hoe duur was de suiker?");
        findBook.setSubtitle("zo duur");
        bookService.updateBook(findBook);
        System.out.println("The following records are updates: " + findBook);
    }

    public static void deleteBook(){
        BookService bookService = new BookService();
        bookService.deleteBook(1L);
        System.out.println("The following records are deleted: " + 1L);
    }

    public static void BorrowDateReportByQuarter(){
        BorrowReceiptService borrowReceiptService = new BorrowReceiptService();
        List<Book> borrowDateSelectReport = borrowReceiptService.findBorrowDateByQuarter(LocalDate.parse("2022-01-08", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println(borrowDateSelectReport);
    }
    public static void BorrowDateReportByYear(){
        BorrowReceiptService borrowReceiptService = new BorrowReceiptService();
        List<Book> borrowDateSelectReport = borrowReceiptService.findBorrowDateByYear(LocalDate.parse("2022-01-08", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println(borrowDateSelectReport);
    }

    public static void RetrieveBorrowReceipt() {
        BorrowReceiptService borrowReceiptService = new BorrowReceiptService();
        List<BorrowReceipt> borrowReceipts = borrowReceiptService.retrieveReceiptList();
        System.out.println(
                "-----------------------------------------"
        );

        borrowReceipts.forEach(borrowReceipt ->
                System.out.format(
                                "\n" + "|| BorrowReceipt borrow_date       :" + borrowReceipt.getBorrow_date() +
                                "\n" + "|| BorrowReceipt Due_Date          :" + borrowReceipt.getDue_date() +
                                "\n" + "|| BorrowReceipt Receipt_Number    :" + borrowReceipt.getReceipt_number() +
                                "\n" + "|| BorrowReceipt remark            :" + borrowReceipt.getRemark() +
                                "\n" + "|| Member                          :" + borrowReceipt.getMember() +
                                "\n\n"
                ));
        System.out.println(
                "-----------------------------------------");
        System.out.println("Retrieved records receipts: " + "\n" + borrowReceipts);

    }

    public static void UpdateBorrowReceipt() {
        BorrowReceiptService borrowReceiptService = new BorrowReceiptService();
        BorrowReceipt findReceiptByNumber = borrowReceiptService.findReceiptByNumber("2022-003");
        findReceiptByNumber.setReceipt_number("2022-004");
        borrowReceiptService.updateReceipt(findReceiptByNumber);
        System.out.println("The following records are updates: " + findReceiptByNumber);
    }

    public static void deleteReceipt(){
        BorrowReceiptService borrowReceiptService = new BorrowReceiptService();
        borrowReceiptService.deleteReceipt(2L);
        System.out.println("The following records are deleted: " + 2L);
    }

    // Read all Member
    public static void RetrieveMember() {
        MemberService memberService = new MemberService();
        List<Member> members = memberService.retrieveMemberlist();
        System.out.println(
                "-----------------------------------------"
        );

        members.forEach(member ->
                System.out.format(
                                "\n" + "|| Member firstname     :" + member.getFirstName() +
                                "\n" + "|| Member lastname      :" + member.getLastName() +
                                "\n" + "|| Member DateOfBirth   :" + member.getDate_of_birth() +
                                "\n" + "|| Member CBBIdNumber   :" + member.getCbb_id_number() +
                                "\n" + "|| Member LibraryNumber :" + member.getLibrary_number() +
                                "\n\n"
                ));
        System.out.println(
                "-----------------------------------------");
        System.out.println("Retrieved records members: " + "\n" + members);
    }

    public static void updateMember() {
        MemberService memberService = new MemberService();
        Member findMemberByLastName= memberService.findMemberByLastName("Cha-A-Jong");
        findMemberByLastName.setFirstName("Chanel");
        memberService.updateMember(findMemberByLastName);
        System.out.println("The following records are updates: " + findMemberByLastName);
    }

    public static void deleteMember(){
        MemberService memberService = new MemberService();
        memberService.deleteMember(3L);
        System.out.println("The following records are deleted: " + 3L);
    }


    public static void RetrieveAuthor() {
        AuthorService authorService = new AuthorService();
        List<Author> authors = authorService.retrieveAuthorlist();
        System.out.println(
                "-----------------------------------------"
        );

        authors.forEach(author ->
                System.out.format(
                                "\n" + "|| Author Firstname    :" + author.getFirstName() +
                                "\n" + "|| Author Lastname     :" + author.getLastName() +
                                "\n" + "|| Author Books        :" + author.getBooks() +
                                "\n\n"
                ));
        System.out.println(
                "-----------------------------------------");

    }

    public static void updateAuthor() {
        AuthorService authorService = new AuthorService();
        Author findAuthorByLastName= authorService.findAuthorByLastName("Rowling");
        findAuthorByLastName.setFirstName("Marry");
        authorService.updateAuthor(findAuthorByLastName);
        System.out.println("The following records are updates: " + findAuthorByLastName);
    }

    public static void RetrieveGenre() {
        GenreService genreService = new GenreService();
        List<Genre> genres = genreService.retrieveGenrelist();
        System.out.println(
                "-----------------------------------------"
        );

        genres.forEach(genre ->
                System.out.format(
                                "\n" + "|| Genres       :" + genre.getName() +
                                "\n\n"
                ));
        System.out.println(
                "-----------------------------------------");
    }

    public static void updateGenre() {
        GenreService genreService = new GenreService();
        Genre findGenreByName = genreService.findGenreByName("Fantasy");
        findGenreByName.setName("Horror");
        genreService.updateGenre(findGenreByName);
        System.out.println("The following records are updates: " + findGenreByName);
    }
}
