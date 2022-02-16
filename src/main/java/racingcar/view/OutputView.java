package racingcar.view;

import java.util.stream.Collectors;

import racingcar.dto.CarDto;
import racingcar.dto.RecordDto;
import racingcar.dto.ResultDto;

public class OutputView {
    private static final String NAME_AND_SCORE_DELIMITER = " : ";
    private static final String DRIVE_SCORE_VIEW = "-";
    private static final String NAME_DELIMITER = ", ";
    private static final String RACE_RECORD_MESSAGE = "실행 결과";
    private static final String RACE_WINNER_MESSAGE = "가 최종 우승했습니다.";

    public static void printRacingRecordHeadLine() {
        System.out.println();
        System.out.println(RACE_RECORD_MESSAGE);
    }

    public static void printRacingRecord(RecordDto racingRecord) {
        for (CarDto carDto : racingRecord.getRacingRecord()) {
            System.out.println(carDto.getName() + NAME_AND_SCORE_DELIMITER + printDash(carDto.getPosition()));
        }
        System.out.println();
    }

    private static String printDash(int position) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append(DRIVE_SCORE_VIEW);
        }
        return stringBuilder.toString();
    }

    public static void printRacingResult(ResultDto racingResult) {
        System.out.println(appendComma(racingResult) + RACE_WINNER_MESSAGE);
    }

    private static String appendComma(ResultDto racingResult) {
        return racingResult.getRacingWinner().stream()
            .collect(Collectors.joining(NAME_DELIMITER));
    }
}
