public import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // CREATE
        Category c = new Category();
        c.setName("Electronics");

        Supplier s = new Supplier();
        s.setSupplierName("Ravi Supplier");
        s.setPhone("9876543210");

        Tag t1 = new Tag();
        t1.setName("New");

        Tag t2 = new Tag();
        t2.setName("Popular");

        Product p = new Product();
        p.setName("Smartphone");
        p.setPrice(15000);
        p.setStatus(ProductStatus.AVAILABLE);
        p.setCategory(c);
        p.setSupplier(s);
        p.setTags(Arrays.asList(t1, t2));

        session.save(c);
        session.save(t1);
        session.save(t2);
        session.save(p);

        tx.commit();


        // READ (GET)
        Product product = session.get(Product.class, p.getId());
        System.out.println("Product: " + product.getName());


        // UPDATE
        tx = session.beginTransaction();
        product.setPrice(18000);
        session.update(product);
        tx.commit();


        // DELETE
        tx = session.beginTransaction();
        session.delete(product);
        tx.commit();

        session.close();
    }
}
 {
    
}
