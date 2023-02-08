package view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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
}