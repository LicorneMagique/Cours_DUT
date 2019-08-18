from PIL import Image
import matplotlib.pyplot as plt
import numpy
import sys

if __name__ == "__main__":

    path = './'
    filename = sys.argv[1]

    # Read image
    image = Image.open(path + filename)
    # Read pixels
    pixels = image.load()

    # image size
    size = image.size
    print("Taille de l'image (largeur, hauteur): " + str(size))

    data = []
    for x in range(size[0]):
        for y in range(size[1]):
            data.append(pixels[x, y][1])  # pour Histogramme
            R = pixels[x, y][0]  # Couleur Rouge
            V = pixels[x, y][1]  # Couleur Verte
            B = pixels[x, y][2]  # Couleur Bleu
            pixels[x, y] = (R, V, B)

    # Affiche l'image
    image.show()
    # Enregistre l'image
    image.save(path + 'Save.png', "PNG")

    # Ouvre dans un tableau 3D l'image [Ligne][Colonne][Couleur]
    pix = numpy.array(image)

    # Pixel Rouge(0) en position 0,0
    print(pix[0][0][0])
    print(pixels[0, 0][0])

    # Création d'une nouvelle image et l'affiche
    newimage = Image.fromarray(pix)
    newimage.show()

    # Affiche un Histogramme
    plt.hist(data, range=(0, 255), bins=256)
    plt.show()
