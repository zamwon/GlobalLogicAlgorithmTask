package karnecki.blazej;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task {


    private static String removeStringSpecialChars(String input) {
        return input.toUpperCase()
                .replaceAll("[^a-zA-Z0-9]", " ");
    }

    private static String trimStringSpecialChars(String input) {
        return input.replaceAll("[^a-zA-Z0-9]", "");

    }

    private static void logicOccurrences(String input, LinkedHashSet<Character> charactersLookedFor) {

        int frazeLength = trimStringSpecialChars(input).length();

        List<String> stringList = Arrays.stream
                (removeStringSpecialChars(input).split(" "))
                .collect(Collectors.toList());

        Map<String, Integer> setIntegerMap = new TreeMap<>(
                Comparator.comparingInt(String::length)
                        .thenComparing(Function.identity()));
        int totalOccur = 0;
        for (String s : stringList) {
            Set<String> charsInWord = new LinkedHashSet<>();
            int count = 0;
            for (Character c : charactersLookedFor) {
                if (s.contains(String.valueOf(c))) {
                    charsInWord.add(String.valueOf(c));
                    for (int i = 0; i < s.length(); i++) {
                        if (s.charAt(i) == c) {
                            count++;
                            totalOccur++;
                        }
                    }
                }
            }

            if (!setIntegerMap.containsKey(charsInWord + " " + s.length())) {
                setIntegerMap.put(charsInWord + " " + s.length(), count);
            } else {
                setIntegerMap.put(charsInWord + " " + s.length(), setIntegerMap.get(
                        charsInWord + " " + s.length()) + count);
            }
        }

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


    public static void main(String[] args) {
        logicOccurrences("I love to work in global logic!", new LinkedHashSet<>(Arrays.asList('L', 'O', 'G', 'I', 'C')));
        System.out.println("#################");
        logicOccurrences("I love to code all day all night!", new LinkedHashSet<>(Arrays.asList('L', 'O', 'V', 'E')));

    }

}
