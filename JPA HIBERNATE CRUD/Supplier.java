import jakarta.persistence.*;

@Entity
@Table(name = "suppliers")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sup_seq")
    @SequenceGenerator(name = "sup_seq", sequenceName = "supplier_seq", allocationSize = 1)
    private int id;  // SEQUENCE example

    @Column(nullable = false, length = 30)
    private String supplierName;

    @Column(unique = true, length = 10)
    private String phone;

    // getters & setters
}
