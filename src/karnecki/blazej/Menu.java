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

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    public String getChars() {
        return chars;
    }

    public void setChars(String chars) {
        this.chars = chars;
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

    public String chooseAction() throws FileNotFoundException {
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
        return action.toString();
    }

    //todo
    private List<String> loadFromFile() throws FileNotFoundException {
        File file = new File("src/karnecki/blazej/TextFromFile");


        Scanner scan = new Scanner(file);
        String fileString = scan.nextLine();
        String fileChars = scan.nextLine();
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
