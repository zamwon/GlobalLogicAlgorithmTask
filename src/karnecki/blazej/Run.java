//package karnecki.blazej;
//
//
//import java.util.Scanner;
//
//public class Run {
//
//    private enum Action {
//        TYPE_IN("type"),
//        READ_FILE("file");
//        String actionChosen;
//
//        Action(String actionChosen) {
//            this.actionChosen = actionChosen;
//        }
//    }
//
//    public void chooseAction() {
//        System.out.println("\\Choose data load method -> (type, file): \\n\"");
//
//        Scanner scanner = new Scanner(System.in);
//        String scannerInput = scanner.next();
//        Action action = Action.valueOf(scannerInput.toUpperCase());
//
//        switch (action) {
//            case TYPE_IN:
//                loadFromScanner();
//                break;
//            case READ_FILE:
//                loadFromFile();
//                break;
//        }
//    }
//
//    private void loadFromFile() {
//    }
//
//    private String loadFromScanner() {
//
//    }
//
//}
//}
