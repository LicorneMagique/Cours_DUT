# Calculs de complexité (1)
def fonction1(tab, n):
    for i in range(0, n - 1): # O(n)
        tab[i] = i # O(1)
# --> O(n)

def rempliDiagonale(matrice):
    for i in range matrice.len-1:
        matrice[i][i] = 1

def rempliTriangle(matrice):
    for i in range matrice.len-1:
        matrice[i][i] = 1
        matrice[0][i] = 1
        matrice[matrice.len-1-i][0] = 1
