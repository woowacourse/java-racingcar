package racingGame.view;

import racingGame.domain.racingCar.Name;
import racingGame.domain.game.Rounds;
import racingGame.domain.utils.NameHandler;
import racingGame.domain.validator.InputValidator;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private InputView() {
    }

    public static List<Name> inputNames(final Scanner scanner) {
        OutputView.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        List<Name> names = NameHandler.splitNames(scanner.nextLine());
        InputValidator.checkIsValidInputNames(names);
        return names;
    }

    public static Rounds inputRounds(final Scanner scanner) {
        OutputView.println("시도할 회수는 몇회인가요?");
        return Rounds.create(readInteger(scanner));
    }

    private static int readInteger(final Scanner scanner) {
        String numeric = scanner.nextLine();
        InputValidator.checkIsNumeric(numeric);
        return Integer.parseInt(numeric);
    }
}
