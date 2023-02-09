package racingcar.domain;

public class CarMovement {

    private final String OUT_OF_MOVENMENT_RANGE_EXCEPTION = "범위 밖의 움직임 값입니다.";
    private final Integer value;

    public CarMovement(Integer value){
        this.validate(value);
        this.value = value;
    }

    private void validate(Integer value){
        if(value >= 10 || value < 0){
            throw new IllegalArgumentException(OUT_OF_MOVENMENT_RANGE_EXCEPTION);
        }
    }

    public boolean isMove(){
        if(this.value >= 4){
            return true;
        }
        return false;
    }
}
