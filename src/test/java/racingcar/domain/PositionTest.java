package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {
    @DisplayName("포지션 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void position_생성_테스트(int number) {
        Position position = new Position(number);

        assertThat(position.index()).isEqualTo(number);
    }

    @DisplayName("포지션 이동 테스트")
    @ParameterizedTest
    @CsvSource({"1,2,true", "11,12,true", "11,17,false"})
    void nextPositionTest(int before, int after, boolean expectedResult) {
        Position beforePosition = new Position(before);
        Position afterPosition = new Position(after);

        assertThat(beforePosition.nextPosition().equals(afterPosition)).isEqualTo(expectedResult);
    }

}
