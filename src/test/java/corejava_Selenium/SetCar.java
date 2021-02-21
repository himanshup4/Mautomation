package corejava_Selenium;

public class SetCar {
    private String model;
    private String carname;
    private int yearmake;
    private String carstatus;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCarname() {
        if(this.yearmake>=2020) {
            carstatus = "Carname is :" + this.carname + " and year is : " + this.yearmake;
        }
        else
            carstatus = "this is invalid year make";

        return carstatus;
    }

    public void setCarname(String carname, int yearmake) {
        if (carname.equals("BMW") && (yearmake > 2019)) {
            this.carname = carname;
            this.yearmake = yearmake;
        }
    }
}
