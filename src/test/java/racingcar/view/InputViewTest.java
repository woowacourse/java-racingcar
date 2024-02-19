package racingcar.view;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {
    @BeforeAll
    static void init() {
        String input = "AA,AA";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    @DisplayName("중복된_이름_입력_시_에러_발생")
    void duplicatedNameTest() {
        assertThatThrownBy(() -> {
            InputView inputView = new InputView();
            inputView.getCarName();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 자동차 이름은 사용할 수 없습니다.");
    }

}
