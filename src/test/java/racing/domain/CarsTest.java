package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("자동차 라인업 생성")
    @Test
    public void construct() {
        String[] carNames = {"아반떼", "소나타", "그랜저"};

        Cars cars = new Cars(carNames);
        assertThat(cars.getCars()).hasSize(3);
    }

    @DisplayName("우승자 구하기")
    @Test
    public void findWinner() {
        Cars cars = new Cars(
                Car.of("아반떼", 5),
                Car.of("소나타", 7),
                Car.of("그랜저", 3)
        );

        assertThat(cars.findWinners())
                .containsExactly(new Car("소나타"));
    }

    @DisplayName("공동 우승자 구하기")
    @Test
    public void findWinners() {
        Cars cars = new Cars(
                Car.of("아반떼", 5),
                Car.of("소나타", 7),
                Car.of("그랜저", 7)
        );

        assertThat(cars.findWinners())
                .containsExactly(new Car("소나타"), new Car("그랜저"));
    }

}