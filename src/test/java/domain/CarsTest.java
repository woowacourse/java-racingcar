package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static util.Constants.MIN_FORWARD_NUMBER;

class CarsTest {

    @DisplayName("Cars 생성 성공 테스트")
    @Test
    void generateCarsTest() {
        List<String> names = List.of("가", "나", "다");

        assertThatCode(() -> new Cars(names)).doesNotThrowAnyException();
    }

    @DisplayName("Cars 이름 중복 테스트")
    @Test
    void duplicatedCarsNameTest() {
        List<String> names = List.of("가", "가", "다");

        assertThatThrownBy(() -> new Cars(names)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("현재 상태값 반환 테스트")
    @Test
    void getCurrentStatusTest() {
        Cars cars = new Cars(List.of("가", "나", "다"));

        cars.getCars().get(0).drive(MIN_FORWARD_NUMBER);
        cars.getCars().get(1).drive(MIN_FORWARD_NUMBER);
        cars.getCars().get(1).drive(MIN_FORWARD_NUMBER);

        assertThat(cars.getCurrentStatus()).containsAll(List.of("가 : -", "나 : --", "다 : "));
    }

    @DisplayName("우승자 1명 테스트")
    @Test
    void findWinnerTest() {
        Cars cars = new Cars(List.of("가", "나", "다"));

        cars.getCars().get(0).drive(MIN_FORWARD_NUMBER);
        cars.getCars().get(1).drive(MIN_FORWARD_NUMBER);
        cars.getCars().get(1).drive(MIN_FORWARD_NUMBER);

        assertThat(cars.findWinners()).containsAll(List.of("나"));
    }

    @DisplayName("우승자 여러명 테스트")
    @Test
    void findWinnersTest() {
        Cars cars = new Cars(List.of("가", "나", "다"));

        cars.getCars().get(0).drive(MIN_FORWARD_NUMBER);
        cars.getCars().get(0).drive(MIN_FORWARD_NUMBER);
        cars.getCars().get(1).drive(MIN_FORWARD_NUMBER);
        cars.getCars().get(2).drive(MIN_FORWARD_NUMBER);
        cars.getCars().get(2).drive(MIN_FORWARD_NUMBER);

        assertThat(cars.findWinners()).containsAll(List.of("가", "다"));
    }

    @DisplayName("모두가 우승자 테스트")
    @Test
    void findWinnersAllTest() {
        Cars cars = new Cars(List.of("가", "나", "다"));

        cars.getCars().get(0).drive(MIN_FORWARD_NUMBER);
        cars.getCars().get(0).drive(MIN_FORWARD_NUMBER);
        cars.getCars().get(1).drive(MIN_FORWARD_NUMBER);
        cars.getCars().get(1).drive(MIN_FORWARD_NUMBER);
        cars.getCars().get(2).drive(MIN_FORWARD_NUMBER);
        cars.getCars().get(2).drive(MIN_FORWARD_NUMBER);

        assertThat(cars.findWinners()).containsAll(List.of("가", "나", "다"));
    }
}
