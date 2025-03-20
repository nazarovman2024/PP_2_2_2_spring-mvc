package web.model;

import javax.validation.constraints.*;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotNull(message = "Name cannot be empty")
    @Size(min = 2, max = 20, message = "Name must be between 2 and 50 characters")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я]+$", message = "Name must contain only letters")
    private String name;

    @Column
    @NotNull(message = "Age cannot be empty")
    @Min(value = 0, message = "Age can't be less than 0")
    @Max(value = 999999999, message = "Is this fun, huh?")
    private int age;

    @Column
    @Email(message = "Not valid Email")
    private String email;

    public User() {
    }

    public User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) { this.age = age; }

    public int getAge() { return age; }

    public void setEmail(String email) { this.email = email; }

    public String getEmail() { return email; }

    @Override
    public String toString() {
        return "Id = " + id + "\n"
                + "Name = " + name + "\n"
                + "Age = " + age + "\n"
                + "Email = " + email + "\n";
    }
}
