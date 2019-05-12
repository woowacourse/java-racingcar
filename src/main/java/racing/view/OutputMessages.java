package racing.view;

public enum OutputMessages {

    OUTPUT_WINNER_NAME("%s가 최종 우승했습니다.");

    private String message;

    private OutputMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
