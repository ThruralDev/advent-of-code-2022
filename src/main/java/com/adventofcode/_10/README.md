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