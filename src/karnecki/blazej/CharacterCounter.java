package karnecki.blazej;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterCounter {

    void countOccurrences(String input, LinkedHashSet<Character> charactersLookedFor) {
        int frazeLength = trimStringSpecialChars(input).length();

        List<String> stringList =
                Arrays.stream
                        (removeStringSpecialChars(input).split(" "))
                        .collect(Collectors.toList());

        Map<String, Integer> setIntegerMap = new TreeMap<>(
                Comparator.comparingInt(String::length)
                        .thenComparing(Function.identity()));

        int totalOccur = 0;


        for (String s : stringList) {
            Set<String> charsInWord = new LinkedHashSet<>();
            int count = 0;
            for (char c : charactersLookedFor) {
                char cToUpperCase = Character.toUpperCase(c);
                if (s.contains(String.valueOf(cToUpperCase))) {
                    charsInWord.add(String.valueOf(cToUpperCase));
                    for (int i = 0; i < s.length(); i++) {
                        if (s.charAt(i) == cToUpperCase) {
                            count++;
                            totalOccur++;
                        }
                    }
                }
            }

            String str = charsInWord + " " + s.length();
            if (!setIntegerMap.containsKey(str)){
                setIntegerMap.put(str, count);
            } else {
                setIntegerMap.put(str, setIntegerMap.get(
                        str) + count);
            }
        }

        printResults(frazeLength, setIntegerMap, totalOccur);
    }

    private void printResults(int frazeLength, Map<String, Integer> setIntegerMap, int totalOccur) {
        int finalTotalOccur = totalOccur;
        setIntegerMap.forEach
                ((k, v) -> System.out.println(
                        "{" + k
                                + "} = "
                                + BigDecimal.valueOf(v.doubleValue() / finalTotalOccur)
                                .setScale(2, RoundingMode.HALF_UP)
                                + " " + v + "/" + finalTotalOccur + ")"));
        int sumOccur = setIntegerMap.values().stream().mapToInt(Integer::valueOf).sum();
        System.out.println
                ("TOTAL Frequency: " +
                        BigDecimal.valueOf((double) sumOccur / frazeLength).setScale(2, RoundingMode.HALF_UP) +
                        " " + sumOccur + "/" + frazeLength + ")");
    }


    private String removeStringSpecialChars(String input) {
        return input.toUpperCase()
                .replaceAll("[^a-zA-Z0-9]", " ");
    }

    private String trimStringSpecialChars(String input) {
        return input.replaceAll("[^a-zA-Z0-9]", "");
    }

}
