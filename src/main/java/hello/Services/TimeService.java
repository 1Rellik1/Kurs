package hello.Services;


import hello.Entities.Time;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class TimeService extends service{


    public TimeService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    protected CriteriaQuery<Time> timeCriteriaQuery;
    protected Root<Time> root;


    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();
        builder = session.getCriteriaBuilder();
        timeCriteriaQuery = builder.createQuery(Time.class);
        root = timeCriteriaQuery.from(Time.class);
    }

    public String getDifference(String firs_value, String second_value) {
        Predicate[] predicates = new Predicate[2];
        predicates[0]=builder.like(root.get("first_value"),firs_value);
        predicates[1]=builder.like(root.get("second_value"),second_value);
        List<Time> ventil =session.createQuery(timeCriteriaQuery.select(root).where(predicates)).getResultList();
        String x=ventil.get(0).Getdifference();
        return x;
    }
    //    session.createQuery("select tm from Time where Time.first_value ='с' and Time.second_value= 'мин'", Time.class);
}

