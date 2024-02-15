package view;

import dto.CarStatus;

import java.util.List;

public class OutputView {

    private final static String DISTANCE_SYMBOL = "-";

    public void printResultMessageTitle() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printRacingResult(List<CarStatus> carStatuses) {
        carStatuses.stream()
                .map(this::generateRacingResultMessage)
                .forEach(System.out::println);
        System.out.println();
    }

    private String generateRacingResultMessage(final CarStatus status) {
        return status.name() + " : " + DISTANCE_SYMBOL.repeat(status.distance());
    }

    public void printWinners(List<String> winners) {
        String message = String.join(", ", winners);
        System.out.println(message + "가 최종 우승했습니다.");
    }
}
