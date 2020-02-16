package racingcarTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import racingcar.Model.Car;
import racingcar.Model.Name;

/**
 * 클래스 이름 : CarTest.java
 *
 * @author 보스독
 * @author 작은곰
 * @author 토니
 * @version 1.0
 * <p>
 * 날짜 : 2020.02.13 목요일
 */

public class CarTest {

    @Test
    @DisplayName("포지션이 더 크면 true 반환")
    void comparePosition_파라미터로_들어온_객체보다_포지션이_크면_true로_반환() {
        Car one = new Car(new Name("작은곰"), 5);
        Car two = new Car(new Name("보스독"), 1);
        assertThat(one.comparePosition(two)).isTrue();
    }
}
