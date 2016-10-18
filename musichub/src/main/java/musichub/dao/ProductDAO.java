package musichub.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import musichub.model.Product;

@Repository
public class ProductDAO {

	private static final Logger logger = LoggerFactory.getLogger(ProductDAO.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public void addProduct(Product p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Product saved successfully, Product Details=" + p);

	}

	public void updateProduct(Product p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Product updated successfully, Product Details=" + p);
	}

	@SuppressWarnings("unchecked")

	public List<Product> listProducts() {
		Session session = sessionFactory.getCurrentSession();

		List<Product> productList = session.createQuery("from Product").list();
		for (Product p : productList) {
			logger.info("Product List::" + p);
		}

		return productList;
	}

	@SuppressWarnings("unchecked")

	public List<Product> getProductsByCategory(String category) {
		Session session = sessionFactory.getCurrentSession();

		List<Product> productList = session.createQuery("from Product p where p.category='" + category + "'").list();
		for (Product p : productList) {
			logger.info("Product List::" + p);
		}

		return productList;
	}

	public Product getProductById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Product p = (Product) session.load(Product.class, new Integer(id));
		logger.info("Product loaded successfully, Product details=" + p);
		return p;
	}

	public void removeProduct(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Product p = (Product) session.load(Product.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
		logger.info("Product deleted successfully, Product details=" + p);

	}

}
