package musichub.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import musichub.model.UserOrder;

@Repository
@Transactional
public class UserOrderDAO{

        @Autowired
        private SessionFactory sessionFactory;
        
        public void setSessionFactory(SessionFactory sf) {
    		this.sessionFactory = sf;
    	}

        public void addOrder(UserOrder userOrder) {
            Session session = sessionFactory.getCurrentSession();
            session.saveOrUpdate(userOrder);
            session.flush();
        }
}
