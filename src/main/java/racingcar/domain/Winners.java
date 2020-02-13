package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class Winners {
    private List<Car> winners;

    public Winners(List<Car> winners) {
        this.winners = Collections.unmodifiableList(winners);
    }

    public String getWinners(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Car winner : winners){
            stringBuilder.append(winner);
        }
        return stringBuilder.toString();
    }
}