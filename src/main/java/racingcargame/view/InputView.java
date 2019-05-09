package racingcargame.view;

import racinginterface.InputViewInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class InputView implements InputViewInterface {

    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private final String NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";

    @Override
    public String readNames() {
        System.out.println(NAME_INPUT_MESSAGE);
        try {
            String names = bufferedReader.readLine();
            validNameFormat(names);
            validNameOverlap(names);
            return names;
        } catch (Exception e) {
            return readNames();
        }
    }

    private void validNameFormat(String names) {
        if (!names.matches("(\\w{1,5},)*\\w{1,5}")) {
            throw new IllegalArgumentException();
        }
    }

    private void validNameOverlap(String names) {
        List<String> nameList = Arrays.asList(names.split(","));
        HashSet<String> set = new HashSet<>(nameList);
        if (nameList.size() != set.size()) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int readCountOfRound() throws IOException {
        return 0;
    }
}
