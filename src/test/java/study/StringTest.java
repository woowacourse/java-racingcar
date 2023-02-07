package study;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringTest {
    
    @Test
    void splitTest() {
        // given
        String beforeSplit = "1,2";

        // when
        String[] afterSplit = beforeSplit.split(",");

        // then
        Assertions.assertThat(afterSplit)
            .containsExactly("1", "2");
    }

    @Test
    void splitOneElement() {
        // given
        String beforeSplit = "1";

        //when
        String[] afterSplit = beforeSplit.split(",");

        //then
        Assertions.assertThat(afterSplit)
            .containsExactly("1");
    }

    @Test
    void removeBracket(){
        //given
        String beforeRemoveBracket = "(1,2)";

        //when
        String afterRemoveBracketBySubstring = beforeRemoveBracket.substring(1, 4);
        String afterRemoveBracketByReplace = beforeRemoveBracket
                .replace("(", "")
                .replace(")", "");

        //then
        Assertions.assertThat(afterRemoveBracketBySubstring)
                .isEqualTo("1,2");
        Assertions.assertThat(afterRemoveBracketByReplace)
                .isEqualTo("1,2");
    }
}
