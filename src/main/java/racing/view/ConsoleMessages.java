package racing.view;

public enum ConsoleMessages {
    INPUT_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)기준으로구분)"),
    INPUT_REPEAT_NUMBER("시도할 횟수는 몇 회인가요?"),
    OUTPUT_WINNER_NAME("%s가 최종 우승했습니다.");

    private String message;
    private ConsoleMessages(String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
