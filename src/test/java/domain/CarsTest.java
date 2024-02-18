package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarsTest {

    private static final int MIN_FORWARD_NUMBER = 4;

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

    @DisplayName("가장 큰 forward 찾기 테스트")
    @Test
    void getMaxForwardTest() {
        List<String> names = List.of("가", "나", "다");
        Cars cars = new Cars(names);

        cars.getCars().get(0).move(MIN_FORWARD_NUMBER);
        cars.getCars().get(1).move(MIN_FORWARD_NUMBER);
        cars.getCars().get(1).move(MIN_FORWARD_NUMBER);

        assertThat(cars.getMaxForward()).isEqualTo(2);
    }
}
