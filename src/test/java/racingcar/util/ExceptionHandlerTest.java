package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.function.Consumer;
import java.util.function.Supplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExceptionHandlerTest {

    @DisplayName("예외 시 다시 실행")
    @Test
    void generate() {
        // given
        TestSupply testSupply = new TestSupply();
        TestConsumer testConsumer = new TestConsumer();

        // when
        String result = ExceptionHandler.retry(testSupply, testConsumer);

        // then
        assertThat(result).isEqualTo(String.valueOf(TestSupply.LIMIT));
        assertThat(TestConsumer.value).isEqualTo("[ERROR] 다시 입력하세요." + TestSupply.LIMIT);
    }

    static class TestSupply implements Supplier<String> {

        private static final int LIMIT = 20000;
        private static int index = 0;

        @Override
        public String get() {
            if (index != LIMIT) {
                index++;
                throw new IllegalArgumentException("[ERROR] 다시 입력하세요." + index);
            }
            return String.valueOf(index);
        }
    }

    static class TestConsumer implements Consumer<String> {

        private static String value;

        @Override
        public void accept(String value) {
            TestConsumer.value = value;
        }
    }
}
