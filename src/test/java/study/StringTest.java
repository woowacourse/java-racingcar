package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("String 클래스")
public class StringTest {

  @Nested
  @DisplayName("split 메소드는 ','를 구분자로 설정했을 때")
  class Describe_split {

    @Test
    @DisplayName("대상 문자열이 '1,2'인 경우 '1', '2'를 반환한다")
    public void splitOneTwo() {
      String given = "1,2";
      String[] result = given.split(",");

      Assertions.assertThat(result).contains("1", "2");
    }

    @Test
    @DisplayName("대상 문자열이 '1'인 경우 '1'를 반환한다")
    public void splitOnlyOne() {
      String given = "1";
      String[] result = given.split(",");

      Assertions.assertThat(result).containsExactly("1");
    }
  }
  
  @Test
  @DisplayName("문자열 양 끝 문자 제거")
  public void removeEdge() {
    String given = "(1,2)";
    String result = given.substring(1, given.length() - 1);

    Assertions.assertThat(result).isEqualTo("1,2");
  }

  @Nested
  @DisplayName("charAt 메소드는")
  public class Describe_charAt {

    @Test
    @DisplayName("접근하려는 인덱스가 범위 내에 있을 때 해당 인덱스의 값을 반환한다.")
    public void getInOfIndexChar() {
      String given = "abc";
      int givenIndex = 1;
      char result = given.charAt(givenIndex);

      Assertions.assertThat(result).isEqualTo('b');
    }

    @Test
    @DisplayName("접근하려는 인덱스가 범위를 벗어나면 StringIndexOutOfBoundsException을 반환한다.")
    public void getOutOfIndexChar() {
      String given = "abc";
      int givenIndex = 3;

      Assertions.assertThatThrownBy(() -> {
        given.charAt(givenIndex);
      }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
  }

}
