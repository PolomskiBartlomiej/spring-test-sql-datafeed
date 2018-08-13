package com.example.sqldatafeedtests;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by mtumilowicz on 2018-08-10.
 */
@Entity
@Value
@Builder
@EqualsAndHashCode
@ToString
class Customer {
    @Id
    Integer id;
    String firstName;
}
