package cc.eugen.ph.customer.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Note {

    @Id
    @SequenceGenerator(name = "mySeqGen", sequenceName = "noteSeq", initialValue = 5555, allocationSize = 13)
    @GeneratedValue(generator = "mySeqGen")
    private Long id;

    @Column
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
