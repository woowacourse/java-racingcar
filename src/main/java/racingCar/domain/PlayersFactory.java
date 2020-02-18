package racingCar.domain;

import racingCar.utils.StringParser;

import java.util.List;
import java.util.stream.Collectors;

public class PlayersFactory {

	private PlayersFactory() {
	}

	public static Players create(String userNames) {
		List<Name> names = StringParser.parseToNameList(userNames);

		return new Players(names.stream()
				.map(Player::new)
				.collect(Collectors.toList()));
	}
}
