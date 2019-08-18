def print_matrice_adjacence(mat):
    # Affichage des numéros des colones (=numéro du sommet correspondant)
    i = 0
    print('    ', end='')
    for element in mat:
        print(i, end=' ')
        i += 1
    print('\n')

    # Affichage de la matrice et du numéro de la ligne (=numéro du sommet correspondant)
    j = 0
    for ligne in mat:
        print(j, end='   ')
        for element in ligne:
            print(element, end=' ')
        print('\n', end='')
        j += 1

def matrice_adjacence(file):
    # Récupération de la taille du fichier
    file = open(file, "r")
    taille = 0
    for i in file:
        taille += 1
    
    # Création de la matrice vide (tout à 0)
    matrice = []
    for i in range(taille):
        matrice.append([])
    for i in range(taille):
        for j in range(taille):
            matrice[i].append(0)
    
    # Remplissage de la matrice
    file = open("graphe.txt", "r")
    numLine = 0
    for ligne in file:
        i = 0
        while ligne[i] != ';':
            if ligne[i] == ':' or ligne[i] == ",":
                matrice[int(ligne[0])][int(ligne[i+1])] = int(ligne[i+3])
            i += 1
        numLine += 1
    file.close()
    return matrice

def isTrie(relations, nbRelation):
    # Retourne True seulement si toutes les arrêtes sont dans l'ordre
        for i in range(nbRelation-2):
            if relations[i][1] > relations[i+1][1]:
                return False
        return True

def isPresent(tab, val):
    # Retourne True si la valeur est déjà dans la liste
    for valeur in tab:
        if int(valeur) == int(val):
            return True
    return False

def ajouter_matrice(matrice, taille, relations, nbRelation, relation):
    # On se demande s'il y a un lien possible de proche en proche entre relation[0] et relation[2]

    # On commence par lister tous les voisins de relation[0] accessibles de proche en proche
    copains = []
    val = relation[0]
    for i in range(taille):
        if matrice[i][val] != 0 and not isPresent(copains, matrice[i][val]):
            copains.append(matrice[i][val])
    for i in range(taille):
        for newVal in copains:
            for j in range(taille):
                if matrice[j][newVal] != 0 and not isPresent(copains, matrice[j][newVal]):
                    copains.append(matrice[j][newVal])

    # Si relation[2] ne se trouve pas dans les voisins de relation[0], alors on doit ajouter l'arrête
    ajouter = True
    for val in copains:
        if val == relation[2]:
            ajouter = False
    if ajouter:
        matrice[relation[0]][relation[2]] = relation[1]

def kruskal_matrice(matrice):
    # On commence par mesurer la taille de la matrice
    taille = 0
    for i in matrice:
        taille += 1
    
    # Ensuite, vu qu'elle est symétrique on enlève les données en double
    for i in range(taille):
        for j in range(taille):
            if i > j:
                matrice[i][j] = 0

    # Puis on récupère les arrêtes tout en vidant la matrice
    relations = []
    nbRelation = 0
    i = 0
    for ligne in matrice:
        j = 0
        for element in ligne:
            if element != 0:
                relations.append((i, element, j))
                matrice[i][j] = 0
                nbRelation += 1
            j += 1
        i += 1
    
    # Il faut maintenant trier les arrêtes par poids
    while not isTrie(relations, nbRelation):
        for i in range(nbRelation-2):
            if relations[i][1] > relations[i+1][1]:
                tmp = relations[i]
                relations[i] = relations[i+1]
                relations[i+1] = tmp

    # Enfin il faut ajouter ces arrêtes à la matrice, si elles ne génèrent pas de boucle
    for relation in relations:
        ajouter_matrice(matrice, taille, relations, nbRelation, relation)

if __name__ == '__main__':
    matrice = matrice_adjacence("graphe.txt")

    print("Après lecture du fichier :\n")
    print_matrice_adjacence(matrice)
    
    print("\nAprès Kruskal :\n")
    kruskal_matrice(matrice)
    print_matrice_adjacence(matrice)
