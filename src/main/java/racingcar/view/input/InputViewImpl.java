package racingcar.view.input;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.exception.round.RoundNotNumericException;
import racingcar.utils.Delimiter;
import racingcar.view.input.reader.Reader;

public class InputViewImpl implements InputView {

    private final Reader reader;

    public InputViewImpl(Reader reader) {
        this.reader = reader;
    }

    public List<String> requestCarNames() {
        return parseNames(reader.readLine());
    }

    private List<String> parseNames(String inputValue) {
        inputValue = appendSpaceBeforeSplit(inputValue);
        return Arrays.stream(Delimiter.splitWithComma(inputValue))
                .map(String::trim)
                .collect(Collectors.toUnmodifiableList());
    }

    private String appendSpaceBeforeSplit(String targetString) {
        return Delimiter.appendSpaceBehind(targetString);
    }

    public int requestRoundNumber() {
        return parseNumber(reader.readLine());
    }

    private int parseNumber(String inputValue) {
        try {
            return Integer.parseInt(inputValue.trim());
        } catch (NumberFormatException exception) {
            throw new RoundNotNumericException();
        }
    }

}
