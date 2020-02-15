package application.racing;

import application.racing.domain.Car;
import application.racing.domain.CarNames;
import application.racing.domain.RacingGame;
import application.racing.domain.RacingLab;
import application.racing.view.OutputViewer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingApplication {
    private static Scanner scanner = new Scanner(System.in);

    public static void runRacingGame() {
        try {
            List<Car> cars = makeCarList();
            RacingLab racingLab = getRacingLab();
            OutputViewer.printRacingResultMessage();
            startRacing(cars, racingLab);
        } catch (Exception e) {
            OutputViewer.printErrorMessage(e.getMessage());
            runRacingGame();
        }
    }

    private static void startRacing(List<Car> cars, RacingLab racingLab) {
        RacingGame racingGame = new RacingGame();
        List<String> winners = racingGame.executeRacingGame(cars, racingLab.getRacingLab());
        OutputViewer.printWinner(winners);
    }

    private static RacingLab getRacingLab() {
        System.out.println("시도할 회수는 몇회인가요?");
        String inputRacingLab = scanner.nextLine();
        return new RacingLab(inputRacingLab);
    }

    private static List<Car> makeCarList() {
        String inputCarNames = getCarNames();
        CarNames carNames = new CarNames(inputCarNames);
        List<Car> cars = new ArrayList<>();
        for (String name : carNames.getCarNameList()) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private static String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        runRacingGame();
    }
}
