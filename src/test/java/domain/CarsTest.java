package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import testNumberGenerator.TestNumberGenerator;

class CarsTest {
    Cars cars;
    Car car = new Car("test");

    @Test
    @DisplayName("차 추가 테스트")
    void checkAdd() {
        List<Integer> testNumbers = Arrays.asList(3, 4);
        cars = new Cars(new TestNumberGenerator(testNumbers));

        cars.add(car);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("value 가 제일 높은 key를 반환한다.")
    void checkGetWinners() {
        List<Integer> testNumbers = Arrays.asList(3, 4);
        cars = new Cars(new TestNumberGenerator(testNumbers));

        Car fox = new Car("fox");

        cars.add(car);
        cars.add(fox);

        cars.move();

        List<String> winners = cars.getWinners();

        assertThat(winners).containsExactly("fox");
    }

    @Test
    @DisplayName("move 실행시 car의 포지션이 1 증가한다.")
    void checkMove() {
        List<Integer> testNumbers = List.of(4);
        cars = new Cars(new TestNumberGenerator(testNumbers));

        cars.add(car);
        cars.move();

        Long position = car.getPosition();

        assertThat(position).isEqualTo(1L);
    }

    @Test
    @DisplayName("value 가 가장 높은 key가 여러개면 모두 반환한다.")
    void checkGetWinnerDraw() {
        List<Integer> testNumbers = Arrays.asList(4, 4);
        cars = new Cars(new TestNumberGenerator(testNumbers));

        Car fox = new Car("fox");

        cars.add(car);
        cars.add(fox);

        cars.move();

        List<String> winners = cars.getWinners();

        assertThat(winners).containsExactly("test", "fox");
    }
}