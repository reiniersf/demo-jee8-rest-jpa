package ee.language.infrastructure;

import java.util.List;
import java.util.stream.Stream;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ee.language.domain.GreetingDescription;
import ee.language.domain.GreetingsRepository;
import ee.language.app.qualifiers.JPABased;

@JPABased
@ApplicationScoped
public class JpaGreetingRepository implements GreetingsRepository {
    @PersistenceContext
    private EntityManager defaultEntityManager;

    @Override
	public List<GreetingDescription> listGreetings() {
		return defaultEntityManager.createNamedQuery("all", GreetingDescription.class).getResultList();
	}

    @Override
    public Stream<GreetingDescription> retrieveDescription(String greeting) {
        return defaultEntityManager.createQuery("select gd from GreetingDescription gd where gd.greeting like %:greet%", GreetingDescription.class)
        .setParameter("greet", greeting)
        .getResultStream();
    }

    

}
