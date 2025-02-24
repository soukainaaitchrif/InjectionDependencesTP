package org.example.presentation;

import org.example.Dao.Dao;
import org.example.Dao.DaoImp;
import org.example.metier.IMetier;
import org.example.metier.MetierImp;

public class PresentationV1 {


    public static void main(String[] args) {

        //Injection des dépendances par instanciation statique
        Dao dao=new DaoImp();
        MetierImp metier=new MetierImp();
        metier.setDao(dao);
        System.out.println("'Injection via setter :'   Resultat : "+metier.calcul());

        IMetier metierr=new MetierImp(dao);//Injection via le constructeur
        System.out.println(" 'Injection via le constructeur : '    Resultat : "+metier.calcul());





    }
}
