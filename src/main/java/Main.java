import domain.Car;
import domain.CarFactory;
import domain.RacingGame;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Car> cars = inputCars();
        int nTrials = InputView.inputNTrials();

        RacingGame.play(cars, nTrials);
    }

    private static List<Car> inputCars() {
        // 차 객체의 생성자에서 에러를 던지는 방식을 유지하면서 MVC패턴을 만드는 방법을 고민 중인데 쉽게 답이 안나오네요.
        try {
            return CarFactory.newCars(InputView.inputCarNames());
        } catch (IllegalArgumentException e) {
            OutputView.printMassage(e.getMessage());
            return inputCars();
        }
    }

}
