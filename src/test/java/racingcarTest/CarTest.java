package racingcarTest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

import racingcar.Model.Car;

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
    private static Car car = new Car("보스독");

    @ParameterizedTest
    @DisplayName("isGo 테스트")
    @CsvSource(value = {
            "1,false", "2,false", "3,false", "4,true", "5,true", "6,true", "7,true", "8,true", "9,true"
    })
    void isGo_랜덤숫자가_4이상일때만_true_반환(int randomNumber, Boolean result) {
        assertThat(car.isGo(randomNumber)).isEqualTo(result);
    }

    @Test
    @DisplayName("포지션이 더 크면 true 반환")
    void comparePosition_파라미터로_들어온_객체보다_포지션이_크면_true로_반환() {
        Car one = new Car("작은곰", 5);
        Car two = new Car("보스독", 1);
        assertThat(one.comparePosition(two)).isTrue();
    }
}
