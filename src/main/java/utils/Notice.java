package utils;

public enum Notice {
    ENTER_CAR_NAME("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
    ENTER_TRY_TIMES("시도할 회수는 몇회인가요?"),
    RESULT("실행 결과"),
    FINAL_WINNER("가 최종 우승했습니다.");

    private final String noticeMessage;

    Notice(String noticeMessage) {
        this.noticeMessage = noticeMessage;
    }

    public String of() {
        return noticeMessage;
    }


}
