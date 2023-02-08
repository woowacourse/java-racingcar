//package view;
//
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//
//import static org.assertj.core.api.Assertions.*;
//
//class InputViewTest {
//
//    @DisplayName("사용자로부터 정상적인 입력값을 받아 처리한다.")
//    @Test
//    void test1() {
//        assertThat(InputView.readCarNames("pobi,crong,honux"))
//                .containsExactly("pobi", "crong", "honux");
//    }
//
//    @DisplayName("사용자로부터 잘못된 값을 입력 받으면 예외가 발생한다.")
//    @Test
//    void test2() {
//        InputView.readCarNames("pobi,cronghonux");
//    }
//
//}