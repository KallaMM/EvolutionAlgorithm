import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
//        Individual individual1 = new Individual(3);
//        System.out.println(individual1);
//        individual1.initialise();
//        System.out.println(individual1);


//        Individual individual1 = new Individual(2);
//        System.out.println(individual1);
//
//        CoordinationPoint point = new CoordinationPoint(0, 10, 1);
//        CoordinationPoint point1 = new CoordinationPoint(-1, 5, 1);
//        CoordinationPoint point2 = new CoordinationPoint(-2, 10, 1);
//        CoordinationPoint point3 = new CoordinationPoint(2, 5, 2);
//        CoordinationPoint point4 = new CoordinationPoint(3, 5, 2);
//
//        List<CoordinationPoint> myTestPoints = new ArrayList<>();
//        myTestPoints.add(point);
//        myTestPoints.add(point1);
//        myTestPoints.add(point2);
//        myTestPoints.add(point3);
//        myTestPoints.add(point4);
//
//
//        Points points = new Points(myTestPoints);
//
//        individual1.getTakenNotTaken().add(1);
//        individual1.getTakenNotTaken().add(1);
//        individual1.getTakenNotTaken().add(1);
//
//        individual1.getCoefficients().add(4);
//        individual1.getCoefficients().add(12);
//        individual1.getCoefficients().add(-4);
//
//        System.out.println(individual1);
//
//        individual1.fitness(points);

            PopulationManager newPop = new PopulationManager(10);
        System.out.println("MyPop:" + newPop.populationList());



//        System.out.println(individual1.functionResult(point));

    }

}
