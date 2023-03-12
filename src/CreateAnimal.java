

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

    public class CreateAnimal {
    static int id = 0;
    static List<Animal> allAnimals = new ArrayList<>();

        private static String enterName(){
        System.out.print("Введите имя животного: ");
        String name = Services.input();
        name = name.replace(" ", "_");
        return name;
    }

    private static String enterAnimalClass(){
        System.out.print("Введите класс животного. Доступно: Cat; Dog; Hamster; Horse; Donkey; Camel. ");
        String animalClass = Services.input();
        return animalClass;
    }

    private static List enterListCommand() {
        List command = new ArrayList();
        boolean con = true;
        while (con) {
            System.out.print("Что умеет животное? Введите команду: ");
            String str = Services.input();
            str = str.replace(" ", "_");
            command.add(str);
            System.out.println("Добавить команду? Y/N");
            con = Services.continuation();
        }
        return command;
    }

    private static String inputDate() throws Exception {
        System.out.println("Введите дату рождения в формате дд.мм.гггг");
        String date = Services.input();
        if (date == "") {
            throw new Exception("Ошибка ввода: Ничего не введено");
        }
        if(date.length() != 10){
            throw new Exception("Ошибка ввода: Некорректный ввод 1");
        }
        String[] arr = date.split(""); // преобразуем строку в массив
        if (!arr[2].equals(".") || !arr[5].equals(".")){
            // точки должны быть на своих местах
            throw new Exception("Ошибка ввода: Некорректный ввод 2");
        }
        int n = 0;
        String date2 = "";
        for (String s : arr) {
            if (s.equals(".")) {  // считаем точки
                n++;
            }
            else {
                date2 = date2 + s; // исключаем точки, что бы дальше проверить на цифры
            }
        }
        if (n != 2) {
            throw new Exception("Ошибка ввода: Некорректный ввод 3");
        }
        for(char s : date2.toCharArray()){
            if(!Character.isDigit(s)){
                throw new Exception("Ошибка ввода: Введены не цифры");
            }
        }
        return date;
    }

    private static String checkDate(){
        boolean flag = true;
        String date = null;
        do {
            flag = false;
            try {
                date = inputDate();
            } catch (Exception ex) {
                flag = true;
                System.out.println(ex);
            }
        }while (flag);
        return date;
    }


    public static void createAnimal() {
        boolean con = true;
        while(con) {
            id++;
            String name = CreateAnimal.enterName();
            String animalClass = enterAnimalClass();
            String birthday = checkDate();
            List command = enterListCommand();

            Animal animal = null;
            if (animalClass.toLowerCase().equals("cat")) {
                animal = new Cat(id, name, birthday, command);
            } else if (animalClass.toLowerCase().equals("dog")) {
                animal = new Dog(id, name, birthday, command);
            } else if (animalClass.toLowerCase().equals("hamster")) {
                animal = new Hamster(id, name, birthday, command);
            } else if (animalClass.toLowerCase().equals("horse")) {
                animal = new Horse(id, name, birthday, command);
            } else if (animalClass.toLowerCase().equals("donkey")) {
                animal = new Donkey(id, name, birthday, command);
            } else if (animalClass.toLowerCase().equals("camel")) {
                animal = new Camel(id, name, birthday, command);
            } else {
                System.out.println("Вид не опознан");
            }
            allAnimals.add(animal);
            Counter.add();
            System.out.println("Добавить животное? Y/N");
            con = Services.continuation();
        }
    }
    public static List<Animal> getAllAnimals() {
        return allAnimals;
    }


    private static String readFile() throws Exception {
        try {
            FileReader reader = new FileReader("Animals.txt");

            int c;
            String result = "";
            while ((c = reader.read()) != -1) {
                result = result + (char) c;
            }
            return result;
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public static void createAnimalFromFile() throws Exception {
        String str = CreateAnimal.readFile();
        id = 0;
        Counter.setCount(0);
        allAnimals = new ArrayList<>();
        if (str != null) {
            String result = str;
            result = result.replaceFirst(".$", "");
            result = result.replace("[", "");
            result = result.replace("]", "");
            result = result.replace(",", "");
            String[] string = result.split(";");
            for (String s : string) {
                String[] words = s.split(" ");
                id++;
                String name = words[1];
                String animalClass = words[3];
                String birthday = words[4];
                List command = new ArrayList();
                for (int i = 5; i < words.length; i++) {
                    command.add(words[i]);
                }
                Animal animal = null;
                if (animalClass.toLowerCase().equals("cat")) {
                    animal = new Cat(id, name, birthday, command);
                } else if (animalClass.toLowerCase().equals("dog")) {
                    animal = new Dog(id, name, birthday, command);
                } else if (animalClass.toLowerCase().equals("hamster")) {
                    animal = new Hamster(id, name, birthday, command);
                } else if (animalClass.toLowerCase().equals("horse")) {
                    animal = new Horse(id, name, birthday, command);
                } else if (animalClass.toLowerCase().equals("donkey")) {
                    animal = new Donkey(id, name, birthday, command);
                } else if (animalClass.toLowerCase().equals("camel")) {
                    animal = new Camel(id, name, birthday, command);
                }
                allAnimals.add(animal);
                Counter.add();
            }

        } else {
            System.out.println("Нет данных");
        }
    }
    }


