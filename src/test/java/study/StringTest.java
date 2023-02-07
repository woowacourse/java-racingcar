package study;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

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
        assertThat(afterSplit)
            .containsExactly("1", "2");
    }

    @Test
    void splitOneElement() {
        // given
        String beforeSplit = "1";

        //when
        String[] afterSplit = beforeSplit.split(",");

        //then
        assertThat(afterSplit)
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
        assertAll(
                ()->assertThat(afterRemoveBracketBySubstring)
                        .isEqualTo("1,2"),
                ()->assertThat(afterRemoveBracketByReplace)
                .isEqualTo("1,2")
        );
    }
}
