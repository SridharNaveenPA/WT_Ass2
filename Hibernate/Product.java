@Entity
 class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // or SEQUENCE, TABLE, AUTO
    private int id;

    private String productName;
}
