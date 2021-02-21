package corejava_Selenium;

public class GetCar {
    int yearmake = 2019;
    public static void main(String[] args){
        GetCar gc = new GetCar();
        SetCar sc = new SetCar();
        sc.setCarname("BMW",gc.yearmake);
        System.out.println(" car name stored : " + sc.getCarname());
    }
}
