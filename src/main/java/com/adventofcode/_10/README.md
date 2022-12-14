# Core information in description

- Both driven by a *precise* clock circuit.
- The clock circuit ticks at a *constant* rate; each *tick* is called a *cycle*.
- Figuring out the signal being sent by the CPU.
- The CPU has a single register, X, which starts with the value 1. It supports *only two* instructions.
- 1. 'addx' V takes *two cycles* to complete. *After two cycles*, the *X register is increased by the value V*. (V can be negative.)
- 2. noop takes one cycle to complete. It has no other effect.
- The CPU uses these instructions in a program (your puzzle input) to, somehow, tell the screen what to draw.
- Signal strength is registrar X multiplied by cycle number. The breakpoints for that should be handled in a set of integers.

# Do in Challenge 1 to stay flexible

1. Variable number of cycles in 'addx' until x is summed up.
2. Make class of Signal Strength in a class to stay extensible and testable.

# Notes to Challenge 2

- A Sprite is 3 pixels wide.
- Draws a single pixel during each cycle.
- X register horizontal position of middle of the sprite.
- Display has a width of 40 pixel and can have various number of rows below.

Output of short input produce this image:

<pre>
##..##..##..##..##..##..##..##..##..##..
###...###...###...###...###...###...###.
####....####....####....####....####....
#####.....#####.....#####.....#####.....
######......######......######......####
#######.......#######.......#######.....
</pre>

If cycle draws a pixel on one of the sprite's position in the horizontal, then a '#' is added.
The sprite moves his position when registrar X is updated.

So we need to keep track of sprites position in tube and then check if the cycles index
appears in these positions. Then the display rows are going to be created

