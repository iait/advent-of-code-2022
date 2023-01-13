package com.adventofcode.day16;

import com.adventofcode.Solver;

import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;
import static java.lang.Math.max;
import static java.util.Collections.unmodifiableSet;
import static java.util.Set.copyOf;

public class PressureRelease extends Solver {

    private static final Pattern pattern = Pattern.compile(
        "Valve ([A-Z]{2}) has flow rate=(\\d+); tunnels? leads? to valves? ([A-Z]{2}(, [A-Z]{2})*)");

    record Valve(String name, int rate, String[] tunnels) {}
    record State(Set<Valve> currentValves, Set<Valve> openValves) {}

    public PressureRelease() {
        super(16);
    }

    @Override
    public String solvePartOne(List<String> lines) {
        Map<String, Valve> valves = parseInput(lines);
        int maxPressure = 0;
        Map<State, Integer> stateMap = new HashMap<>();
        stateMap.put(new State(Set.of(valves.get("AA")), Set.of()), 0);
        for (int i = 1; i <= 30; i++) {
            Map<State, Integer> newStateMap = new HashMap<>();
            for (Entry<State, Integer> entry : stateMap.entrySet()) {
                State state = entry.getKey();
                Valve currentValve = state.currentValves.iterator().next();
                Integer pressure = entry.getValue();
                if (!state.openValves.contains(currentValve) && currentValve.rate > 0) {
                    HashSet<Valve> newOpenValves = new HashSet<>(state.openValves);
                    newOpenValves.add(currentValve);
                    State newState =
                            new State(state.currentValves, unmodifiableSet(newOpenValves));
                    int newPressure = max(
                            newStateMap.getOrDefault(newState, 0),
                            pressure + (30 - i) * currentValve.rate);
                    newStateMap.put(newState, newPressure);
                    maxPressure = max(maxPressure, newPressure);
                }
                for (String tunnel : currentValve.tunnels) {
                    State newState =
                            new State(Set.of(valves.get(tunnel)), copyOf(state.openValves));
                    int newPressure = max(
                            newStateMap.getOrDefault(newState, 0),
                            pressure);
                    newStateMap.put(newState, newPressure);
                    maxPressure = max(maxPressure, newPressure);
                }
            }
            stateMap = newStateMap;
        }
        return String.valueOf(maxPressure);
    }

    @Override
    public String solvePartTwo(List<String> lines) {
        var problem = new Problem(lines);
        return String.valueOf(problem.solve());
    }

    private Map<String, Valve> parseInput(List<String> lines) {
        Map<String, Valve> valves = new HashMap<>();
        for (String line : lines) {
            var matcher = pattern.matcher(line);
            if (!matcher.find()) {
                throw new RuntimeException("Unexpected line: " + line);
            }
            String name = matcher.group(1);
            int rate = parseInt(matcher.group(2));
            String[] tunnels = matcher.group(3).split(", ");
            valves.put(name, new Valve(name, rate, tunnels));
        }
        return valves;
    }

    public static void main(String[] args) {
        System.out.println("test");
        Set<Integer> set = Set.of(1, 2);
        Integer[] array = set.toArray(new Integer[1]);
        System.out.println(Arrays.toString(array));
    }
}
