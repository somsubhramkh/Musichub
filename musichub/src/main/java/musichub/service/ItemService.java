package musichub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import musichub.dao.ItemDAO;
import musichub.dao.ProductDAO;
import musichub.model.Cart;
import musichub.model.Item;
import musichub.model.Product;

@Service
public class ItemService {

	 @Autowired
	    private ItemDAO itemDAO;

	    public void addItem(Item cartItem) {
	        itemDAO.addItem(cartItem);
	    }

	    public void removeItem(Item item) {
	    	itemDAO.removeItem(item);
	    }

	    public void removeAllCartItems(Cart cart){
	    	itemDAO.removeAllItems(cart);
	    }

	    public Item getItemByItemId (int itemId) {
	        return itemDAO.getItemByItemId(itemId);
	    }
}
