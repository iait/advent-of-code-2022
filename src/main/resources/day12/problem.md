# Day 12 - Hill Climbing Algorithm

Your puzzle input is a heightmap of the surrounding area.

The elevation of each square of the grid is given by a single lowercase letter `a-z`.

Also included in the map are marks for your current position `S` and the location you should get the best signal `E`.

You'd like to reach `E` in as few steps as possible.

During each step, you can move exactly one square up, down, left, or right.

The elevation of the destination square can be at most one higher than the elevation of your current square.

```
Sabqponm
abcryxxl
accszExk
acctuvwj
abdefghi
```

### Part one

Find the minimum number of steps needed to move from your current position `S` to the goal `E`.

### Part two

You need to find the shortest path from any square at elevation `a` to the square marked `E`.

What is the fewest steps required to move starting from any square with elevation `a` to the location that should get the best signal?