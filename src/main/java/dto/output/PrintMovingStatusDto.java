package dto.output;

import domain.Cars;

import java.util.List;

public class PrintMovingStatusDto {
    private final List<Cars> movingStatus;

    public PrintMovingStatusDto(final List<Cars> movingStatus) {
        this.movingStatus = movingStatus;
    }

    public List<Cars> getMovingStatus() {
        return movingStatus;
    }
}
