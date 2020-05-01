# language: fr
Fonctionnalité: Calcul du score avec bonus lié au Strike

  Contexte:
    Etant donnée une nouvelle partie de bowling

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
