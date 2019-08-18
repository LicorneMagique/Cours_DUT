# Arbres Binaires de Recherche (ABR) aussi appelés arbres ordonnés

# Pour trier un tableau de valeurs il suffit de les mettre dans un ABR puis de lire l'ABR en infixe en réécrivant dans le tableau

def planter(ABR, val):
    if val > ABR.val:
        if ABR.fg != None:
            planter(ABR.fg, val)
        else:
            ABR.fg = newNoeud(None, val, None)
    else:
        if ABR.fd != None:
            planter(ABR.fd, val)
        else:
            ABR.fd = newNoeud(None, val, None)

def exist(ABR, val):
    if ABR == None:
        return False
    if ABR.val == val:
        return True
    if val > ABR.val:
        return exist(ABR.fg)
    else:
        return exist(ABR.fd)

def getNoeud(ABR, val):
    if ABR.val == val:
        return ABR
    if ABR.val > val:
        return getNoeud(ABR.fg, val)
    return getNoeud(ABR.fd, val)

def suppr(ABR, val):
# On va au niveau du noeud à supprimer
# On doit y mettre soit la plus grande valeur de son sous-arbre droit, soit la plus petite de son sous-arbre gauche
# Si l'une de ces valeurs est dans une feuille, on met sa valeur dans ABR puis on supprime la feuille
# Sinon on defini un cote, ici la gauche
# On recherche le noeud qui contient le max du sous-arbre gauche d'ABR
# On remplace la valeur de ABR par la valeur de ce noeud
# Et on répète l'action sur ce noeud

    # On va au niveau du noeud à supprimer
    ABR = getNoeud(ABR, val)
    
    # S'il a un fils gauche, on récupère le noeud de sa plus grande valeur
    maxGauche = (ABR.fg != None) ? getNoeud(ABR.fg, getMax(ABR.fg)) : None
    
    # Si le fils gauche existe et est une feuille, on le remonte puis on le supprime
    if maxGauche != None and maxGauche.fg == None and maxGauche.fd == None:
        ABR.val = maxGauche.val
        maxGauche = None
        return 0
    
    # Si la racine a un fils droit, pareil
    minDroit = (ABR.fd != None) ? getNoeud(ABR.fd, getMin(ABR.fd)) : None
    
    # Si le fils droit existe et est une feuille, pareil
    if minDroit != None and minDroit.fg == None and minDroit.fd == None:
        ABR.val = minDroit.val
        minDroit = None
        return 0
    
    # On récupère la hauteur des sous-arbres
    hg = getTaille(ABR.fg, val)
    hd = getTaille(ABR.fd, val)
    
    # Pour optimiser l'arbre
    if hg < hd:
        # On prend le noeud qui contient le max du sous-arbre gauche d'ABR (maxGauche)
        # On remplace la valeur de ABR par la valeur de maxGauche
        ABR.val = maxGauche.val
        
        # On répète l'action sur maxGauche
        return suppr(maxGauche, val)
    else:
        # On prend le noeud qui contient le min du sous-arbre droit d'ABR (minDroit)
        # On remplace la valeur de ABR par la valeur de minDroit
        ABR.val = minDroit.val
        
        # On répète l'action sur maxGauche
        return suppr(minDroit, val)

