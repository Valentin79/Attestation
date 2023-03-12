import java.util.List;

abstract class Animal {

    private int id;
    private String name;
    private String birthday;
    private List<String> command;


    public Animal(int id, String name, String birthday, List command) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.command = command;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public List<String> getCommand() {
        return command;
    }

    public void setCommand(List<String> command) {
        this.command = command;
    }

    public static void showAnimalForName(String str){
        boolean flag = true;
        for(Animal animal: CreateAnimal.allAnimals){
            if (animal.getName().toLowerCase().equals(str)) {
                System.out.println(animal);
                flag = false;
            }
        }
        if(flag){
            System.out.println("Животное не найдено");
        }
    }

    public static void showAnimalSkills(String str) {
        boolean flag = true;
        for (Animal animal : CreateAnimal.allAnimals) {
            if (animal.getName().toLowerCase().equals(str.toLowerCase())) {
                System.out.println(animal.getName() + " Умеет: " + animal.getCommand());
                flag = false;
            }
        }
        if(flag){
            System.out.println("Животное не найдено");
        }
    }

    public static void addSkillToAnimal(String str, String newCommand) {
        newCommand = newCommand.replace(" ", "_");
        boolean flag = true;
        for (Animal animal : CreateAnimal.allAnimals) {
            if (animal.getName().toLowerCase().equals(str.toLowerCase())) {
                //System.out.println(animal.getCommand());
                animal.command.add(newCommand);
                System.out.println("Теперь " + animal.getName() + " умеет: " + animal.getCommand());
                flag = false;
            }
        }
        if(flag){
            System.out.println("Животное не найдено");
        }
    }

    @Override
    public String toString() {
        return "\n" + "Animal{" +
                "id: " + id +
                ". Name: " + name + " " + getClass() +
                ". Birthday: " + birthday +
                ". Умеет: " + command  + '}';
    }


}
