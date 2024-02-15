import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {


    @Nested
    @DisplayName("자동차 이름 테스트")
    class CarNameTest {

        @ParameterizedTest
        @ValueSource(strings = {"abc", "ABCDE", "ABC가나", "가나다", "가나다라마"})
        @DisplayName("이름은 영어, 한글 5자 이내이다")
        void validateCarName(String name) {
            Assertions.assertThatCode(() -> Validator.validateCarName(name))
                    .doesNotThrowAnyException();
        }

        @ParameterizedTest
        @ValueSource(strings = {"a!", "a b", " ", "ABC가나k"})
        @DisplayName("이름은 영어, 한글 5자 이내가 아니면 예외가 발생한다.")
        void invalidateCarName(String name) {
            Assertions.assertThatThrownBy(() -> Validator.validateCarName(name))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("이름은 중복일 수 없다")
        void invalidateCarName() {
            String[] names = new String[]{"hi", "hi"};
            Assertions.assertThatThrownBy(() -> Validator.validateParticipant(names))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("실행 회수 테스트")
    class CountTest {

        @ParameterizedTest
        @ValueSource(ints = {1, 100, 45})
        @DisplayName("실행 회수는 1이상 100이하 이다")
        void validateCount(int count) {
            Assertions.assertThatCode(() -> Validator.validateCount(count))
                    .doesNotThrowAnyException();
        }

        @ParameterizedTest
        @ValueSource(ints = {-1, 0, 101})
        @DisplayName("실행 회수가 0이하 100초과라면 예외가 발생한다")
        void invalidateCount(int count) {
            Assertions.assertThatThrownBy(() -> Validator.validateCount(count))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
