package vn.edu.iuh.fit.lab1_vanquangphong_week2.enums;

public enum ProductStatus {
    TRADE(1),
    IN_TRADE(0),
    TERMINATE(-1);
    private int value;
    ProductStatus(int value){this.value = value;}
    public int getValues() { return  value;}
}
