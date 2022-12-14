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

Registrar is now 16 while signal Signal[instruction=addx, value=-9] and cycle 179.
Registrar is now 16 while signal Signal[instruction=addx, value=-9] and cycle 180.
Current Signal has strength of 2880 and created with registrar 16 and cycle 180

Registrar is now 21 while signal Signal[instruction=addx, value=1] and cycle 139.
Registrar is now 21 while signal Signal[instruction=addx, value=1] and cycle 140.
Current Signal has strength of 2940 and created with registrar 21 and cycle 140

Registrar is now 18 while signal Signal[instruction=noop, value=0] and cycle 99.
Registrar is now 18 while signal Signal[instruction=noop, value=0] and cycle 100.
Current Signal has strength of 1800 and created with registrar 18 and cycle 100

Registrar is now 19 while signal Signal[instruction=addx, value=-3] and cycle 59.
Registrar is now 19 while signal Signal[instruction=addx, value=-3] and cycle 60.
Current Signal has strength of 1140 and created with registrar 19 and cycle 60

Registrar is now 21 while signal Signal[instruction=addx, value=-1] and cycle 19.
Registrar is now 21 while signal Signal[instruction=addx, value=-1] and cycle 20.
Current Signal has strength of 420 and created with registrar 21 and cycle 20