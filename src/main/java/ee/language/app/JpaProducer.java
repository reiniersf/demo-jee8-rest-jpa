package ee.language.app;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class JpaProducer{

    @PersistenceContext(unitName = "DefaultPU")
    private EntityManager emf;

    @Produces
    @RequestScoped
    public EntityManager defaulEntityManager(){
        return emf;
    }
}
