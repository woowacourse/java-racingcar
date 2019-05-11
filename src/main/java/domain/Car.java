package domain;

import java.util.Objects;

/**
 * Created by Heebg
 * User: heebg
 * Date: 2019-05-08
 */
public class Car {
    private final String name;
    private int position;

    public Car(final String name) {
        this(name,Const.CAR_OBJ_INIT_POSITION);
    }

    public Car (final String name, final int position){
        if (Const.MIN_NAME_LEN > name.length() || Const.MAX_NAME_LEN < name.length()) {
            throw new IllegalArgumentException(Const.EX_NAME_LEN);
        }
        if(position < Const.CAR_OBJ_INIT_POSITION){
            throw new IllegalArgumentException();
        }

        this.name = name;
        this.position = position;
    }

    public String getName() {
        return this.name;
    }

    public void increasePositionOrNot(int random) {
        if (Const.GO_RAN_NUM <= random) {
            this.position++;
        }
    }

    public boolean checkGreaterThanMaxPos(int maxPosition) {
        return this.position > maxPosition;
    }

    public boolean isMaxPosition(int maxPosition) {
        return this.position == maxPosition;
    }

    @Override
    public String toString() {
        String positionView = "";
        for(int i = 0 ; i < position ; i++){
            positionView += Const.SHAPE_CAR_POSITION;
        }
        return name + " : " + positionView;
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
