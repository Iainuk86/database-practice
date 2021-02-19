package dbtest;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name="address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="street_address")
    private String streetAddress;

    @Column(name="city")
    private String city;

    @OneToOne(mappedBy="address")
    private Student student;

    public Address(String streetAddress, String city) {
        this.streetAddress = streetAddress;
        this.city = city;
    }
}
