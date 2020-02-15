package racingTest;

import org.junit.jupiter.api.Test;
import racing.model.Car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;



public class CarTest {

    @Test
    void 글자수_5글자_이하만_생성(){
        assertThatThrownBy(() -> {
            Car car = new Car("보스독보스");
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessage("이름은 5글자를 초과할 수 없습니다.");
    }

}
