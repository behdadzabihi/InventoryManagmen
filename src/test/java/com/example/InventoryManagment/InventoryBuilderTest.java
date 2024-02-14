package com.example.InventoryManagment;

public class InventoryBuilderTest {
    private Integer id =1;
    private  String product="iphone";
   private  Double unitTest=1100.0;

   private Boolean available =true;
    public  Inventory build(){
        return new Inventory(id,product,unitTest,available);
    }


    public InventoryBuilderTest  withProduct(String product){
       new Inventory(id,product,unitTest,available);
       return this;
    }

    public InventoryBuilderTest  withUnitTest(Double unitTest){
        new Inventory(id,product,unitTest,available);
        return this;
    }
    public InventoryBuilderTest  withAvailable(Boolean available){
        new Inventory(id,product,unitTest,available);
        return this;
    }

}
