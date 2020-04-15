# language: fr
Fonctionnalité: Calculer le score d'une partie de bowling pour 1 joueur
  En tant que joueur de bowling
  Afin de savoir si je progresse
  J'ai besoin de connaître le score de mes parties

  Scénario: Le score est à 0 au début de la partie
    Etant donnée une nouvelle partie de bowling
    Alors le score est égal à 0
    
  Scénario: Quand le joueur effectue un lancer, le score est égal au nombre de quilles tombées
    Étant donnée une nouvelle partie de bowling
    Lorsque le joueur fait tomber 4 quilles
    Alors le score est égal à 4