package ee.language.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "lang_greetings")
@NamedQuery(name = "all", query = "select gd from GreetingDescription gd")
public class GreetingDescription {

    @Id
    @SequenceGenerator(name = "greeting_seqg", sequenceName = "lang_greetings_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "greeting_seqg")
    private long id;
    private String description;
    @Column(name = "body")
    private String greeting;
    private String lang;

    public GreetingDescription() {

    }

    GreetingDescription(String description, String greeting, String lang) {
        this.description = description;
        this.greeting = greeting;
        this.lang = lang;
    }

    public static GreetingDescription of(String description, String greeting, String lang) {
        return new GreetingDescription(description, greeting, lang);
    }

    public String getDescription() {
        return this.description;
    }

    public String getGreeting() {
        return this.greeting;
    }

    public String getLang() {
        return this.lang;
    }

    public Long getId() {
        return this.id;
    }

    public static GreetingDescription unknown(String greeting) {
        return GreetingDescription.of("No description registered", greeting, "Any language");
    }
}