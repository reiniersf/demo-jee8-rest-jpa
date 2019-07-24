package ee.language.infrastructure;

import java.util.List;
import java.util.stream.Stream;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ee.language.domain.GreetingDescription;
import ee.language.domain.GreetingsRepository;
import ee.language.app.qualifiers.JPABased;

@JPABased
@RequestScoped
public class JpaGreetingRepository implements GreetingsRepository {
    @Inject
    private EntityManager defaultEntityManager;

    @Override
    public List<GreetingDescription> listGreetings() {
        return defaultEntityManager.createNamedQuery("all", GreetingDescription.class).getResultList();
    }

    @Override
    public Stream<GreetingDescription> retrieveDescription(String greeting) {
        return defaultEntityManager.createQuery("select gd from GreetingDescription gd where gd.greeting like :greet",
                GreetingDescription.class).setParameter("greet", "%" + greeting + "%").getResultStream();
    }

}
