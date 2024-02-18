package view;

import common.PrintMessage;
import model.Car;
import model.MoveStatus;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class OutputView implements AutoCloseable {
    private static final String DELIMITER = " : ";
    private final BufferedWriter writer;

    public OutputView() {
        this.writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public void printResultComment() throws IOException {
        writer.write(System.lineSeparator() + PrintMessage.RESULT_COMMENT.getMessage());
        writer.newLine();
    }

    public void printResult(List<Car> cars) throws IOException {
        for (Car car : cars) {
            writer.write(car.getName() + DELIMITER + MoveStatus.join("", car.getStatuses()));
            writer.newLine();
        }
        writer.newLine();
    }

    public void printWinner(List<Car> cars) throws IOException {
        String winnersName = String.join(", ", cars.stream().map(Car::getName).toList());
        String composeWinnerMessage = String.format((PrintMessage.WINNER.getMessage()), winnersName);
        writer.write(composeWinnerMessage);
        writer.newLine();
    }

    @Override
    public void close() throws Exception {
        writer.flush();
        writer.close();
    }
}
