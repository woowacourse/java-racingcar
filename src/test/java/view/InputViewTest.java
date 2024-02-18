package view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;

@DisplayName("입력 테스트")
class InputViewTest {

    private InputView getInputView(String testInput) {
        final InputStream inputStream = new ByteArrayInputStream(testInput.getBytes());
        return new InputView(inputStream);
    }

    @Nested
    @DisplayName("자동차 이름 입력 테스트")
    class CarNamesTest {

        @Test
        @DisplayName("이름에 특수문자가 포함되면 예외를 발생하는가")
        void read_car_name_contain_special_test() {
            // given
            final String text = "asd,###";
            final InputView inputView = getInputView(text);

            // when, then
            assertThatIllegalArgumentException().isThrownBy(inputView::readCarNames);
        }

        @Test
        @DisplayName("이름에 한글 포함되면 예외를 발생하는가")
        void read_car_name_contain_kr_test() {
            // given
            final String text = "가나,아";
            final InputView inputView = getInputView(text);

            // when, then
            assertThatIllegalArgumentException().isThrownBy(inputView::readCarNames);
        }

        @Test
        @DisplayName("이름에 공백이 포함되어도 괜찮은가")
        void read_car_name_contain_blank_test() {
            // given
            final String text = "mang , cho ";
            final InputView inputView = getInputView(text);

            // when, then
            assertThatCode(inputView::readCarNames).doesNotThrowAnyException();
        }
    }

    @Nested
    @DisplayName("시도 횟수 입력 테스트")
    class AttemptsTest {

        @ParameterizedTest
        @ValueSource(strings = {"#", "a", "아", "", " "})
        @DisplayName("숫자가 아니면 예외를 발생하는가")
        void invalid_number_of_attempts_test(final String attempts) {
            // given
            final InputView inputView = getInputView(attempts);

            // when, then
            assertThatIllegalArgumentException().isThrownBy(inputView::readNumberOfAttempts)
                    .withMessageContaining("1부터 10 이하의 숫자를 입력하세요.");
        }

        // 음수는 비즈니스 정책으로 View에서 테스트하지 않음
        @ParameterizedTest
        @ValueSource(strings = {"1", "0", "-1"})
        @DisplayName("숫자인가")
        void valid_number_of_attempts_test(final String attempts) {
            // given
            final InputView inputView = getInputView(attempts);

            // when, then
            assertThatCode(inputView::readNumberOfAttempts).doesNotThrowAnyException();
        }
    }

}
