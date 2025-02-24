package org.example.Dao;

import org.springframework.stereotype.Component;

@Component("dao")
public class DaoImp implements Dao{
    @Override
    public double getData() {
        System.out.println("version BD");
        double data=21;
        return data;
    }
}
