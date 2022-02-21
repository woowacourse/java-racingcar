package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    @DisplayName("중복된 이름의 자동차 하나로 인식")
    void DuplicatedCarName() {
        Cars cars = Cars.from(new String[]{"woo", "woo"});
        ExecutionResult executionResult = cars.generateExecutionResult();

        assertThat(executionResult.getExecutionResult().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("중복되지 않은 이름의 자동차 개별로 인식")
    void NonDuplicatedCarName() {
        Cars cars = Cars.from(new String[]{"woo", "te"});
        ExecutionResult executionResult = cars.generateExecutionResult();

        assertThat(executionResult.getExecutionResult().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("한명의 올바른 최종 우승자를 선택하는지 확인")
    void selectOneRightWinner() {
        Set<Car> input = new HashSet<>();

        input.add(new Car(new CarName("woo"), 10));
        input.add(new Car(new CarName("te"), 0));
        input.add(new Car(new CarName("co"), 0));

        Cars cars = new Cars(input);

        assertThat(cars.selectWinners()).containsExactly("woo");
    }

    @Test
    @DisplayName("여러명의 올바른 최종 우승자를 선택하는지 확인")
    void selectManyRightWinner() {
        Set<Car> input = new HashSet<>();

        input.add(new Car(new CarName("woo"), 10));
        input.add(new Car(new CarName("te"), 10));
        input.add(new Car(new CarName("co"), 0));

        Cars cars = new Cars(input);
        List<String> winners = cars.selectWinners();

        assertThat(cars.selectWinners().size()).isEqualTo(2);
        assertThat(winners).contains("woo");
        assertThat(winners).contains("te");
    }
}
