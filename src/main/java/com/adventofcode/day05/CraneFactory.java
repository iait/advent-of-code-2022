package com.adventofcode.day05;

import java.util.List;

public interface CraneFactory {

    Crane createCrane(List<String> lines, int size);

    CraneFactory PART_ONE = CranePartOne::new;

    CraneFactory PART_TWO = CranePartTwo::new;

}
