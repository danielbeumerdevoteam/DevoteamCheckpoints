
public class Automaker {
    public String name;

    public Automaker() {
    }
    public Automaker (String name){
        if (name == null || name.length() == 0) {
            System.out.println("Must provide automaker with a name.");
            return;
        }
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {

        this.name = name;
    }
}