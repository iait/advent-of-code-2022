# Day 10 - Cathode-Ray Tube

You need to design a replacement for the device's video system.

The signal sent starts with the value 1.

Instructions:

* `addx V`. After two cycles the X register is increased by V.
* `noop`. Takes one cycle and has no other effect.

Your input will be a set of instructions.

### Part one

The objective is to find the **signal strength** (cycle multiplied by the value of the X register) during the 20th cycle an every 40 cycles after that (i.e. 20th, 60th, 100th, 140th, 180th, and so on).

Then, compute the sum of these signal strengths.

### Part two

The X register controls the horizontal position of a 3-pixel wide sprite.

Your CRT has 40 pixels wide and 6 pixels high.

The CRT draws a single pixel during each cycle; first it draws the top row of pixels left-to-right, then the row below that, and so on.

If the sprite is positioned such that one of its three pixels is the pixel currently being drawn, the screen produces a lit pixel (`#`); otherwise, the screen leaves the pixel dark (`.`).

```
addx 15
addx -11
addx 6
addx -3
addx 5
addx -1
addx -8
addx 13
addx 4
noop
addx -1
addx 5
addx -1
addx 5
addx -1
addx 5
addx -1
addx 5
addx -1
addx -35
addx 1
addx 24
addx -19
addx 1
addx 16
addx -11
noop
noop
addx 21
addx -15
noop
noop
addx -3
addx 9
addx 1
addx -3
addx 8
addx 1
addx 5
noop
noop
noop
noop
noop
addx -36
noop
addx 1
addx 7
noop
noop
noop
addx 2
addx 6
noop
noop
noop
noop
noop
addx 1
noop
noop
addx 7
addx 1
noop
addx -13
addx 13
addx 7
noop
addx 1
addx -33
noop
noop
noop
addx 2
noop
noop
noop
addx 8
noop
addx -1
addx 2
addx 1
noop
addx 17
addx -9
addx 1
addx 1
addx -3
addx 11
noop
noop
addx 1
noop
addx 1
noop
noop
addx -13
addx -19
addx 1
addx 3
addx 26
addx -30
addx 12
addx -1
addx 3
addx 1
noop
noop
noop
addx -9
addx 18
addx 1
addx 2
noop
noop
addx 9
noop
noop
noop
addx -1
addx 2
addx -37
addx 1
addx 3
noop
addx 15
addx -21
addx 22
addx -6
addx 1
noop
addx 2
addx 1
noop
addx -10
noop
noop
addx 20
addx 1
addx 2
addx 2
addx -6
addx -11
noop
noop
noop
```
