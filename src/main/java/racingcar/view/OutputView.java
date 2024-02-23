package racingcar.view;

import racingcar.dto.CarStatus;

import java.util.List;

public class OutputView {

    private static final String DISTANCE_SYMBOL = "-";

    public void printResultMessageTitle() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printRacingResult(final List<CarStatus> carStatuses) {
        carStatuses.stream()
                .map(this::generateRacingResultMessage)
                .forEach(System.out::println);
        System.out.println();
    }

    private String generateRacingResultMessage(final CarStatus status) {
        return status.name() + " : " + DISTANCE_SYMBOL.repeat(status.distance());
    }

    public void printWinners(final List<String> winners) {
        final String message = String.join(", ", winners);
        System.out.println(message + "가 최종 우승했습니다.");
    }

    public void printInputCarNamesErrorMessage() {
        System.out.println("자동차 이름은 1이상, 5이하의 ,로 구분한 문자열만 가능합니다.");
    }

    public void printInputRacingCountErrorMessage() {
        System.out.println("경주 횟수는 1이상의 정수만 입력할 수 있습니다.");
    }
}
