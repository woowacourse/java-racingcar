package racing.input;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameInputManagerTest {

  @Test
  @DisplayName("정상 동작 테스트")
  void getName() {
    List<String> testNames = CarNameInputManager.getName("testA,testB,testC");
    Assertions.assertThat(testNames)
        .containsExactlyElementsOf(List.of("testA", "testB", "testC"));
  }

  @ParameterizedTest
  @ValueSource(strings = {",testA,testB", "testA,testB,", "testA,,testB", "testAB,testA"})
  @DisplayName("이름의 길이가 올바른지 확인")
  void getNameFailByWrongNameLength(String input) {
    Assertions.assertThatThrownBy(() -> CarNameInputManager.getName(input))
        .isInstanceOf(RuntimeException.class)
        .hasMessage("이름의 길이는 1 이상 5 이하여야 합니다.");
  }

  @ParameterizedTest
  @ValueSource(strings = {"test1,testB", "test&,testB"})
  @DisplayName("이름을 구성하는 문자가 올바른지 확인")
  void getNameFailByWrongCharacter(String input) {
    Assertions.assertThatThrownBy(() -> CarNameInputManager.getName(input))
        .isInstanceOf(RuntimeException.class)
        .hasMessage("이름은 알파벳 대소문자로만 이루어져야 합니다.");
  }
}