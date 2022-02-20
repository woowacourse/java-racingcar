package racingcar.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.view.ErrorMessage;

class CarsTest {

    @DisplayName("add() 테스트")
    @Test
    void add_test() {
        String name = "name1";
        String[] names = {name};
        Cars cars = new Cars(names);
        assertThat(cars.isSameSize(1)).isTrue();
    }

    @DisplayName("judgeWinners() 단독, 공동우승 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"name1", "name1,name2"})
    void judgeWinners_test(String inputNames) {
        String[] names = inputNames.split(",");
        Cars cars = new Cars(names);
        String winners = cars.judgeWinners().toString();
        for (String name : names) {
            assertThat(winners.contains(name)).isTrue();
        }
    }

    @DisplayName("add() 중복된 이름이 입력되었을 때 예외 테스트")
    @Test
    void add_duplicate_name_exception_test() {
        String name = "name1";
        String[] names = {name, name};
        assertThatThrownBy(() -> new Cars(names))
                .hasMessageContaining(ErrorMessage.CAR_NAME_DUPLICATE.getMessage());
    }
}
