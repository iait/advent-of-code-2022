# Day 13 - Distress signal

The input is a list of pair of packets, separated by a blank line.

Each packet is a list that contains zero or more comma-separated values (either integers or other lists).

You need to identify how many pairs of packets are in the right order, according to the following rules:

* If both values are integers, the lower integer should come first.
* If both values are lists, compare the first value of each list, then the second, and so on. If the left list runs out of items first, the input is in the right order.
* If exactly one value is an integer, convert the integer to a list which only contains that integer and compare.

```
[1,1,3,1,1]
[1,1,5,1,1]

[[1],[2,3,4]]
[[1],4]

[9]
[[8,7,6]]

[[4,4],4,4]
[[4,4],4,4,4]

[7,7,7,7]
[7,7,7]

[]
[3]

[[[]]]
[[]]

[1,[2,[3,[4,[5,6,7]]]],8,9]
[1,[2,[3,[4,[5,6,0]]]],8,9]
```

### Part one

Determine which pairs of packets are in the right order and sum its indices.

### Part two

Sort all the packets disregarding the blank lines and adding two additional packets:

```
[[2]]
[[6]]
```

Locate the added packets and multiply their indices.