package ru.dkoty.start;

import org.junit.Test;
import ru.dkoty.models.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test
 *
 * @author deniskaa
 * @since 28.11.2017
 * @version 1.0
 */

public class TrackerTest {

    // Тест метода findByName.

    @Test
    public void whenFindByNameThenReturnTwoItem() {
        Tracker tracker = new Tracker();
        Item first = new Item("first", "first note", 123L);
        Item second = new Item("second", "second note", 1234L);
        Item third = new Item("fourth", "third note", 1235L);
        Item fourth = new Item("fourth", "fourth note", 12346);
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        tracker.add(fourth);
        Item[] resultArr = tracker.findByName("fourth");
        String result = resultArr[0].getName() + " " + resultArr[1].getName();
        String expected = "fourth fourth";
        assertThat(result, is(expected));

    }

    //Тест метода update.

    @Test
    public void whenUpdateNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Task("first", "testDescription");
        tracker.add(previous);
        Item next = new Task("second", "testDescription2");
        next.setId(previous.getId());
        tracker.update(next);
        assertThat(tracker.findById(previous.getId()).getName(), is("second"));
    }

    //Тест метода delete.

    @Test
    public void whenDeleteItemThenReturnNewArray() {
        Tracker tracker = new Tracker();
        Item first = new Item("first", "first note", 123L);
        Item second = new Item("second", "second note", 1234L);
        Item third = new Item("third", "third note", 1235L);
        Item fourth = new Item("fourth", "fourth note", 12346);
        tracker.add(fourth);
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        tracker.delete(fourth);
        Item[] resultArr = tracker.findAll();
        String result = resultArr[0].getName() + " " + resultArr[1].getName() + " " + resultArr[2].getName();
        String expected = "first second third";
        assertThat(result, is(expected));
    }
}

