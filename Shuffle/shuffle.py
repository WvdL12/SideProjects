import matplotlib.pyplot as plt
import random

list = []
for i in range(52):
    list.append(i)
rand = list.copy()
plots = []

figure1, axis1 = plt.subplots(2,6, figsize=(13.5,6.5),num="Perfect")
figure2, axis2 = plt.subplots(2,6, figsize=(13.5,6.5),num="Random")

for shuffle in range(12):
    perfect = []
    for i in range (26):
        perfect.append(list[i])
        perfect.append(list[i + 26])
    distance = []
    neighbour1 = []
    for j in range(52):
        distance.append(abs(j - perfect[j]))
        mean = 0.0
        var = 0
        if (j>0):
            mean += abs(perfect[j-1]-perfect[j])
            var += 1
        if j < 51:
            mean += abs(perfect[j+1]-perfect[j])
            var += 1
        mean = (mean / var) % 13
        neighbour1.append(mean)

    axis1[shuffle // 6,shuffle % 6].plot(range(52),distance,label='Distance from Start')
    axis1[shuffle // 6,shuffle % 6].plot(range(52),neighbour1,label='Distance from Neighbours')
    name = str(shuffle + 1) + " perfect shuffles"
    axis1[shuffle // 6,shuffle % 6].set_title(name)
    axis1[shuffle // 6,shuffle % 6].set_ylim([0,52])

    num = random.randint(21,31)
    group1 = rand[0:num]
    cnt1 = 0
    group2 = rand[num:52]
    cnt2 = 0

    for i in range(52):
        roll = random.random()
        if roll < 0.5 and cnt1 < num:
            rand[i] = group1[cnt1]
            cnt1 += 1
        elif cnt2 < 52 - num:
            rand[i] = group2[cnt2]
            cnt2 += 1
        else:
            rand[i] = group1[cnt1]
            cnt1 += 1

    distance2 = []
    neighbour2 = []
    for j in range(52):
        distance2.append(abs(j - rand[j]))
        mean = 0.0
        var = 0
        if (j>0):
            mean += abs(rand[j-1]-rand[j])
            var += 1
        if j < 51:
            mean += abs(rand[j+1]-rand[j])
            var += 1
        mean = (mean / var) % 13
        neighbour2.append(mean)
    
    axis2[shuffle // 6,shuffle % 6].plot(range(52),distance2,label='Distance from Start')
    axis2[shuffle // 6,shuffle % 6].plot(range(52),neighbour2,label='Distance from Neighbours')
    name = str(shuffle + 1) + " rough shuffles"
    axis2[shuffle // 6,shuffle % 6].set_title(name)
    axis2[shuffle // 6,shuffle % 6].set_ylim([0,52])

    list = perfect

handles, labels = plt.gca().get_legend_handles_labels()
figure1.legend(handles, labels, loc='upper center')
figure2.legend(handles, labels, loc='upper center')

plt.show()
    