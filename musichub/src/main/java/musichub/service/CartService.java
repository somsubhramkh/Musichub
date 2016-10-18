package musichub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import musichub.dao.CartDAO;
import musichub.model.Cart;

@Service
public class CartService {

	@Autowired
    private CartDAO cartDAO;

    public Cart getCartById(int cartId) {
        return cartDAO.getCartById(cartId);
    }

    /*public void update(Cart cart) {
        cartDao.update(cart);
    }*/
}
