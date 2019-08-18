import matrice_adjacence as god

class Arrete():
    def __init__(self, sommet1, sommet2, valuation):
        self.s1 = sommet1
        self.s2 = sommet2
        self.valuation = valuation
        self.suiv = None

    def info(self):
        return "Arrete de",self.s1,"à",self.s2,"avec une valuation de",self.valuation

def listeToMatrice(liste):
    # Récupération de la taille du fichier
    taille = len(liste)
    
    # Création de la matrice vide (tout à 0)
    matrice = []
    for i in range(taille):
        matrice.append([])
    for i in range(taille):
        for j in range(taille):
            matrice[i].append(0)
    
    # Remplissage de la matrice
    for a in tab:
        while a != None:
            matrice[int(a.s1)][int(a.s2)] = int(a.valuation)
            a = a.suiv
    return matrice

def matriceToListe(matrice):
    tab = []
    for i in range(len(matrice)):
        tab.append(None)
    for i in range(len(matrice)):
        for j in range(len(matrice)):
            if matrice[i][j] != 0:
                if tab[i] == None:
                    tab[i] = Arrete(i, j, matrice[i][j])
                else:
                    a = tab[i]
                    while a.suiv != None:
                        a = a.suiv
                    a.suiv = Arrete(i, j, matrice[i][j])
    return tab
                

def liste_adjacence(txt):
    tab = []
    file = open(txt,"r")

    for line in file:           # pour chaque sommet
        nbarretes = 0
        i = 0
        while line[i] != ';':
            if line[i] == ':' or line[i] == ',':
                if nbarretes == 0:      # cas sommet non relié
                    if line[i+1] == ';':
                        first = None
                    else:
                        first = Arrete(line[0],line[i+1], line[i+3])
                        ref = first
                else:
                    ref.suiv = Arrete(line[0],line[i+1], line[i+3])
                    ref = ref.suiv
                nbarretes += 1 
            i += 1
        tab.append(first)

    file.close()

    return tab

def print_liste_adjacence(tab):
    i = 0
    for a in tab:
        print("sommet",i)
        while a != None:
            print(a.info())
            a = a.suiv
        i += 1

def kruskal_liste(liste):
    matrice = listeToMatrice(liste)
    god.kruskal_matrice(matrice)
    return matriceToListe(matrice)

if __name__ == '__main__':
    tab = liste_adjacence("graphe.txt")
    
    print("Après lecture du fichier :\n")
    print_liste_adjacence(tab)
    
    print("\nAprès Kruskal :\n")
    tab = kruskal_liste(tab)
    print_liste_adjacence(tab)