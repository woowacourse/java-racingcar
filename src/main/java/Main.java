import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Car> cars = inputCars(new CarFactory());
        int nTrials = inputNTrials();

        // 이렇게 받는 걸 보면 어떤 느낌이 들까???
        // 조금 나눠서 적용하는 걸로 충분할까?
        RacingGame racingGame = new RacingGame(new RacingTrial(new CarMoveFilter(new MoveStrategy(new Random()))));
        racingGame.play(cars, nTrials);
    }

    private static List<Car> inputCars(CarFactory carFactory) {
        try {
            OutputView.printMassage("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n");
            return carFactory.newCars(InputView.readString());
        } catch (Exception e) {
            OutputView.printMassage(String.format("각 차의 이름은 %d 글자의 길이여야합니다.", Car.MAX_NAME_LEN));
            OutputView.printMassage(e.getMessage());
            return inputCars(carFactory);
        }
    }

    private static int inputNTrials() {
        int nTrials;
        try {
            OutputView.printMassage("시도할 회수는 몇회인가요?\n");
            nTrials = InputView.readNumber();
        } catch (IllegalArgumentException e) {
            OutputView.printMassage("올바르지 않은 입력입니다. 숫자를 입력해주세요.\n");
            return inputNTrials();
        }

        if (nTrials < 0) {
            OutputView.printMassage("입력 값이 음수입니다. 다시 입력해주세요.");
            return inputNTrials();
        }
        return nTrials;
    }
}
