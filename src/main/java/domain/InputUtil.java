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

        } while (isNotValidInput(names));

        return new ArrayList<>(Arrays.asList(names));
    }

    private static boolean isNotValidInput(String[] names) {
        boolean result = false;

        for (String name : names) {
            if (isBlank(name)) {
                result = true;
                break;
            }
        }

        return result;
    }

    private static boolean isBlank(String str) {
        return str.equals("");
    }

    public static int inputRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        String round = input();
        //예외처리
        return Integer.parseInt(round);
    }


}
