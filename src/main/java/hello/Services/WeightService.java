package hello.Services;

import hello.Entities.Time;
import hello.Entities.Weight;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class WeightService extends service{


    public WeightService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    protected CriteriaQuery<Weight> timeCriteriaQuery;
    protected Root<Weight> root;


    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();
        builder = session.getCriteriaBuilder();
        timeCriteriaQuery = builder.createQuery(Weight.class);
        root = timeCriteriaQuery.from(Weight.class);
    }

    public String getDifference(String firs_value, String second_value) {
        Predicate[] predicates = new Predicate[2];
        predicates[0]=builder.like(root.get("first_value"),firs_value);
        predicates[1]=builder.like(root.get("second_value"),second_value);
        List<Weight> ventil =session.createQuery(timeCriteriaQuery.select(root).where(predicates)).getResultList();
        String x=ventil.get(0).Getdifference();
        return x;
    }
}
