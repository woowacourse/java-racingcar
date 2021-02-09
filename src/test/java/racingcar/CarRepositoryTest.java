package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.CarRepository;
import racingcar.domain.car.Name;
import racingcar.domain.car.Position;

import java.util.ArrayList;
import java.util.List;

public class CarRepositoryTest {

    @AfterEach
    void afterEach() {
        CarRepository.deleteAll();
    }

    @DisplayName("우승자 결과 테스트 한 명")
    @Test
    void singleWinnerResult() {
        Car winner = new Car(new Name("pobi"), new Position(4));
        Car loser = new Car(new Name("crong"), new Position(2));

        CarRepository.save(winner);
        CarRepository.save(loser);

        List<Car> winners = CarRepository.winners();

        Assertions.assertThat(winners.size()).isEqualTo(1);
        Assertions.assertThat(winners.get(0)).isEqualTo(winner);
    }

    @DisplayName("우승자 결과 테스트 여러명")
    @Test
    void multiWinnerResult() {
        List<Car> expectedWinners = new ArrayList<>();

        Car winner1 = new Car(new Name("pobi"), new Position(3));
        Car winner2 = new Car(new Name("poci"), new Position(3));
        Car winner3 = new Car(new Name("podi"), new Position(3));
        Car loser = new Car(new Name("crong"), new Position(1));

        CarRepository.save(winner1);
        CarRepository.save(winner2);
        CarRepository.save(winner3);
        CarRepository.save(loser);

        expectedWinners.add(winner1);
        expectedWinners.add(winner2);
        expectedWinners.add(winner3);

        List<Car> actualWinners = CarRepository.winners();

        Assertions.assertThat(actualWinners.size()).isEqualTo(3);
        Assertions.assertThat(actualWinners.containsAll(expectedWinners)).isTrue();
    }
}
