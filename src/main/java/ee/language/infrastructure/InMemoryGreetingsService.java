package ee.language.infrastructure;

import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import ee.language.domain.GreetingsService;
import ee.language.domain.Language;
import ee.language.domain.GreetingDescription;

@Named
@RequestScoped
public class InMemoryGreetingsService implements GreetingsService {

        private Language english = new Language("English", "en_US");
        private Map<String, String> greetingsDescription = Map.of("Hello".toUpperCase(), "A formal greetings",
                        "Hi".toUpperCase(), "An informal greetings");
        private Map<String, Language> greetingsLang = Map.of("Hello".toUpperCase(), english, "Hi".toUpperCase(),
                        english);

        public GreetingDescription describeGreetings(String greeting) {
                return GreetingDescription.of(
                                greetingsDescription.getOrDefault(greeting.toUpperCase(), "No description defined"),
                                greeting, greetingsLang.getOrDefault(greeting.toUpperCase(), Language.some()));
        }

        @Override
        public List<GreetingDescription> retrieveGreetings() {
                return List.of();
        }
}