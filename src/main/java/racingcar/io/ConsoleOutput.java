package racingcar.io;

import java.util.LinkedHashMap;
import java.util.List;

public class ConsoleOutput {

    public static final String COMMAANDSPACE = ", ";
    public static final String WONTHERACE = "이(가) 최종 우승했습니다.";
    public static final String HYPEN = "-";
    public static final String BLANKSTRING = "";
    public static final String NAME_POSITION_DIVIDER = ": ";

    public static void printStatus(LinkedHashMap<String, Integer> status) {
        status.forEach((name, position) -> {
            System.out.println(name + NAME_POSITION_DIVIDER + stripBuilder(position));
        });
        System.out.println("");
    }

    private static String stripBuilder(Integer position) {
        String strip = BLANKSTRING;
        for (int i = 0; i < position; i++) {
            strip += HYPEN;
        }
        return strip;
    }

    public static void printResult(List<String> result) {
        System.out.println(String.join(COMMAANDSPACE, result) + WONTHERACE);
    }
}
