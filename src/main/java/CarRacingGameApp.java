import domain.Car;
import view.InputView;
import view.OutputView;

import java.util.List;

public class CarRacingGameApp {
    public static void main(String[] args) {
        List<String> names = InputView.inputCarNames();
        List<Car> cars = CarRacingGame.readyCarForRacing(names);
        int tryNum = InputView.inputTryNum();

        System.out.println("\n실행 결과");
        CarRacingGame.startRacing(cars, tryNum);

        OutputView.printWinner(cars);
    }
}
