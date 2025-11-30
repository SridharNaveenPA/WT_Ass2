import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class HQL_CRUD {

    public static void main(String[] args) {

        // ----------------------------------------
        // INSERT NEW PRODUCT
        // ----------------------------------------
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Product p1 = new Product();
        p1.setName("Laptop");
        p1.setPrice(55000);
        p1.setStockQuantity(10);

        session.save(p1);   // Hibernate inserts automatically
        tx.commit();

        // ----------------------------------------
        // RETRIEVE ALL PRODUCTS (HQL)
        // ----------------------------------------
        session = HibernateUtil.getSessionFactory().openSession();
        List<Product> products = session.createQuery("FROM Product", Product.class).list();

        System.out.println("\n--- ALL PRODUCTS ---");
        for (Product p : products) {
            System.out.println(p.getId() + " | " + p.getName() + " | Rs " + p.getPrice());
        }

        // ----------------------------------------
        // UPDATE PRODUCT PRICE (HQL)
        // ----------------------------------------
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();

        String updateQuery = "UPDATE Product SET price = :newPrice WHERE id = :pid";
        int updated = session.createQuery(updateQuery)
                .setParameter("newPrice", 60000.0)
                .setParameter("pid", p1.getId())
                .executeUpdate();

        tx.commit();
        System.out.println("\nPrice Updated! Rows affected: " + updated);

        // ----------------------------------------
        // DELETE PRODUCT WITH ZERO STOCK (HQL)
        // ----------------------------------------
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();

        String deleteQuery = "DELETE FROM Product WHERE stockQuantity = 0";
        int deleted = session.createQuery(deleteQuery).executeUpdate();

        tx.commit();
        System.out.println("\nDeleted products with zero stock: " + deleted);

        session.close();
    }
}
