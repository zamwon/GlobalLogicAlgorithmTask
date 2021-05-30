package karnecki.blazej;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    String inputString;
    String chars;

    public String getInputString() {
        return inputString;
    }
    public String getChars() {
        return chars;
    }

    private enum ActionType {
        TYPE("type"),
        FILE("file"),
        EXIT("exit");
        String actionChosen;

        ActionType(String actionChosen) {
            this.actionChosen = actionChosen;
        }
    }

    public void chooseAction(){
        System.out.println("Choose data loading method -> \"type\" - for cmd input, \"file\" - for loading data from file: ");

        Scanner scanner = new Scanner(System.in);
        String scannerInput = scanner.nextLine();
        ActionType action = ActionType.valueOf(scannerInput.toUpperCase());

        switch (action) {
            case TYPE:
                inputString = strFromInput();
                chars = charactersFromInput();
                break;
            case FILE:
                inputString = loadFromFile().get(0).toUpperCase();
                chars = loadFromFile().get(1).toUpperCase();
                break;
            case EXIT:
                System.exit(1);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + action);
        }
    }

    private List<String> loadFromFile() {
        File file = new File("src/karnecki/blazej/TextFromFile");


        Scanner scan = null;
        String fileString = null;
        String fileChars = null;
        try {
            scan = new Scanner(file);
            fileString = scan.nextLine();
            fileChars = scan.nextLine();
        } catch (FileNotFoundException e) {
            e.getMessage();
        } finally {
            if (scan != null) {
                scan.close();
            }
        }

        return List.of(fileString, fileChars);
    }


    private String strFromInput() {
        System.out.println("Provide string:");
        Scanner inputStringScanner = new Scanner(System.in);

        return inputStringScanner.nextLine();
    }

    private String charactersFromInput() {
        System.out.println("Provide character you want look for:");
        Scanner charactersScanner = new Scanner(System.in);
        return charactersScanner.nextLine().toUpperCase();
    }

}
