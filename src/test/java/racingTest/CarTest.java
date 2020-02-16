package racingTest;

import org.junit.jupiter.api.Test;
import racing.model.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


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
    void 현재_포지션_만큼_연속된_대쉬_문자열반환(){
        Car car = new Car("boss");
        String currentPositionByDash = car.getPositionByDash(5);
        assertThat(currentPositionByDash).isEqualTo("-----");
    }


}
