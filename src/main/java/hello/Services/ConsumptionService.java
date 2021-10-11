package hello.Services;

import hello.Entities.Consumption;
import hello.Entities.Time;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class ConsumptionService extends service{

    public ConsumptionService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    protected CriteriaQuery<Consumption> timeCriteriaQuery;
    protected Root<Consumption> root;


    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();
        builder = session.getCriteriaBuilder();
        timeCriteriaQuery = builder.createQuery(Consumption.class);
        root = timeCriteriaQuery.from(Consumption.class);
    }

    public String getDifference(String firs_value, String second_value) {
        Predicate[] predicates = new Predicate[2];
        predicates[0]=builder.like(root.get("first_value"),firs_value);
        predicates[1]=builder.like(root.get("second_value"),second_value);
        List<Consumption> ventil =session.createQuery(timeCriteriaQuery.select(root).where(predicates)).getResultList();
        String x=ventil.get(0).Getdifference();
        return x;
    }
}
