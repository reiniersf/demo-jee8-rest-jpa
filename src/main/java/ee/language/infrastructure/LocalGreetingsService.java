package ee.language.infrastructure;

import static ee.language.domain.GreetingDescription.unknown;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import ee.language.domain.GreetingDescription;
import ee.language.domain.GreetingsRepository;
import ee.language.domain.GreetingsService;
import ee.language.app.qualifiers.JPABased;

@JPABased
@RequestScoped
public class LocalGreetingsService implements GreetingsService {

    @Inject
    @JPABased
    private GreetingsRepository greetingsRepository;

    @Override
    public GreetingDescription describeGreetings(String greeting) {
        return greetingsRepository.retrieveDescription(greeting).findFirst().orElse(unknown(greeting));
    }

}
