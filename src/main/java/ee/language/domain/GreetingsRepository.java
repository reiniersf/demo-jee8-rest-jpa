package ee.language.domain;

import java.util.List;
import java.util.stream.Stream;

public interface GreetingsRepository {

    List<GreetingDescription> listGreetings();

	Stream<GreetingDescription> retrieveDescription(String greeting);
}
