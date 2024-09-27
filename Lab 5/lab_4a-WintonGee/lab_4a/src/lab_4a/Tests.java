package lab_4a;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class Tests {

    @Test
    public void testAddInteger() {
        Bag<Integer> bag = new Bag<>();
        bag.add(1);
        bag.add(2);
        assertEquals(2, bag.size());
    }

    @Test
    public void testAddString() {
        Bag<String> bag = new Bag<>();
        bag.add("String");
        bag.add("Second String");
        bag.add("Third String");
        assertEquals(3, bag.size());
    }

    @Test
    public void testRemove() {
        Bag<Integer> bag = new Bag<>();
        bag.add(1);
        bag.add(2);
        bag.add(3);
        bag.remove(1);
        assertEquals(2, bag.size());
    }

    @Test
    public void testRemoveNotExistingElement() {
        Bag<Integer> bag = new Bag<>();
        bag.add(1);
        bag.add(2);
        bag.add(3);
        bag.remove(100);
        assertEquals(3, bag.size());
    }

    @Test
    public void testSize() {
        Bag<Integer> bag = new Bag<>();
        bag.add(1);
        bag.add(2);
        bag.add(3);
        assertEquals(3, bag.size());
    }

    @Test
    public void testCount() {
        Bag<Integer> bag = new Bag<>();
        bag.add(1);
        bag.add(2);
        bag.add(3);
        assertEquals(1, bag.count(1));
    }

    @Test
    public void testCountNotExistingElement() {
        Bag<Integer> bag = new Bag<>();
        bag.add(1);
        bag.add(2);
        bag.add(3);
        assertEquals(0, bag.count(100));
    }

    @Test
    public void testGrab() {
        Bag<Integer> bag = new Bag<>();
        bag.add(1);
        assertEquals(Optional.of(1), bag.grab());
    }

    @Test
    public void testGrabEmpty() {
        Bag<Integer> bag = new Bag<>();
        assertEquals(Optional.empty(), bag.grab());
    }

}
