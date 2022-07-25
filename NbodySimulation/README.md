Simulates a system of bodies and their gravitational action on each other.  

### Usage

Compile: `javac universeSim.java`  
Run: `java universeSim`  
  
The program will prompt you to populate the universe/system with details about each body using standard keyboard input:  
First, the number of bodies in the system.  
Followed by the radial size to plot these bodies in (i.e. relative size of the canvas).  
Then, for each body, provide the following 5 values in order:  
x-coordinate, y-coordinate ( (0, 0) is the centre of the canvas ), initial x-velocity, initial y-velocity, mass.  
  
After receiving details of the system, it will begin simulating the system in a series of timesteps, until the program is closed.  
  
Provided is to sample Universe files that can be used as input for the program. Universe1 is a 4-body universe that oscillate around the centre of the canvas. Universe2 is a model of our solar system with the 8 major planets.
