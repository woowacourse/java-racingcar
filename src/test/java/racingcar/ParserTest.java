package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParserTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private static final String ERROR_MESSAGE = "[ERROR]";

    @BeforeEach
    void setUp() {

    }

    /**
     * 파싱 테스트 : 이상한 입력은 예외 처리
     * 예) ,philz,panda
     * ,philz,
     * 1) 5자를 초과하는 이름에 대해 예외처리
     * 2) 이동 횟수가 음수일 때 예외처리
     * 3) 앞이나 뒤에 쉼표가 있는 경우 예외처리
     * 4) 공백이 있는경우는 trim해주어 처리를한다
     * 5) # 등의 특수문자가 있는 경우 예외처리한다
     * 6) 허용하는 입력 : 숫자, 알파벳, 한글
     * 기능테스트
     * 1) 전진한다 : 위치가 1이다
     * 2) 움직이지 않는다 : 위치가 0이다
     * 3) 우승자 판단 - 주어진 입력값에 대해 올바른 우승자를 도출하는지
     * 3명의 참가자 중 2명이 완주일 경우: 2명을 이름 순 출력
     * 3명의 참가자 중 1명이 완주일 경우: 1명 출력
     */

    // 예외 입력: #, null, 앞뒤로 쉼표
    @ParameterizedTest
    @ValueSource(strings = {",", "#", "panda,", "#philz", ",phobi,"})
    @DisplayName("이름에 허용되지 않는 문자")
    public void Not_Available_Character(String input) {
        /*assertThatThrownBy(()->{
            input.contains("[;,]");
        }).isInstanceOf(Exception.class);*/
        //assertThat(input.contains("[;,]")).isTrue();
        assertThatThrownBy(
                () -> StringParser.validateCarName(input)
        ).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("이름에 허용되지 않는 문자 : null")
    public void Not_Available_Null() {
        // then
        assertThatThrownBy(
                () -> StringParser.validateCarName(null)
        ).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("한 번 해보는 정상입력")
    public void Available_Character() {

        //StringParser.validateCarName("Keesun");
        Assertions.assertDoesNotThrow(() -> {
            StringParser.validateCarName("polo");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"panda,philz,java", " panda, philz  , java"})
    @DisplayName("자동차 전체 입력 : 정상")
    public void input_all_car_name(String input) {
        String[] inputNames = StringParser.readCarNameInputs(input);

        assertThat(inputNames).containsExactly("panda", "philz", "java");
    }

    @Test
    @DisplayName("자동차 전체 입력 : 예외")
    public void input_all_car_name_exception() {
        assertThatThrownBy(() -> {
            StringParser.readCarNameInputs("panda,philz,javajigi");
        });
    }
/*
    @Test
    @DisplayName("자동차 이동")
    public void move_car() {
       // given
        Car car = new Car("philz");

       // when

       // then

    }
*/
}