package racingcar.domain.fcc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.vo.Attempt;
import racingcar.dto.RoundResult;
import racingcar.strategy.MovableNumberGenerator;
import racingcar.strategy.NonMovableNumberGenerator;

public class CarsTest {

    private static final String HAS_NOTHING_CAR_NAME_ERROR_MESSAGE = "자동차의 이름을 1개 이상 입력해야합니다.";
    private static final String DUPLICATE_CAR_NAME_ERROR_MESSAGE = "자동차의 이름이 중복되었습니다.";

    @ParameterizedTest(name = "repeatRaceBy() 테스트 : {0}, {1}")
    @MethodSource("repeatRaceByTestSet")
    public void repeatRaceBy_test(
            String[] nameInput,
            String attemptInput,
            List<List<Integer>> testSet,
            List<Integer> positionResult
    ) throws Exception {
        Cars cars = new Cars(nameInput);
        Attempt attempt = new Attempt(attemptInput);
        List<RoundResult> results = cars.repeatRaceBy(attempt, testSet);

        assertThat(results).hasSize(Integer.parseInt(attemptInput));
        assertThat(results).allSatisfy(result -> {
            Set<String> names = result.getNames();
            assertThat(names).hasSize(nameInput.length);
            assertThat(names).contains(nameInput);
            names.forEach(name ->
                    assertThat(result.getPosition(name)).isEqualTo(positionResult.remove(0)));
        });
    }

    private static Stream<Arguments> repeatRaceByTestSet() {
        MovableNumberGenerator movableNumberGenerator = new MovableNumberGenerator();
        NonMovableNumberGenerator nonMovableNumberGenerator = new NonMovableNumberGenerator();
        int move = movableNumberGenerator.generate();
        int stop = nonMovableNumberGenerator.generate();
        List<Integer> numbers = new ArrayList<>(Arrays.asList(move, stop));
        List<List<Integer>> testSet5 = new ArrayList<>(Arrays.asList(numbers, numbers, numbers, numbers, numbers));
        List<List<Integer>> testSet3 = new ArrayList<>(Arrays.asList(numbers, numbers, numbers));
        List<List<Integer>> testSet1 = new ArrayList<>(Arrays.asList(numbers));
        List<Integer> positionResult5 = new ArrayList<>(Arrays.asList(1, 0, 2, 0, 3, 0, 4, 0, 5, 0));
        List<Integer> positionResult3 = new ArrayList<>(Arrays.asList(1, 0, 2, 0, 3, 0));
        List<Integer> positionResult1 = new ArrayList<>(Arrays.asList(1, 0));
        return Stream.of(
                Arguments.of(new String[]{"name1", "name2"}, "5", testSet5, positionResult5),
                Arguments.of(new String[]{"name3", "name4"}, "3", testSet3, positionResult3),
                Arguments.of(new String[]{"name5", "name6"}, "1", testSet1, positionResult1)
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
