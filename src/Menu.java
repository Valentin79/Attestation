public class Menu {
    public static void menu() throws Exception {
        CreateAnimal.createAnimalFromFile(); // заполняем питомник животными из файла
        boolean con = true;
        while (con) {
            System.out.println("Добро пожаловать в программу \"Питомник животных\"\n" +
                    "Доступны следующие опции:\n" +
                    "1: Посмотреть всех животных в питомнике.\n" +
                    "2: Посмотреть конкретное животное.\n" +
                    "3: Посмотреть умения животного.\n" +
                    "4: Добавить животное.\n" +
                    "5: Добавить животному умение.\n" +
                    "6: Сохранить изменения.\n" +
                    "7: Отменить изменения.\n" +
                    "8: Выход.");
            System.out.println("Введите номер меню: ");
            int option = 0;
            do {
                try {
                    option = Integer.parseInt(Services.input());
                } catch (Exception ex) {
                    System.out.println("Введена не цифра");
                }
                if (option < 1 || option > 9) {
                    System.out.println("Введите номер пункта меню: 1, 2, 3, 4 ... 9");
                }
            } while (option < 1 || option > 9);

                if (option == 1) {
                    System.out.println(CreateAnimal.getAllAnimals());
                    System.out.println("Всего животных:" + Counter.getCount());
                }
                if (option == 2) {
                    System.out.println("Введите имя животного:");
                    String name = Services.input();
                    Animal.showAnimalForName(name);
                }
                if (option == 3) {
                    System.out.println("Введите имя животного:");
                    String name = Services.input();
                    Animal.showAnimalSkills(name);
                }
                if (option == 4) {
                    CreateAnimal.createAnimal();
                }
                if (option == 5) {
                    boolean flag = true;
                    while (flag) {
                        System.out.println("Введите имя животного:");
                        String name = Services.input();
                        System.out.println("Введите команду:");
                        String command = Services.input();
                        Animal.addSkillToAnimal(name, command);
//                        System.out.println("Результат: ");
//                        Animal.showAnimalSkills(name);
                        System.out.println("Добавить команду? Y/N");
                        flag = Services.continuation();
                    }
                }

                if (option == 6) {
                    Services.saveFile();
                }
                if (option == 7) {
                    CreateAnimal.createAnimalFromFile();

                }
                if (option == 8) {
                    break;
                }

            System.out.println("Продолжить работу? Y/N");
            con = Services.continuation();
        }

        Services.saveFile();

    }
}
