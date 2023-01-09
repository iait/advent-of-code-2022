# Day 15 - Beacon Exclusion Zone

Sensors and beacons always exist at integer coordinates.

Each sensor knows its own position and can determine the position of its closest beacon as measured by the Manhattan distance.

```
Sensor at x=2, y=18: closest beacon is at x=-2, y=15
Sensor at x=9, y=16: closest beacon is at x=10, y=16
Sensor at x=13, y=2: closest beacon is at x=15, y=3
Sensor at x=12, y=14: closest beacon is at x=10, y=16
Sensor at x=10, y=20: closest beacon is at x=10, y=16
Sensor at x=14, y=17: closest beacon is at x=10, y=16
Sensor at x=8, y=7: closest beacon is at x=2, y=10
Sensor at x=2, y=0: closest beacon is at x=2, y=10
Sensor at x=0, y=11: closest beacon is at x=2, y=10
Sensor at x=20, y=14: closest beacon is at x=25, y=17
Sensor at x=17, y=20: closest beacon is at x=21, y=22
Sensor at x=16, y=7: closest beacon is at x=15, y=3
Sensor at x=14, y=3: closest beacon is at x=15, y=3
Sensor at x=20, y=1: closest beacon is at x=15, y=3
```

None of the detected beacons seem to be producing the distress signal, so you'll need to work out where the distress beacon is by working out where it isn't.

In the row with `y=10` there are `26` positions where a beacon cannot be present.

The distress beacon must have `x` and `y` coordinates each no lower than `0` and no larger than `20`.

The **tuning frequency** can be obtained multiplying the `x` coordinate by `4000000` and then adding the `y` coordinate of the distress beacon. 

### Part one

In the row with `y=2000000` find how many positions cannot contain a beacon.

### Part two

The distress beacon must have `x` and `y` coordinates each no lower than `0` and no larger than `4000000`.

Find the only possible position of the distress beacon and return its tuning frequency.