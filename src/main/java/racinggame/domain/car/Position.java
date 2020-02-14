package racinggame.domain.car;

/**
 * Position 클래스는 Car 클래스에서 사용되는 position 변수를 감싸는 클래스이다.
 * position의 예외값에 대한 검증을 수행하고, 제한적인 동작(이동) 만 가능하도록 설계하였다.
 */
public class Position {
    /**
     * position은 자동차의 위치를 표현하는 정수형 변수이다.
     * 0 이상의 정수형이고, 감산되지 않음을 보장한다.
     */
    private int position;

    /**
     * DEFAULT_ACCELERATE는 정수형 상수값으로, 별도의 파라미터가 없을 경우 자동차가 한번에 움직이는 거리이다.
     */
    public static final int DEFAULT_ACCELERATE = 1;

    /**
     * 생성자 메서드는 정수형 파라미터를 전달받아, 이를 position에 대입한다.
     * 이 과정에서 예외가 발생하는지 검사한다.
     *
     * @param position 이 클래스에 대입할 위치 값으로, 정수형 변수이다.
     */
    public Position(int position) {
        validatePosition(position);
        this.position = position;
    }

    /**
     * validatePosition은 position값이 올바른지 검사하는 메서드이다.
     * 만약 position이 0보다 작을 경우, 예외를 발생시킨다.
     *
     * @param position 검사할 position 값이다.
     */
    private void validatePosition(int position){
        if(position < 0){
            throw new IllegalArgumentException("위치값은 0 이상이어야 합니다.");
        }
    }

    /**
     * match 메서드는 정수값을 전달받아, 이 값과 현재 이 클래스가 가지는 position의 값이 같은지 검사한다.
     *
     * @param position 이 클래스의 인스턴스가 가지는 position 값과 비교할 정수형 값이다.
     * @return 두 값이 같다면 true를, 다르다면 false를 반환한다.
     */
    public boolean match(int position) {
        return position == this.position;
    }

    /**
     * accelerate는 position에 값을 더해주는 메서드이다.
     * position 값은 0 이상의 정수이며, 더하는 것만 가능하다.
     * 그렇기 때문에 accelerate 메서드를 통해서만 조작할 수 있도록 설계하였다.
     * 만약 파라미터 없이 호출될 경우, 상수로 정의된 값만큼 position을 올려준다.
     */
    public void accelerate() {
        accelerate(DEFAULT_ACCELERATE);
    }

    /**
     * accelerate(오버로딩)는 position에 전달된 파라미터만큼 값을 더해주는 메서드이다.
     * position 값은 0 이상의 정수이며, 더하는 것만 가능하다.
     * 그렇기 때문에 accelerate 메서드를 통해서만 조작할 수 있도록 설계하였다.
     * 만약 파라미터가 음수이거나 더한 값이 오버플로우가 될 경우, 예외를 발생시킨다.
     *
     * @param accelerateValue 현재 위치에 더해 줄 정수 값이다.
     */
    public void accelerate(int accelerateValue){
        if(accelerateValue <= 0){
            throw new IllegalArgumentException("잘못된 요청이 가속 메서드에 전달되었습니다");
        }
        try {
            position = Math.addExact(position,accelerateValue);
        }catch(ArithmeticException e){
            throw new IllegalArgumentException("잘못된 요청이 가속 메서드에 전달되었습니다");
        }
    }
}
