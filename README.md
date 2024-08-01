# Maxwell's Demon

The 19th century mathematical physicist, James Maxwell, is best known for developing a set of
four equations (known as Maxwell's equations) that describe classical electromagnetism. He also
made contributions to statistical thermodynamics, producing the Maxwell-Boltzman distribution for
ideal gas behavior. It was during this work that he conceived of a thought experiment in which
the second law of thermodynamics (entropy) might be violated.

> ... if we conceive of a being whose faculties are so sharpened that he can follow every molecure
> in its course, such a being, whose attributes are as essentially finite as our own, would be able
> to do what is impossible to us. For we have seen that molecules in a vessel full of air at
> uniform temperature are moving with velocities by no means uniform. Now let us suppose that such
> a vessel is divided into two portions, A and B, by a division in which there is a small hole,
> and that a being, who can see the individual molecules, opens and closes this hole, so as took
> allow only the swifter molecules to pass from A to B, and only the slower molecules to pass from
> B to A, in contradiction to the second law of thermodynamics.
- Bennet, Charles H. (November 1987). "Demons, Engines, and the Second Law" (PDF). Scientific
  American. 257(5): 108-116.
  
In other words, Maxwell envisioned a box split into two halves, with a door between the parts that
could be opened or closed by a "demon" who observed every particle in the box. By carefully opening
and closing the door at the correct moments, the demon could place all the fast-moving (i.e., hot)
particles on one side of the door and all the slow-moving (i.e., cold) particles on the other side,
reducing the entropy of the system.


#### The Maxwell's Demon GUI

When a player begins a game of Maxwell's Demon, they see a graphical display that includes all of the following components:
- A rectangular "play area" which is divided into two halves by a wall through the middle.
   - The wall contains a "door" which spans (roughly) the middle third of the wall.
- Two "temperature" displays; one for each chamber of the play area
- Two buttons  control gameplay
   - A "reset" button which, when pressed, returns the game to its initial state (that is, as if
     the game was being opened and started for the first time)
   - An "add particles" button which, when pressed, introduces new particles into the game

The player controls the door (in the wall separating the chambers) using the mouse. When the mouse
button is *pressed* (that is, pushed and held), the door opens; when the button is
*released* (that is, not pushed), the door closes. 

#### Hot and cold particles

During a game of Maxwell's Demon, the players see particles which animate within the play area. These particles are visually separated into hot (red) and cold (blue) particles, based on their speed.
- A hot (red) particle should have an on-screen speed of between 4 and 6 cm/s
- A cold (blue) particle should have an on-screen speed of between 2 and 4 cm/s

The speed of a newly created particle is chosen randomly from within the specified range; e.g., not all hot particles will have exactly the same speed. Under the simplified kinematics of this project, a particle will not change it speed (or color) after creation.

Particles remain within the play area by reflecting (elastically) off of the boundary walls, the center wall, and the door (while closed). Particles do *not* need to reflect off of each other.

#### Starting particles and adding particles

At the start of a game (or after the reset button is pressed), there will be exactly four particles in the game. Specifically, each chamber contains both a hot particle and a cold particle.

Whenever the add button is pressed, four new particles are added to the game. Just as at the start of the game, this adds a new hot particle and a new cold particle to both chambers. Adding particles in this way does not affect any existing particles or their location (if the game has been running for some time).

#### Computing the temperature of a chamber

Displays the "temperature" of both chambers of the play area. In the simplified kinetic model for this game, temperature is calculated as the *average of the squared speeds* of the particles. 

(We are essentially ignoring physical units in this calculation, but otherwise adhering to real
physics; the temperature of an ideal gas is proportional to the average kinetic energy of the
particles. For those with an interest in numerical simulation of physical systems, see
[this Wikipedia article](http://en.wikipedia.org/wiki/Kinetic_theory_of_gases#Temperature_and_kinetic_energy).


