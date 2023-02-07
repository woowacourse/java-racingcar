package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringTest {

    @DisplayName("문자열이 ',' 기준으로 split 되는지 확인한다.")
    @Test
    void divideString() {
        String input = "1,2";

        assertThat(input.split(","))
                .contains("1", "2");
    }

    @DisplayName("split할 수 없는 문자열인 경우, 해당 문자열만을 포함한 배열로 반환하는지 확인한다.")
    @Test
    void divideStringToSingleArray() {
        String input = "1";

        assertThat(input.split(","))
                .containsExactly("1");
    }

//    @ParameterizedTest
//    @MethodSource("provideSplitStringContainsExpected")
//    void containsSplitString(String input, List<String> expected) {
//        assertThat(input.split(","))
//                .contains(expected.get(0));
//    }
}
