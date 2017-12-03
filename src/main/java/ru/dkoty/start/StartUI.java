package ru.dkoty.start;

import ru.dkoty.models.*;

/**
 * Класс содержит набор методов для реализации меню.
 * @author deniskaa
 * @since 03.12.2017
 * @version 1.0
 */

public class StartUI {
  private Input input;
  private final Tracker tracker;
  long time = 0;
  private static final String ADD = "0";
  private static final String SHOWALL = "1";
  private static final String EDIT = "2";
  private static final String DELETE = "3";
  private static final String FINDBYID = "4";
  private static final String FINDBYNAME = "5";
  private static final String EXIT = "6";

  public StartUI(Input input, Tracker tracker) {
    this.input = input;
    this.tracker = tracker;
  }

  // Метод реализует меню программы.
  public void init() {
    boolean exit = false;
    while (!exit) {
      this.showMenu();
      String answer = this.input.ask("Введите пункт меню : ");
      if (ADD.equals(answer)) {
        this.createItem();
      } else if (SHOWALL.equals(answer)) {
        this.showAllItems();
      } else if (EDIT.equals(answer)) {
        this.update();
      } else if (DELETE.equals(answer)) {
        this.deleteItem();
      } else if (FINDBYID.equals(answer)) {
        this.findItemById();
      } else if (FINDBYNAME.equals(answer)) {
        this.findItemByName();
      } else if (EXIT.equals(answer)) {
        exit = true;
      }
    }
  }

  // Отображает пункты меню в консоли.
  private void showMenu() {
    System.out.println("---------------------- Меню ----------------------");
    System.out.println("Введите цифру для выбранного раздела");
    System.out.println("Добавить новую заявку" + " " + ADD);
    System.out.println("Показать все заявки" + " " + SHOWALL);
    System.out.println("Редактировать существующую заявку" + " " + EDIT);
    System.out.println("Удалить заявку" + " " + DELETE);
    System.out.println("Найти заявку по Id" + " " + FINDBYID);
    System.out.println("Найти заявку по названию" + " " + FINDBYNAME);
    System.out.println("Выйти с программы " + " " + EXIT);

  }

  // Создать новою заявку.
  private void createItem() {
    System.out.println("------------ Добавление новой завки --------------");
    String name = this.input.ask("Введите имя заявки: ");
    String desc = this.input.ask("Введите описание: ");
    Item item = new Item(name, desc, time);
    this.tracker.add(item);
    System.out.println("---------- Новая заявка, id: " + item.getId() + "----------");
  }

  // Отобразить все заявки.
  private void showAllItems() {
    System.out.println("------------------ Все заявки --------------------");
    Item[] allItems = tracker.findAll();
    for (int cnt = 0; cnt < allItems.length; cnt++) {
      System.out.println(cnt + ". " + "Имя: " + " " + allItems[cnt].getName() + "; " + "Id: " + " " + allItems[cnt].getId());
    }
  }

  // Редактировать существующие заявки.
  private void update() {
    System.out.println("------------- Редактирование заявок --------------");
    String name = this.input.ask("Введите новое имя заявки: ");
    String desc = this.input.ask("Введите новое описание: ");
    String oldItemId = this.input.ask("Введите id заявки: ");
    Item oldItem = tracker.findById(oldItemId);
    Item item = new Item(name, desc, time);
    item.setId(oldItem.getId());
    tracker.update(item);
    System.out.println("-------- Заявка id: " + item.getId() + " обновлена --------");
  }

  // Удалить выбраную заявку.
  private void deleteItem() {
    System.out.println("---------------- Удаление заявок -----------------");
    String delItemId = this.input.ask("Введите id заявки: ");
    Item item = tracker.findById(delItemId);
    System.out.println("-------- Заявка id: " + item.getId() + " удалена --------");
    tracker.delete(item);
  }

  // Найти заявку по Id.
  private void findItemById() {
    System.out.println("------------------ Поиск по Id -------------------");
    String itemId = this.input.ask("Введите id заявки: ");
    Item item = tracker.findById(itemId);
    System.out.println("Имя: " + item.getName() + " " + "Описание: " + item.getDesc() + " " + "Id: " + item.getId());
  }

  // Найти заявки по имени.
  private void findItemByName() {
    System.out.println("--------------- Поиск по названию ----------------");
    String itemName = this.input.ask("Введите имя заявки: ");
    Item[] result  = tracker.findByName(itemName);
    for (int cnt = 0; cnt < result.length; cnt++) {
      System.out.println(cnt + ". " + "Имя: " + result[cnt].getName() + " " + "Описание: " + result[cnt].getDesc() + " " + "Id: " + result[cnt].getId());
    }
  }



  public static void main(String[] args) {
    new StartUI(new ConsoleInput(), new Tracker()).init();
  }
}
