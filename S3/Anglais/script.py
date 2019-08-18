from sense_hat import SenseHat
from mpl_toolkits import mplot3d
from time import sleep

import matplotlib.pyplot as plt
import time

from skimage.measure import structural_similarity as ssim
import numpy as np
#import imageio


def mse(imageA, imageB):

    err = np.sum((imageA.astype("float") - imageB.astype("float")) ** 2)
    err /= float(imageA.shape[0] * imageA.shape[1])
    
    return err
 
def compare_images(imageA, imageB, title):

    print(imageA.shape)

    m = mse(imageA, imageB)
    s = ssim(imageA, imageB, multichannel=True)
    
    fig = plt.figure(title)
    plt.suptitle("MSE: %.2f, SSIM: %.2f DSSIM: %.2f" % (m, s, (1-s)/2))

    ax = fig.add_subplot(1, 2, 1)
    plt.imshow(imageA, cmap = plt.cm.gray)
    plt.axis("off")
    
    ax = fig.add_subplot(1, 2, 2)
    plt.imshow(imageB, cmap = plt.cm.gray)
    plt.axis("off")

    plt.show()



def displayDrawing(xData, yData, zData):
    ax = plt.axes(projection='3d')
    ax.plot3D(xData, yData, 'gray')
    plt.savefig("drawing.png")
    
def displayDrawing2D(xData, yData, zData, i):
    ax = plt.plot(xData, yData, linewidth=9.0)
    name = "drawing" + str(i) + ".png"
    plt.savefig(name)
    #recording = False
    #recording.addEvent(Button_PRESSED)

if __name__ == "__main__":
    sense = SenseHat()
    print("Start")
    event = sense.stick.wait_for_event()
    #print(event)
    recording = 0 # 0 == not recording, 1 == recording, 2 == stop recording

    acceleration_values_x = []
    acceleration_values_y = []
    acceleration_values_z = []

    velocity_values_x = []
    velocity_values_y = []
    velocity_values_z = []

    position_values_x = []
    position_values_y = []
    position_values_z = []
    
    i = 0
    
    while True:
        if event != None and event.action == 'pressed':
            while event.action != 'released':
                event = sense.stick.wait_for_event()
            if recording == 0:
                recording = 1
            elif recording == 1:
                recording = 2
            elif recording == 2:
                recording = 1

        if recording == 1: #If we are in recording mode (recording == True)
            acceleration = sense.get_accelerometer_raw()

            x = acceleration['x']
            y = acceleration['y']
            z = acceleration['z']
            
            acceleration_values_x.append(x)
            acceleration_values_y.append(y)
            acceleration_values_z.append(z)

            print("Recording")

        if recording == 2:

            plt.clf()
            plt.cla()
            plt.close()

            for i in range(len(acceleration_values_x) - 2):
                velocity_values_x.append((acceleration_values_x[i] + acceleration_values_x[i+1])/2)
                velocity_values_y.append((acceleration_values_y[i] + acceleration_values_y[i+1])/2)
                velocity_values_z.append((acceleration_values_z[i] + acceleration_values_z[i+1])/2)


            for i in range(len(velocity_values_x) - 2):
                position_values_x.append((velocity_values_x[i] + velocity_values_x[i+1])/2)
                position_values_y.append((velocity_values_y[i] + velocity_values_y[i+1])/2)
                position_values_z.append((velocity_values_z[i] + velocity_values_z[i+1])/2)

            for i, position in enumerate(position_values_x):
                if position < 1.5 and position_values_y[i] < 1.5 and position_values_z[i] < 1.5:
                    position_values_x.remove(position)
                    position_values_y.pop(i)
                    position_values_z.pop(i)

            i += 1

            displayDrawing2D(position_values_x, position_values_y, position_values_z, i)

            print("Not recording")

            recording = 0

            acceleration_values_x = []
            acceleration_values_y = []
            acceleration_values_z = []

            velocity_values_x = []
            velocity_values_y = []
            velocity_values_z = []

            position_values_x = []
            position_values_y = []
            position_values_z = []

            
            
            

            # img1 = plt.imread(name)
            # img2 = plt.imread("model.png")

            # compare_images(img1, img2, "Result :")

        events = sense.stick.get_events()

        try:
            event = events[0]
        except:
            event = None
