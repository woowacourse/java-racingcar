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
        StringBuilder result = new StringBuilder();
        getInitCarResult(carRaceResult, result);
        totalRaceResult.forEach(raceResultDto -> getRaceResult(raceResultDto, result));
        System.out.println("\n" + result.toString().trim());
    }

    private void getInitCarResult(List<CarRaceDto> carRaceResult, StringBuilder result) {
        result.append(RESULT_MESSAGE.getValue());
        carRaceResult
                .forEach(carRaceDto -> createRaceResult(carRaceDto, result));
        result.append("\n");
    }

    private void getRaceResult(RaceResultDto raceResult, StringBuilder result) {
        raceResult.getCarRaceResult()
                .forEach(carRaceDto -> createRaceResult(carRaceDto, result));
        result.append("\n");
    }

    private void createRaceResult(CarRaceDto carRaceDto, StringBuilder result) {
        result.append(carRaceDto.getCarName())
                .append(NAME_POSITION_DELIMITER.getValue())
                .append(RACE_MARK.getValue().repeat(carRaceDto.getCarPosition()))
                .append("\n");
    }

    public void printWinnerResult(List<String> winners) {
        System.out.println("\n" + String.join(WINNER_DELIMITER.getValue(), winners) + WINNER_MESSAGE.getValue());
    }
}
