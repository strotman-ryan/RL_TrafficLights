# RL_TrafficLights
Practice using different RL algorithms on the traffic light problem


Traffic Handling

Problem:
	- people wait to long at intersections
	- the light may be red and someone is waiting while no one is
	  utilizing the green light
	- lights are not synched up so that traffic can be easily backed up

How to measure success/failure
    - there are many different ways to rate a soltuion
    - notation
      - waitTime = actual time - time if no traffic and light green
    - total wait time
      - rational: this otimizes the utility function for society
      - SUM(over all cars)(waitTime)
      - benefits: this maximizes the utility of society
      - drawbacks: a side street may never get to go (starvation)
    - total exponential time
      - no one should wait a long time the longer you weight your cost goes up
      - E(over all cars)(f(wait time))
      - f(wait time) is some function greater than linear (ei. quadratic, exponential)
      - benefits: everyone will eventually go
      - drawbacks: doesnt minimize full wait time of society
    - maximum wait time
      - value is the waitTime of the car with the greatest waitTime
      - MAX(over all cars)(waitTime)
      - benefits: minimizes the max wait time for everyone, everyone goes
      - drawbacks: total waitTime of society could be high

Define the problem
    - I will go through a number of different scenarios

    - Scenario 1: Single Lane with no turning
        - There is one intersection with two roads perpendicular
	- each road is a two lane road
	  - ie. One lane each direction
	- all cars keep going straight
	  - ie. a car going north will contine north thrugh the intersection
	- there are 2 states the lights can be in
	  1. Green light for the North South(NS) traffic and red for East West(EW)
	  2. Green light for EW and red for NS
	- cars can only move across the intersection when they have a green light
	- The lights can be on for an arbitrarily discrete time
	- time will be broken up into time steps
	- lights can be on for however many time steps
	- One car moves across the intersection per time step
	- the lights can change at anytime beween time steps
	- The traffic light can sense how many cars are waiting at a light
	  - They cannot sense if a car is incoming however
	- cars arrive at an intersection according to some distribution beween time steps
	- waitTime (see 'how to measure success and failure') is measured by how many time steps a car waits at a light
	  - a car will have a wait time of zero if
      	    - it arrives at the intersection
	    - there is no waiting cars in its lane
	    - the light is green for it
	- what all happens in a time step
	  1. The lights change if the algorithm changes it
	  2. Cars arrive at the intersection and wait
	  3. If a car is the first in the Queue and its light is green it passes through
	  4. All cars remaining at the intersection add 1 to the time it has waited
	- Algorithms to run
	  - Basic 

	
