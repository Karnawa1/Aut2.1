package org.sdc;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    static Stream<double[]> provideInvalidTriangles() {
        return Stream.of(
            new double[]{-1, -2, -3},
            new double[]{0, 0, 0},
            new double[]{1, 2, 3},
            new double[]{1, 1, 3}
        );
    }

    @ParameterizedTest
    @MethodSource("provideInvalidTriangles")
    void testInvalidTriangles(double[] sides) {
        assertFalse(Main.isTriangleValid(sides[0], sides[1], sides[2]));
    }

    static Stream<double[]> provideEquilateralTriangles() {
        return Stream.of(
            new double[]{1, 1, 1},
            new double[]{2, 2, 2},
            new double[]{5, 5, 5}
        );
    }

    @ParameterizedTest
    @MethodSource("provideEquilateralTriangles")
    void testEquilateralTriangles(double[] sides) {
        assertTrue(Main.isTriangleValid(sides[0], sides[1], sides[2]));
        assertTrue(sides[0] == sides[1] && sides[1] == sides[2]);
    }

    static Stream<double[]> provideIsoscelesTriangles() {
        return Stream.of(
            new double[]{2, 2, 3},
            new double[]{3, 4, 3},
            new double[]{5, 5, 3}
        );
    }

    @ParameterizedTest
    @MethodSource("provideIsoscelesTriangles")
    void testIsoscelesTriangles(double[] sides) {
        assertTrue(Main.isTriangleValid(sides[0], sides[1], sides[2]));
        assertTrue(sides[0] == sides[1] || sides[1] == sides[2] || sides[0] == sides[2]);
    }

    static Stream<double[]> provideScaleneTriangles() {
        return Stream.of(
            new double[]{3, 4, 5},
            new double[]{5, 7, 9},
            new double[]{8, 10, 12}
        );
    }

    @ParameterizedTest
    @MethodSource("provideScaleneTriangles")
    void testScaleneTriangles(double[] sides) {
        assertTrue(Main.isTriangleValid(sides[0], sides[1], sides[2]));
        assertTrue(sides[0] != sides[1] && sides[1] != sides[2] && sides[0] != sides[2]);
    }
}
