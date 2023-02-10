package view;

import dto.request.CarNameDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static domain.Car.MAX_NAME_LENGTH;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {
    @DisplayName("Car의 이름이 검증을 통과하면 예외를 발생시키지 않는다.")
    @Test
    void Car_이름_검증_통과() {
        String input = "Car1,Car2,Car3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatNoException().isThrownBy(() -> new InputView().sendCarsName());
    }

    @DisplayName("Car의 이름이 5자 초과이면 예외를 발생시킨다.")
    @Test
    void Car_이름_검증_실패_길이초과() {
        String input = "이름이긴자동차1,이름이긴자동차2,이름이긴자동차3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatIllegalArgumentException().isThrownBy(() -> new InputView().sendCarsName())
                .withMessageContaining("이름은 " + MAX_NAME_LENGTH + "자 이하여야 합니다. ");
    }

    @DisplayName("Car의 이름에 공백이 포함되면 예외를 발생시킨다.")
    @Test
    void Car_이름_검증_실패_공백포함() {
        String input = "공백 1,공백 2, 공백3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatIllegalArgumentException().isThrownBy(() -> new InputView().sendCarsName())
                .withMessageContaining("이름에 공백을 포함할 수 없습니다." );
    }
}