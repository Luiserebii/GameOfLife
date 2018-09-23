# Conway's Game Of Life
Game of Life implemented in JavaFX. Includes various options such as the ability to choose the size of the board, change the cells' colors, and set the initial seed.

<br>
<div align="center"><img src="http://i.imgur.com/ULnjTyJ.png"/></div><br>
Image of Game Of Life Initialize Settings window
<br>
<br>

## Features

### Size input: 
The length/width parameters set the board to a specific size, by pixels.

### Color:
Color can be input by typing in a string that matches any one of the JavaFX Color API's static fields: https://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html. Hex color codes can also be input, as can RGB values through the following syntax: "#7FFFD4" and "rgb(127,255,212)" respectively. 
To set the color, press <b>Enter</b> while the color input box is in focus.
<br><b>Rainbow:</b> Checking the Rainbow option will lock the selected color, and cause cells to generate as random colors.

### Seed:
This allows the user to select the initial seed. <b>"Random Board"</b> will generate a random initial seed, each cell having a 50% chance of being born. <b>"10 Cell Seed"</b> generates a row of 10 cells in the center.

### Rules:
Leaving "Chaos Mode" unchecked will result in using the traditional Game Of Life rules. "Chaos Mode" is a modified version of the original, allowing for more cell survival. <b>Try this with a 10 Cell Seed!</b>

### Initialization: 
To generate a board of cells with the selected options, just click "Initialize Game of Life"!
<br>

## Sample Board: 
![alt tag](http://i.imgur.com/xW0ZF5J.png)<br>
Sample Game of Life board under default options. (600px x 400px)
<br>
<br>
## Future Implementation
* More seed options, perhaps even custom user seeds, which can be created through a simple UI and saved to file. "10 Cell Seed" could become "X Cell Seed," perhaps with a box input on the right of the combobox to provide the X?
* Rules insensitive to the board's edges - the size of the board influences whether certain cells live or die, not quite the infinite grid Game of Life is supposed to be simulated on. Perhaps even allow the user to drag around and view more of the grid?
* More rules options, custom user rules?
* Color options for the game's board
* Color coding cells which never died/were never born
* Allow for setting the pixel size of every cell
* Better UI - current one is not the most attractive GUI

-----------------------------------------------------------------------------------------

## Appendix

### A. Wikipedia: Conway's Game of Life - Excellent Summary on the Algorithm: https://en.wikipedia.org/wiki/Conway's_Game_of_Life

### B. Conway's Game Of Life on <i>Stephen Hawking's Grand Design</i>, Episode 1 - "The Meaning of Life": https://www.youtube.com/watch?v=CgOcEZinQ2I

### C. Complex implementation of Conway's Game Of Life (cool to watch!): https://www.youtube.com/watch?v=C2vgICfQawE

### D. "Life in Life" - Meta Game Of Life: https://www.youtube.com/watch?v=xP5-iIeKXE8

