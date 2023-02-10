package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import utils.RandomNumberGenerator;
import vo.Name;
import vo.Position;

class CarsTest {
    Cars cars;
    Car car = new Car(Name.of("test"));

    @Test
    @DisplayName("차 추가 테스트")
    void checkAdd() {
        cars = new Cars(new ArrayList<>(), new RandomNumberGenerator());

        cars.saveCar(car);

        assertThat(cars.getPosition(car)).isEqualTo(Position.of(0L));
    }

    @Test
    @DisplayName("value 가 제일 높은 key를 반환한다.")
    void checkGetWinners() {
        List<Integer> testNumbers = Arrays.asList(3, 4);
        cars = new Cars(new ArrayList<>(), new TestRandomNumberGenerator(testNumbers));

        Car fox = new Car(Name.of("fox"));

        cars.saveCar(car);
        cars.saveCar(fox);

        cars.move();

        List<Name> winners = cars.getWinners();

        assertThat(winners).containsExactly(Name.of("fox"));
    }

    @Test
    @DisplayName("move 실행시 value가 1 증가한다.")
    void checkMove() {
        List<Integer> testNumbers = List.of(4);
        cars = new Cars(new ArrayList<>(), new TestRandomNumberGenerator(testNumbers));

        cars.saveCar(car);
        cars.move();

        Position status = cars.getPosition(car);

        assertThat(status).isEqualTo(Position.of(1L));
    }

    @Test
    @DisplayName("value 가 가장 높은 key가 여러개면 모두 반환한다.")
    void checkGetWinnerDraw() {
        List<Integer> testNumbers = Arrays.asList(4,4);
        cars = new Cars(new ArrayList<>(), new TestRandomNumberGenerator(testNumbers));

        Car fox = new Car(Name.of("fox"));

        cars.saveCar(car);
        cars.saveCar(fox);

        cars.move();

        List<Name> winners = cars.getWinners();

        assertThat(winners).containsExactly(Name.of("test"), Name.of("fox"));
    }

    static class TestRandomNumberGenerator extends RandomNumberGenerator {
        private final Iterator<Integer> testNumber;

        public TestRandomNumberGenerator(List<Integer> testNumber) {
            this.testNumber = testNumber.iterator();
        }

        @Override
        public int generateRandomNumber() {
            while (testNumber.hasNext()) {
                return testNumber.next();
            }

            throw new IllegalArgumentException();
        }
    }
}