package racinggame.domain.car;

import racinggame.domain.data.Output;

import java.util.List;

/**
 * Car 클래스는 자동차 경주에 사용될 자동차의 정보값을 담는 클래스이다.
 * 현재 위치와 이름 값을 필드에 보유하고 있으며,
 * 추가로 static 변수인 winnerRecord을 가지고 있어
 * Car 클래스가 보유한 position값 중 제일 큰 position 값이 무엇인지 조회할 수 있다.
 */
public class Car {
    /**
     * name은 자동차의 이름을 담는 문자열 인스턴스이다.
     */
    private final String name;

    /**
     * position은 자동차의 현재 위치를 담는 Position 인스턴스이다.
     */
    private Position position;

    /**
     * winnerRecord는 static 정수 변수로, Car 인스턴스 전체가 공유한다.
     * 여기에 Car 인스턴스가 보유한 position 값 중 제일 큰 값이 무엇인지 저장한다.
     * 이는 position에 대한 값 변조가 일어날 시 마다 갱신된다.
     */
    private static int winnerRecord = 0;

    /**
     * START_POSITION은 Car 클래스 생성 시 position 값으로 설정되는 정수형 상수이다.
     */
    private static final int START_POSITION = 0;

    /**
     * 생성자 메서드는 이름을 입력받아, position이 0이고 name이 name(param)인 Car 인스턴스를 생성한다.
     * 이름과 포지션 모두를 파라미터로 받는 다른 생성자 메서드를 오버로딩한다.
     *
     * @param name 이름값을 저장하는 문자열 인스턴스이다.
     */
    public Car(String name) {
        this(name, START_POSITION);
    }

    /**
     * 생성자 메서드는 이름과 위치값을 입력받아, position이 position(param)이고 name이 name(param)인 Car 인스턴스를 생성한다.
     * 테스트 코드에서 사용되며, 기본 생성자에서도 상수값을 파라미터로 하여 호출된다.
     *
     * @param name     이름값을 저장하는 문자열 인스턴스이다.
     * @param position 위치값을 저장하는 정수형 변수이다.
     */
    public Car(String name, int position) {
        this.name = name;
        this.position = new Position(position);
    }

    /**
     * updateMaxPosition은 winnerRecord의 값을 수정하는 메서드이다.
     * 이 메서드 외에서는 winnerRecord 값이 변경되지 않도록 설계에 주의하였다.
     * 만약 현재의 position 값이 winnerRecord 값보다 크다면, 그 값으로 갱신한다.
     */
    private void updateMaxPosition() {
        winnerRecord = Integer.max(position.getPosition(), winnerRecord);
    }

    /**
     * accelerate 메서드는 랜덤한 값과 기준이 되는 값을 전달받아,
     * 랜덤한 값이 기준이 되는 값을 넘은 경우 position을 증가시킨다.
     * 또한 이 증가 메서드 호출 시, Car 인스턴스 전체에 공유되는 winnerRecord값을 갱신해준다.
     *
     * @param random 비교를 위한 임의의 정수형 변수이다.
     * @param bound  가속을 위한 비교의 기준값인 정수형 변수이다.
     */
    public void accelerate(int random, int bound) {
        if (random >= bound) {
            position.accelerate();
            updateMaxPosition();
        }
    }

    /**
     * isWinner는 이 인스턴스가 승자인지(position이 모든 Car 인스턴스 중 제일 큰 지) 확인하여 반환한다.
     *
     * @return 이 인스턴스가 승자라면 true를, 아니라면 false를 반환한다.
     */
    public boolean isWinner() {
        return position.match(winnerRecord);
    }

    /**
     * match는 정수값을 입력받아 그 값과 이 인스턴스의 position 값이 일치하는지 여부를 반환한다.
     *
     * @param position 비교를 위한 위치값을 저장하는 정수형 변수이다.
     * @return 이 인스턴스의 position 값과 파라미터가 일치하면 true를, 아니라면 false를 반환한다.
     */
    public boolean match(int position) {
        return this.position.match(position);
    }

    /**
     * addWinnerName은 리스트 winners를 전달받은 후, 만약 이 인스턴스가 승자(isWinner로 검사)라면
     * 이 인스턴스의 이름을 winners에 추가하는 메서드이다.
     * 이를 전체 인스턴스에 대해 순회시킴으로써 승자들의 이름 목록을 구할 수 있다.
     *
     * @param winners String을 저장하는 List 구조이다.
     */
    public void addWinnerName(List<String> winners) {
        if (isWinner()) {
            winners.add(this.name);
        }
    }

    /**
     * passingLog는 Output 인스턴스를 전달받은 후, 현재 이 인스턴스의 상태 기록을 업데이트하는 메서드이다.
     *
     * @param output 출력값을 저장하는 Output 인스턴스이다.
     */
    public void passingLog(Output output) {
        output.updateCarStatus(name, position.getPosition());
    }

    /**
     * InitWinnerRecord은 static으로 설정되어 잘못된 값이 설정될 수 있는 winnerRecord의 값을 초기화하는 메서드이다.
     * 물론 현재 프로그램에서는 문제가 없지만, 만약 레이스를 다회 실행할 경우 문제가 될 여지가 있어 추가하였다.
     * 또한 테스트 메서드에서 반복을 위해 사용하고 있다.
     */
    public static void initWinnerRecord() {
        winnerRecord = 0;
    }
}
