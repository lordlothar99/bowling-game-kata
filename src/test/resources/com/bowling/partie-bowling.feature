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

  Scénario: Une manche correspond à 2 lancers maximum
    Etant donné que le joueur a fait tomber 6 quilles
    Etant donné que le joueur a fait tomber 4 quilles
    Lorsque le joueur fait tomber 3 quilles
    Alors le nombre de manches est 2

  Scénario: Il n'y a que 10 quilles par manche
    Etant donné que le joueur a fait tomber 6 quilles
    Lorsque le joueur fait tomber 5 quilles
    Alors il y a une erreur

  Scénario: Faire tomber les 10 quilles d'une manche en deux coups s'appelle un Spare
    Etant donné que le joueur a fait tomber 6 quilles
    Lorsque le joueur fait tomber 4 quilles
    Alors il y a un Spare

  Scénario: Lorsqu'il y a un Spare, le score de la manche obtient un bonus correspondant au lancer suivant
    Etant donné que le joueur a fait tomber 6 quilles
    Et que  le joueur a fait tomber 4 quilles
    Lorsque le joueur fait tomber 3 quilles
    Alors le score est égal à 16

  Scénario: Faire tomber les 10 quilles d'une manche en un seul coup s'appelle un Strike
    Lorsque le joueur fait tomber 10 quilles
    Alors il y a un Strike

  Scénario: Après un Strike, la manche est terminée
    Etant donné que le joueur a fait tomber 10 quilles
    Lorsque le joueur fait tomber 1 quille
    Alors le nombre de manches est 2

  Scénario: Lorsqu'il y a un Strike, le score de la manche obtient un bonus correspondant aux deux lancers suivants
    Etant donné que le joueur a fait tomber 10 quilles
    Et que  le joueur a fait tomber 4 quilles
    Lorsque le joueur fait tomber 3 quilles
    Alors le score est égal à 24

  Scénario: La partie se termine après 10 manches
    Etant donné que le joueur a fait tomber 0 quille 19 fois
    Lorsque le joueur fait tomber 0 quille
    Alors le nombre de manches est 10
    Et la partie est terminée

  Scénario: Si le joueur essaie de continuer à jouer après la fin de la partie, une erreur survient
    Etant donné que le joueur a fait tomber 0 quille 20 fois
    Lorsque le joueur fait tomber 3 quilles
    Alors il y a une erreur

  Scénario: Lors de la 10e et dernière manche, si le joueur fait un Spare, alors il a un lancer bonus
    Etant donné que le joueur a fait tomber 10 quilles 9 fois
    Et que le joueur a fait tomber 3 quilles
    Et que le joueur a fait tomber 7 quilles
    Lorsque le joueur fait tomber 7 quilles
    Alors le nombre de manches est 10
    Et la partie est terminée

  Scénario: Lors de la 10e et dernière manche, si le joueur fait un Strike, alors il a deux lancers bonus
    Etant donné que le joueur a fait tomber 10 quilles 10 fois
    Et que le joueur a fait tomber 7 quilles
    Lorsque le joueur fait tomber 7 quilles
    Alors le nombre de manches est 10
    Et la partie est terminée

  Plan du scénario: Quelques exemples de calcul de score
    Etant donné que le joueur a fait tomber les quilles suivantes : <quilles tombees>
    Alors le score est égal à <score attendu>
    Exemples:
    | quilles tombees                               | score attendu |
    | 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,10,2,2    | 14            |
    | 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,10,10,2   | 22            |
    | 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,10,10,10  | 30            |
    | 10,10,10,10,10,10,10,10,10,10,10,10           | 300           |
