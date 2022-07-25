This project tested two methods of estimating pi - one by running trials, and one by estimating areas.

## Trials - RandomPi.java

This program runs T trials, each generating a 2 random integers between 1 and N. It keeps track of proportion of these trials that generated 2 coprimes. Using this proportion, and the knowledge that the probability of two random numbers in the interval (1, N) being coprime approaches 6/pi^2 as N approaches infinity, one can estimate pi.

### Usage

Compile: `javac RandomPi.java`  
Run: `java RandomPi N T`

## Areas - PrizeQuestion.java

This program was written as part of a small class competition. It estimates pi using the area of a circle inscribed in a unit square. The program takes as argument the number of 'subdivisions' or points per axis N to consider in the unit square. It calculates the proportion of these points that fall inside the circle, using this proportion as estimate for the area of the circle. Using this, and the formula for calculating the area of a circle, one can estimate pi.

### Usage

Compile: `javac PrizeQuestion.java`  
Run: `java PrizeQuestion N`
