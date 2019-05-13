package racing.view;

public enum ConsoleMessages {
    INPUT_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)기준으로구분)"),
    INPUT_REPEAT_NUMBER("시도할 횟수는 몇 회인가요?"),
    ERR_REPEAT_NUMBER("반복 횟수는 숫자만 가능합니다."),
    ERR_IDENTIFIER_NAME("이름은 쉼표를 기준으로 구분합니다."),
    ERR_CAR_NAME("레이서의 이름은 5자 이하여야 합니다."),
    ERR_CAR_BLANK_NAME("레이서의 이름은 적어도 하나의 공백이 아닌 문자가 있어야 합니다."),
    ERR_INVALID_REPEAT_NUMBER("횟수는 1 이상이어야 합니다."),
    OUTPUT_WINNER_NAME("%s가 최종 우승했습니다.");

    private String message;

    private ConsoleMessages(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

}
