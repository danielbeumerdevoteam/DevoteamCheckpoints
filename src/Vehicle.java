public class Vehicle extends Automaker {
    private String color;
    private int year;
    private String model;
    private final String automaker;

    public Vehicle( String automaker, String model) {
        this.automaker = automaker;
        this.model = model;
    }
    public void prettyPrint (){
            System.out.println("Color is:" + color + ".\n");
            System.out.println("Year is:" + year + ".\n" );
            System.out.println("Automaker is" + automaker + ".\n");
            System.out.println("Model is" + model + ".\n");
        }
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    public String getAutomaker() {
        return automaker;
    }
}
