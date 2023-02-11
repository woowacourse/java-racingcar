package racingcar.view;

import racingcar.domain.dto.CarRaceDto;
import racingcar.domain.dto.RaceResultDto;

import java.util.List;

import static racingcar.enumType.OutputMessage.*;

public class OutputView {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printRaceResult(List<CarRaceDto> carRaceResult, List<RaceResultDto> totalRaceResult) {
        printHeadResult(carRaceResult);
        StringBuilder result = new StringBuilder();
        totalRaceResult.forEach(raceResultDto -> result.append(getRaceResult(raceResultDto)));
        System.out.println(result.toString().trim());
    }

    public void printWinnerResult(List<String> winners) {
        System.out.println("\n" + String.join(WINNER_DELIMITER.getValue(), winners) + WINNER_MESSAGE.getValue());
    }

    private void printHeadResult(List<CarRaceDto> carRaceResult) {
        StringBuilder result = new StringBuilder();
        result.append(RESULT_MESSAGE.getValue());
        carRaceResult
                .forEach(carRaceDto -> createRaceResult(carRaceDto, result));
        System.out.println(result);
    }

    private StringBuilder getRaceResult(RaceResultDto raceResult) {
        StringBuilder result = new StringBuilder();
        raceResult.getCarRaceResult()
                .forEach(carRaceDto -> createRaceResult(carRaceDto, result));
        return result.append("\n");
    }

    private void createRaceResult(CarRaceDto carRaceDto, StringBuilder result) {
        result.append(carRaceDto.getCarName())
                .append(NAME_POSITION_DELIMITER.getValue())
                .append(RACE_MARK.getValue().repeat(carRaceDto.getCarPosition()))
                .append("\n");
    }
}
