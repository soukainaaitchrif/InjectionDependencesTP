package org.example.metier;

import org.example.Dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MetierImp implements IMetier{

@Autowired
    private Dao dao;

    public MetierImp() {

    }
    public MetierImp(Dao dao) {
        this.dao=dao;
    }
    @Override
    public double calcul() {
        double t=this.dao.getData();
        double res=t*16;
        return res;
    }


    public void setDao(Dao dao) {
        this.dao = dao;
    }

}
