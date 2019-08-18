from stegano import *


if __name__ == "__main__":

    path = './exercices/'
    filename = 'message_x_cool.png'
    newFilename = filename.split('.')[0] + '_decode.png'

    size, image = image_load(path + filename)

    result = image_new(size)

    for x in range(size[0] * size[1] * 3):
        pixel = image[x]
        result[x] = low(pixel, 4) << 4

    image_save(result, size, path + newFilename)
