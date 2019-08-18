= open("graphe.txt", "r")
    numLine = 0
    for ligne in file:
        i = 0
        while ligne[i] != ';':
            if ligne[i] == ':' or ligne[i] == ",":
                matrice[int(ligne[0])][int(ligne[i+1])] = int(ligne[i+3])
            i += 1
        numLine += 1
    file.close()
    return matr