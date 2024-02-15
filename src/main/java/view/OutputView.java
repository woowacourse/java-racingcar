package view;

import dto.CarStatus;

import java.util.List;

public class OutputView {

    private final static String DISTANCE_SYMBOL = "-";

    public void printRacingResult(List<CarStatus> carStatuses) {
        System.out.println("실행 결과");
        carStatuses.stream()
                .map(this::generateRacingResultMessage)
                .forEach(System.out::println);
        System.out.println();
    }

    private String generateRacingResultMessage(final CarStatus status) {
        return status.name() + " : " + DISTANCE_SYMBOL.repeat(status.distance());
    }
}
