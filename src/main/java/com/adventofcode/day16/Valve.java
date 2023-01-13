package com.adventofcode.day16;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Valve {

    private final int rate;
    private final List<Integer> tunnels;

    public Valve(int rate, List<Integer> tunnels) {
        this.rate = rate;
        this.tunnels = Collections.unmodifiableList(tunnels);
    }

    public int getRate() {
        return rate;
    }

    public List<Integer> getTunnels() {
        return tunnels;
    }
}
