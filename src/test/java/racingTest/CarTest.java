package racingTest;

import org.junit.jupiter.api.Test;
import racing.model.Car;
import racing.model.Position;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class CarTest {

    @Test
    void 글자수_5글자_이하만_생성(){
        assertThatThrownBy(() -> {
            Car car = new Car("6글자이름니다.");
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessage("이름은 5글자를 초과할 수 없습니다.");
    }

    @Test
    void 차이름_공백_또는_빈문자열_예외처리(){
        assertThatThrownBy(() -> {
            Car car = new Car("");
        }).isInstanceOf(NullPointerException.class)
        .hasMessage("차이름은 공백 또는 빈 문자열일 수 없습니다.");
    }

    @Test
    void 이름과_함께_현재_포지션_반환(){
        Car car = new Car("보스독");
        String result = car.getCurrentResult(new Position(5));
        assertThat(result).isEqualTo("보스독 : -----");
    }

}
