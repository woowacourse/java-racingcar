package racingcarTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.Model.Car;
import racingcar.Model.Name;

/**
 * 클래스 이름 : CarTest.java
 *
 * @author 작은곰
 * @version 1.0.2
 * <p>
 * 날짜 : 2020.02.17 월요일
 */

public class CarTest {

    @Test
    @DisplayName("포지션이 더 크면 true 반환")
    void comparePosition_파라미터로_들어온_객체보다_포지션이_크면_true로_반환() {
        Car one = new Car(new Name("작은곰"), 5);
        Car two = new Car(new Name("보스독"), 1);
        assertThat(one.comparePosition(two)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("숫자가 4 이상인 경우 움직인다")
    @CsvSource(value = {"3, 0", "4, 1"})
    void goOrNot_숫자가_4_이상이면_움직인다(int randomNo, int result) {
        Car car = new Car("작은곰");
        car.goOrNot(randomNo);
        assertThat(car.getPosition()).isEqualTo(result);
    }
}
