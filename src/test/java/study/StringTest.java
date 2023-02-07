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
}
