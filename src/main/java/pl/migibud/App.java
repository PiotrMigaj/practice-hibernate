package pl.migibud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.migibud.entity.Product;
import pl.migibud.entity.Review;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class App {

    private static final Logger logger = LogManager.getLogger(App.class);
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

//        List<Product> products = em.createQuery("SELECT p FROM Product p", Product.class).getResultList();
//        List<Product> products1 = em.createQuery("SELECT p FROM Product p JOIN FETCH p.reviews", Product.class).getResultList();

//        products1.forEach(logger::info);

//        List<Review> reviews = em.createQuery("SELECT r FROM Review r", Review.class).getResultList();
//        reviews.forEach(logger::info);

//        Product product = em.find(Product.class, 2L);
//        em.remove(product);
//
//        logger.info(product);

        Product product = em.find(Product.class, 5L);
        product.getReviews().forEach(review -> product.getReviews().remove(review));

        em.getTransaction().commit();
        em.close();
    }
}
