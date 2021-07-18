package guru.springframwork.spring5webapp.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String address;
    @ManyToMany(mappedBy = "book")
    private Set<Book> books;

}
