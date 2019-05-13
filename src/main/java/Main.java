import domain.Car;
import domain.CarFactory;
import domain.RacingGame;
import domain.RacingTrial;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Car> cars = inputCars();
        int nTrials = inputNTrials();

        RacingGame.play(cars, nTrials);
    }

    private static ArrayList<Car> inputCars() {
        try {
            OutputView.printMassage("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n");
            return CarFactory.newCars(InputView.readString());
        } catch (IllegalArgumentException e) {
            OutputView.printMassage(e.getMessage());
            return inputCars();
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
