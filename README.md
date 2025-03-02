#  Structure du Projet  

📦 org.example <br> 
 ┣ 📂 Dao <br> 
 ┃ ┣ 📜 Dao.java          //Interface DAO    <br> 
 ┃ ┣ 📜 DaoImp.java       // Implémentation de DAO    <br> 
 ┣ 📂 metier   <br> 
 ┃ ┣ 📜 IMetier.java      // Interface métier   <br> 
 ┃ ┣ 📜 MetierImp.java    //Implémentation métier   <br> 
 ┣ 📂 presentation  <br> 
 ┃ ┣ 📜 PresentationV1.java    <br> 
 ┃ ┣ 📜 PresentationV2.java     <br> 
 ┃ ┣ 📜 PresentationV3.java    <br> 
  ┃ ┣ 📜 PresentationV4.java    <br> 
 ┣ 📂 resources  <br> 
 ┃ ┣ 📜 config.xml         // Fichier de configuration Spring    <br> 
 ┃ 📜 config.txt         // Fichier de configuration pour l'injection dynamique    <br> 





##  Ce projet explore différentes approches d’injection de dépendances en Java :  <br> 

### 1. Injection des Dépendances par Instanciation Statique <br>
L’injection des dépendances par instanciation statique lie fortement les classes en créant directement les objets dans le code, ce qui limite la flexibilité et complique les tests. <br>
**Avantages**
L'instanciation statique est facile à implémenter et ne nécessite aucun framework externe. Elle permet une compréhension rapide du code et convient aux petites applications où la modularité n'est pas une priorité. <br>
**Inconvénients**
Elle crée une forte dépendance entre les classes, limitant la flexibilité et rendant le code plus difficile à maintenir et à tester. Les modifications nécessitent des changements directs dans le code source, ce qui peut compliquer l’évolution du projet.
**Exemple:**
```java
public class PresentationV1 {
    public static void main(String[] args) {
      //Injection des dépendances par instanciation statique
        Dao dao=new DaoImp();
        MetierImp metier=new MetierImp();
        metier.setDao(dao);
        System.out.println("'Injection via setter :'   Resultat : "+metier.calcul());

        IMetier metierr=new MetierImp(dao);//Injection via le constructeur
        System.out.println(" 'Injection via le constructeur : '    Resultat : "+metier.calcul());
    }}

 
