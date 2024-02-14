package racingcar.dto.request;

import racingcar.domain.RaceParticipants;
import racingcar.domain.car.Car;
import racingcar.view.utils.InputUtils;

import java.util.List;

public record RaceParticipantsRequest(String input) {
    public RaceParticipants toRaceParticipants() {
        List<Car> cars = InputUtils.splitByComma(input).stream()
                .map(Car::new)
                .toList();

        return new RaceParticipants(cars);
    }
}
