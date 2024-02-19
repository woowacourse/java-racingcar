package racingcar.dto.request;

import racingcar.domain.RaceParticipants;
import racingcar.domain.car.Car;
import racingcar.domain.car.move.MovingStrategy;

import java.util.Arrays;
import java.util.List;

public record RaceParticipantsRequest(String input) {
    public RaceParticipants toRaceParticipants(final MovingStrategy movingStrategy) {
        List<Car> cars = splitByComma().stream()
                .map(carName -> new Car(carName, movingStrategy))
                .toList();

        return new RaceParticipants(cars);
    }

    private List<String> splitByComma() {
        if (input == null) {
            return List.of();
        }
        return Arrays.stream(input.split(",", -1))
                .map(String::trim)
                .toList();
    }
}
