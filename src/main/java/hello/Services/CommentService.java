package hello.Services;

import hello.Entities.Comments;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    protected SessionFactory sessionFactory;

    protected Session session;

    protected CriteriaBuilder builder;

    public CommentService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();
        builder = session.getCriteriaBuilder();
    }

    public List<Comments> get_comments(){
        return session.createQuery("SELECT a FROM Comments a", Comments.class).list();
    }

    public void addComment(Comments comment){
        session.beginTransaction();
        session.saveOrUpdate(comment);
        session.getTransaction().commit();
    }
    @PreDestroy
    public void unSession() {
        session.close();
    }
}
