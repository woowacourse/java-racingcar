package racingcar.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewValidatorTest {

    private final InputViewValidator inputViewValidator = new InputViewValidator();

    @Nested
    @DisplayName("전체 자동차 이름 검증 테스트")
    class carNamesTest {

        @Test
        @DisplayName("전체 입력받은 자동차 이름이 빈 값인 경우 예외 처리")
        void carNamesBlankTest() {
            String carNames = "";

            Assertions.assertThatThrownBy(() -> inputViewValidator.validateCarNames(carNames))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("분리한 자동차 이름 검증 테스트")
    class splitCarNameTest {

        @Test
        @DisplayName("분리한 자동차 이름이 중복된 경우")
        void splitCarNamesDuplicateTest() {
            String[] carNames = new String[]{"성하", "성하", "이오"};

            Assertions.assertThatThrownBy(() -> inputViewValidator.validateSplitCarNames(carNames))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("시도할 횟수 검증 테스트")
    class tryNumTest {

        @Test
        @DisplayName("시도할 횟수가 빈 값인 경우 예외 처리")
        void tryNumBlankTest() {
            String tryNum = "";

            Assertions.assertThatThrownBy(() -> inputViewValidator.validateTryNum(tryNum))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"0.5", "-0.5"})
        @DisplayName("시도할 횟수가 정수가 아닌 경우 예외 처리")
        void tryNumIntegerTest(String tryNum) {

            Assertions.assertThatThrownBy(() -> inputViewValidator.validateTryNum(tryNum))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"-1", "0"})
        @DisplayName("시도할 횟수가 0 이하인 경우 예외 테스트")
        void readTryNumNotPositiveTest(String tryNum) {

            Assertions.assertThatThrownBy(() -> inputViewValidator.validateTryNum(tryNum))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
