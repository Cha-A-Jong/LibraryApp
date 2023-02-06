package sr.unasat.libraryapp.app;

import sr.unasat.libraryapp.service.*;

import java.io.IOException;
import java.util.Scanner;

public class Application {
    public static void close() throws InterruptedException {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
        Thread.sleep(100);
        System.out.println("Application closed........");
        System.exit(0);
    }

    public static void choose(){
        System.out.println("\nChoose your menu option: ");}

    public static void Menu() throws InterruptedException, IOException{
        Scanner input = new Scanner(System.in);
        int choice;
        do{
            System.out.println("\n\n\n\n\n\n\nMenu library app");
            System.out.println("------------------------------");
            System.out.println("1       Create dummy data");
            System.out.println("2       Data Retrieve/Read");
            System.out.println("3       Data update");
            System.out.println("4       Data delete");
            System.out.println("5       Design pattern Builder");
            System.out.println("6       Design pattern Chain of responsibility");
            System.out.println("7       Design pattern Decorator");
            System.out.println("8  [X]  CLOSE APP\n");
            choose();
            choice = input.nextInt();
        }
        while (choice > 8);
        switch (choice) {

            case 1:
                subMenu();
            case 2:
                subMenu2();
            case 3:
                subMenu3();
            case 4:
                subMenu4();
            case 5:
                subMenu5();
            case 6:
                subMenu6();
            case 7:
                subMenu7();
            case 8:
                close();
                break;
        }
    }

    public static void subMenu() throws InterruptedException, IOException{
        DummyDataService.createDummyData();
        System.out.println("Dummy Data created succesful\n");
        int choice;
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("-----------------------\n");
            System.out.print("1  [<]  MENU\n");
            System.out.print("2  [X]  CLOSE APP\n");
            choose();
            choice = input.nextInt();
        }
        while (choice > 2);
        switch (choice) {
            case 1:
                Menu();
            case 2:
                close();
        }
    }

    public static void subMenu2() throws InterruptedException, IOException {
        DataService.RetrieveBook();
        System.out.println("Data Retrieve/Read 'books' succesful\n");
        int choice;
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("-----------------------\n");
            System.out.print("1  [<]  MENU\n");
            System.out.print("2  [X]  CLOSE APP\n");
            choose();
            choice = input.nextInt();
        }
        while (choice > 2);
        switch (choice) {
            case 1:
                Menu();
            case 2:
                close();
        }
    }

    public static void subMenu3() throws InterruptedException, IOException {
        DataService.updateBook();
        DataService.RetrieveBook();
        System.out.println("Data update 'book' succesful\n");
        int choice;
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("-----------------------\n");
            System.out.print("1  [<]  MENU\n");
            System.out.print("2  [X]  CLOSE APP\n");
            choose();
            choice = input.nextInt();
        }
        while (choice > 2);
        switch (choice) {
            case 1:
                Menu();
            case 2:
                close();
        }
    }

    public static void subMenu4() throws InterruptedException, IOException {
        DataService.deleteBook();
        DataService.RetrieveBook();
        System.out.println("Data delete 'book' succesful(data deleted where id is '1' ");
        int choice;
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("-----------------------\n");
            System.out.print("1  [<]  MENU\n");
            System.out.print("2  [X]  CLOSE APP\n");
            choose();
            choice = input.nextInt();
        }
        while (choice > 2);
        switch (choice) {
            case 1:
                Menu();
            case 2:
                close();
        }
    }

    public static void subMenu5() throws InterruptedException, IOException {
        BuilderService builderService = new BuilderService();
        builderService.builderApp();
        System.out.println("Design Pattern Builder succesful\n");
        int choice;
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("-----------------------\n");
            System.out.print("1  [<]  MENU\n");
            System.out.print("2  [X]  CLOSE APP\n");
            choose();
            choice = input.nextInt();
        }
        while (choice > 2);
        switch (choice) {
            case 1:
                Menu();
            case 2:
                close();

        }
    }
    public static void subMenu6() throws InterruptedException, IOException {
        MessageChainMaker messageChain = new MessageChainMaker();
        messageChain.messageMaker();
        System.out.println("Design pattern Chain of responsibility succesful\n");
        int choice;
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("-----------------------\n");
            System.out.print("1  [<]  MENU\n");
            System.out.print("2  [X]  CLOSE APP\n");
            choose();
            choice = input.nextInt();
        }
        while (choice > 2);
        switch (choice) {
            case 1:
                Menu();
            case 2:
                close();

        }
    }
    public static void subMenu7() throws InterruptedException, IOException {
        DecoratorService decoratorService = new DecoratorService();
        decoratorService.decoratorApp();
        System.out.println(">> Design Patterns Decorator succesful !!!\n");
        int choice;
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("-----------------------\n");
            System.out.print("1  [<]  MENU\n");
            System.out.print("2  [X]  CLOSE APP\n");
            choose();
            choice = input.nextInt();
        }
        while (choice > 2);
        switch (choice) {
            case 1:
                Menu();
            case 2:
                close();
        }
    }


//JPAConfig.shutdown();

}
