package racinggame.domain;

import racinggame.domain.car.GenerateNumberService;

public class GenerateTestNumber implements GenerateNumberService {
    public int generateNumber(int bound){
        return bound - 1;
    }
}
