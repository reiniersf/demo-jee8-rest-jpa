package ee.language.domain;

import static javax.persistence.GenerationType.SEQUENCE;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Language {
    @Id
    @SequenceGenerator(name = "lang_seqg", sequenceName = "lang_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "lang_seqg", strategy = SEQUENCE)
    private long id;
    @Column(name = "common_name")
    private String name;
    @Column
    private String acronym;
    @OneToMany(mappedBy = "lang")
    private List<GreetingDescription> greetingDescriptions;
    private static Language unknownLang = new Language("Some unknown language", "UNKNOWN");

    public Language() {
    }

    public Language(String name, String acronym){
        this.name = name;
        this.acronym = acronym;
    }

    public static Language some() {
        return unknownLang;
    }

    /**
     * @return the acronym
     */
    public String getAcronym() {
        return acronym;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

}
