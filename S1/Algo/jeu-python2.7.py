#GIRAUD Julien
#Python 2.7

#from array import array
#par soucis avec array, nous utiliserons des
#listes python de la meme facon que des taleaux

jeu=[["1", "2", "3"], ["4", "5", "6"], ["7", "8", "9"]]
joueurs=['','']; symbole=["X", "O"]; case=""
joueur=0; i=0; j=0

def ini(joueurs):
    joueurs[0]=raw_input("Entrer le nom du premier joueur :\n")
    joueurs[1]=raw_input("Entrer le nom du deuxieme joueur :\n")

def gagnant(jeu):
    if jeu[1][1]==jeu[0][0] and jeu[1][1]==jeu[2][2]: #cas des 2 diagonales
        return 0
    if jeu[1][1]==jeu[0][2] and jeu[1][1]==jeu[2][0]:
        return 0
    
    for i in range(3):
        if jeu[i][1]==jeu[i][0] and jeu[i][1]==jeu[i][2]: #cas des 3 lignes |
            return 0
        if jeu[1][i]==jeu[0][i] and jeu[1][i]==jeu[2][i]: #cas des 3 lignes _
            return 0
    
    for i in range(3):
        for j in range(3):
            if jeu[i][j][0]>="1" and jeu[i][j][0]<="9": #Si la partie n'est pas finie
                return 1
    return 2 #Si la partie est fini avec une egalite

def afficher(jeu):
    print("---------")
    for i in range(3):
        for j in range(3):
            print "", jeu[i][j][0],
        print("")
    print("---------")

def valide(case, jeu):
    if case>="1" and case<="9":
        for i in range(3):
            for j in range(3):
                if jeu[i][j]==case:
                    return 0
    return 1

#programme final:
ini(joueurs)
while True:
    while valide(case, jeu):
        afficher(jeu)
        print "C'est a", joueurs[joueur], "de jouer.\nEntrez le numero d'une case pour mettre un '"+symbole[joueur]+"' :"
        case=raw_input("")
    for i in range(3):
        for j in range(3):
            if jeu[i][j]==case:
                jeu[i][j]=symbole[joueur]
    if gagnant(jeu)==0:
        afficher(jeu)
        print "Bravo !", joueurs[joueur], "a gagne !"
        break
    elif gagnant(jeu)==2:
        afficher(jeu)
        print "Dommage ! Il y a egalite entre", joueurs[0], "et", joueurs[1]
        break
    else:
        if joueur==0:
            joueur=1
        else:
            joueur=0
