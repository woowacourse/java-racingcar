package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarsTest {

    private static final int MIN_POWER = 4;

    @DisplayName("주어진 이름 목록으로 자동차 목록을 생성한다.")
    @Test
    void generateCarsTest() {
        List<String> names = List.of("가", "나", "다");

        assertThatCode(() -> new Cars(names)).doesNotThrowAnyException();
    }

    @DisplayName("중복된 이름이 존재하면 예외를 던진다.")
    @Test
    void duplicatedCarsNameTest() {
        List<String> names = List.of("가", "가", "다");

        assertThatThrownBy(() -> new Cars(names)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("최대 전진 횟수를 반환한다.")
    @Test
    void getMaxForwardTest() {
        List<String> names = List.of("가", "나", "다");
        Cars cars = new Cars(names);
        int expectedMaxPosition = 2;

        cars.getCars().get(0).move(MIN_POWER);
        cars.getCars().get(1).move(MIN_POWER);
        cars.getCars().get(1).move(MIN_POWER);

        assertThat(cars.getMaxPosition()).isEqualTo(expectedMaxPosition);
    }
}
