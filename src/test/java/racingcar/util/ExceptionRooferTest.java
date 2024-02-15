package racingcar.util;

import java.util.function.Consumer;
import java.util.function.Supplier;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExceptionRooferTest {

    @DisplayName("예외 시 다시 실행")
    @Test
    void generate() {
        // given
        TestSupply testSupply = new TestSupply();
        TestConsumer testConsumer = new TestConsumer();

        // when
        String result = ExceptionRoofer.generate(testSupply, testConsumer);

        // then
        Assertions.assertThat(result).isEqualTo("1");
        Assertions.assertThat(TestConsumer.value).isEqualTo("[ERROR] 다시 입력하세요.");

    }

    static class TestSupply implements Supplier<String> {

        private static int index = 0;

        @Override
        public String get() {
            if (index == 0) {
                index++;
                throw new IllegalArgumentException("[ERROR] 다시 입력하세요.");
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