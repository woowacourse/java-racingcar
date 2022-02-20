package racingcar.domain.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CarsTest {

    private static final String HAS_NOTHING_CAR_NAME_ERROR_MESSAGE = "자동차의 이름을 1개 이상 입력해야합니다.";
    private static final String DUPLICATE_CAR_NAME_ERROR_MESSAGE = "자동차의 이름이 중복되었습니다.";

    @ParameterizedTest(name = "repeatRaceBy() 테스트 : {0}, {1}")
    @MethodSource("repeatRaceByTestSet")
    public void repeatRaceBy_test(String[] nameInput, String attemptInput) throws Exception {
        Cars cars = new Cars(nameInput);
        Attempt attempt = new Attempt(attemptInput);
        List<RoundResult> results = cars.repeatRaceBy(attempt);

        assertThat(results).hasSize(Integer.parseInt(attemptInput));
        assertThat(results).allSatisfy(result -> {
            assertThat(result.getNames()).hasSize(nameInput.length);
            assertThat(result.getNames()).contains(nameInput);
        });
    }

    private static Stream<Arguments> repeatRaceByTestSet() {
        return Stream.of(
                Arguments.of(new String[]{"name1", "name2"}, "5"),
                Arguments.of(new String[]{"name3", "name4"}, "3"),
                Arguments.of(new String[]{"name5", "name6"}, "1")
        );
    }

    @DisplayName("Cars() 자동차 이름이 없는 경우 예외 테스트")
    @Test
    public void has_nothing_car_name_test() throws Exception {
        String[] name = {};
        assertThatThrownBy(() -> new Cars(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(HAS_NOTHING_CAR_NAME_ERROR_MESSAGE);
    }

    @DisplayName("Cars() 중복된 이름 입력 예외 테스트")
    @Test
    public void duplicate_car_name_exception_test() throws Exception {
        String[] name = {"name1", "name1"};
        assertThatThrownBy(() -> new Cars(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_CAR_NAME_ERROR_MESSAGE);
    }
}
