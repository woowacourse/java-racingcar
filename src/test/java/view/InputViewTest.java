package view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import dto.CarDto;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {
    private InputView inputView;

    @Nested
    class ReadCarNamesTest {
        @Test
        @DisplayName("입력된 이름들이 올바르게 분리된다.")
        void readNamesProperly() {
            // given
            InputStream is = new ByteArrayInputStream("rosie,hong\n".getBytes(StandardCharsets.UTF_8));
            System.setIn(is);
            inputView = new InputView();
            // when
            List<String> readCarNames = inputView.readCarNames().stream()
                    .map(CarDto::getName)
                    .collect(Collectors.toUnmodifiableList());
            // then
            assertThat(readCarNames).containsExactly("rosie", "hong");
        }

        @ParameterizedTest
        @ValueSource(strings = {",,", ","})
        @DisplayName("이름을 입력하지 않으면 IllegalArgumentException을 발생시킨다다.")
        void throwExceptionWhenSplitListIsEmpty(String input) {
            InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
            System.setIn(in);
            inputView = new InputView();
            assertThatThrownBy(() -> inputView.readCarNames()).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class ReadTryTimeTest {
        @DisplayName("integer 범위의 수가 아닌 문자열")
        @ParameterizedTest(name = "\"{0}\" 인 케이스 일때 InputMismatchException 발생")
        @ValueSource(strings = {"a1", "가나다", "3.3", "999999999999999"})
        void throwIllegalArgumentExceptionWhenInputIsNotNumber(String input) {
            //given
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            inputView = new InputView();
            //when,then
            assertThatThrownBy(() -> inputView.readTryTime())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("입력값은 정수형 범위여야합니다.");
        }
    }
}
