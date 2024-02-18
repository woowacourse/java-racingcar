package dto;


import java.util.List;

public record RacingResult(
        List<RacingStatus> racingStatuses,
        List<String> winners
) {
}
