# language: fr
Fonctionnalité: Calculer le score d'une partie de bowling pour 1 joueur
  En tant que joueur de bowling
  Afin de savoir si je progresse
  J'ai besoin de connaître le score de mes parties

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