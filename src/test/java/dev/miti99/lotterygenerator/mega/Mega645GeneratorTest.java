package dev.miti99.lotterygenerator.mega;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Mega645GeneratorTest {
    @Test
    public void testGenerateNumbers() {
        var mega645Generator = new Mega645Generator();
        var numbers = mega645Generator.generateNumbers();
        System.out.println(numbers);
        assertEquals(6, numbers.size());
        for (int number : numbers) {
            assertTrue(number >= 1 && number <= 45);
            assertEquals(numbers.indexOf(number), numbers.lastIndexOf(number));
        }
    }
}
