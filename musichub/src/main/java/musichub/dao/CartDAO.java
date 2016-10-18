package musichub.dao;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import musichub.model.BillingAddress;
import musichub.model.Cart;
import musichub.model.User;
import musichub.service.UserOrderService;

@Repository
@Transactional
public class CartDAO {

	
    @Autowired
    private SessionFactory sessionFactory;
    
    @Autowired
    private UserOrderService userOrderService;
	
	public Cart getCartById (int cartId) {
        Session session = sessionFactory.getCurrentSession();
        return (Cart) session.get(Cart.class, cartId);
    }

    public void update(Cart cart) {
        int cartId = cart.getCartId();
        double grandTotal = userOrderService.getOrderGrandTotal(cartId);
        cart.setGrandTotal(grandTotal);

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cart);
    }

    public Cart validate(int cartId) throws IOException {
        Cart cart=getCartById(cartId);
        if(cart==null||cart.getItems().size()==0) {
            throw new IOException(cartId+"");
        }
        update(cart);
        return cart;
    }
    
    public User getUser(int cartId){
    	
    	Cart cart=getCartById(cartId);
    	User user=cart.getUser();
    
    	return user;
    }
    
    
    public BillingAddress getBillingAddress(int cartId){
    	
    	BillingAddress billingAddress=getCartById(cartId).getUser().getBillingAddress();
    	return billingAddress;
    	
    }
	
}
