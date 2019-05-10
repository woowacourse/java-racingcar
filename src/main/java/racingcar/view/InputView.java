package racingcar.view;

import racingcar.domain.Race;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class InputView {
    private static final Scanner input = new Scanner(System.in);

    public static Race inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        try {
            return new Race(filterTypos(input.nextLine()));
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            return inputCarNames();
        }
    }

    private static List<String> filterTypos(String arg) {
        return new ArrayList<>(
                Arrays.stream(arg.split(","))
                        .map(x -> x.trim())
                        .filter(x -> (!x.equals("")) && (!x.equals(" ")) && (!x.equals(",")))
                        .collect(Collectors.toList())
        );
    }

    public static int inputNumberOfTrial() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            int number = Integer.parseInt(input.nextLine().trim());
            if (number > 0) {
                return number;
            }
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            return inputNumberOfTrial();
        }
    }
}