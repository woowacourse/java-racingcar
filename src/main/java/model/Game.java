package model;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final List<Car> participant;

    public Game(List<String> carNames) {
        validateDuplicate(carNames);
        this.participant = convertToCar(carNames);
    }

    private void validateDuplicate(List<String> carNames){
        int originCount = carNames.size();
        int distinctCount = (int) carNames.stream().distinct().count();
        if(originCount != distinctCount){
            throw new IllegalArgumentException();
        }
    }

    private List<Car> convertToCar(List<String> carNames){
        return carNames.stream().map(Car::new).toList();
    }

    public int getParticipantSize(){
        return participant.size();
    }

    public List<Car> proceed(List<Integer> result){
        for(int i = 0; i < result.size(); i++){
            if(CarStatus.decide(result.get(i)).equals(CarStatus.FORWARD)){
                participant.get(i).forward();
                continue;
            }
            participant.get(i).stop();
        }
        return new ArrayList<>(participant);
    }


}
