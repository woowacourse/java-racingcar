package racingcar.validator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class ValidatorTest {
    private static Validator validator;

    @BeforeAll
    static void set() {
        validator = new Validator();
    }

    @ParameterizedTest()
    @DisplayName("횟수 유효성 검사 테스트")
    @ValueSource(strings = {"1", "3", "9", "100", "300", "500"})
    public void 횟수_유효성_검사(String tryCount) {
        assertDoesNotThrow(() -> validator.validateTryCount(tryCount));
    }

    @ParameterizedTest()
    @DisplayName("횟수가 자연수가 아닐 경우 예외 테스트")
    @ValueSource(strings = {"a", "0", "-100", "1abc", "테스트"})
    public void 횟수_예외_검사(String tryCount) {
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->
                validator.validateTryCount(tryCount)
        );
        assertEquals("시도할 횟수는 자연수만 가능합니다.", exception.getMessage());
    }

    @ParameterizedTest()
    @DisplayName("이름 유효성 검사 테스트")
    @MethodSource("이름_유효성_검사_데이터_생성")
    public void 이름_유효성_검사(List<String> names) {
        assertDoesNotThrow(() -> validator.validateNames(names));
    }

    static Stream<Arguments> 이름_유효성_검사_데이터_생성() {
        return Stream.of(
                Arguments.of(Arrays.asList("홍고", "오잉")),
                Arguments.of(Arrays.asList("1", "22", "333")),
                Arguments.of(Arrays.asList("hongo", "oing"))
        );
    }

    @ParameterizedTest()
    @DisplayName("이름 길이 예외 테스트")
    @MethodSource("길이_예외_검사_데이터_생성")
    public void 길이_예외_검사(List<String> names) {
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->
                validator.validateNames(names)
        );
        assertEquals("자동차 이름은 5자이하만 가능합니다.", exception.getMessage());
    }

    static Stream<Arguments> 길이_예외_검사_데이터_생성() {
        return Stream.of(
                Arguments.of(Arrays.asList("홍고홍고홍고", "오잉")),
                Arguments.of(Arrays.asList("123123", "456", "789")),
                Arguments.of(Arrays.asList("hongo", ""))
        );
    }

    @ParameterizedTest()
    @DisplayName("중복 예외 테스트")
    @MethodSource("중복_예외_검사_데이터_생성")
    public void 중복_예외_검사(List<String> names) {
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->
                validator.validateNames(names)
        );
        assertEquals("자동차 이름은 중복될 수 없습니다.", exception.getMessage());
    }

    static Stream<Arguments> 중복_예외_검사_데이터_생성() {
        return Stream.of(
                Arguments.of(Arrays.asList("홍고", "오잉", "홍고")),
                Arguments.of(Arrays.asList("123", "456", "123")),
                Arguments.of(Arrays.asList("hongo", "hongo", "oing"))
        );
    }
}