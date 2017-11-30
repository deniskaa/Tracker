package ru.dkoty.start;

import ru.dkoty.models.*;
import java.util.*;

/**
 * Класс содержит методы для управления списком заявок.
 * @author deniskaa
 * @since 28.11.2017
 * @version 1.0
 */

public class Tracker {
    private int position = 0;
    private Item[] items = new Item[100];
    private static final Random RN = new Random();

    //Возвращает номер ячейки в массиве.

    public int getCell(Item item) {
        return Arrays.asList(items).indexOf(item);
    }

    //Добавляет новые элементы в массив.

    public Item add(Item item) {
        item.setId(this.generateId());
        items[this.position++] = item;
        return item;
    }

    //Обновляет уже существующие элементы.

    public void update(Item item) {
        items[getCell(this.findById(item.getId()))] = item;
    }

    //Удаляет не нужные элементы.

    public void delete(Item item) {
        Item[] result = new Item[100];
        int numOfCopy = findAll().length - 1;
        System.arraycopy(items, getCell(item) + 1, result, 0, numOfCopy);
        System.arraycopy(result, 0, items, getCell(item), numOfCopy);
    }

    //Генерирует новый Id.

    String generateId() {
        return String.valueOf(RN.nextInt());
    }

    //Поиск по Id.

    protected Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
            }
        } return result;
    }

    //Поиск по имени.

    protected Item[] findByName(String key) {
        Item[] result = new Item[100];
        int cnt = 0;
        for (Item item : items) {
            if (item != null && item.getName().equals(key)) {
                result[cnt] = item;
                cnt++;
            }
        } return result;
    }

    //Возвращает список всех элементов, кроме null.

    public Item[] findAll() {
        Item[] result = new Item[100];
        int cnt = 0;
        for (Item item : items) {
            if (item != null) {
                result[cnt] = items[getCell(item)];
                cnt++;
            }
        } return result;
    }
}
