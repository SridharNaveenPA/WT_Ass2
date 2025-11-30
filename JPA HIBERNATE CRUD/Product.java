import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "products_table")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)   // AUTO example
    private int id;

    @Column(nullable = false, length = 40)
    private String name;

    @Enumerated(EnumType.STRING)       // ENUM
    private ProductStatus status;

    @Column(nullable = false)
    private double price;

    @Transient                         // Not saved in DB
    private double discountPrice;

    @ManyToOne                         // Many products → One category
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToOne(cascade = CascadeType.ALL) // One-to-one
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @ManyToMany                        // Many to Many example
    @JoinTable(
            name = "product_tags",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;

    // getters & setters
}
