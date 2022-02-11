package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {

    @Test
    public void judgeRacingWinners() {
        List<Car> cars = new ArrayList<>();

        Car eden = new Car("Eden");
        eden.move();
        eden.move();

        Car thor = new Car("Thor");
        thor.move();
        thor.move();

        Car pobi = new Car("Pobi");
        pobi.move();

        cars.add(eden);
        cars.add(thor);
        cars.add(pobi);

        Referee referee = new Referee();
        List<Name> winners = referee.judgeRacingWinners(cars);

        assertThat(winners.get(0).toString()).isEqualTo("Eden");
    }
}
