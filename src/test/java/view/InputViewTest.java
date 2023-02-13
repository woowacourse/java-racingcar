package view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import utils.Converter;
import vo.CarName;
import vo.Trial;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class InputViewTest {
    private InputView inputView;

    @Nested
    @DisplayName("자동차 이름을 입력받는 getCarNames() 메소드 테스트")
    class GetCarNamesTest {
        @Test
        @DisplayName("쉼표로 구분된 자동차 이름을 입력하면 CarName 리스트를 리턴한다.")
        void givenCarNamesSeparatedByComma_whenGettingCarNames_thenReturnsCarNames() {
            inputView = initializeInputView("Car,Car2,Car3");

            List<CarName> carNames = inputView.getCarNames();

            assertThat(carNames)
                    .containsExactly(
                            CarName.of("Car"),
                            CarName.of("Car2"),
                            CarName.of("Car3")
                    );
        }

        @Test
        @DisplayName("자동차 이름 하나만 입력하면 하나의 원소만 들어있는 CarName 리스트를 리턴한다.")
        void givenSingleCarName_whenGettingCarNames_thenReturnsCarNames() {
            inputView = initializeInputView("Car");

            List<CarName> carNames = inputView.getCarNames();

            assertThat(carNames)
                    .containsExactly(
                            CarName.of("Car")
                    );
        }

        @Nested
        @DisplayName("검증 실패 테스트")
        class ValidationFailTest {
            @Test
            @DisplayName("입력 자체가 비어있다면 예외가 발생한다.")
            void givenBlank_whenGettingCarNames_thenThrowsException() {
                inputView = initializeInputView("");

                assertThatThrownBy(() -> inputView.getCarNames())
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("입력값은 비어있을 수 없습니다.");
            }

            @Test
            @DisplayName("쉼표로 구분된 단어가 비어있다면 예외가 발생한다.")
            void givenCarNamesHavingBlank_whenGettingCarNames_thenThrowsException() {
                inputView = initializeInputView("Car,,Car3");

                assertThatThrownBy(() -> inputView.getCarNames())
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("입력값은 비어있을 수 없습니다.");
            }
        }
    }

    @Nested
    @DisplayName("시도 횟수를 입력받는 getTrial() 메소드 테스트")
    class GetTrial {
        @Test
        @DisplayName("양수의 정수로 이루어진 시도 횟수 값을 입력하면 Trial 객체를 반환한다.")
        void givenPositiveNumber_whenGettingTrial_thenReturnsTrial() {

        }

        @Nested
        @DisplayName("검증 실패 테스트")
        class ValidationFailTest {
            @Test
            @DisplayName("숫자가 아닌 값이 주어지는 경우 예외가 발생한다.")
            void givenNotNumber_whenGettingTrial_thenThrowsException() {
                inputView = initializeInputView("숫자아님");

                assertThatThrownBy(() -> inputView.getTrial())
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(Converter.NOT_NUMBER_EXCEPTION_MESSAGE);
            }

            @Test
            @DisplayName("양수가 아닌 값이 주어지는 경우 예외가 발생한다.")
            void givenNotPositive_whenGettingTrial_thenThrowsException() {
                inputView = initializeInputView("-33");

                assertThatThrownBy(() -> inputView.getTrial())
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(Trial.NOT_POSITIVE_NUMBER_EXCEPTION_MESSAGE);
            }

            @Test
            @DisplayName("내부 필드로 Long 타입을 가지고 있으므로 Integer 범위를 넘어서는 수가 넘어와도 된다.")
            void givenOverInteger_whenGettingTrial_thenSuccess() {
                inputView = initializeInputView("2200000000");

                assertThatCode(() -> inputView.getTrial())
                        .doesNotThrowAnyException();
            }

            @Test
            @DisplayName("정수가 아닌 값이 주어지는 경우 예외가 발생한다.")
            void givenNotInteger_whenGettingTrial_thenSuccess() {
                inputView = initializeInputView("33.5");

                assertThatThrownBy(() -> inputView.getTrial())
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(Converter.NOT_NUMBER_EXCEPTION_MESSAGE);
            }
        }
    }

    private static InputView initializeInputView(String... mockValue) {
        return new InputView(new MockingInputReader(mockValue));
    }
}