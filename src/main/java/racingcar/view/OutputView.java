package racingcar.view;

import racingcar.domain.dto.CarStatusDto;
import racingcar.domain.dto.RaceResultDto;

import java.util.List;

import static racingcar.enumType.OutputMessage.*;

public class OutputView {

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public void printRaceResult(List<CarStatusDto> initCarStatus, List<RaceResultDto> totalRaceResult) {
        StringBuilder raceResult = new StringBuilder();
        createInitCarResult(initCarStatus, raceResult);
        totalRaceResult.forEach(raceResultDto -> createTotalRaceResult(raceResultDto, raceResult));
        System.out.println("\n" + raceResult.toString().trim());
    }

    private void createInitCarResult(List<CarStatusDto> initCarStatus, StringBuilder raceResult) {
        raceResult.append(RESULT_MESSAGE.getValue());
        initCarStatus
                .forEach(carStatusDto -> createTotalRaceResult(carStatusDto, raceResult));
        raceResult.append("\n");
    }

    private void createTotalRaceResult(RaceResultDto raceResultDto, StringBuilder raceResult) {
        raceResultDto.getCarRaceResult()
                .forEach(carStatusDto -> createTotalRaceResult(carStatusDto, raceResult));
        raceResult.append("\n");
    }

    private void createTotalRaceResult(CarStatusDto carStatusDto, StringBuilder raceResult) {
        raceResult.append(carStatusDto.getCarName())
                .append(NAME_POSITION_DELIMITER.getValue())
                .append(RACE_MARK.getValue().repeat(carStatusDto.getCarPosition()))
                .append("\n");
    }

    public void printWinnersResult(List<String> winners) {
        System.out.println("\n" + String.join(WINNER_DELIMITER.getValue(), winners) + WINNER_MESSAGE.getValue());
    }
}
