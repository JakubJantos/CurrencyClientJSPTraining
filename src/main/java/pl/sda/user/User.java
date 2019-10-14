package pl.sda.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String paswd;
    private LocalDate date;

    public User() {
    }

    public User(String email, String paswd, LocalDate date) {
        this.email = email;
        this.paswd = paswd;
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public String getPaswd() {
        return paswd;
    }

    public LocalDate getDate() {
        return date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPaswd(String paswd) {
        this.paswd = paswd;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
