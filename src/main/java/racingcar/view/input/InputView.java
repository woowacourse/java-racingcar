package racingcar.view.input;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.exception.WrongArgumentException;
import racingcar.exception.status.round.RoundCountExceptionStatus;
import racingcar.utils.Delimiter;
import racingcar.view.input.reader.Reader;

public class InputView {

    private final Reader reader;

    public InputView(final Reader reader) {
        this.reader = reader;
    }

    public List<String> requestCarNames() {
        return parseNames(reader.readLine());
    }

    private List<String> parseNames(final String inputValue) {
        return Arrays.stream(Delimiter.splitWithComma(appendSpaceBeforeSplit(inputValue)))
                .map(String::trim)
                .collect(Collectors.toUnmodifiableList());
    }

    private String appendSpaceBeforeSplit(final String targetString) {
        return Delimiter.appendSpaceBehind(targetString);
    }

    public int requestRoundNumber() {
        return parseNumber(reader.readLine());
    }

    private int parseNumber(final String inputValue) {
        try {
            return Integer.parseInt(inputValue.trim());
        } catch (NumberFormatException exception) {
            throw new WrongArgumentException(RoundCountExceptionStatus.ROUND_IS_NOT_NUMERIC);
        }
    }

}
