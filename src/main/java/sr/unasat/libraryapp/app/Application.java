package sr.unasat.libraryapp.app;

import sr.unasat.libraryapp.config.JPAConfig;
import sr.unasat.libraryapp.dao.BookDAO;
import sr.unasat.libraryapp.entities.Author;
import sr.unasat.libraryapp.entities.BorrowReceipt;
import sr.unasat.libraryapp.entities.Genre;
import sr.unasat.libraryapp.service.*;

import javax.xml.crypto.Data;

public class Application {
    public static void main(String[] args) {

//        DummyDataService.createDummyData();

//       Book Service
//        DataService.RetrieveBook();
//        DataService.updateBook();
//        DataService.deleteBook();

//        Boeken die zijn uitgeleend in de eerste kwartaal en laat zijn ingeleverd
//        DataService.BorrowDateReportByQuarter();
//        Boeken die zijn uitgeleend binnen een bepaalde jaar
//        DataService.BorrowDateReportByYear();

//        BorrowReceipt Service
//        DataService.RetrieveBorrowReceipt();
//        DataService.UpdateBorrowReceipt();
//        DataService.deleteReceipt();

//        Member Service
//        DataService.RetrieveMember();
//        DataService.updateMember();
//        DataService.deleteMember();

//        Author Service
//        DataService.RetrieveAuthor();
//        DataService.updateAuthor();

//        Genre Service
//        DataService.RetrieveGenre();
//        DataService.updateGenre();

        //Decorator
        DecoratorService decoratorService = new DecoratorService();
//        decoratorService.decoratorApp();

        //ChainOfResponsibilties
        MessageChainMaker messageChain = new MessageChainMaker();
//        messageChain.messageMaker();

        //Builder
        BuilderService builderService = new BuilderService();
//        builderService.builderApp();

//JPAConfig.shutdown();

    }
}
