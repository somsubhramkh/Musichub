package musichub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import musichub.dao.UserOrderDAO;
import musichub.model.Cart;
import musichub.model.Item;
import musichub.model.UserOrder;

@Service
public class UserOrderService {

    @Autowired
    private UserOrderDAO userOrderDAO;

    @Autowired
    private CartService cartService;

    public void addOrder(UserOrder userOrder) {
    	
		userOrderDAO.addOrder(userOrder);
    }

    public double getOrderGrandTotal(int cartId) {
        double grandTotal=0;
        Cart cart = cartService.getCartById(cartId);
        List<Item> items = cart.getItems();

        for (Item item : items) {
            grandTotal+=item.getTotalPrice();
        }

        return grandTotal;
    }
}
