# language: fr
Fonctionnalité: Calculer le score d'une partie de bowling pour 1 joueur
  En tant que joueur de bowling
  Afin de savoir si je progresse
  J'ai besoin de connaître le score de mes parties

  Vous pouvez trouver un outil de test en ligne [ici](https://bowlinggenius.com/)

  ![](./img/bowling.jpg "Bowling Game 2")

  Contexte:
    Etant donnée une nouvelle partie de bowling

  Scénario: Le score est à 0 au début de la partie
    Alors le score est égal à 0
    
  Scénario: Quand le joueur effectue un lancer, le score est égal au nombre de quilles tombées
    Lorsque le joueur fait tomber 4 quilles
    Alors le score est égal à 4

  Scénario: Le score après deux lancers est égal à la somme des quilles tombées
    Etant donné que le joueur a fait tomber 6 quilles
    Lorsque le joueur fait tomber 3 quilles
    Alors le score est égal à 9

  Scénario: Une manche correspond à 2 lancers maximum
    Etant donné que le joueur a fait tomber 6 quilles
    Etant donné que le joueur a fait tomber 4 quilles
    Lorsque le joueur fait tomber 3 quilles
    Alors le nombre de manches est 2

  Scénario: Il n'y a que 10 quilles par manche
    Etant donné que le joueur a fait tomber 6 quilles
    Lorsque le joueur fait tomber 5 quilles
    Alors il y a une erreur

  Scénario: La partie se termine après 10 manches
    Etant donné que le joueur a fait tomber 0 quille 19 fois
    Lorsque le joueur fait tomber 0 quille
    Alors le nombre de manches est 10
    Et la partie est terminée

  Scénario: Si le joueur essaie de continuer à jouer après la fin de la partie, une erreur survient
    Etant donné que le joueur a fait tomber 0 quille 20 fois
    Lorsque le joueur fait tomber 3 quilles
    Alors il y a une erreur

  Plan du scénario: Quelques exemples de calcul de score
    Etant donné que le joueur a fait tomber les quilles suivantes : <quilles tombees>
    Alors le score est égal à <score attendu>
    Exemples:
    | quilles tombees                               | score attendu |
    | 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0       | 0             |
    | 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,1       | 9             |
    | 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1       | 20            |
