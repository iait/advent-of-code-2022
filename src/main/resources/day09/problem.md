# Day 9 - Rope Bridge

The objective is to determine how the tail knot of a rope moves with a series of motions of the head knot of the rope.

The head (H) and tail (T) must always be touching.

If the head is two steps up, down, left, or right from the tail, the tail must also move one step in that direction.

```
.....    .....
.T.H. -> ..TH.
.....    .....
```

If the head and tail aren't touching and aren't in the same row or column, the tail moves one step diagonally.

```
.....    .....
..H..    ..H..
..... -> ..T..
.T...    .....
.....    .....
```

You just need to work out where the tail goes as the head follows a series of motions.

Example:

```
R 4
U 4
L 3
D 1
R 4
D 1
L 5
R 2
```

### Part One

The objective is to count up all the positions the tail visited at least once.

### Part Two

Now the rope has 10 knots marked H, 1, 2, 3, 4, 5, 6, 7, 8, 9.

Each knot follows the previous one with the same rules described before.

The objective is to count the positions the tail of the rope (knot 9) visits at least once.

