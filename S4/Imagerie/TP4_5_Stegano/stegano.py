import PIL
import PIL.Image


def high(value, n):
    '''
    Return the n high weight bits of a value

    >>> bin(high(0b11010101, 2))
    '0b11000000'
    '''

    return value >> (8 - n) << (8 - n)


def low(value, n):
    '''
    Return the n lowest bits of a value

    >>> bin(low(0b11010010, 2))
    '0b10'
    '''

    return value % (2 ** n)


def image_load(path):
    '''
    Load an image from *path* and returns it size Width and Height and
    an array containing image values.

    returns: (W, H), array

    Note: if the image width is WxH, returns an array of size WxHx3
    because there is 3 bands, Red, Green and Blue per image.

    Each array item is in the range [0, 255], (i.e: color band are
    stared as one byte item).
    '''

    im = PIL.Image.open(path).convert('RGB')
    return im.size, bytearray(im.tobytes())


def image_save(data, size, path):
    '''
    Save an array *data* of size WxHx3 to an image of *size* to the *path*.

    Note: the path extension indicate the file format (png or jpg for example).
    '''

    im = PIL.Image.new('RGB', size)
    im.frombytes(bytes(data))
    im.save(path)


def image_new(size):
    '''
    Create a new array able to store an image of size *size*.
    '''

    im = PIL.Image.new('RGB', size)
    return bytearray(im.tobytes())
