package view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {
    @Nested
    class ReadCarNamesTest {

        @Test
        @DisplayName("입력된 이름들이 올바르게 분리된다.")
        void readNamesProperly() {
            // given
            System.setIn(new ByteArrayInputStream("rosie,hong".getBytes(StandardCharsets.UTF_8)));

            // when
            List<String> readCarNames = InputView.readCarNames();

            // then
            assertThat(readCarNames).containsExactly("rosie", "hong");
        }
    }

    @Nested
    class ReadTryTimeTest {
        @DisplayName("integer 범위의 수가 아닌 문자열")
        @ParameterizedTest(name = "\"{0}\" 인 케이스 일때 InputMismatchException 발생")
        @ValueSource(strings = {"a1", "가나다", "3.3", "999999999999999", ""})
        void throwIllegalArgumentExceptionWhenInputIsNotNumber(String input) {
            //given
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            //when,then
            assertThatThrownBy(InputView::readTryTime)
                    .isInstanceOf(InputMismatchException.class);
        }
    }
}