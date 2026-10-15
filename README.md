
# TP 1 : Les sockets en mode connecté TCP
## Activité 1-1 : Première connexion Client/Serveur





## Activité 1-2 : Service de calculatrice

## Étape 1 : Préparation de l'espace de travail

Création des fichiers Client.java et Serveur.java
pour réaliser une application client/serveur TCP.


## Étape 2 : Service de multiplication

### 1. Application Serveur

Le serveur écoute sur le port 1234, attend une
connexion, reçoit un entier et le multiplie par 5.
Il renvoie ensuite le résultat au client.

![Exécution](capture/Capture d'écran server.png)

![Exécution](capture/1.png)

### 2. Application Client

Le client se connecte au serveur, demande un
entier à l'utilisateur, puis envoie cet entier.
Il reçoit le résultat et l'affiche.

![Exécution du client](capture/2.png)

### 3. Résultat

Pour x = 4, le serveur calcule 5 * 5 = 25.
Le client reçoit et affiche le résultat 25.

![Exécution du client](capture/3.png)
![Exécution du client](capture/4.png)

