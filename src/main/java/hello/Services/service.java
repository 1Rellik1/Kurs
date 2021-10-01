package hello.Services;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import javax.persistence.criteria.CriteriaBuilder;

@Service
public abstract class service {
    @Autowired
    protected SessionFactory sessionFactory;

    protected Session session;

    protected CriteriaBuilder builder;

    public abstract String getDifference(String firs_value, String second_value);

    @PreDestroy
    public void unSession() {
        session.close();
    }

}
