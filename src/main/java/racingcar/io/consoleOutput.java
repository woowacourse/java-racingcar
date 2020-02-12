package racingcar.io;

import java.util.LinkedHashMap;
import java.util.List;

public class consoleOutput {
    public static void printStatus(LinkedHashMap<String, Integer> status) {
        status.forEach((name, position) -> {
            System.out.println(name + ": " + stripBuilder(position));
        });
        System.out.println("");
    }

    private static String stripBuilder(Integer position) {
        String strip = "";
        for (int i = 0; i < position; i++) {
            strip += "-";
        }
        return strip;
    }

    public static void printResult(List<String> result) {
        System.out.println(String.join(", ", result) + "이(가) 최종 우승했습니다.");
    }
}
