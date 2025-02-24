#  Structure du Projet  

📦 org.example <br> 
 ┣ 📂 Dao <br> 
 ┃ ┣ 📜 Dao.java          //Interface DAO    <br> 
 ┃ ┣ 📜 DaoImp.java       // Implémentation de DAO    <br> 
 ┣ 📂 metier   <br> 
 ┃ ┣ 📜 IMetier.java      // Interface métier   <br> 
 ┃ ┣ 📜 MetierImp.java    //Implémentation métier   <br> 
 ┣ 📂 presentation  <br> 
 ┃ ┣ 📜 PresentationV1.java  //Injection statique   <br> 
 ┃ ┣ 📜 PresentationV2.java  // Injection dynamique   <br> 
 ┃ ┣ 📜 PresentationV3.java  // Injection avec Spring (version XML)   <br> 
 ┣ 📂 resources  <br> 
 ┃ ┣ 📜 config.xml         // Fichier de configuration Spring    <br> 
 ┃ 📜 config.txt         // Fichier de configuration pour l'injection dynamique    <br> 





##  Ce projet explore différentes approches d’injection de dépendances en Java à travers quatre classes de présentation :  <br> 

PresentationV1 : Par instanciation statique  <br> 
PresentationV2 : Par instanciation dynamique  <br> 
PresentationV3 :  En utilisant le Framework Spring  <br> 
                 - Version XML  <br> 

