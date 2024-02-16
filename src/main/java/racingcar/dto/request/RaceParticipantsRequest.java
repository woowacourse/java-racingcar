package racingcar.dto.request;

import java.util.List;
import racingcar.domain.RaceParticipants;
import racingcar.domain.car.Car;
import racingcar.domain.move.MovingStrategy;
import racingcar.view.utils.InputUtils;

public record RaceParticipantsRequest(String input) {
    public RaceParticipants toRaceParticipants(final MovingStrategy movingStrategy) {
        List<Car> cars = InputUtils.splitByComma(input).stream()
                .map(carName -> new Car(carName, movingStrategy))
                .toList();

        return new RaceParticipants(cars);
    }
}
