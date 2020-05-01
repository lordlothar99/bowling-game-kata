# language: fr
Fonctionnalité: Calcul du score avec bonus lié au Spare

  Contexte:
    Etant donnée une nouvelle partie de bowling

  Scénario: Faire tomber les 10 quilles d'une manche en deux coups s'appelle un Spare
    Etant donné que le joueur a fait tomber 6 quilles
    Lorsque le joueur fait tomber 4 quilles
    Alors il y a un Spare

  Scénario: Lorsqu'il y a un Spare, le score de la manche obtient un bonus correspondant au lancer suivant
    Etant donné que le joueur a fait tomber 6 quilles
    Et que  le joueur a fait tomber 4 quilles
    Lorsque le joueur fait tomber 3 quilles
    Alors le score est égal à 16

  Scénario: Lors de la 10e et dernière manche, si le joueur fait un Spare, alors il a un lancer bonus
    Etant donné que le joueur a fait tomber 10 quilles 9 fois
    Et que le joueur a fait tomber 3 quilles
    Et que le joueur a fait tomber 7 quilles
    Lorsque le joueur fait tomber 7 quilles
    Alors le nombre de manches est 10
    Et la partie est terminée

  Plan du scénario: Quelques exemples de calcul de score
    Etant donné que le joueur a fait tomber les quilles suivantes : <quilles tombees>
    Alors le score est égal à <score attendu>
    Exemples:
    | quilles tombees                                       | score attendu |
    | 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,2,4             | 14            |
    | 0,10,0,10,0,10,0,10,0,10,0,10,0,10,0,10,0,10,0,0      | 90            |
    | 0,10,0,10,0,10,0,10,0,10,0,10,0,10,0,10,0,10,0,10,10  | 110           |
