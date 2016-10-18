package musichub.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import musichub.model.Cart;
import musichub.model.Item;

@Repository
@Transactional
public class ItemDAO {

	 @Autowired
	    private SessionFactory sessionFactory;

	    public void addItem(Item item) {
	        Session session = sessionFactory.getCurrentSession();
	        session.saveOrUpdate(item);
	        session.flush();
	    }

	    public void removeItem (Item item) {
	        Session session = sessionFactory.getCurrentSession();
	        session.delete(item);
	        session.flush();
	    }

	    public void removeAllItems(Cart cart) {
	        List<Item> items = cart.getItems();

	        for (Item item : items) {
	            removeItem(item);
	        }
	    }

	    public Item getItemByItemId (int itemId) {
	        Session session = sessionFactory.getCurrentSession();
	        Query query = session.createQuery("from Item where itemId = ?");
	        query.setInteger(0, itemId);
	        session.flush();

	        return (Item) query.uniqueResult();
	    }
	
}
