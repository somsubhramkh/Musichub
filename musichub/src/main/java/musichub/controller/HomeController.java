package musichub.controller;

import java.security.Principal;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import musichub.dao.ProductDAO;
import musichub.model.BillingAddress;
import musichub.model.Cart;
import musichub.model.Product;
import musichub.model.User;
import musichub.model.UserOrder;
import musichub.service.CartService;
import musichub.service.ProductService;
import musichub.service.UserOrderService;
import musichub.service.UserService;

@Controller
public class HomeController {

	private ProductService productService;

	@Autowired(required = true)
	@Qualifier(value = "productService")
	public void setProductService(ProductService ps) {
		this.productService = ps;
	}
	
	private UserService userService;

	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setUserService(UserService us) {
		this.userService = us;
	}
	
	@Autowired
    private CartService cartService;
	
	@Autowired
    private UserOrderService userOrderService;
	

	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("index");
		return model;
	}
	
	@RequestMapping("/order")
	public String checkout(Principal p) {
		
		User user=userService.getUserByUsername(p.getName());
		UserOrder userOrder = new UserOrder();
		Cart cart=cartService.getCartById(user.getCart().getCartId());
        userOrder.setCart(cart);

        
        userOrder.setUser(user);
        userOrder.setBillingAddress(user.getBillingAddress());
        userOrderService.addOrder(userOrder);
        
		return "redirect:/loginFlow?cartId="+user.getCart().getCartId();
	}

	@RequestMapping("/Register")
	public ModelAndView registerPage(Model m) {
		BillingAddress billingAddress=new BillingAddress();
		User user=new User();
		user.setBillingAddress(billingAddress);
		m.addAttribute("user", new User());	
		ModelAndView model = new ModelAndView("Register");
		return model;
	}

	@RequestMapping("/AboutUs")
	public ModelAndView aboutUsPage() {
		ModelAndView model = new ModelAndView("AboutUs");
		return model;
	}

	@RequestMapping("/ContactUs")
	public ModelAndView contactUsPage() {
		ModelAndView model = new ModelAndView("ContactUs");
		return model;
	}

	@RequestMapping("/Product")
	public ModelAndView productPage() {

		List<Product> products = productService.listProducts();
		String json = new Gson().toJson(products);

		ModelAndView model = new ModelAndView("Product");
		model.addObject("prodData", json);
		return model;
	}

	@RequestMapping("/Product/{category}")
	public ModelAndView productPageFilter(@PathVariable("category") String category) {

		List<Product> products = productService.getProductByCategory(category);
		String json = new Gson().toJson(products);

		ModelAndView model = new ModelAndView("Product");
		model.addObject("prodData", json);
		return model;
	}

	/* Added for implementing Spring Security */

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {

		return "Login";

	}

	@RequestMapping(value = "/loginError", method = RequestMethod.GET)
	public String loginError(ModelMap model) {
		model.addAttribute("error", "true");
		return "Login";

	}

	@RequestMapping("/ProductDetails")
	public ModelAndView productDetailsPage() {
		ModelAndView model = new ModelAndView("ProductDetails");
		return model;
	}
	
	@RequestMapping("/Share")
	public String sharePage() {
		//ModelAndView model = new ModelAndView("Share");
		return "Share";
	}
	
	@RequestMapping("/sendMail")
	public ModelAndView sendMail(HttpServletRequest request) {
		
		final String username = "som.musichub@gmail.com";
		final String password = "transformation";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("from-email@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(request.getParameter("email")));
			message.setSubject(request.getParameter("subject"));
			message.setText(request.getParameter("content"));

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

		
		
		ModelAndView model = new ModelAndView("Share");
		return model;
	}

}
