package org.example.Dao;

public class DaoImp implements Dao{
    @Override
    public double getData() {
        System.out.println("version BD");
        double data=21;
        return data;
    }
}
