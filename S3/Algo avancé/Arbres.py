#----------ARBRES BINAIRES----------

#Termes : Racine (R), Sous-arbre Gauche (Sg), droit (Sd)

#On peut soit les les parcourir de branche en branche :
#   Préfixe : R, Sg, Sd
#   Infixe : Sg, R, Sd
#   Postfixe : Sg, Sd, R
#Soit on peut parcourir par étage

#La taille d'un arbre est son nombre de noeuds
#Sa hauteur est le niveau maximum du niveau des feuilles
#La hauteur de la racine est de 0

def parcourtPrefixe(racine):
    if racine != None:
        #Traitement avec racine.val
        parcourtPrefixe(racine.fg)
        parcourtPrefixe(racine.fd)

def parcourtInfixe(racine):
    if racine != None:
        parcourtInfixe(racine.fg)
        #Traitement avec racine.val
        parcourtInfixe(racine.fd)

def parcourtPostfixe(racine):
    if racine != None:
        parcourtPostfixe(racine.fg)
        parcourtPostfixe(racine.fd)
        #Traitement avec racine.val

def parcourtEtage(racine):
    mafile = newFile()
    arbre = racine
    if racine != None:
        mafile.ajouter(arbre)
    while !mafile.estVide(): #Tant qu'il y a des éléments dans mafile
        #traitement sur "mafile.getDebut().valeur"
        if mafile.getDebut.fdz != None: #ATTENTION la droite et la gauche sont inversés à la lecture
            mafile.ajouter(mafile.getDebut.fd)
        if mafile.getDebut.fg != None:
            mafile.ajouter(mafile.getDebut.fg)
        mafile.enleverDebut()
        
def getHauteur(racine):
    if racine == None:
        return -1
    return 1 + max(getHauteur(racine.fg), getHauteur(racine.fd))

def getTaille(racine):
    if racine == None:
        return 0
    return 1 + getTaille(racine.fg) + getTaille(racine.fd)

def exist(racine, val):
    if racine.val == val:
        return True
    if racine == None:
        return False
    return exist(racine.fg) or exist(racine.fd)

def getMin(racine):
    if racine.fg == None and racine.fd == None:
        return racine.val
    minG = getMin(racine.fg)
    minD = getMin(racine.fd)
    if minG <= minD:
        return minG
    return minD

def supprDroit(tree):
    courant = tree
    precedent = None
    while courant.fd != None and courant.fg != None:
        if courant.fd == None:
            precedent = courant
            courant = courant.fg
        else:
            precedent = courant
            courant = courant.fd
    if precedent.fg == courant:
        precedent.fg = None
    else:
        precedent.fd = None
    free(courant)

def getMirror(racine):
    courant = racine
    if racine != None :
        tmp = courant.fg
        courant.fg = courant.fd
        courant.fd = tmp
        
        courant.fd = getMirror(courant.fd)
        courant.fg = getMirror(courant.fg)
    return courant

def supprVal(racine, val):

