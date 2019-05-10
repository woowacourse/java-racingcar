package view;

import domain.Car;
import domain.Cars;
import domain.Const;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static List<Car> setCarsOnRace() {
        try {
            Cars cars = new Cars(InputView.inputCarNames());
            return cars.createCars();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setCarsOnRace();
        }
    }

    private static List<String> inputCarNames() {
        System.out.println(Const.INPUT_CAR_NAME);
        return Arrays.asList(SCANNER.nextLine().split(","));
    }

    public static int setRoundCount() {
        try {
            int roundCount = InputView.inputRoundCount();
            if (roundCount <= Const.ZERO) {
                throw new IllegalArgumentException();
            }
            return roundCount;
        } catch (Exception e) {
            System.out.println(Const.EX_ROUND_COUNT);
            return setRoundCount();
        }
    }

    private static int inputRoundCount() throws NumberFormatException {
        System.out.println(Const.INPUT_ROUND_CNT);
        return Integer.parseInt(SCANNER.nextLine());
    }
}
