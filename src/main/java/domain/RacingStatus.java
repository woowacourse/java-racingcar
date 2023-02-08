package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingStatus {
    private final List<Car> racingStatus;

    public RacingStatus(String carNames) {
        racingStatus = Arrays.stream(carNames.split(","))
                .map(name -> new Car(name))
                .collect(Collectors.toList());

    }

    public void updateOnce() {
//        racingStatus.stream().forEach(it=>it.move());
    }

//    public List<Dto> toDto(){
//        return List.of(new Dto(name,status));
//    }


}
