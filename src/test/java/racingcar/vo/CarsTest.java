package racingcar.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CarsTest {

    @DisplayName("Cars() 테스트")
    @Test
    public void constructor_test() throws Exception {
        String[] name = {"name1", "name2"};
        Cars cars = new Cars(name);
        assertThat(cars.toString()).contains(name);
    }

    @ParameterizedTest(name = "repeatRaceBy() 테스트 : {0}, {1}")
    @MethodSource("repeatRaceByTestSet")
    public void repeatRaceBy_test(String[] nameInput, String attemptInput) throws Exception {
        Cars cars = new Cars(nameInput);
        Attempt attempt = new Attempt(attemptInput);
        RoundResults result = cars.repeatRaceBy(attempt);
        for (int i = 0; i < Integer.parseInt(attemptInput); i++) {
            assertThat(result.hasResult()).isTrue();
            RoundResult roundResult = result.poll();
            assertThat(roundResult.getNames()).hasSize(nameInput.length);
            assertThat(roundResult.getNames()).contains(nameInput);
        }
        assertThat(result.hasResult()).isFalse();
    }

    private static Stream<Arguments> repeatRaceByTestSet() {
        return Stream.of(
                Arguments.of(new String[]{"name1", "name2"}, "5"),
                Arguments.of(new String[]{"name3", "name4"}, "3"),
                Arguments.of(new String[]{"name5", "name6"}, "1")
        );
    }

    @DisplayName("Cars() 중복된 이름 입력 예외 테스트")
    @Test
    public void duplicate_car_name_exception_test() throws Exception {
        String[] name = {"name1", "name1"};
        assertThatThrownBy(() -> new Cars(name))
                .isInstanceOf(RuntimeException.class);
    }
}
