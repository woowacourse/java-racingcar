package racingcarTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.Model.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car = new Car("보스독");

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
        Car car = new Car("작은곰", 5);
        Car target = new Car("보스독", 1);
        assertThat(car.comparePosition(target)).isTrue();
    }
}
