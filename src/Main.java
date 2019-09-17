
import com.example.*;
import com.example.Car;
import com.example.Engine;
import com.example.EngineCylinder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //    System.out.println("Hello World!");

        Engine e1 = new Engine(1500, EngineCylinder.FOUR_CYL_ENGINE);
        //Engine e2 = new Engine(2200, EngineCylinder.SIX_CYL_ENGINE);

        Car c1 = Car.withColorGasEnginePassengers("Red", 7, e1, "Rohit", "Bharti", "Aai", "Anna");
        //Car c2 = Car.withColorGasEnginePassengersTrunk("Black", 4, e2, Arrays.asList("Bharti", "Baba", "Kaka", "Kaku"));

//        System.out.println(c1);
//        c1.setCarEngine(e2);
//        System.out.println(c1);
//
//        e2.setPowerCC(5126);
//        System.out.println(c1);


        Car c3 = (Car)c1.clone();
        c3.getCarEngine().setPowerCC(5126);
        c3.getCarEngine().setEngineCylinder(EngineCylinder.SIX_CYL_ENGINE);
        c3.getTyreList().get(0).setDiameter(555);
        c3.getTyreList().get(1).setWidth(555);

        System.out.println("After getter & setting value");
        System.out.println(c3);
        System.out.println("=============================");

        Engine e2 = new Engine(5126, EngineCylinder.SIX_CYL_ENGINE);
        c3.setCarEngine(e2);
        List<Tyre> t1 = new ArrayList<Tyre>();
        t1.add(new Tyre(50,555));
        t1.add(new Tyre(60,666));
        c3.setTyreList(t1);

        c3.getTyreList().get(0).setDiameter(777);
        c3.getTyreList().get(1).setWidth(777);

        t1.get(0).setDiameter(654531);
        t1.get(1).setDiameter(79864);

        System.out.println("After only setting value");
        System.out.println(c3);


//        System.out.println(c1);


//        List<String> tempPass = c1.getPassengers();
//        tempPass.add("New");
//        tempPass.add("NewNew");
//
//        List<String> tempTrunk = c1.getTrunkContents();
//        tempTrunk.add("New");
//        tempTrunk.add("NewNew");
//
//        System.out.println(c1);
//        System.out.println(tempPass);
//        System.out.println(tempTrunk);
    }

}