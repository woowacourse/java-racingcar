package racingcar.view;

import racingcar.domain.dto.CarStatusDto;
import racingcar.domain.dto.RaceResultDto;

import java.util.List;

import static racingcar.enumType.OutputMessage.*;

public class OutputView {

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public void printInitCarStatus(List<CarStatusDto> initCarStatus) {
        StringBuilder initCarResult = new StringBuilder();
        initCarResult.append(RESULT_MESSAGE.getValue());
        initCarStatus
                .forEach(carStatusDto -> createCarStatus(carStatusDto, initCarResult));
        System.out.println("\n" + initCarResult);
    }

    public void printRaceResult(List<RaceResultDto> totalRaceResult) {
        StringBuilder raceResult = new StringBuilder();
        totalRaceResult
                .forEach(raceResultDto -> createTotalRaceResult(raceResultDto, raceResult));
        System.out.println("\n" + raceResult.toString().trim());
    }

    private void createTotalRaceResult(RaceResultDto raceResultDto, StringBuilder raceResult) {
        raceResultDto.getCarRaceResults()
                .forEach(carStatusDto -> createCarStatus(carStatusDto, raceResult));
        raceResult.append("\n");
    }

    private void createCarStatus(CarStatusDto carStatusDto, StringBuilder carStatus) {
        carStatus.append(carStatusDto.getCarName())
                .append(NAME_POSITION_DELIMITER.getValue())
                .append(RACE_MARK.getValue().repeat(carStatusDto.getCarPosition()))
                .append("\n");
    }

    public void printWinnersResult(List<String> winners) {
        System.out.println("\n" + String.join(WINNER_DELIMITER.getValue(), winners) + WINNER_MESSAGE.getValue());
    }
}
