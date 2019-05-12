package racingcar.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class InputView {
    private static final int MIN_NUMBER_OF_CARS = 2;
    private static final int MIN_NUMBER_OF_TRIALS = 1;

    public static List<String> inputCarNames() {
        Scanner input = new Scanner(System.in);
        for (;;) {
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            List<String> names = filterTypos(input.nextLine());
            if (names.size() >= MIN_NUMBER_OF_CARS) {
                return names;
            }
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
        }
    }

    private static List<String> filterTypos(String text) {
        return new ArrayList<>(
            Arrays.stream(text.split(","))
                .map(x -> x.trim())
                .filter(x -> (!x.equals("")) && (!x.equals(" ")) && (!x.equals(",")))
                .collect(Collectors.toList())
        );
    }

    public static int inputNumberOfTrials() {
        Scanner input = new Scanner(System.in);
        for(;;) {
            System.out.println("시도할 회수는 몇회인가요?");
            try {
                int number = Integer.parseInt(input.nextLine().trim());
                if (number >= MIN_NUMBER_OF_TRIALS) {
                    return number;
                }
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }
}