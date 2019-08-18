from numpy import*

def remplacerCaractere(tableau, ancien, nouveau):
    """
    entree : tableau tableau 2D
    entree : ancien str
    entree nouveau str
    sortie : etat booleen
    pre-cond:
    post-cond : modifie le tableau et renvoie True si l'opération a réussi, False sinon
    """
    etat=False
    i = 0
    while i<len(tableau):
        j=0
        while j<len(tableau[0]):
            if tableau[i][j] == ancien:
                tableau[i][j] = nouveau
                etat=True
            j += 1
        i += 1
    return etat

def inverserRole(joueur):
    """
    entree: joueur int
    sortie: joueur int
    pre-cond: joueurActif vaut 1 ou 2
    post-cond: retourne joueur qui vaut 1 s'il valait 2 et 2 s'il valait 1
    """
    if joueur == 1: 
        joueur = 2
    elif joueur == 2:
        joueur = 1
    return joueur

def enregistrerJoueur():
    """
    entree:
    sortie: tab tableau 2D
    pre-cond:
    post-cond: retourne le tableau contenant les informations des joueurs
    """
    joueur1=str(input("Entrez le nom du joueur n°1 (symbole X) : "))
    symbole1="X"
    joueur2=str(input("Entrer le nom du joueur n°2 (symbole O) : "))
    symbole2="O"
    tab=array([[joueur1,joueur2],[symbole1,symbole2]]) #tableau qui stock les noms et les symboles associés aux joueurs
    return tab

def continuer():
    """
    entree: 
    pre-cond :
    post-cond : renvoie False si un joueur a aligner 3 pions ce qui arrête la boucle continuer de la fonction jouer puis affiche le nom du joueur gagnant. Elle renvoie False sinon et la partie continue
    """
    if((tableau[0][0] == tableau[0][1] and tableau[0,0] == tableau[0][2]) or (tableau[1][0]==tableau[1,1] and tableau[1][0]==tableau[1,2]) or (tableau[2][0] == tableau[2][1] and tableau[2][0] == tableau[2][2])): # 3 possibilités pour XXX
       print("-------------------\n",tableau,"\nBravo",tableauJoueur[0,joueurActif-1],"tu as remporté cette partie !!")
       return False
    elif ((tableau[0][0] == tableau[1][0] and tableau[0,0] == tableau[2][0]) or (tableau[0][1]==tableau[1][1] and tableau[0][1]==tableau[2,1]) or (tableau[0][2] == tableau[1][2] and tableau[0][2] == tableau[2][2])): # 3 possibilités pour X
       print("-------------------\n",tableau,"\nBravo",tableauJoueur[0,joueurActif-1],"tu as remporté cette partie !!")                                                                                                 #                     X
       return False                                                                                                                                                                                                     #                     X                                                                                                                                                  
    elif ((tableau[0][0] == tableau[1][1] and tableau[0][0] == tableau[2][2]) or (tableau[0][2]==tableau[1][1] and tableau[0][2]==tableau[2][0])) : # 2 possibilités pour X
        print("-------------------\n",tableau,"\nBravo",tableauJoueur[0,joueurActif-1],"tu as remporté cette partie !!")                            #                       X  
        return False                                                                                                                                #                         X
    elif(caseRestante==0):
        print("--------------------\n", tableau,"\n Il y a égalité !")
    else:
        return True

# REMARQUE : ON AURAIT PU UTILISER UN SEUL IF EN UTILISANT DES OR A LA PLACE DES ELIF MAIS C'EST MOINS VISUEL ET LE PROGRAMME DOIT PASSER EN REVU PLUS DE CONDITIONS
     
tableau=array([["1","2","3"],["4","5","6"],["7","8","9"]]) #tableau morpion 3x3
joueurActif=1 #joueurActif est le numéro du joueur qui joue actuellement
caseRestante=9 #Nombre de cases maximales, elles sont généralement toutes remplies lorsqu'il y a égalité
tableauJoueur=enregistrerJoueur()
while(continuer()):
        i=0
        print("\n---------------------\n") #avant tableau
        while i<len(tableau):
            j=0
            while j<len(tableau[0]):
                print(tableau[i][j],"\t",end="")
                j+=1
            print("\n")
            i+=1    
        print("\n---------------------\nC'est à",tableauJoueur[0,joueurActif-1],"(",tableauJoueur[1,joueurActif-1],") de jouer")
        case=str(input("Entrer le numéro de la case à modifier : "))
        if(remplacerCaractere(tableau, case, tableauJoueur[1,joueurActif-1])):
            joueurActif=inverserRole(joueurActif)
            caseRestante-=1
        else:
            print("\n/!\ La case est déjà utilisée ou inexistante /!\ \n")
