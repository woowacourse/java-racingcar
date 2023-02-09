package view;

import dto.RacingStatusDto;

import java.util.List;

public class OutputView {
    public static final String WINNER_GUIDE_MESSAGE = "가 최종 우승했습니다.";
    public static final String WINNER_DELIMITER = ", ";
    private static final String STATUS_GUIDE_MESSAGE = "실행 결과";
    private static final String COLON = " : ";
    private static final String CAR_POSITION = "-";
    private final Output output;

    public OutputView(Output output) {
        this.output = output;
    }

    private void printOneStatus(RacingStatusDto racingStatus) {
        output.print(racingStatus.getCarName());
        output.print(COLON);

        for (int i = 0; i < racingStatus.getStatus(); i++) {
            output.print(CAR_POSITION);
        }
        output.println();
    }

    public void printWinner(List<String> winners) {
        output.print(String.join(WINNER_DELIMITER, winners));
        output.println(WINNER_GUIDE_MESSAGE);
    }

    public void printStatus(List<RacingStatusDto> racingStatus) {
        racingStatus.forEach(this::printOneStatus);
        output.println();
    }

    public void printStatusGuide() {
        output.println();
        output.println(STATUS_GUIDE_MESSAGE);
    }

    public void printErrorMessage(String errorMessage) {
        output.println(errorMessage);
    }
}
