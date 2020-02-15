package application.racing;

import application.racing.domain.Cars;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarsTest {
    @DisplayName("Cars 클래스 생성자 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", ",asd", "asdfrq,pobi", "pobi,pobi", "pobi,,crong", "pobi, ,crong", "  ,pobi"})
    public void carsConstructorTest(String input) {
        Assertions.assertThatThrownBy(() -> {
            new Cars(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
