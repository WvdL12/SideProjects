import numpy as np
import argparse
from time import time
import math

def estimate(size: int):
    TOTAL = size * size
    chunk_size = 20000
    coords = (np.linspace(-0.5, 0.5, num=size) ** 2).reshape(1, -1)
    gridsum = 0
    chunks = math.ceil(size / chunk_size)
    # print(chunks)
    for i in range(chunks):
        for j in range(chunks):
            gridsum += (np.sum((coords[:, i*chunk_size:(i+1)*chunk_size].T + coords[:, j*chunk_size:(j+1)*chunk_size]) <= 0.25) / TOTAL)
    # gridsum = np.sum((coords.T + coords) <= 0.25)
    return (gridsum) * 4

if __name__ == '__main__':
    t = time()
    parser = argparse.ArgumentParser()
    parser.add_argument('--size', '-s', default=1000, type=int, help="Number of points along one side of unit square.")
    args = parser.parse_args()
    pi = estimate(args.size)
    print(f"Runtime {round(time() - t, 4)}s. Estimate: {pi}")