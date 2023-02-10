package view;

import java.util.List;
import java.util.stream.Collectors;

import domain.Car;
import domain.Cars;
import output.Output;
import output.Outputs;

public class OutputView {

    private static final String RESULT_MESSAGE = "\n실행 결과";
    private static final String PRINT_STATUS_FORMAT = "%s : %s\n";
    private static final String PRINT_WINNER_FORMAT = "%s가 최종 우승했습니다.\n";
    private static final String DELIMITER = ", ";
    private static final String DASH = "-";

    public static void printResult() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printCars(Outputs outputs) {
        for (Output output : outputs.getOutputs()) {
            printCar(output);
        }
        System.out.println();
    }

    private static void printCar(Output output) {
        String name = output.getName();
        int position = output.getPosition();

        String status = toDash(position);
        System.out.printf(PRINT_STATUS_FORMAT, name, status);
    }

    private static String toDash(int position) {
        return DASH.repeat(position);
    }

    public static void printWinner(Cars winnerCars) {
        List<String> carNames = winnerCars.getStream()
                .map(Car::getName)
                .collect(Collectors.toList());

        String winnerString = String.join(DELIMITER, carNames);
        System.out.printf(PRINT_WINNER_FORMAT, winnerString);
    }
}
