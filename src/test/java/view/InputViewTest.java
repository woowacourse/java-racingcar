package view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @Test
    void 시도_횟수로_정수가_아닌_문자열이_들어오면_예외가_발생한다() {
        // given
        System.setIn(new ByteArrayInputStream("mark".getBytes()));
        InputView inputView = new InputView();

        // when & then
        assertThatThrownBy(inputView::inputTryCount)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
