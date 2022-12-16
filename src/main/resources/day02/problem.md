# Day 2 - Rock, Paper, Scissors

The input is a strategy guide.
The first column is what your opponent is going to play.
The second column is what you should play in response (because winning every time would be suspicious).
```
A Y
B X
C Z
```

Score = shape you selected + outcome of the round

Shape:
* Rock - 1
* Paper - 2
* Scissors - 3

Outcome:
* Lost - 0
* Draw - 3
* Won - 6

The goal is to calculate the score you would get if you were to follow the strategy guide.

## Part Two

Now the second column says how the round needs to end:
* X - Lost
* Y - Draw
* Z - Won

The goal is again to calculate the score if you follow the strategy.