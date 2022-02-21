package racingcar.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.message.NoticeMessages;

public class InputView {
    private static final String DELIMITER = ",";

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    private InputView() {

    }

    public static List<String> inputCarNames() throws IOException {
        System.out.println(NoticeMessages.INPUT_CAR_NAMES);
        return splitNames(bufferedReader.readLine());
    }

    public static String inputTryCount() throws IOException {
        System.out.println(NoticeMessages.INPUT_TRY_CNT);
        return bufferedReader.readLine();
    }

    private static List<String> splitNames(String namesString) {
        return Arrays.stream(namesString.split(DELIMITER))
                .collect(Collectors.toList());
    }
}
