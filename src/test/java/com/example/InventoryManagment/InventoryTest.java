package com.example.InventoryManagment;

import ch.qos.logback.core.joran.action.Action;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.sl.In;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.InvalidArgumentException;

import javax.swing.*;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class InventoryTest {

    InventoryBuilderTest builder;
    public  InventoryTest(){
    builder=new InventoryBuilderTest();
    }
    @Test
    public void should_constructInventoryPrpperly(){

        //arrange
       String product="iphone";
       Double unitPrice=1100.0;
       Boolean available=true;

       //act
       Inventory inventory=builder.build();

       //assert
        assertThat(inventory.getUnitPrice()).isEqualTo(unitPrice);
        assertThat(inventory.getProduct()).isEqualTo(product);
        assertThat(inventory.getAvailable()).isEqualTo(available);

    }

    @Test
    public void should_throwNullPointerException_when_productIsNull(){

        //assert
        assertThatThrownBy(()->builder.withProduct(null).build())
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    public void should_throwNullPointerException_when_unitPriceIsNull(){

        //assert
        assertThatThrownBy(()->builder.withUnitTest(null).build())
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    public void should_throwNullPointerException_when_unitPriceIsLessThanZero(){

        //assert
        assertThatThrownBy(()->builder.withUnitTest(-1.0).build())
                .isInstanceOf(InvalidArgumentException.class)
                .hasMessageContaining("Invalid Unit Price");
    }
}
