package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class InputUtil {
    private static Scanner sc = new Scanner(System.in);

    private static String input() {
        return sc.nextLine();
    }

    public static ArrayList<String> inputNames() {
        String[] names;

        do {
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            names = input().trim().split("\\s*,\\s*");

        } while (isNotValidNames(names));

        return new ArrayList<>(Arrays.asList(names));
    }

    private static boolean isNotValidNames(String[] names) {
        boolean result = false;

        for (String name : names) {
            if (isBlank(name)) {
                result = true;
                break;
            }
        }
        result = isInvalidCarNumber(names);

        return result;
    }

    private static boolean isBlank(String str) {
        return str.equals("");
    }

    private static boolean isInvalidCarNumber(String[] names) {
        return names.length < Constant.MINIMUM_PARTICIPANT;
    }

    public static int inputRound() {
        String round;
        do {
            System.out.println("시도할 회수는 몇회인가요?");
            round = input().trim();
        } while (isNotValidRound(round));

        return Integer.parseInt(round);
    }

    private static boolean isNotValidRound(String round) {
        boolean result = true;

        if (isInteger(round) && isPositive(round)) {
            result = false;
        }

        return result;
    }

    private static boolean isInteger(String number) {
        boolean result = true;

        try {
            Integer.parseInt(number);
        } catch (NumberFormatException nfe) {
            result = false;
        }

        return result;
    }

    private static boolean isPositive(String number) {
        return Integer.parseInt(number) > 0;
    }
}
