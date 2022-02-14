package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    public void participateInRacing() {
        Cars participants = new Cars();

        participants.participateInRacing(new Car("Eden"));

        assertThat(participants.participateSize()).isEqualTo(1);
    }

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