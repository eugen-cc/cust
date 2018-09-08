package cc.eugen.ph.customer.model.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class represents the customer entity.
 */
@Entity
public class Customer {

    @Id
    @SequenceGenerator(name = "CustSeqGen", sequenceName = "CustSeq", initialValue = 101010, allocationSize = 11)
    @GeneratedValue(generator = "CustSeqGen")
    private Long id;

    @Column(nullable = false)
    //@Enumerated(EnumType.STRING)  <-- StatusConverter
    private Status status;

    @Column(name = "FIRSTNAME", nullable = false)
    private String firstName;

    @Column(name = "LASTNAME", nullable = false)
    private String lastName;

    @Embedded
    private ContactDetails details;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    @DateTimeFormat(pattern = "dd-MMM-YYYY hh:mm:ss")
    private Date created;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Note> notes = new ArrayList<>();


    public enum Status {
        PROSPECTIVE("prospective"), CURRENT("current"), NON_ACTIVE("non-active");

        String value;

        Status(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static Status fromValue(String value) {
            switch (value) {
                case "prospective":
                    return PROSPECTIVE;
                case "current":
                    return CURRENT;
                case "non-active":
                    return NON_ACTIVE;
                default:
                    throw new RuntimeException("Invalid value for Status : " + value);
            }
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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

    public ContactDetails getDetails() {
        return details;
    }

    public void setDetails(ContactDetails details) {
        this.details = details;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
}
