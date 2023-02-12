package racingcar.service;

import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.domain.dto.CarStatusDto;
import racingcar.domain.dto.RaceResultDto;

import java.util.ArrayList;
import java.util.List;

public class RaceService {

    private final CarsService carsService;

    public RaceService(final CarsService carsService) {
        this.carsService = carsService;
    }

    public Race createRace(final String raceCount) {
        return Race.createRace(raceCount);
    }

    public List<RaceResultDto> getRaceResults(final Cars cars, final Race race) {
        List<RaceResultDto> raceResults = new ArrayList<>();
        int raceCount = 0;

        while (!race.isRaceFinish(raceCount++)) {
            RaceResultDto raceResult = startRaceAndGetResult(cars);
            raceResults.add(raceResult);
        }
        return raceResults;
    }

    private RaceResultDto startRaceAndGetResult(final Cars cars) {
        cars.race();
        List<CarStatusDto> carRaceResult = carsService.getCarStatus(cars);
        return RaceResultDto.createRaceResultDto(carRaceResult);
    }
}
