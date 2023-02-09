package view.output;

import domain.Car;
import java.util.List;

public class OutputView {

    static private void print(PrintMessages message) {
        System.out.println(message.getContent());
    }

    static public void printEnterCarNames() {
        print(PrintMessages.ENTER_CAR_NAMES);
    }

    static public void printEnterCount() {
        print(PrintMessages.ENTER_COUNT);
    }

    static public void printResultMessage() {
        print(PrintMessages.RESULT);
    }

    static public void printRoundResult(List<Car> cars) {
        StringBuilder content = new StringBuilder();
        cars.forEach(car -> addCarResult(content, car));
        System.out.println(content);
    }

    static private void addCarResult(StringBuilder roundResult, Car car) {
        final String DELIMITER = " : ";
        final String CAR_RESULT = car + DELIMITER + convertDistance(car.getDrivenDistance()) + '\n';
        roundResult.append(CAR_RESULT);
    }

    static private String convertDistance(int distance) {
        final String DISTANCE = "-";
        return DISTANCE.repeat(distance);
    }

    static public void printErrorMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }
}
