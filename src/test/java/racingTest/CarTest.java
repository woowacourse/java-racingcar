package racingTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.model.Car;
import racing.model.CarLineUp;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class CarTest {

    private CarLineUp carLineUp = new CarLineUp();

    @BeforeEach
    void setUp(){
        carLineUp.add(new Car("포비"));
        carLineUp.add(new Car("코난"));
        carLineUp.add(new Car("보스독"));
        carLineUp.add(new Car("엘사"));
    }


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
    void 차이름_중복될_경우_예외처리(){
        assertThatThrownBy(() -> {
            Car car = new Car("포비");
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessage("차이름이 중복되었습니다.");
    }

}
