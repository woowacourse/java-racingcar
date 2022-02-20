package racingcar.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.dto.RacingRecord;
import racingcar.dto.CarResponse;

public class OutputView {

    private static final String CAR_DELIMITER = " : ";
    private static final String CAR_PROGRESS = "-";
    private static final String WINNER_DELIMITER = ", ";

    public void printProcessPrompt() {
        System.out.println("실행 결과");
    }

    public void printRacingRecords(List<RacingRecord> racingRecords) {
        printProcessPrompt();
        racingRecords.forEach(this::printRacingRecord);
    }

    private void printRacingRecord(RacingRecord racingRecord) {
        Map<String, Integer> result = racingRecord.getRacingRecord();
        result.forEach(this::printCarPosition);
        System.out.println();
    }

    private void printCarPosition(String carName, int position) {
        System.out.print(carName + CAR_DELIMITER);
        for (int i = 0; i < position; i++) {
            System.out.print(CAR_PROGRESS);
        }
        System.out.println();
    }


    public void printWinners(List<CarResponse> carList) {
        List<String> nameList = toNames(carList);
        System.out.println(String.join(WINNER_DELIMITER, nameList) + "가 최종 우승했습니다.");
    }

    private List<String> toNames(List<CarResponse> carList) {
        return carList.stream()
            .map(CarResponse::getName)
            .collect(Collectors.toList());
    }
}
