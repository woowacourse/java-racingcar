package racingcar.view;

import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import util.Count;

public class InputView {
    private final static Scanner SCANNER = new Scanner(System.in);
    private static final String COMMA = ",";

    public static List<String> getNames() {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            List<String> input = Arrays.asList(SCANNER.nextLine()
                .split(COMMA));
            input.forEach(Car::checkValidName);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println("다시 입력해주세요");
            return getNames();
        }
    }

    public static int getMoveCount() {
        Count count;

        try {
            System.out.println("시도할 회수는 몇회인가요?");
            count = new Count(Integer.parseInt(SCANNER.nextLine()));
            return count.getMoveCount();
        } catch (IllegalArgumentException e) {
            System.out.println("다시 입력해주세요");
            return getMoveCount();
        }
    }
}
