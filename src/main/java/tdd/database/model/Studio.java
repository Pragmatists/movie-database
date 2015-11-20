package tdd.database.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.annotation.PersistenceConstructor;

@Entity
public class Studio {

    @Id
    private String name;

    @PersistenceConstructor
    public Studio(String name) {
        this.name = name;
    }
}
