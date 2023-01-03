package com.adventofcode.day12;

import java.util.*;

public class Problem {

    private byte[][] map;
    private Integer width, depth;
    private Point start;
    private List<Point> startPoints;
    private Point end;

    public Problem(List<String> lines) {
        depth = lines.size();
        map = new byte[depth][];
        startPoints = new ArrayList<>();
        for (int i = 0; i < depth; i++) {
            String line = lines.get(i);
            if (width == null) {
                width = line.length();
            }
            map[i] = new byte[width];
            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);
                byte b;
                if (c == 'S') {
                    b = 0;
                    start = new Point(i, j);
                } else if (c == 'E') {
                    b = 25;
                    end = new Point(i, j);
                } else {
                    b = (byte) (c - 'a');
                }
                if (b == 0) {
                    startPoints.add(new Point(i, j));
                }
                map[i][j] = b;
            }
        }
    }

    public List<Point> getStartPoints() {
        return startPoints;
    }

    public Point getStart() {
        return start;
    }

    public Node search(Point start) {

//        long startTime = System.nanoTime();

        Map<Point, Node> reached = new HashMap<>();
        PriorityQueue<Node> frontier = new PriorityQueue<>();

        Node initial = new Node(start, null, 0);
        frontier.add(initial);
        reached.put(initial.pos(), initial);
        while (!frontier.isEmpty()) {
            Node node = frontier.poll();
            if (node.pos().equals(end)) {
//                long endTime = System.nanoTime();
//                System.out.println("Reached: " + reached.size());
//                System.out.println("Frontier: " + frontier.size());
//                System.out.println("Expanded: " + (reached.size() - frontier.size()));
//                System.out.println("Time: " + ((endTime - startTime) / 1_000_000));
                return node;
            }
            for (Node child : expand(node)) {
                Node repeated = reached.get(child.pos());
                if (repeated == null || child.steps() < repeated.steps()) {
                    reached.put(child.pos(), child);
                    frontier.add(child);
                }
            }
        }
        return null;
    }

    private List<Node> expand(Node n) {
        List<Node> expanded = new ArrayList<>();
        int limit = map[n.pos().x()][n.pos().y()] + 1;
        if (n.pos().x() > 0 && map[n.pos().x() - 1][n.pos().y()] <= limit) {
            Point newPos = new Point(n.pos().x() - 1, n.pos().y());
            expanded.add(new Node(newPos, n, n.steps() + 1));
        }
        if (n.pos().x() < depth - 1 && map[n.pos().x() + 1][n.pos().y()] <= limit) {
            Point newPos = new Point(n.pos().x() + 1, n.pos().y());
            expanded.add(new Node(newPos, n, n.steps() + 1));
        }
        if (n.pos().y() > 0 && map[n.pos().x()][n.pos().y() - 1] <= limit) {
            Point newPos = new Point(n.pos().x(), n.pos().y() - 1);
            expanded.add(new Node(newPos, n, n.steps() + 1));
        }
        if (n.pos().y() < width - 1 && map[n.pos().x()][n.pos().y() + 1] <= limit) {
            Point newPos = new Point(n.pos().x(), n.pos().y() + 1);
            expanded.add(new Node(newPos, n, n.steps() + 1));
        }
        return expanded;
    }

}

record Point(int x, int y) {}

record Node(Point pos, Node parent, int steps) implements Comparable<Node> {
    @Override
    public int compareTo(Node o) {
        return steps - o.steps;
    }
}
