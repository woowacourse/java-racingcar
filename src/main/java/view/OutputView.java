package view;

import domain.Car;
import domain.Cars;
import dto.Output;
import dto.Outputs;

import java.util.ArrayList;
import java.util.List;

public class OutputView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String PRINT_STATUS_FORMAT = "%s : %s\n";
    private static final String PRINT_WINNER_FORMAT = "%s가 최종 우승했습니다.\n";
    private static final String DELIMITER = ", ";

    public static void printResult() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printStatus(Outputs outputs) {
        for (Output output : outputs.getOutputs()) {
            String name = output.getName();
            int position = output.getPosition();
            String positionString = getPositionString(position);
            System.out.printf(PRINT_STATUS_FORMAT, name, positionString);
        }
        System.out.println();
    }

    private static String getPositionString(int position) {
        String positionString = "";
        for (int i = 0; i < position; i++) {
            positionString += "-";
        }
        return positionString;
    }

    public static void printWinner(Cars winnerCars) {
        List<Car> cars = winnerCars.getCars();
        List<String> carNames = new ArrayList<>();
        for (Car car : cars) {
            carNames.add(car.getName());
        }
        String winnerString = String.join(DELIMITER, carNames);
        System.out.printf(PRINT_WINNER_FORMAT, winnerString);
    }
}
