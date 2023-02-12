package view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static model.domain.Car.MAX_NAME_LENGTH;
import static model.domain.TryCount.TRY_COUNT_LIMIT;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class InputViewTest {
    @DisplayName("Car의 이름이 검증을 통과하면 예외를 발생시키지 않는다.")
    @Test
    void Car_이름_검증_통과() {
        String input = "Car1,Car2,Car3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatNoException().isThrownBy(() -> new InputView().sendCarsName());
    }

    @DisplayName("Car의 이름이 " + MAX_NAME_LENGTH + "자 초과이면 예외를 발생시킨다.")
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
                .withMessageContaining("이름에 공백을 포함할 수 없습니다.");
    }

    @DisplayName("tryCount가 게임을 실행하기에 무리가 없는 크기의 수인지 검증한다.")
    @Test
    void tryCount_크기_검증_성공() {
        String input = "10";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatNoException().isThrownBy(() -> new InputView().sendTryCount());

    }

    @DisplayName("tryCount가 1보다 작으면 예외를 발생시킨다.")
    @Test
    void tryCount_크기_검증_실패_너무작은수() {
        String input = "0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatIllegalArgumentException().isThrownBy(() -> new InputView().sendTryCount())
                .withMessageContaining("시도 횟수는 양의 정수여야 합니다.");

    }

    @DisplayName("tryCount가 " + TRY_COUNT_LIMIT + "보다 크면 예외를 발생시킨다.")
    @Test
    void tryCount_크기_검증_실패_너무큰수() {
        String input = "101";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatIllegalArgumentException().isThrownBy(() -> new InputView().sendTryCount())
                .withMessageContaining("시도할 회수는 " + TRY_COUNT_LIMIT +"회 이하여야 합니다.");
    }
}