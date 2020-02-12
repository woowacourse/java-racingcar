package application;

import application.calculator.Calculate;
import application.calculator.UserInputScanner;
import application.racing.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    private static Scanner scanner = new Scanner(System.in);

    public static void runCalculator() {
        Calculate calculate = new Calculate();
        try {
            String userInput = UserInputScanner.inputStringEquation();
            int result = Calculate.calculation(calculate.makeNumbersList(userInput));
            System.out.println(userInput + " => " + Integer.toString(result));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            runCalculator();
        }
    }

    public static void runRacingGame() {
        try {
            List<Car> cars = makeCarList();
            RacingLab racingLab = getRacingLab();
            startRacing(cars, racingLab);
        } catch (Exception e) {
            Output.printErrorMessage(e.getMessage());
            runRacingGame();
        }
    }

    private static void startRacing(List<Car> cars, RacingLab racingLab) {
        Racing racing = new Racing();
        List<String> winners = racing.executeRacingGame(cars, racingLab.getRacingLab());
        Output.printWinner(winners);
    }

    private static RacingLab getRacingLab() {
        System.out.println("시도할 회수는 몇회인가요?");
        String inputRacingLab = scanner.nextLine();
        return new RacingLab(inputRacingLab);
    }

    private static List<Car> makeCarList() {
        String inputCarNames = getCarNames();
        CarName carName = new CarName(inputCarNames);
        List<Car> cars = new ArrayList<>();
        for (String name : carName.getCarNameList()) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private static String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public static void main(String[] args) {
//        runCalculator();
        runRacingGame();
    }
}
