package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CircuitTest {

    Engine poweredOnEngine = new Engine(() -> 9);
    Engine poweredOffEngine = new Engine(() -> 0);

    @Test
    @DisplayName("현재 경주의 상태를 올바르게 반환한다.")
    void raceStatusTest() {
        // given
        Car car1 = new Car("car1", poweredOnEngine);
        Car car2 = new Car("car2", poweredOffEngine);
        Circuit circuit = new Circuit(List.of(car1, car2));

        // when
        circuit.startRace();
        List<CarStatus> raceResults = circuit.getRaceResults();

        // then
        assertThat(raceResults).containsExactly(
                new CarStatus("car1", 1),
                new CarStatus("car2", 0)
        );
    }

    @Test
    @DisplayName("여러 우승자를 올바르게 반환한다.")
    void getWinnerTest() {
        // given
        Car car1 = new Car("car1", poweredOnEngine);
        Car car2 = new Car("car2", poweredOnEngine);
        Car car3 = new Car("car3", poweredOffEngine);
        Circuit circuit = new Circuit(List.of(car1, car2, car3));

        // when
        circuit.startRace();
        circuit.startRace();
        List<CarStatus> raceResults = circuit.getRaceResults();

        // then
        assertThat(circuit.getWinners(raceResults)).containsExactly(
                new CarStatus("car1", 2),
                new CarStatus("car2", 2)
        );
    }
}
