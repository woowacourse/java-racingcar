package console;

import domain.Car;
import domain.Record;
import java.util.List;
import java.util.stream.Collectors;

public class ConsolePrinter {

    public void printPlayRecords(List<List<Record>> playRecords) {
        StringBuilder stringBuilder = new StringBuilder("실행 결과\n");

        for (List<Record> record : playRecords) {
            String output = record.stream()
                    .map(it -> String.format("%s : " + "-".repeat(it.distance()), it.name()))
                    .collect(Collectors.joining(System.lineSeparator()));
            stringBuilder.append(output).append(System.lineSeparator()).append(System.lineSeparator());
        }

        System.out.print(stringBuilder);
    }

    public void printWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::name)
                .collect(Collectors.joining(", "));
        System.out.print(winnerNames + "가 최종 우승했습니다.");
    }
}
