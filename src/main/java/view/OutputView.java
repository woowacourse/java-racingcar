package view;

import dto.GameResultDto;

public class OutputView {

    private static final String RACE_RESULT_PREFIX = "\n실행 결과";

    private final MessageResolver messageResolver;

    public OutputView(MessageResolver messageResolver) {
        this.messageResolver = messageResolver;
    }

    public void printResultPrefix() {
        System.out.println(RACE_RESULT_PREFIX);
    }

    public void printRaceResult(GameResultDto gameResultDto) {
        System.out.println(messageResolver.resolveGameResultMessage(gameResultDto));
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
