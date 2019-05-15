import domain.Car;
import view.InputView;
import view.OutputView;

import java.util.List;

public class CarRacingGameApp {
    public static void main(String[] args) {
        List<String> names;
        List<Car> cars;

        do {
            names = InputView.inputCarNames();
            cars = CarRacingGame.readyCarForRacing(names);
        } while (cars.size() == 0);

        int tryNum = InputView.inputTryNum();

        System.out.println("\n실행 결과");
        CarRacingGame.startRacing(cars, tryNum);

        OutputView.printWinner(cars);
    }
}
