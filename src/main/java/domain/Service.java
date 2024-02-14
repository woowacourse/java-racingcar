package domain;

public class Service {
    public Service() {
    }

    public String[] separateCarName(String carNames) {
        return carNames.split(",");
    }
    
}

