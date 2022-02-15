package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {

    @Test
    public void judgeRacingWinners() {
        List<Car> cars = new ArrayList<>();

        Car eden = new Car("Eden");
        eden.tryMove(5);
        eden.tryMove(5);

        Car thor = new Car("Thor");
        thor.tryMove(5);
        thor.tryMove(5);

        Car pobi = new Car("Pobi");
        pobi.tryMove(5);

        cars.add(eden);
        cars.add(thor);
        cars.add(pobi);

        Referee referee = new Referee();
        List<Name> winners = referee.judgeRacingWinners(cars);

        assertThat(winners.get(0).toString()).isEqualTo("Eden");
    }
}
