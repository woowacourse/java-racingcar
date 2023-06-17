import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class ResultViewTest {
    @DisplayName("자동차 위치 출력 테스트")
    @Test
    void ViewTest1() {
        String expectResult = "----\r\n";
        ResultView resultView = new ResultView();
        Car car = new Car();

        for (int i = 0; i < 3; i++) {
            car.forward();
        }

        OutputStream realResult = new ByteArrayOutputStream();
        System.setOut(new PrintStream(realResult));
        resultView.showCarLocation(car);

        assertThat(expectResult).isEqualTo(realResult.toString());
    }
}
