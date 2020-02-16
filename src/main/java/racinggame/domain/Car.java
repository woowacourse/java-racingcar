package racinggame.domain;

import java.util.List;

public class Car {
    private static final int FORWARD_NUMBER = 4;
    private static final int START_POSITION = 0;
    private final String name;
    private int position;

    public Car(String name) {
        this(name, START_POSITION);
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public boolean move(int random){
        if (random >= FORWARD_NUMBER) {
            position++;
            return true;
        }
        return false;
    }

    public boolean match(int position) {
        return position == this.position;
    }

    public boolean isSamePosition(int position){
        return this.position == position;
    }

    public String makeLog(){
        StringBuilder log = new StringBuilder(name);
        log.append(" : ");
        for(int i=0;i<position;i++){
            log.append("-");
        }
        return log.toString();
    }

    public String makeWinnerLog(){
        return this.name;
    }

    public int updateMaxPosition(int maxPosition) {
        return Math.max(position, maxPosition);
    }
}
