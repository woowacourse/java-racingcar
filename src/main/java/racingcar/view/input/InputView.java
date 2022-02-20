package racingcar.view.input;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.exception.round.WrongRoundCountException;
import racingcar.exception.round.RoundCountExceptionStatus;
import racingcar.utils.Delimiter;
import racingcar.view.input.reader.Reader;
import racingcar.view.output.OutputView;

public class InputView {

    private final Reader reader;
    private final OutputView outputView;

    public InputView(final Reader reader, final OutputView outputView) {
        this.reader = reader;
        this.outputView = outputView;
    }

    public List<String> requestCarNames() {
        outputView.printMessageOfRequestCarNames();
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

    public int requestRoundCount() {
        outputView.printMessageOfRequestRound();
        return parseNumber(reader.readLine());
    }

    private int parseNumber(final String inputValue) {
        try {
            return Integer.parseInt(inputValue.trim());
        } catch (NumberFormatException exception) {
            throw new WrongRoundCountException(RoundCountExceptionStatus.ROUND_IS_NOT_NUMERIC);
        }
    }

}
