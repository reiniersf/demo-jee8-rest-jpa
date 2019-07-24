package ee.language.infrastructure;

import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import ee.language.domain.GreetingsService;
import ee.language.domain.GreetingDescription;

@Named
@RequestScoped
public class InMemoryGreetingsService implements GreetingsService{

    private Map<String, String> greetingsDescription = Map.of("Hello".toUpperCase(), "A formal greetings",
            "Hi".toUpperCase(), "An informal greetings");
    private Map<String, String> greetingsLang = Map.of("Hello".toUpperCase(), "en_US", "Hi".toUpperCase(), "en_US");

    public GreetingDescription describeGreetings(String greeting) {
        return GreetingDescription.of(
                greetingsDescription.getOrDefault(greeting.toUpperCase(), "No description defined"), greeting,
                greetingsLang.getOrDefault(greeting.toUpperCase(), "Unknown lang"));
    }

    @Override
    public List<GreetingDescription> retrieveGreetings() {
        return List.of();
	}
}