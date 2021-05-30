package karnecki.blazej;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Task {

    public static void main(String[] args) {
        Menu menu = new Menu();
        CharacterCounter characterCounter = new CharacterCounter();
        menu.chooseAction();

        List<Character> chars = menu.getChars()
                .chars()
                .mapToObj(e -> (char) e)
                .collect(Collectors.toList());

        characterCounter.countOccurrences(menu.getInputString(), new LinkedHashSet<>(chars));
    }
}
