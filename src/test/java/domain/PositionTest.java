package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Position;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(3, Arrays.asList(1, 3)),
                Arguments.of(100, Arrays.asList(5, 100)),
                Arguments.of(4, Arrays.asList(4, 3)),
                Arguments.of(17, Arrays.asList(1, 17)),
                Arguments.of(76, Arrays.asList(76, 3)),
                Arguments.of(45, Arrays.asList(5, 45))
        );
    }

    public void increasePositionValue(final Position pos, final Integer count) {
        for (int i = 0; i < count; i++) {
            pos.increasePosition();
        }
    }

    @Test
    @DisplayName("기본 포지션 생성 테스트")
    public void defaultPositionInitializeTest() {
        final Position pos = new Position();
        assertThat(pos).extracting("value").isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7})
    @DisplayName("포지션 값 증가 테스트")
    public void increasePositionValueTest(final int value) {
        final Position pos = new Position();
        increasePositionValue(pos, value);
        assertThat(pos).extracting("value").isEqualTo(value);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    @DisplayName("Position 객체의 동일성 테스트")
    public void equalPositionValueTest(final int value) {
        final Position pos = new Position();
        increasePositionValue(pos, value);
        final Position comparePosition = new Position();
        increasePositionValue(comparePosition, value);
        assertThat(pos).isEqualTo(comparePosition);
    }

    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("Position 의 값 비교 테스트")
    public void comparePositionValueTest(final int maxValue, final List<Integer> values) {
        final Position pos1 = new Position();
        final Position pos2 = new Position();
        increasePositionValue(pos1, values.get(0));
        increasePositionValue(pos2, values.get(1));

        final Position expected = new Position();
        increasePositionValue(expected, maxValue);

        final List poses = List.of(pos1, pos2);
        assertThat(Collections.max(poses)).isEqualTo(expected);
    }
}
