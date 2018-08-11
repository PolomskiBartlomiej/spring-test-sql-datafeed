package com.example.sqldatafeedtests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Created by mtumilowicz on 2018-08-11.
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
@Sql(value = "delete_all_customers.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    @DisplayName("Checking if DI works with @Autowired over field.")
    void checkResolverForConstructor() {
        assertNotNull(customerRepository);
    }

    @Test
    void findAll_noEntities() {
        assertThat(customerRepository.findAll(), is(empty()));
    }

    @Test
    @Sql(value = "insert_customer_id_1.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void findAll_entities() {
//        given
        Customer expectedCustomer = Customer.builder()
                .id(1)
                .firstName("firstName")
                .build();
//        when
        List<Customer> customers = customerRepository.findAll();

//        then
        assertThat(customers, is(not(empty())));
        assertThat(customers.get(0), is(expectedCustomer));
    }

}