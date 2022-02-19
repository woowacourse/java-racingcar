import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest {

    @DisplayName("main() 전체 테스트")
    @Test
    void main_test() throws Exception {
        String[] input = {"name1,name2,name3", "5"};
        OutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        byte[] buf = String.join("\n", input).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        Application.main(null);

        String out = output.toString();
        assertThat(out).contains("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).",
                "시도할 회수는 몇회인가요?", "실행 결과", "name1 : ", "최종 우승했습니다.");
    }
}
