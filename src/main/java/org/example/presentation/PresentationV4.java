package org.example.presentation;

import org.example.metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PresentationV4 {

    public static void main(String[] args) {


        ApplicationContext context = new AnnotationConfigApplicationContext("org.example");
        IMetier metier = (IMetier) context.getBean(IMetier.class);
        System.out.println(metier.calcul());


    }
}