package racinggame.race.view.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import racinggame.race.car.Car;
import racinggame.race.car.Cars;
import racinggame.race.car.engine.FixedEngine;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingRequestDTOTest {

    @DisplayName("dto 에서 entity 로 바꾸기")
    @Test
    void toCars() {
        //given
        RacingRequestDTO racingRequestDTO = new RacingRequestDTO("a,b", 1);

        //when
        Cars cars = racingRequestDTO.toCars(FixedEngine.getInstance());

        //then
        assertThat(cars).isEqualTo(new Cars(Arrays.asList(new Car("a", FixedEngine.getInstance()), new Car("b", FixedEngine.getInstance()))));
    }

    @DisplayName("이름을 null 혹은 빈칸을 입력받은 경우 exception 발생")
    @NullAndEmptySource
    @ParameterizedTest
    void validateName(String names) {
        assertThatThrownBy(() -> new RacingRequestDTO(names, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도 횟수를 1보다 작은 횟수를 입력받은 경우 exception 발생")
    @Test
    void validateCount() {
        assertThatThrownBy(() -> new RacingRequestDTO("pobi,bebop", 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 0보다 커야합니다.");
    }
}