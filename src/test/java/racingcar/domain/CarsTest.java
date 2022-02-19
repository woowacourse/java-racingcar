package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {

    @Test
    @DisplayName("중복된 자동차 이름을 입력한 경우 예외 발생")
    void carNameMustNotDuplicated() {
        String[] carNames = {"woo", "te", "co", "woo"};

        assertThatThrownBy(() -> new Cars(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("한명의 올바른 최종 우승자를 선택하는지 확인")
    void selectOneRightWinner() {
        Map<String, Integer> carInfo = new HashMap<>();
        carInfo.put("woo", 10);
        carInfo.put("te", 0);
        carInfo.put("co", 0);

        Cars cars = new Cars(carInfo);

        assertThat(cars.selectWinners()).containsExactly("woo");
    }

    @Test
    @DisplayName("여러명의 올바른 최종 우승자를 선택하는지 확인")
    void selectManyRightWinner() {
        Map<String, Integer> carInfo = new HashMap<>();
        carInfo.put("woo", 0);
        carInfo.put("te", 10);
        carInfo.put("co", 10);

        Cars cars = new Cars(carInfo);
        List<String> winners = cars.selectWinners();

        List<String> expected = new ArrayList<>();
        expected.add("te");
        expected.add("co");

        assertThat(winners).isEqualTo(expected);
    }
}
