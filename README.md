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


## Introduction  <br>
L'injection de dépendances est un principe fondamental en programmation qui permet de découpler les composants d'une application, améliorant ainsi sa modularité, sa maintenabilité et sa testabilité. Plutôt que de laisser une classe créer directement ses dépendances, ces dernières lui sont fournies de l'extérieur, réduisant ainsi le couplage et facilitant l'évolution du code. Cette approche peut être mise en œuvre de différentes manières : par instanciation statique, dynamique ou via un framework comme Spring, qui automatise la gestion des dépendances.


##  Ce projet explore différentes approches d’injection de dépendances en Java :  <br> 

### 1. Injection des Dépendances par Instanciation Statique <br>
L’injection des dépendances par instanciation statique lie fortement les classes en créant directement les objets dans le code, ce qui limite la flexibilité et complique les tests. <br>
**Avantages** <br>
L'instanciation statique est facile à implémenter et ne nécessite aucun framework externe. Elle permet une compréhension rapide du code et convient aux petites applications où la modularité n'est pas une priorité. <br>
**Inconvénients** <br>
Elle crée une forte dépendance entre les classes, limitant la flexibilité et rendant le code plus difficile à maintenir et à tester. Les modifications nécessitent des changements directs dans le code source, ce qui peut compliquer l’évolution du projet.<br>
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
```

### 2. Injection des Dépendances par Instanciation dynamique <br>
L’injection des dépendances par instanciation dynamique permet de créer les objets à l’exécution en utilisant la réflexion. Cette approche offre une flexibilité accrue, car les classes à instancier peuvent être définies dans un fichier de configuration externe, évitant ainsi un couplage fort entre les composants. <br>
**Exemple:**
```java
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
        }}}

```
cette approche permet de modifier les dépendances sans toucher au code source, ce qui facilite l’évolution du projet et l’intégration avec des frameworks d’injection de dépendances. <br>

### 3. Injection des Dépendances avec Spring (Configuration XML) <br>
L’injection des dépendances avec Spring en utilisant un fichier de configuration XML permet de déléguer la gestion des objets au framework, ce qui améliore la modularité et la maintenabilité du code. Spring instancie et injecte automatiquement les dépendances définies dans config.xml, réduisant ainsi le couplage entre les classes. <br>
**Exemple:**

```java
public class PresentationV3 {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        IMetier metier= (IMetier) context.getBean(IMetier.class);
        System.out.println(metier.calcul());
    }
}
```
Spring facilite la gestion des dépendances et la configuration des composants sans modifier le code source. 


### 4. Injection des Dépendances avec Spring (Version Annotations) <br>

L’injection des dépendances avec Spring via les annotations simplifie la configuration en évitant l'utilisation d'un fichier XML. Grâce à des annotations comme @Component et @Autowired, Spring détecte et gère automatiquement les dépendances, améliorant ainsi la lisibilité et la maintenabilité du code. <br>

```java
@Component("dao")
public class DaoImp implements Dao{
    @Override
    public double getData() {
        System.out.println("version BD");
        double data=21;
        return data;
    }
}
```
```java

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
    }}
```

## Conclusion <br>
L'injection de dépendances favorise la flexibilité et la maintenabilité des applications. En évoluant de l'instanciation statique vers une approche dynamique, puis vers l'utilisation de Spring, l'architecture devient plus modulaire et facilement extensible.


