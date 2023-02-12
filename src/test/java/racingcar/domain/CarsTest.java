package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
    TestNumberGenerator testNumberGenerator = new TestNumberGenerator();

    Cars cars = new Cars("가비,주드");

    @Test
    @DisplayName("우승자 확인 성공 테스트")
    void getWinnerSuccessTest() {
        cars.moveCars(testNumberGenerator);
        cars.getCars().add(new Car("포비"));
        assertThat(cars.getWinnerNames()).containsExactly("가비", "주드").doesNotContain("포비");
    }

    @Test
    @DisplayName("우승자 확인 실패 테스트")
    void getWinnerFailTest() {
        cars.moveCars(testNumberGenerator);
        assertThat(cars.getWinnerNames()).isNotEqualTo(List.of());
    }

    private class TestNumberGenerator implements NumberGenerator {
        private static final int MOVE = 5;
        @Override
        public int generate() {
            return MOVE;
        }
    }

}