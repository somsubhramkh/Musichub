package musichub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import musichub.model.Cart;
import musichub.model.Item;
import musichub.model.Product;
import musichub.model.UserOrder;
import musichub.service.CartService;
import musichub.service.ItemService;
import musichub.service.ProductService;
import musichub.service.UserOrderService;
import musichub.service.UserService;

@RestController
@RequestMapping("/usercart/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;
    
    @Autowired
    private UserOrderService userOrderService;

    @RequestMapping("/refreshCart/{cartId}")
    public Cart getCartById (@PathVariable(value = "cartId") int cartId) {
        return cartService.getCartById(cartId);
    }
    /*
     * addItem method is used to add a item in user cart.
     */

    @RequestMapping(value = "/addItem/{itemId}", method = RequestMethod.PUT)
    public void addItem (@PathVariable(value ="itemId") int itemId, @AuthenticationPrincipal User activeUser) {

    	musichub.model.User user = userService.getUserByUsername(activeUser.getUsername());
        Cart cart = user.getCart();
        Product product = productService.getProductById(itemId);
        List<Item> items = cart.getItems();

        for (int i=0; i<items.size(); i++) {
            if(product.getId()==items.get(i).getProduct().getId()){
                Item item = items.get(i);
                item.setQuantity(item.getQuantity()+1);
                item.setTotalPrice(product.getPrice()*item.getQuantity());
                itemService.addItem(item);

                return;
            }
        }

        Item item = new Item();
        item.setProduct(product);
        item.setQuantity(1);
        item.setTotalPrice(product.getPrice()*item.getQuantity());
        item.setCart(cart);
        
        itemService.addItem(item);
    }
    /*
     * removeItem method is used to remove a item from user cart.
     */
    @RequestMapping(value = "/removeItem/{itemId}", method = RequestMethod.PUT)
    public void removeItem (@PathVariable(value = "itemId") int itemId) {
        Item item = itemService.getItemByItemId(itemId);
        itemService.removeItem(item);

    }
    /*
     * clearCartItems method is used to remove all items from user cart.
     */
    @RequestMapping(value = "/clearCartItems/{cartId}", method = RequestMethod.DELETE)
    public void clearCartItems(@PathVariable(value = "cartId") int cartId) {
        Cart cart = cartService.getCartById(cartId);
        itemService.removeAllCartItems(cart);
    }
    
    
    @RequestMapping("/order/{cartId}")
    public String createOrder(@PathVariable("cartId") int cartId) {
    	UserOrder userOrder = new UserOrder();
        Cart cart=cartService.getCartById(cartId);
        userOrder.setCart(cart);

        musichub.model.User user = cart.getUser();
        userOrder.setUser(user);
        userOrder.setBillingAddress(user.getBillingAddress());
        userOrder.setShippingAddress(user.getShippingAddress());

        userOrderService.addOrder(userOrder);

        return "redirect:/loginFlow?cartId="+cartId;
    }
    
    /*
     * ExceptionHandler for client errors.
     */
    /*@ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload.")
    public void handleClientErrors (Exception e) {}
    
     * ExceptionHandler for server errors.
     
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error.")
    public void handleServerErrors (Exception e) {}*/
}

