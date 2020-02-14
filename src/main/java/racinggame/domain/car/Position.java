package racinggame.domain.car;

public class Position {
    public static final int DEFAULT_ACCELERATE = 1;
    private int position;

    private void validatePosition(int position){
        if(position < 0){
            throw new IllegalArgumentException("위치값은 0 이상이어야 합니다.");
        }
    }

    public Position(int position) {
        validatePosition(position);
        this.position = position;
    }

    public boolean match(int position) {
        return position == this.position;
    }

    public void accelerate() {
        accelerate(DEFAULT_ACCELERATE);
    }

    public void accelerate(int accelerateValue){
        position+=accelerateValue;
    }
}
