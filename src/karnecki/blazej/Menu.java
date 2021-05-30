package karnecki.blazej;
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

    public void chooseAction() {
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
                loadFromFile();
                break;
            case EXIT:
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + action);
        }
    }

    //todo
    private String loadFromFile() {
        return "file";
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
