package org.example.ext;

import org.example.Dao.Dao;

public class DaoImpV2 implements Dao {


    @Override
    public double getData() {
        System.out.println("Web Service");
        double d=58;
        return d;
    }
}
