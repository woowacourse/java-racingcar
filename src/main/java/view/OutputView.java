package view;

import message.PrintMessage;
import model.Car;
import model.MoveStatus;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class OutputView implements AutoCloseable {
    private static final String FORWARD_MESSAGE = "-";
    private static final String DELIMITER = " : ";
    private final BufferedWriter writer;

    public OutputView() {
        this.writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public void printResultComment() {
        try {
            writer.write(System.lineSeparator() + PrintMessage.RESULT_COMMENT.getMessage());
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void printResult(List<Car> cars) {
        cars.forEach(this::printCarRacingResult);
        try {
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void printCarRacingResult(Car car) {
        try {
            writer.write(car.getName() + DELIMITER + concatenateMoveStatuses(car.getStatuses()));
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String concatenateMoveStatuses(List<MoveStatus> moveStatuses) {
        int forwardStatusCount = (int) moveStatuses.stream().filter(status -> status.equals(MoveStatus.FORWARD)).count();
        return FORWARD_MESSAGE.repeat(forwardStatusCount);
    }

    public void printWinner(List<Car> cars) {
        String winnersName = String.join(", ", cars.stream().map(Car::getName).toList());
        String winnersPrintMessage = String.format(PrintMessage.WINNER.getMessage(), winnersName);
        try {
            writer.write(winnersPrintMessage);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        try {
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
