package racingcar.view;

import racingcar.domain.Round;
import racingcar.domain.car.Cars;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static String inputValue() {
        return scanner.nextLine();
    }

    public static Cars inputCarNames() {
        try {
            System.out.println("경주할 자동차 이름을 입력해주세요.(이름은 쉼표(,)를 기준으로 구분합니다.)");
            String inputForNames = inputValue();
            return new Cars(inputForNames);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return inputCarNames();
        }
    }

    public static Round inputRoundNumber() {
        try {
            System.out.println("시도할 회수는 몇회인가요?");
            String inputForRound = inputValue();
            return new Round(inputForRound);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return inputRoundNumber();
        }
    }
}