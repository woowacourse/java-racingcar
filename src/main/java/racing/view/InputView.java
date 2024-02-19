package racing.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;
import java.util.function.Supplier;

public class InputView {

  public static <T> T getInput(Function<Supplier<String>, T> function) {
    return function.apply(InputView::readFromConsole);
  }

  private static String readFromConsole() {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    try {
      return bufferedReader.readLine();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
