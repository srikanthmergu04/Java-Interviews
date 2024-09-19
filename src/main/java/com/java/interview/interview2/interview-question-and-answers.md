# American Airlines Interview Questions and Answers

## Tech: Java, Spring Boot, MySQL, and NoSQL

### 1. Sort employee based on both `id` and `name`

To sort `Employee` objects by both `id` and `name`, implement the `Comparator` interface. Example:

```java
import java.util.*;

class Employee {
    private int id;
    private String name;

    // Constructor, Getters, Setters

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "'}";
    }
}

class EmployeeSortByIdAndName implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        int idCompare = Integer.compare(e1.getId(), e2.getId());
        if (idCompare == 0) {
            return e1.getName().compareTo(e2.getName());
        }
        return idCompare;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(2, "John"),
            new Employee(1, "Alice"),
            new Employee(1, "Bob")
        );

        employees.sort(new EmployeeSortByIdAndName());

        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}
2. Which collection is best for modifying elements?
The best collection for modifying elements frequently is ArrayList for random access and LinkedList for frequent insertions or deletions.

ArrayList: Best when you need fast access by index.
LinkedList: Best when you need fast insertion or deletion from both ends.
3. What is serialization and what is the use of serialVersionUID?
Serialization: The process of converting an object into a byte stream for storage or transmission.
serialVersionUID: A unique identifier for each version of a serializable class. It helps in ensuring that the sender and receiver of a serialized object have compatible classes.
Example:

java
Copy code
class Employee implements Serializable {
    private static final long serialVersionUID = 1L;  // Unique identifier

    private int id;
    private String name;

    // Constructor, Getters, Setters
}
4. Map<Employee, String> - What should Employee class implement?
The Employee class must override equals() and hashCode() methods to ensure that it behaves correctly when used as a key in a Map.

Example:

java
Copy code
class Employee {
    private int id;
    private String name;

    // Constructor, Getters, Setters

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
5. How to avoid variables from being serialized?
Mark the variables you want to exclude from serialization as transient.

Example:

java
Copy code
class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private transient String password;  // This won't be serialized
}
6. What is self join in MySQL?
A self join is a join where a table is joined with itself. This is useful when you want to compare rows within the same table.

Example:

sql
Copy code
SELECT A.employee_id, A.name, B.name AS manager_name
FROM employees A
JOIN employees B ON A.manager_id = B.employee_id;
7. How to initialize database, Kafka, and WebClient in Spring Boot?
Database: You can initialize using spring.datasource properties in application.properties or use @Configuration classes.
Example:

properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/db
spring.datasource.username=root
spring.datasource.password=password
Kafka: Use @EnableKafka in your configuration class and configure Kafka properties.
Example:

java
Copy code
@EnableKafka
@Configuration
public class KafkaConfig {
    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
    }
}
WebClient: Configure WebClient bean for asynchronous calls.
Example:

java
Copy code
@Bean
public WebClient.Builder webClientBuilder() {
    return WebClient.builder();
}
8. What is the use of hashCode() and equals() and how to implement them?
hashCode(): Provides an integer hash representation for an object, used in hashing-based collections (e.g., HashMap, HashSet).
equals(): Compares two objects for equality.
Both methods are essential for correct behavior when objects are used as keys in hash-based collections.

Implementation Example:

java
Copy code
class Employee {
    private int id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}