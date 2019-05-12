package racing.view;

public enum InputMessages {
    CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)기준으로구분)"),
    REPEAT_NUMBER("시도할 횟수는 몇 회인가요?");

    private String message;
    private InputMessages(String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
