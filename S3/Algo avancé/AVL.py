# AVL = ABR équilibré (dont la hauteur est minimale)

def isEquilibre(ABR)
    return (getHauteur(ABR.fg)-gethauteur(ABR.fd))**2 <= 1 and getTaille(ABR) >= 2**(min(getHauteur(ABR.fg), gethauteur(ABR.fd)) + 1) - 1 # ** pour mettre à la puissance

def isFeuille(noeud):
	return noeud.fg == None and noeud.fd == None

def equilibre(racine):
	if sommeD > sommeG: # S'il y a au moins deux fois plus d'éléments à droite qu'à gauche de la racine
		newRacine = creerNoeud(suppr(getFeuilleGauche(racine.fd))) # On détache la feuille la plus à gauche du sous-arbre droit de la racine
		newRacine.fd = suppr(racine.fd) # On rattache le reste du sous-arbre droit sur la nouvelle racine (c'est son nouveau sous-arbre droit)
		newRacine.fg = racine # On recole le reste comme sous-arbre gauche de la nouvelle racine
	else:
		newRacine = creerNoeud(suppr(getFeuilleDroit(racine.fg)))
		newRacine.fg = suppr(racine.fg)
		newRacine.fg = racine
	return newRacine
    
def equilibre_AVL(racine): # A utiliser après l'insertion d'une valeur
	if racine != None:
		# Si l'un des fils vaut None et que l'autre fils n'est pas une feuille, il faut équilibrer la racine
		if racine.fg == None and isFeuille(racine.fd):
			equilibre(racine.fd)
		elif racine.fd == None and isFeuille(racine.fg):
			equilibre(racine.fg)

		# Sinon il faut parcourir l'arbre en direction d'une racine à équilibrer
		sommeG = getSommeNoeud(racine.fg) # Le nombre d'éléments de type 'noeud' rattachés à racine.fg
		sommeD = getSommeNoeud(racine.fd) # Pareil pour racine.fd
		if sommeD > sommeG: # S'il faut équilibrer le sous-arbre droit
			equilibre_AVL(racine.fd)
		elif sommeG > sommeD: # Contraire
			equilibre_AVL(racine.fg)
		elif !isEquilibre(racine): # S'il faut équilibrer les deux sous-arbres
			equilibre_AVL(racine.fd)
			equilibre_AVL(racine.fg)
			
def transforme_ABR_en_AVL(racine):
	while !isEquilibre(racine):
		equilibre_AVL(racine)