package com.adventofcode.day13;

import com.adventofcode.Solver;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DistressSignal extends Solver {

    public DistressSignal() {
        super(13);
    }

    @Override
    public String solvePartOne(List<String> lines) {
        int sum = 0;
        int i = 0;
        while (i < lines.size()) {
            Packet first = parsePacket(lines.get(i++));
            Packet second = parsePacket(lines.get(i++));
            if (first.compareTo(second) < 0) {
                sum += (i + 1) / 3;
            }
            i++;
        }
        return String.valueOf(sum);
    }

    @Override
    public String solvePartTwo(List<String> lines) {
        List<Packet> packets = new ArrayList<>();
        int i = 0;
        while (i < lines.size()) {
            packets.add(parsePacket(lines.get(i++)));
            packets.add(parsePacket(lines.get(i++)));
            i++;
        }
        Packet key1 = createKeyPacket(2);
        Packet key2 = createKeyPacket(6);
        packets.add(key1);
        packets.add(key2);
        packets.sort(null);
        int result = 1;
        for (int j = 0; j < packets.size(); j++) {
            if (packets.get(j) == key1 || packets.get(j) == key2) {
                result *= j + 1;
            }
        }
        return String.valueOf(result);
    }

    private Packet createKeyPacket(int value) {
        return new ListPacket(new Packet[]{new ListPacket(
                new Packet[]{new IntegerPacket(value)})});
    }

    private Packet parsePacket(String line) {
        var om = new ObjectMapper();
        try {
            return parseNode(om.readTree(line));
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Parsing error", e);
        }
    }

    private Packet parseNode(JsonNode node) {
        if (node.isInt()) {
            return new IntegerPacket(node.intValue());
        }
        if (node.isArray()) {
            Packet[] list = new Packet[node.size()];
            for (int i = 0; i < node.size(); i++) {
                list[i] = parseNode(node.get(i));
            }
            return new ListPacket(list);
        }
        throw new RuntimeException("Unknown type");
    }
}

interface Packet extends Comparable<Packet> {}
record ListPacket(Packet[] list) implements Packet {
    @Override
    public int compareTo(Packet o) {
        if (o instanceof ListPacket) {
            return Arrays.compare(list, ((ListPacket) o).list());
        }
        if (o instanceof IntegerPacket) {
            return compareTo(new ListPacket(new Packet[]{o}));
        }
        throw new RuntimeException("Unknown type");
    }
}
record IntegerPacket(int value) implements Packet {
    @Override
    public int compareTo(Packet o) {
        if (o instanceof IntegerPacket) {
            return value - ((IntegerPacket) o).value;
        }
        if (o instanceof ListPacket) {
            return new ListPacket(new Packet[]{this}).compareTo(o);
        }
        throw new RuntimeException("Unknown type");
    }
}
