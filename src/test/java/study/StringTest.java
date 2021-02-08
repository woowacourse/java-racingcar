package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

  @Test
  public void split() {
    String[] values = "1,2".split(",");
    assertThat(values).containsExactly("1", "2");

    values = "1".split(",");
    assertThat(values).containsExactly("1");
  }

  @Test
  @DisplayName("String - substring 테스트")
  void substring() {
    //given
    String values = "(1,2)";

    //when
    String substring = values.substring(1, values.length() - 1);

    //then
    assertThat(substring).isEqualTo("1,2");
  }

  @Test
  @DisplayName("String - charAt 테스트")
  void charAt() {
    //given
    String value = "abc";

    // when
    char charAt = value.charAt(0);
    // then
    assertThat(charAt).isEqualTo('a');

    assertThatThrownBy(() -> value.charAt(4))
        .isInstanceOf(StringIndexOutOfBoundsException.class)
        .hasMessageContaining("String index out of range: 4");
  }

}