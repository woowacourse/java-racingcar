package racing.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

class CarsTest {

    private final List<String> dummy = List.of("포르쉐", "현대차", "기아");

    @Test
    @DisplayName("moveAll 메소드를 호출하면 Car의 Position이 1 증가한다.")
    void moveAllTest() {
        Cars cars = new Cars(dummy);

        cars.moveAll(new AlwaysMoveGenerator());

        List<Integer> positions = cars.getUnmodifiableCars().stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());

        Assertions.assertThat(positions).containsOnly(1);
    }

    @Test
    @DisplayName("moveAll 메소드를 호출해도 Car의 Position이 증가하지 않는다.")
    void notMoveAllTest() {
        Cars cars = new Cars(dummy);

        cars.moveAll(new NeverMoveGenerator());

        List<Integer> positions = cars.getUnmodifiableCars().stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());

        Assertions.assertThat(positions).containsOnly(0);
    }

    @Test
    @DisplayName("dicideWinners 메소드를 호출하면 우승자의 이름 목록을 반환한다.")
    void decideWinners() {
        Cars cars = new Cars(dummy);

        cars.moveAll(new AlwaysMoveGenerator());

        List<String> carNames = cars.getUnmodifiableCars().stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        Assertions.assertThat(carNames).containsAll(dummy);
    }

    private static class AlwaysMoveGenerator implements RandomNumberGenerator {

        @Override
        public int generate() {
            return 4;
        }
    }

    private static class NeverMoveGenerator implements RandomNumberGenerator {

        @Override
        public int generate() {
            return 3;
        }
    }
}