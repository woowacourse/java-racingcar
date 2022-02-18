package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @DisplayName("차가 정상적으로 참여하는지 확인한다.")
    @Test
    public void participateInRacing() {
        Cars cars = new Cars();

        cars.participateInRacing(new Car("Eden"));

        assertThat(cars.getCarsSize()).isEqualTo(1);
    }

    @DisplayName("차가 이동 가능한지 확인한다.")
    @Test
    public void isMovable() {

    }

    @DisplayName("우승자를 판별한다.")
    @Test
    public void judgeRacingWinners() {
        Cars cars = new Cars();

        Car eden = new Car("Eden");
        eden.move(true);
        eden.move(true);

        Car thor = new Car("Thor");
        thor.move(true);
        thor.move(true);

        Car pobi = new Car("Pobi");
        pobi.move(true);

        cars.participateInRacing(eden);
        cars.participateInRacing(thor);
        cars.participateInRacing(pobi);

        List<Name> winners = cars.judgeRacingWinners();

        assertThat(winners.get(0).toString()).isEqualTo("Eden");
    }
}
