package view;

import message.PrintMessage;
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

    public void printAllRacingResult(List<Car> cars, int racingCount) throws IOException {
        for (int wantRacingCount = 1; wantRacingCount <= racingCount; wantRacingCount++) {
            printResult(cars, wantRacingCount);
        }
    }

    private void printResult(List<Car> cars, int wantRacingCount) throws IOException {
        for (Car car : cars) {
            writer.write(car.getName() + DELIMITER + concatenateMoveStatuses(car.getStatuses(wantRacingCount)));
            writer.newLine();
        }
        writer.newLine();
    }

    private String concatenateMoveStatuses(List<MoveStatus> moveStatuses) {
        return String.join("", moveStatuses.stream().map(MoveStatus::getOutput).toList());
    }

    public void printWinner(List<Car> cars) throws IOException {
        String winnersName = String.join(", ", cars.stream().map(Car::getName).toList());
        String winnersPrintMessage = String.format((PrintMessage.WINNER.getMessage()), winnersName);
        writer.write(winnersPrintMessage);
        writer.newLine();
    }

    @Override
    public void close() throws Exception {
        writer.flush();
        writer.close();
    }
}
