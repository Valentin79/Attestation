import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Services {
    public static String input(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        return str;
    }

    public static void saveFile(){
        String result = "";

        File file = new File("Animals.txt");
        for(Animal animal: CreateAnimal.allAnimals) {
            result = result + "\n" + animal.getId() + " " + animal.getName() + " " + animal.getClass() + " " +
                    animal.getBirthday() + " " + animal.getCommand() + ";";
        }
            try (FileWriter writer = new FileWriter(file, false)) {
                writer.write(result);
            }
            catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

    }
    public static boolean continuation(){
        boolean con = true;
        boolean resume = true;
        while (resume) {
            // Scanner sc = new Scanner(System.in);
            //String c = sc.nextLine();
            String c = input();
            if (c.equalsIgnoreCase("n")) {
                con = false;
                resume = false;
            } else if (c.equalsIgnoreCase("y")) {
                con = true;
                resume = false;
            }
            else{
                System.out.println("Введите Y или N");
                resume = true;
            }
        }
        return con;
    }

}
