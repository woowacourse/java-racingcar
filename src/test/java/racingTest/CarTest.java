package racingTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.model.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class CarTest {

    @Test
    @DisplayName("자동차 이름 5글자 이하인지 확인")
    void checkNameLengthUnderFiveTest(){
        assertThatThrownBy(() -> {
            new Car("6글자이름니다.");
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessage("이름은 5글자를 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("차 이름 공백 또는 빈 문자열인 경우 예외 발생")
    void checkNameEmptyTest(){
        assertThatThrownBy(() -> {
            new Car("");
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessage("차이름은 공백 또는 빈 문자열일 수 없습니다.");
    }

    @Test
    @DisplayName("4이상의 숫자를 인자로 받을 경우 position 증가 여부 확인")
    void moveAndPositionChangeTest(){
        Car car = new Car("보스독");

        int currentPosition = car.getPosition().getPosition();
        assertThat(currentPosition).isEqualTo(0);

        car.move(4);
        currentPosition = car.getPosition().getPosition();
        assertThat(currentPosition).isEqualTo(1);
    }
}
