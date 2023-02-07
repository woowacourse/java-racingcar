package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

  @Test
  @DisplayName("[1,2]의 경우")
  public void splitOneTwo() {
    String given = "1,2";
    String[] result = given.split(",");

    Assertions.assertThat(result).contains("1", "2");
  }

  @Test
  @DisplayName("[1]의 경우")
  public void splitOnlyOne() {
    String given = "1";
    String[] result = given.split(",");

    Assertions.assertThat(result).containsExactly("1");
  }

  @Test
  @DisplayName("문자열 양 끝 문자 제거")
  public void removeEdge() {
    String given = "(1,2)";
    String result = given.substring(1, given.length() - 1);

    Assertions.assertThat(result).isEqualTo("1,2");
  }

  @Test
  @DisplayName("범위 내 index의 문자 접근")
  public void getInOfIndexChar() {
    String given = "abc";
    int givenIndex = 1;
    char result = given.charAt(givenIndex);

    Assertions.assertThat(result).isEqualTo('b');
  }

  @Test
  @DisplayName("범위 밖 index의 문자 접근")
  public void getOutOfIndexChar() {
    String given = "abc";
    int givenIndex = 3;
    //char result = ;

    Assertions.assertThatThrownBy(() -> {
      given.charAt(givenIndex);
    }).isInstanceOf(StringIndexOutOfBoundsException.class);
  }
}
