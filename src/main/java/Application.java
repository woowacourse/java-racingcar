import domain.Car;
import domain.Race;
import domain.WinnerCars;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;

public class Application {
    private static ArrayList<String> carNames;
    private static int gameRound;
    private static ArrayList<Car> cars = new ArrayList<>();

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        input();
        registerCars();
        race();
        outputWinners();
    }

    private static void input() {
        carNames = InputView.inputNames();
        gameRound = InputView.inputRound();
    }

    private static void registerCars() {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    private static void race() {
        System.out.println("실행 결과");

        for (int i = 1; i <= gameRound; i++) {
            Race.raceByRound(cars);
            OutputView.printPosition(cars);
            System.out.println();
        }
    }

    private static void outputWinners() {
        WinnerCars winnerCars = new WinnerCars();
        ArrayList<Car> winners = winnerCars.determineWinners(cars);

        OutputView.printWinners(winners);
    }
}
