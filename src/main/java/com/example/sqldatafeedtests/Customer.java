package com.example.sqldatafeedtests;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Id;

import static java.util.Objects.nonNull;

/**
 * Created by mtumilowicz on 2018-08-10.
 */
@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    @Id
    Integer id;
    String firstName;
    
    public void updateFrom(@NonNull Customer customer) {
        if (nonNull(customer.getFirstName())) {
            firstName = customer.getFirstName();
        }
    }
}