package view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {

    @DisplayName("이름을 입력받아 ',' 로 분리")
    @Test
    public void nameSplit() {
        String input = "k3,k5,audi";
        String[] names = InputView.nameSplit(input);
        assertThat(names).containsExactly("k3", "k5", "audi");
    }
}
