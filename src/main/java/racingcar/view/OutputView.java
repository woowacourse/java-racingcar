package racingcar.view;

import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.domain.dto.CarRaceDto;
import racingcar.domain.dto.RaceResultDto;

import java.util.List;

import static racingcar.enumType.OutputMessage.*;

public class OutputView {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printRaceResult(Cars cars, Race race) {
        printHeadResult(cars);
        List<RaceResultDto> raceResult = race.start(cars);
        StringBuilder result = new StringBuilder();
        raceResult.forEach(raceResultDto -> result.append(getRaceResult(raceResultDto)));
        System.out.println(result.toString().trim());
    }

    public void printWinnerResult(List<String> winners) {
        System.out.println("\n" + String.join(WINNER_DELIMITER.getValue(), winners) + WINNER_MESSAGE.getValue());
    }

    private void printHeadResult(Cars cars) {
        StringBuilder result = new StringBuilder();
        List<CarRaceDto> carRaceDtos = cars.initStatus();
        result.append(RESULT_MESSAGE.getValue());
        carRaceDtos.forEach(this::createRaceResult);
        System.out.println(result);
    }

    private StringBuilder getRaceResult(RaceResultDto raceResult) {
        StringBuilder result = new StringBuilder();
        raceResult.getCarRaceResult()
                .forEach(carRaceDto -> result.append(createRaceResult(carRaceDto)));
        return result.append("\n");
    }

    private StringBuilder createRaceResult(CarRaceDto carRaceDto) {
        StringBuilder result = new StringBuilder();
        result.append(carRaceDto.getCarName())
                .append(NAME_POSITION_DELIMITER.getValue())
                .append(RACE_MARK.getValue().repeat(carRaceDto.getCarPosition()))
                .append("\n");
        return result;
    }
}
