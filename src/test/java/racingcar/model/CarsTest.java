package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.utils.MovableNumberGenerator;

class CarsTest {

    @DisplayName("각 차들이 모두 움직인다")
    @Test
    public void race() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("Eden"));
        carList.add(new Car("Thor"));
        Cars cars = new Cars(carList);
        Car nonMoveCar = new Car("Zero");

        cars.race(new MovableNumberGenerator());

        assertThat(cars.getParticipantCars())
                .filteredOn(car -> car.isSamePosition(nonMoveCar))
                .isEmpty();
    }

    @DisplayName("우승자를 판별한다.")
    @Test
    public void judgeRacingWinners() {
        final MovableNumberGenerator movableNumberGenerator = new MovableNumberGenerator();

        Car eden = new Car("Eden");
        eden.move(movableNumberGenerator);
        eden.move(movableNumberGenerator);

        Car thor = new Car("Thor");
        thor.move(movableNumberGenerator);
        thor.move(movableNumberGenerator);

        Car pobi = new Car("Pobi");
        pobi.move(movableNumberGenerator);

        List<Car> participants = new ArrayList<>();
        participants.add(eden);
        participants.add(thor);
        participants.add(pobi);
        Cars cars = new Cars(participants);

        cars.participateInRacing(eden);
        cars.participateInRacing(thor);
        cars.participateInRacing(pobi);

        List<Name> winners = cars.judgeRacingWinners();

        assertThat(winners.get(0).toString()).isEqualTo("Eden");
    }

    @DisplayName("불변인지를 테스트합니다1")
    @Test
    public void immutable_1() {
        List<Car> testCars = new ArrayList<>();
        testCars.add(new Car("Thor"));
        Cars cars = new Cars(testCars);

        testCars.add(1, new Car("Rocky"));

        assertThat(cars.getParticipantCars().size()).isEqualTo(1);
    }
}
