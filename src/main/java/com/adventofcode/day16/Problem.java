package com.adventofcode.day16;

import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;
import static java.lang.Math.max;
import static java.util.Arrays.copyOf;

public class Problem {

    private static final Pattern pattern = Pattern.compile(
       "Valve ([A-Z]{2}) has flow rate=(\\d+); tunnels? leads? to valves? ([A-Z]{2}(, [A-Z]{2})*)");

    private final int size;
    private final Map<String, Integer> valveNames;
    private final Map<Integer, Valve> valves;

    public Problem(List<String> lines) {
        Map<String, Integer> valveNames = new HashMap<>();
        for (int i = 0; i < lines.size(); i++) {
            var line = lines.get(i);
            var matcher = pattern.matcher(line);
            if (!matcher.find()) {
                throw new RuntimeException("Unexpected line: " + line);
            }
            String name = matcher.group(1);
            valveNames.put(name, i);
        }
        Map<Integer, Valve> valves = new HashMap<>();
        for (String line : lines) {
            var matcher = pattern.matcher(line);
            if (!matcher.find()) {
                throw new RuntimeException("Unexpected line: " + line);
            }
            String name = matcher.group(1);
            int rate = parseInt(matcher.group(2));
            List<Integer> tunnels = Arrays.stream(matcher.group(3).split(", "))
                    .map(valveNames::get).toList();
            valves.put(valveNames.get(name), new Valve(rate, tunnels));
        }
        this.size = lines.size();
        this.valveNames = Collections.unmodifiableMap(valveNames);
        this.valves = Collections.unmodifiableMap(valves);
    }

    private Map<State, Integer> pressureMap;
    private int max;

    public int solve() {
        pressureMap = new HashMap<>();
        max = 0;
        int initialValve = valveNames.get("AA");
        var initialState = new State(initialValve, initialValve, new boolean[size]);
        pressureMap.put(initialState, 0);
        for (int i = 1; i <= 26; i++) {
            List<Entry<State, Integer>> entries = new ArrayList<>(pressureMap.entrySet());
            pressureMap = new HashMap<>();
            for (Entry<State, Integer> entry : entries) {
                State state = entry.getKey();
                Integer pressure = entry.getValue();
                int closedValvesPressure = 0;
                for (int j = 0; j < state.getOpenValves().length; j++) {
                    if (!state.getOpenValves()[j]) {
                        closedValvesPressure += valves.get(j).getRate();
                    }
                }
                if (closedValvesPressure * (26 - i) + pressure > max) {
                    expand(state, pressure, 26 - i);
                }
            }
        }
        return max;
    }

    public void expand(State state, int pressure, int time) {
        boolean[] openValves = state.getOpenValves();
        int valve1 = state.getValve1();
        int valve2 = state.getValve2();
        if (!openValves[valve1] && valves.get(valve1).getRate() > 0) {
            // open valve 1
            boolean[] newOpenValves = copyOf(openValves, openValves.length);
            newOpenValves[valve1] = true;
            int newPressure = pressure + time * valves.get(valve1).getRate();
            if (!newOpenValves[valve2] && valves.get(valve2).getRate() > 0) {
                // open valve 2
                boolean[] newestOpenValves = copyOf(newOpenValves, openValves.length);
                newestOpenValves[valve2] = true;
                int newestPressure = newPressure + time * valves.get(valve2).getRate();
                State newState = new State(valve1, valve2, newestOpenValves);
                if (!pressureMap.containsKey(newState)
                        || pressureMap.get(newState) < newestPressure) {
                    pressureMap.put(newState, newestPressure);
                    max = max(max, pressure);
                }
            }
            for (Integer newValve2 : valves.get(valve2).getTunnels()) {
                // move valve 2
                State newState = new State(valve1, newValve2, newOpenValves);
                if (!pressureMap.containsKey(newState)
                        || pressureMap.get(newState) < newPressure) {
                    pressureMap.put(newState, newPressure);
                    max = max(max, pressure);
                }
            }
        }
        for (Integer newValve1 : valves.get(valve1).getTunnels()) {
            // move valve 1
            if (!openValves[valve2] && valves.get(valve2).getRate() > 0) {
                // open valve 2
                boolean[] newOpenValves = copyOf(openValves, openValves.length);
                newOpenValves[valve2] = true;
                int newPressure = pressure + time * valves.get(valve2).getRate();
                State newState = new State(newValve1, valve2, newOpenValves);
                if (!pressureMap.containsKey(newState)
                        || pressureMap.get(newState) < newPressure) {
                    pressureMap.put(newState, newPressure);
                    max = max(max, pressure);
                }
            }
            for (Integer newValve2 : valves.get(valve2).getTunnels()) {
                // move valve 2
                State newState = new State(newValve1, newValve2, openValves);
                if (!pressureMap.containsKey(newState)
                        || pressureMap.get(newState) < pressure) {
                    pressureMap.put(newState, pressure);
                    max = max(max, pressure);
                }
            }
        }
    }
}
