package racingcar.domain;

public class Position {
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public void increase() {
        position += 1;
    }

    public int getPosition(){
        return this.position;
    }
    
}
