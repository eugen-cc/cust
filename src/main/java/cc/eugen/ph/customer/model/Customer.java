package cc.eugen.ph.customer.model;

import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Embedded
    private ContactDetails details;

    @Version
    private Time created;


    enum Status {
        PROSPECTIVE("prospective"), CURRENT("current"), NON_ACTIVE("non-active");

        String value;

        Status(String value) {
            this.value = value;
        }
    }

}
