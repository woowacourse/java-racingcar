package racingcar.validator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class CarNamesValidatorTest {
    private static CarNamesValidator carNamesValidator;

    @BeforeAll
    static void set() {
        carNamesValidator = new CarNamesValidator();
    }

    @ParameterizedTest()
    @MethodSource("이름_유효성_검사_데이터_생성")
    @DisplayName("이름 유효성 검사 테스트")
    public void 이름_유효성_검사(List<String> names) {
        assertDoesNotThrow(() -> carNamesValidator.validateNames(names));
    }

    static Stream<Arguments> 이름_유효성_검사_데이터_생성() {
        return Stream.of(
                Arguments.of(Arrays.asList("홍고", "오잉")),
                Arguments.of(Arrays.asList("1", "22", "333")),
                Arguments.of(Arrays.asList("hongo", "oing"))
        );
    }

    @ParameterizedTest()
    @MethodSource("길이_예외_검사_데이터_생성")
    @DisplayName("이름 길이 예외 테스트")
    public void 길이_예외_검사(List<String> names) {
        Assertions.assertThatThrownBy(() -> carNamesValidator.validateNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자이하만 가능합니다.");
    }

    static Stream<Arguments> 길이_예외_검사_데이터_생성() {
        return Stream.of(
                Arguments.of(Arrays.asList("홍고홍고홍고", "오잉")),
                Arguments.of(Arrays.asList("123123", "456", "789")),
                Arguments.of(Arrays.asList("hongo", ""))
        );
    }

    @ParameterizedTest()
    @MethodSource("중복_예외_검사_데이터_생성")
    @DisplayName("중복 예외 테스트")
    public void 중복_예외_검사(List<String> names) {
        Assertions.assertThatThrownBy(() -> carNamesValidator.validateNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 중복될 수 없습니다.");
    }

    static Stream<Arguments> 중복_예외_검사_데이터_생성() {
        return Stream.of(
                Arguments.of(Arrays.asList("홍고", "오잉", "홍고")),
                Arguments.of(Arrays.asList("123", "456", "123")),
                Arguments.of(Arrays.asList("hongo", "hongo", "oing"))
        );
    }

    @ParameterizedTest()
    @MethodSource("공백_예외_검사_데이터_생성")
    @DisplayName("공백 예외 테스트")
    public void 공백_예외_검사(List<String> names) {
        Assertions.assertThatThrownBy(() -> carNamesValidator.validateNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백이 포함된 문자는 입력할 수 없습니다.");
    }

    static Stream<Arguments> 공백_예외_검사_데이터_생성() {
        return Stream.of(
                Arguments.of(Arrays.asList("홍 고", "오잉", "바다")),
                Arguments.of(Arrays.asList("123 ", "456", "123")),
                Arguments.of(Arrays.asList(" ", "hongo", "oing"))
        );
    }
}