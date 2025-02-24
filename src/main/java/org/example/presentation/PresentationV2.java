package org.example.presentation;

import org.example.Dao.Dao;
import org.example.metier.IMetier;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class PresentationV2 {
    public static void main(String[] args) {


        try {
            Scanner sc = new Scanner(new File("config.txt"));
            String daoClassname=sc.nextLine();
            Class cdao=Class.forName(daoClassname);
            Dao dao = (Dao) cdao.getConstructor().newInstance();
            System.out.println(dao.getData());

           String metierClassname=sc.nextLine();
            Class cmetier=Class.forName(metierClassname);
            IMetier metier = (IMetier) cmetier.getConstructor(Dao.class).newInstance(dao);
            System.out.println(metier.calcul());


        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
