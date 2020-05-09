import requests
import time
import datetime as dt
import matplotlib.pyplot as plt
import matplotlib.animation as anim
from PIL import Image

# phyphox configuration
PP_ADDRESS = "http://192.168.0.154"
PP_CHANNELS = ["subscore", "currentScore"]

# global var to save timestamp
xs = []

# global array to save acceleration
subscore = []
currentScore = []


def getSensorData():
    url = PP_ADDRESS + "/get?" + ("&".join(PP_CHANNELS))
    data = requests.get(url=url).json()
    subscore = data["buffer"][PP_CHANNELS[0]]["buffer"][0]
    currentScore = data["buffer"][PP_CHANNELS[1]]["buffer"][0]
    t = dt.datetime.now().strftime('%M:%S.%f')
    return [subscore, currentScore]


def getData():
    [nsubscore, ncurrentScore] = getSensorData()  # get nth sample
    t = dt.datetime.now().strftime('%M:%S.%f')  # %H:%M:%S.%f
    xs.append(t)
    subscore.append(nsubscore)
    currentScore.append(ncurrentScore)
    return [t, nsubscore, ncurrentScore]

def identify():

    peakCount = 0
    peakScore = 0
    #[t, nsubscore, currentScore] = getSensorData()

    p=0
    peakCount1=0
    p1=0
    cc=0
    cc1=0
    index =0
    for i in range(len(subscore)):
        if float(subscore[i])<=0.9:
            p=i
            p1=i #if it is quiet again, we will record the time for the snap from there


        if float(subscore[i]) >=1.0 and float(subscore[i]) <=4.0:
            if float(subscore[i-1])<=0.9:
                p=i-1 # record the first occurence of snap
            peak = int(xs[i][3:5]+xs[i][6:])-int(xs[p][3:5]+xs[p][6:])
            if 100000<=peak<=200000: # if it is more than 0.1s, we will count it as a snap
                if cc!=p:



                    peakCount += 1
                    if (peakCount==1 and peakCount1==0): index =0
                    print (subscore[i])
                    cc=p

        if float(subscore[i]) >4.0:
            if float(subscore[i-1]) <=0.9:
                p1=i-1 # record the first occurence of snap
            peak = int(xs[i][3:5] + xs[i][6:]) - int(xs[p1][3:5] + xs[p1][6:])
            if 100000<=peak<=200000: # if it is more than 0.1s, we will count it as a snap
                if cc1!=p1:
                    peakCount1+=1
                    if (peakCount1==1 and peakCount==0): index =1
                    print(subscore[i])
                    cc1=p1



    arr=[pc(peakCount), pc1(peakCount1)]
    return arr[index]


def pc(peakCount):
    if peakCount == 1 :
        img1 = Image.open('pause.jpg')
        img1.show()
        return "pause play"

    elif peakCount == 2 :
        img1 = Image.open('next.jpg')
        img1.show()
        return "next song"
    elif peakCount == 3 :
        img1 = Image.open('prev.jpg')
        img1.show()
        return "prev song"
    elif peakCount>=4:
        return "try again"

def pc1(peakCount1):
    if peakCount1 == 1: # nSubscore value for min snap sound:
        img1 = Image.open('answer.jpg')
        img1.show()
        return "answer call"
    elif peakCount1 == 2:
        img1 = Image.open('hangup.jpg')
        img1.show()
        return "hang up"

    else:
        return "no signal detected"
def main():
    start = time.time()
    s = int(dt.datetime.now().strftime('%M%S'))
    b=True
    while b:
        [t, nsubscore, currentScore] = getData()
        print(t, ' ', nsubscore, ' ', currentScore)
        if (int(t[0:2]+t[3:5])-s>=20 ): b=False
    print(subscore)
    print(identify())

        # time.sleep(INTERVALS/1000)   # Delays for INTERVALS seconds.


if __name__ == '__main__':
    main()
