package be.pxl.superhero.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Superhero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String superHeroName;

    public Superhero() {
        //JPA ONLY
    }

    public Superhero(String firstName, String lastName, String superHeroName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.superHeroName = superHeroName;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSuperHeroName() {
        return superHeroName;
    }

    public void setSuperHeroName(String superHeroName) {
        this.superHeroName = superHeroName;
    }
}
