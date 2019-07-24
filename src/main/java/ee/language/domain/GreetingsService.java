package ee.language.domain;

import java.util.List;

public interface GreetingsService {

    List<GreetingDescription> retrieveGreetings();

    GreetingDescription describeGreetings(String greeting);
}