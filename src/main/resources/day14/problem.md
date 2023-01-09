# Day 14 - Regolith Reservoir

The input is a scan of a two-dimensional vertical slice of the cave above you.

The scan traces the path of each solid rock and reports a sequence of `x,y` coordinates that form the shape of the path, where `x` is distance to the right and `y` is distance down.

```
498,4 -> 498,6 -> 496,6
503,4 -> 502,4 -> 502,9 -> 494,9
```

Each point indicates the end of a straight horizontal or vertical line to be drawn from the previous point.

```
2v 2<
1< 5v 8<
```

```
  4     5  5
  9     0  0
  4     0  3
0 ......+...
1 ..........
2 ..........
3 ..........
4 ....#...##
5 ....#...#.
6 ..###...#.
7 ........#.
8 ........#.
9 #########.
```

The sand is pouring into the cave from point `500,0`.

Sand is produced **one unit at a time**, and the next unit of sand is not produced until the previous unit of sand **comes to rest**.

A unit of sand always falls **down one step** if possible. 

If the tile immediately below is blocked (by rock or sand), the unit of sand attempts to instead move **diagonally one step down and to the left**.

If that tile is blocked, the unit of sand attempts to instead move **diagonally one step down and to the right**.

If all three possible destinations are blocked, the unit of sand **comes to rest**.

### Part one

Find how many units of sand come to rest before sand starts flowing into the abyss below.

### Part two

The floor is an infinite horizontal line with a `y` coordinate equal to two plus the highest `y` coordinate of your scan.

To find somewhere safe to stand, you'll need to simulate falling sand until a unit of sand comes to rest at `500,0`, blocking the source entirely and stopping the flow of sand into the cave.

