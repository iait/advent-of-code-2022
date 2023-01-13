# Day 16 - Proboscidea Volcanium

Your device estimates that you have 30 minutes before the volcano erupts.

You scan the cave and discover a network of pipes and pressure-release valves.

Your device produces a report of each valve's flow rate if it were opened (in pressure per minute) and the tunnels you could use to move between the valves.

You estimate it will take you one minute to open a single valve and one minute to follow any tunnel from one valve to another.

```
Valve AA has flow rate=0; tunnels lead to valves DD, II, BB
Valve BB has flow rate=13; tunnels lead to valves CC, AA
Valve CC has flow rate=2; tunnels lead to valves DD, BB
Valve DD has flow rate=20; tunnels lead to valves CC, AA, EE
Valve EE has flow rate=3; tunnels lead to valves FF, DD
Valve FF has flow rate=0; tunnels lead to valves EE, GG
Valve GG has flow rate=0; tunnels lead to valves FF, HH
Valve HH has flow rate=22; tunnel leads to valve GG
Valve II has flow rate=0; tunnels lead to valves AA, JJ
Valve JJ has flow rate=21; tunnel leads to valve II
```

If you spend one minute going to the valve `BB` and another minute opening it, the valve will release pressure during the remaining `28` minutes, a total of `28 * 13 = 364`.

### Part one

Find the most pressure that can be released in 30 minutes. 

### Part two

One of the elephants will help you to open the valves.

It would take you 4 minutes to teach the elephant, leaving you only 26 minutes to execute the plan.

Find the most pressure that can be released with to executors in 26 minutes.