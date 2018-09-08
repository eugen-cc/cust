package cc.eugen.ph.customer.model.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 *  This class represents a Note for a customer
 */
@Entity
public class Note {


    @Id
    @SequenceGenerator(name = "NoteSeqGen", sequenceName = "NoteSeq", initialValue = 5555, allocationSize = 5)
    @GeneratedValue(generator = "NoteSeqGen")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_customer")
    private Customer customer;

    @Column
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
