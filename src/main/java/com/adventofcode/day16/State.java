package com.adventofcode.day16;

import java.util.Arrays;
import java.util.Objects;

public class State {

    private final int valve1, valve2;
    private final boolean[] openValves;

    public State(int valve1, int valve2, boolean[] openValves) {
        this.valve1 = valve1;
        this.valve2 = valve2;
        this.openValves = openValves;
    }

    public int getValve1() {
        return valve1;
    }

    public int getValve2() {
        return valve2;
    }

    public boolean[] getOpenValves() {
        return openValves;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return valve1 == state.valve1
                && valve2 == state.valve2
                && Arrays.equals(openValves, state.openValves);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(valve1, valve2);
        result = 31 * result + Arrays.hashCode(openValves);
        return result;
    }
}
