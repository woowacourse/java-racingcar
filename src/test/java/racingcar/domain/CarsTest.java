package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    TestNumberGenerator testNumberGenerator = new TestNumberGenerator();

    Cars cars = new Cars("가비,주드,포비");

    @Test
    @DisplayName("가비, 주드 자동차만 앞으로 한 칸 이동하여 우승한다")
    void getWinnerSuccessTest() {
        cars.moveCars(testNumberGenerator);
        assertThat(cars.getWinnerNames()).containsExactly("가비", "주드").doesNotContain("포비");
    }

}
