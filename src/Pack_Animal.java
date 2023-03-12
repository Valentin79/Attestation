import java.util.List;

abstract class Pack_Animal extends Animal{
    private List command;
    public Pack_Animal(int id, String name, String birthday, List command) {
        super(id, name, birthday, command);

    }
}
