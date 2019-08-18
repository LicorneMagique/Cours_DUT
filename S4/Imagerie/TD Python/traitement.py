from PIL import Image
import numpy
import sys


def nuanceGris(tab, size):
    for x in range(size[0]):
        for y in range(size[1]):
            R = pixels[x, y][0]
            V = pixels[x, y][1]
            B = pixels[x, y][2]
            G = int(0.299 * R + 0.587 * V + 0.114 * B)# coding: utf8

            pixels[x, y] = (G, G, G)


if __name__ == "__main__":

    path = './'
    filename = sys.argv[1]
    choix = sys.argv[2]

    # Read image
    image = Image.open(path + filename)

    # Affiche l'image
    image.show()

    # Read pixels
    pixels = image.load()

    # image size
    size = image.size

    data = []
    for x in range(size[0]):
        for y in range(size[1]):
            data.append(pixels[x, y][1])  # pour Histogramme
            R = pixels[x, y][0]  # Couleur Rouge
            V = pixels[x, y][1]  # Couleur Verte
            B = pixels[x, y][2]  # Couleur Bleu
            pixels[x, y] = (R, V, B)

    '''switch(choix):
        case "nuanceGris":'''
    nuanceGris(pixels, size)

    # Enregistre l'image
    image.save(path + filename.split(".")[0] + "_nuanceGris.png", "PNG")

    # Ouvre dans un tableau 3D l'image [Ligne][Colonne][Couleur]
    pix = numpy.array(image)

    # Pixel Rouge(0) en position 0,0
    print(pix[0][0][0])
    print(pixels[0, 0][0])


    # Création d'une nouvelle image et l'affiche
    newimage = Image.fromarray(pix)
    newimage.show()
