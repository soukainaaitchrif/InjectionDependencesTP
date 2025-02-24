# ** Structure du Projet ***

📦 org.example
 ┣ 📂 Dao
 ┃ ┣ 📜 Dao.java          # Interface DAO  
 ┃ ┣ 📜 DaoImp.java       # Implémentation de DAO  
 ┣ 📂 metier
 ┃ ┣ 📜 IMetier.java      # Interface métier  
 ┃ ┣ 📜 MetierImp.java    # Implémentation métier  
 ┣ 📂 presentation
 ┃ ┣ 📜 PresentationV1.java  # Injection statique  
 ┃ ┣ 📜 PresentationV2.java  # Injection dynamique 
 ┃ ┣ 📜 PresentationV3.java  # Injection avec Spring (version XML) 
 ┣ 📂 resources
 ┃ ┣ 📜 config.xml         # Fichier de configuration Spring  
 ┃ 📜 config.txt         # Fichier de configuration pour l'injection dynamique  





# ** Ce projet explore différentes approches d’injection de dépendances en Java à travers trois classes de présentation :

PresentationV1 : Par instanciation statique
PresentationV2 : Par instanciation dynamique
PresentationV3 :  En utilisant le Framework Spring
                 - Version XML

