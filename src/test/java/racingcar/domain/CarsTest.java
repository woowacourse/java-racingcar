package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @Test
    @DisplayName("stripStringArray()시 문자열을 ,기준으로 문자열 리스트로 나눈다.")
    void test_1() {
        // given
        String inputNames = "채채,말랑";
        Cars cars = new Cars(inputNames);

        // when
        String[] names = cars.stripStringArray(inputNames);

        // then
        assertThat(names).containsExactlyInAnyOrder("채채", "말랑");
    }

    @Test
    @DisplayName("Cars 클래스는 문자열을 받아 자동차리스트를 생성한다.")
    void test_2() {
        // given
        String inputNames = "채채,말랑";

        // when
        Cars cars = new Cars(inputNames);
        List<Car> carList = cars.getCars();

        // then
        assertThat(carList).containsExactlyInAnyOrder(cars.getCars().get(0), cars.getCars().get(1));
    }

    @Test
    @DisplayName("입력한 이름이 중복일때 예외처리")
    void test_3() {
        assertThatThrownBy(() -> new Cars("채채,채채"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력한 이름이 하나이하 일때 예외처리")
    void test_4() {
        assertThatThrownBy(() -> new Cars("채채"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
