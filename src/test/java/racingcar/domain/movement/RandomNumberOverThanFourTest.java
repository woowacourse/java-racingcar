package racingcar.domain.movement;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberOverThanFourTest {
    @Test
    @DisplayName("숫자들을 받아 숫자에 대해 4 이상이면 전진 값에 대하여 1을 변환하고 4 미만이면 0을 변환하여 List로 묶어 반환한다.")
    void move_Test() {
        //given
        final Movement movement = new RandomNumberOverThanFour();
        final List<Integer> movementSourceValues = Arrays.asList(3, 4, 4);
        final List<Integer> expected = Arrays.asList(0, 1, 1);
        //when
        final List<Integer> actual = movement.getMovementValues(movementSourceValues);
        //then
        assertThat(actual).isEqualTo(expected);
    }
}