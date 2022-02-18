package racingcar.domain.car.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class DistanceTest {
    private final Distance distance = new Distance(1);

    @Test
    @DisplayName("거리 값을 반환한다.")
    void getDistance_Test() {
        //given
        int expected = 1;
        //when
        int actual = distance.getDistance();
        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("정수 값을 받아 값만큼 거리 값을 증가시킨다.")
    void increaseBy_Test() {
        //given
        int increasingAmount = 1;
        distance.increaseBy(increasingAmount);
        int expected = 2;
        //when
        int actual = distance.getDistance();
        //then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("다른 Distance를 받아 자신의 값이 크거나 같은지 반환한다.")
    @CsvSource({"0, true", "1, true", "2, false"})
    void isSameOrHigherThan_Test(final int anotherDistanceValue, final boolean expected) {
        //given
        Distance another = new Distance(anotherDistanceValue);
        //when
        boolean actual = distance.isSameOrHigherThan(another);
        //then
        assertThat(actual).isEqualTo(expected);
    }
}