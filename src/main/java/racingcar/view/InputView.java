package racingcar.view;

import racingcar.domain.Name;
import racingcar.domain.Rounds;
import racingcar.utils.NameHandler;
import racingcar.validator.InputValidator;

import java.util.Scanner;

public class InputView {

    private InputView() {
    }

    public static Name[] getNames(final Scanner scanner) {
        OutputView.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return NameHandler.splitNames(scanner.nextLine());
    }

    public static Rounds getRounds(final Scanner scanner) {
        OutputView.println("시도할 회수는 몇회인가요?");
        return Rounds.create(getInteger(scanner));
    }

    private static int getInteger(final Scanner scanner) {
        String numeric = scanner.next();
        InputValidator.checkIsNumeric(numeric);
        return Integer.parseInt(numeric);
    }
}
