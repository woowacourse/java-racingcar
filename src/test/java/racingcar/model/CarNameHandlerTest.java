package racingcar.model;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import racingcar.model.firstcollection.Cars;
import racingcar.model.vo.Car;

class CarNameHandlerTest {
    @Test
    @DisplayName("이름이 중복일 경우 예외 발생 테스트")
    void carNameShouldNotDuplicateName() {
        // given
        List<Car> duplicateCars = List.of(new Car("pobi"), new Car("pobi"), new Car("rich"));

        // when & then
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Cars(duplicateCars))
            .withMessageMatching("이름은 중복될 수 없습니다.");
    }

}