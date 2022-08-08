# MouseRace
# Author: Yonatan Yavin

## General explanation:
There are different elements on the screen.
Every element has:

· Type:
- Chase: Move towards the mouse
- Escape: Move away from the mouse
- Random: Move in a straight line. When he hits the end of the screen, switch direction randomly

· Shape:
  circle, square, rectangle.
  Determined by type: Circle - Chase, Square - Escape, Rectangle - Random

· Size (random)

· Speed (random)

## The rules of the game:
When you click ‘Start’ all the elements appear in random places. The player has a score that is shown on the screen, it goes up by 1 each second. At any given moment, an element moves within the logic determined by its type. When an element touches the mouse, it performs his ‘onHitTarget’ function, by the type of element:
- Chase: Game Over
- Random: Game Over
- Escape: The player gains 5 points and the element launches to a random place on the screen.

## Start
- The game starts from StartGame.java
- Each game launched by StartGame.java runs on Game.java
