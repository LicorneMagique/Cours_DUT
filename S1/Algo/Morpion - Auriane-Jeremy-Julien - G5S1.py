#DELAHAIE Auriane
#GIRAUD Julien
#THOMAS Jeremy
#Exercice Morpion
#Python 3

from numpy import*

def creation_joueurs():
    """
    entree :
    sortie : tab : tableau de type str
    pre-cond :
    post-cond : retourne le tableau contenant deux elements : le nom des deux joueurs
    """
    joueur_1=str(input("Entrez le nom du joueur n°1 (symbole X) : "))
    joueur_2=str(input("Entrer le nom du joueur n°2 (symbole O) : "))
    tab=array([joueur_1, joueur_2]) #tableau qui stock les noms associés aux joueurs
    return tab

def gagnant(jeu):
    """
    entree : jeu : tableau de type str a deux dimension avec trois lignes et trois colones
    sortie : etat_partie int
    pre-cond : jeu contient la partie de morpion
    post-cond : retourner 0 si trois memes symboles sont alignes
		retourner 1 si la partie n'est pas terminee
		retourner 2 si la partie s'est terminee avec une egalite
    """
    if jeu[1][1]==jeu[0][0] and jeu[1][1]==jeu[2][2]: #cas des 2 diagonales : X * * et : * * X
        return 0				      #			      * X *      * X *
    if jeu[1][1]==jeu[0][2] and jeu[1][1]==jeu[2][0]: #			      * * X      X * *
        return 0
    
    i=0
    while i<3:
        if jeu[i][1]==jeu[i][0] and jeu[i][1]==jeu[i][2]: #cas des 3 lignes verticales : X * *,  * X *,  * * X et orizontales : X X X,  * * *,  * * *
            return 0					  #				 X * *   * X *   * * X			* * *   X X X   * * *
        if jeu[1][i]==jeu[0][i] and jeu[1][i]==jeu[2][i]: #				 X * *   * X *   * * X			* * *   * * *   X X X
            return 0
        i+=1

    i=0
    while i<3:
        j=0
        while j<3:
            if jeu[i][j][0]>="1" and jeu[i][j][0]<="9": #Si la partie n'est pas finie (donc s'il reste un nombre entre 1 et 9 dans le tableau)
                return 1
            j+=1
        i+=1
    return 2 #Si la partie est fini avec une egalite (donc la partie n'a pas de gagnant et il ne reste pas de nombre entre 1 et 9 dans le tableau)

def afficher(jeu):
    """
    entree : jeu : tableau de type str a deux dimension avec trois lignes et trois colones
    sortie :
    pre-cond : jeu contient la partie de morpion
    post-cond : afficher jeu
    """
    print("\n"*100+"-"*25, "\n")
    i=0
    while i<3:
        j=0
        while j<3:
            print (" "*4, jeu[i][j][0], end=" ")
            j+=1
        print("\n")
        i+=1
    print("-"*25, "\n"*4)

def valide(case, jeu):
    """
    entree : case : type str : numero de la case ou veut jouer le joueur actif
    entree : jeu : tableau de type str a deux dimension avec trois lignes et trois colones
    sortie : booleenne
    pre-cond : jeu contient la partie de morpion
	       case devrait contenir le numero d'une case vide, cependant les erreurs sont gerees
    post-cond : renvoie False si un joueur a aligner 3 pions ce qui arrête la boucle continuer de la fonction jouer puis affiche le nom du joueur gagnant. Elle renvoie False sinon et la partie continue
    """
    if case>="1" and case<="9":
        i=0
        while i<3:
            j=0
            while j<3:
                if jeu[i][j]==case:
                    return False
                j+=1
            i+=1
    return True

def inverser_role(numero_joueur_actif):
    """
    entree: numero_joueur_actif int
    sortie: nouveau_joueur_actif int
    pre-cond: joueur_actif vaut 0 ou 1
    post-cond: si joueur_actif vaut 0 : retourne 1
	       si joueur_actif vaut 1 : retourne 0
    """
    if numero_joueur_actif == 0: 
        return 1
    else:
        return 0

#----------------------------programme final:----------------------------------------

jeu=array([["7", "8", "9"], ["4", "5", "6"], ["1", "2", "3"]]) #tableau morpion 3x3

symbole=array(["X", "O"]) #symboles X pour le joueur 1 et O pour le joueur 2

joueur_actif=0 #joueurActif est le numéro du joueur qui joue actuel : 0 pour le joueur 1 et 1 pour le joueur 2

case="" #numero de la case ou le joueur actif veut jouer

i=0; j=0 #variables pour les boucles

joueurs=creation_joueurs()

while True:
    while valide(case, jeu):
        afficher(jeu)
        print ("C'est a", joueurs[joueur_actif], "de jouer.\nEntrez le numero d'une case pour mettre un '"+symbole[joueur_actif]+"' :")
        case=input("")
    i=0
    while i<3:
        j=0
        while j<3:
            if jeu[i][j]==case:
                jeu[i][j]=symbole[joueur_actif]
            j+=1
        i+=1
    if gagnant(jeu)==0:
        afficher(jeu)
        print ("Bravo !", joueurs[joueur_actif], "a gagne !\n")
        break
    elif gagnant(jeu)==2:
        afficher(jeu)
        print ("Dommage ! Il y a egalite entre", joueurs[0], "et", joueurs[1], "!\n")
        break
    else:
        joueur_actif=inverser_role(joueur_actif)
