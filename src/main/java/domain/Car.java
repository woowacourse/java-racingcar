package domain;

import java.util.Objects;

/**
 * 이름과 위치 정보를 가지고있는 자동차 클래스
 * <br> Car car = new Car("name")
 * <br> Car car = new Car("name", 0)
 *
 * @author heebg
 * @version 1.0 2019-05-08
 */
public class Car implements Comparable<Car> {
    private final String name;
    private int position;

    /**
     * Car 생성자
     * <br> 위치는 최소값으로 초기화
     *
     * @param name 자동차 이름
     */
    public Car(final String name) {
        this(name, Const.CAR_OBJ_INIT_POSITION);
    }

    /**
     * Car 생성자
     *
     * @param name     자동차 이름
     * @param position 자동차 위치
     * @throws IllegalArgumentException 이름 길이가 최대/최소 이외일 경우 <br> 위치가 최소보다 작을 경우 발생.
     */

    public Car(final String name, final int position) {
        if (Const.MIN_NAME_LEN > name.length() || Const.MAX_NAME_LEN < name.length()) {
            throw new IllegalArgumentException(Const.EX_NAME_LEN);
        }
        if (position < Const.CAR_OBJ_INIT_POSITION) {
            throw new IllegalArgumentException();
        }

        this.name = name;
        this.position = position;
    }

    /**
     * 인자값에 따라 위치를 증가
     * <br> 값이 전진 기준 이상이면 위치 1 증가
     *
     * @param random 전진 여부를 결정하는 값
     */
    public void increasePositionOrNot(int random) {
        if (Const.GO_RAN_NUM <= random) {
            this.position++;
        }
    }

    /**
     * 현재 위치가 인자값보다 큰지 확인
     *
     * @param position 위치
     * @return true : 현재 위치가 인자값보다 클 경우
     */
    public boolean isGreater(int position) {
        return this.position > position;
    }

    /**
     * 현재 위치가 인자값과 같은지 확인
     *
     * @param position 위치
     * @return true : 현재 위치가 인자값과 같을 경우
     */
    public boolean isMatchPosition(int position) {
        return this.position == position;
    }

    @Override
    public String toString() {
        String positionView = "";
        for (int i = 0; i < position; i++) {
            positionView += Const.SHAPE_CAR_POSITION;
        }
        return name + " : " + positionView;
    }

    @Override
    public int compareTo(Car o) {
        return this.position - o.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
