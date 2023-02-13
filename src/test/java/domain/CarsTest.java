package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.NumberGenerator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CarsTest {

    @Test
    @DisplayName("중복된 자동차 이름이 존재하면 예외가 발생한다.")
    void checkNameDuplication() {
        List<String> carNames = List.of("pobi", "pobi", "crong");

        assertThrows(IllegalArgumentException.class,
                () -> new Cars(carNames));
    }

    @Test
    @DisplayName("라운드를 진행하지 않았을 때의 최대 이동 거리는 0이다.")
    void findInitialMaxDistance() {
        Cars cars = new Cars(List.of("pobi", "crong", "hunox"));

        Assertions.assertThat(cars.findMaxDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("최장거리를 이동한 자동차의 위치를 찾는다.")
    void findMaxDistanceTest() {
        Cars cars = new Cars(List.of("pobi", "crong", "hunox"));
        Car pobi = cars.getCars().stream()
                .filter(car -> car.getCarName().equals("pobi"))
                .findFirst()
                .orElse(null);
        assert pobi != null;
        MovementManager movementManager = new MovementManager();

        int movingCount = 5;
        for (int count = 0; count < movingCount; count++) {
            pobi.move(movementManager, 4);
        }

        Assertions.assertThat(cars.findMaxDistance()).isEqualTo(movingCount);
    }

    @Test
    @DisplayName("최장거리를 이동한 우승자를 찾아 List로 반환한다.")
    void findWinners_success() {
        Cars cars = new Cars(List.of("pobi", "crong", "hunox"));

        Car pobi = cars.getCars().stream()
                .filter(car -> car.getCarName().equals("pobi"))
                .findFirst()
                .orElse(null);
        assert pobi != null;
        pobi.move(new MovementManager(), 4);

        Assertions.assertThat(cars.findWinners(1)).containsOnly(pobi.getCarName());
    }

    @Test
    @DisplayName("최장거리를 이동하지 않은 자동차는 우승자 명단에 포함되지 않는다.")
    void findWinners_fail() {
        Cars cars = new Cars(List.of("pobi", "crong", "hunox"));

        Car pobi = cars.getCars().stream()
                .filter(car -> car.getCarName().equals("pobi"))
                .findFirst()
                .orElse(null);
        assert pobi != null;
        pobi.move(new MovementManager(), 4);

        Assertions.assertThat("crong").isNotIn(cars.findWinners(1));
    }

    @Test
    @DisplayName("3 이하의 숫자가 나온 자동차들은 전진하지 않는다.")
    void progressRound_all_stop() {
        Cars cars = new Cars(List.of("pobi", "crong", "hunox"));
        int startNumber = 1;
        TestNumberGenerator testNumberGenerator = new TestNumberGenerator(startNumber);

        cars.progressRound(testNumberGenerator, new MovementManager());

        for (Car car : cars.getCars()) {
            Assertions.assertThat(car.getDistance()).isEqualTo(0);
        }
    }

    @Test
    @DisplayName("4 이상의 숫자가 나온 자동차들은 전진한다.")
    void progressRound_all_move() {
        Cars cars = new Cars(List.of("pobi", "crong", "hunox"));
        int startNumber = 4;
        TestNumberGenerator testNumberGenerator = new TestNumberGenerator(startNumber);

        cars.progressRound(testNumberGenerator, new MovementManager());

        for (Car car : cars.getCars()) {
            Assertions.assertThat(car.getDistance()).isEqualTo(1);
        }
    }

    public static class TestNumberGenerator implements NumberGenerator {

        public int testNumber;

        public TestNumberGenerator(Integer number) {
            this.testNumber = number;
        }

        @Override
        public int generateNumber() {
            return testNumber++;
        }
    }

}