# Labyrinth escaper!
## IN1010 Assignment 6 H22
This program uses recursion to find ways out of labyrinths. The labyrinths are grids consisting of squares that are either walls or not. 
A couple labyrinths can be found in the labyrinter directory, where each file corresponds to one labyrinth.

## Get to know the labyrinth files
All files in the labyrinter directory have the same setup. The first line consists of two positive integers, the first one determining the number of rows and the second 
one determining the number of columns of the labyrinth.
- White squares (not wall, free to roam) are represented by . (full stop).
- Black squared (wall, cannot walk through), are represented by # (hashtag).
- Other characters (white space and new lines) are to be ignored.

## Example on how to run program
```
>java Oblig6 3.in
Slik ser labyrinten ut:
# # # # # # # # # # # # #
. . # . . . . . . . . . #
# . # # # # # # # . # # #
# . . . # . . . # . # . #
# # # . # . # . # # # . #
# . # . # . # . . . . . #
# . # . # . # # # # # # #
# . . . # . . . . . . . #
# . # # # # # # # # # . #
# . # . . . . . . . . . #
# . # . # # # # # # # . #
# . . . # . . . . . . . .
# # # # # # # # # # # # #

Skriv inn koordinater <rad> <kolonne> ('-1' for aa avslutte)
>3 5

Aapninger:
(1,0)
(11,12)

Utveier:
  Loesning nr 1:
(3,5) (4,5) (5,5) (6,5) (7,5) (7,6) (7,7) (7,8) (7,9) (7,10) (7,11)
(8,11) (9,11) (9,10) (9,9) (9,8) (9,7) (9,6) (9,5) (9,4) (9,3)
(10,3) (11,3) (11,2) (11,1) (10,1) (9,1) (8,1) (7,1) (7,2) (7,3)
(6,3) (5,3) (4,3) (3,3) (3,2) (3,1) (2,1) (1,1) (1,0)

  Loesning nr 2:
(3,5) (4,5) (5,5) (6,5) (7,5) (7,6) (7,7) (7,8) (7,9) (7,10) (7,11)
(8,11) (9,11) (10,11) (11,11) (11,12)

2 loesninger funnet

Skriv inn nye koordinater ('-1' for aa avslutte)
>1 5

Aapninger:
Utveier:

0 loesninger funnet

Skriv inn nye koordinater ('-1' for aa avslutte)
>-1

```
