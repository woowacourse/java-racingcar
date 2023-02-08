package view;

import dto.RacingStatusDto;

import java.util.List;

public class OutputView {
    private static final String STATUS_GUIDE_MESSAGE = "실행 결과";

    private OutputView() {
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printStatusGuide() {
        System.out.println();
        System.out.println(STATUS_GUIDE_MESSAGE);
    }

    public static void printStatus(List<RacingStatusDto> racingStatus) {
        racingStatus.forEach(OutputView::printOneStatus);
        System.out.println();
    }

    private static void printOneStatus(RacingStatusDto racingStatus) {
        System.out.print(racingStatus.getCarName());
        System.out.print(" : ");
        for (int i = 0; i < racingStatus.getStatus(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
