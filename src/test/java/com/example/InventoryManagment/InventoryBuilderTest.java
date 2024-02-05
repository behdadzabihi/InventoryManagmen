package com.example.InventoryManagment;

public class InventoryBuilderTest {
    private static String product="iphone";
   private static Double unitTest=1100.0;
    public static Inventory build(){
        return new Inventory(product,unitTest);
    }


    public InventoryBuilderTest  withProduct(String product){
       new Inventory(product,unitTest);
       return this;
    }

    public InventoryBuilderTest  withUnitTest(Double unitTest){
        new Inventory(product,unitTest);
        return this;
    }
}
