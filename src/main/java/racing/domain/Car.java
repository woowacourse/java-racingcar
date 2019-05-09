package racing.domain;

import racing.util.RandomNumberGenerator;

import java.util.Objects;

public class Car {
    private static final int GO_FORWRARD_CRITERIA_NUM = 4;
    private static final int GO_STEP = 1;

    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void tryGoForward(){
        int randomNum = RandomNumberGenerator.generate(10);
        if (isGo(randomNum)) position += GO_STEP;
    }

    private boolean isGo(int number){
        if (number>=GO_FORWRARD_CRITERIA_NUM) return true;
        return false;
    }
}
