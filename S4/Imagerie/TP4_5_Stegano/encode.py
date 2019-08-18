from stegano import *


if __name__ == "__main__":

    path = './exercices/'
    filename = 'message_x_cool.png'
    newFilename = filename.split('.')[0] + '_encode.png'

    size, message = image_load('message.jpg')
    size2, mask = image_load('mask.jpg')
    assert size == size2
    result = image_new(size)

    for x in range(size[0] * size[1] * 3):
        pixel1 = message[x]
        pixel2 = mask[x]
        result[x] = low(pixel2, 4) << 4
        result[x] += high(pixel2, 4) >> 4

    image_save(result, size, 'resultat.png')
