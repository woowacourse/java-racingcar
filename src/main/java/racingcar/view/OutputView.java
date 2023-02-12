package racingcar.view;

import racingcar.domain.dto.CarRaceDto;
import racingcar.domain.dto.RaceResultDto;

import java.util.List;

import static racingcar.enumType.OutputMessage.*;

public class OutputView {

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public void printRaceResult(List<CarRaceDto> initCarResult, List<RaceResultDto> totalRaceResult) {
        StringBuilder raceResult = new StringBuilder();
        createInitCarResult(initCarResult, raceResult);
        totalRaceResult.forEach(raceResultDto -> createTotalRaceResult(raceResultDto, raceResult));
        System.out.println("\n" + raceResult.toString().trim());
    }

    private void createInitCarResult(List<CarRaceDto> carRaceResult, StringBuilder raceResult) {
        raceResult.append(RESULT_MESSAGE.getValue());
        carRaceResult
                .forEach(carRaceDto -> createTotalRaceResult(carRaceDto, raceResult));
        raceResult.append("\n");
    }

    private void createTotalRaceResult(RaceResultDto raceResultDto, StringBuilder raceResult) {
        raceResultDto.getCarRaceResult()
                .forEach(carRaceDto -> createTotalRaceResult(carRaceDto, raceResult));
        raceResult.append("\n");
    }

    private void createTotalRaceResult(CarRaceDto carRaceDto, StringBuilder raceResult) {
        raceResult.append(carRaceDto.getCarName())
                .append(NAME_POSITION_DELIMITER.getValue())
                .append(RACE_MARK.getValue().repeat(carRaceDto.getCarPosition()))
                .append("\n");
    }

    public void printWinnersResult(List<String> winners) {
        System.out.println("\n" + String.join(WINNER_DELIMITER.getValue(), winners) + WINNER_MESSAGE.getValue());
    }
}
