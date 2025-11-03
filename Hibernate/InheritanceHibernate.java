@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="emp_type", discriminatorType = DiscriminatorType.STRING)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
}

@Entity
@DiscriminatorValue("Permanent")
public class PermanentEmployee extends Employee {
    private double salary;
}

@Entity
@DiscriminatorValue("Contract")
public class ContractEmployee extends Employee {
    private double hourlyRate;
}
