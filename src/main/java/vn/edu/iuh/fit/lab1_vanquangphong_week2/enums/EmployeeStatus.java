package vn.edu.iuh.fit.lab1_vanquangphong_week2.enums;

public enum EmployeeStatus {
    ACTIVE(1),
    IN_ACTIVE(0),
    TERMINATE(-1);
    private int value;
    EmployeeStatus(int value){this.value = value;}
    public int getValues() { return  value;}
}
