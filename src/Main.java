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
//        individual1.getTakenNotTaken().add(0);
//        individual1.getTakenNotTaken().add(0);
//        individual1.getTakenNotTaken().add(1);
//
//        individual1.getCoefficients().add(9);
//        individual1.getCoefficients().add(12);
//        individual1.getCoefficients().add(6);

//        System.out.println(individual1);
//
//        individual1.fitness(points);

        //populationTest
//            PopulationManager newPop = new PopulationManager(10);
//        System.out.println("MyPop:" + newPop.populationList());

        List<CoordinationPoint> pointsGenerator = new ArrayList<>();
        //groupOne
        pointsGenerator.add(new CoordinationPoint(1, 2, 1));
        pointsGenerator.add(new CoordinationPoint(3, 3, 1));
        pointsGenerator.add(new CoordinationPoint(1, 4, 1));
        pointsGenerator.add(new CoordinationPoint(4, 4, 1));
        pointsGenerator.add(new CoordinationPoint(2, 5, 1));
        pointsGenerator.add(new CoordinationPoint(3, 5, 1));
        pointsGenerator.add(new CoordinationPoint(4, 5, 1));
        pointsGenerator.add(new CoordinationPoint(2, 6, 1));
        pointsGenerator.add(new CoordinationPoint(4, 6, 1));
        pointsGenerator.add(new CoordinationPoint(3, 7, 1));

        //groupTWo
        pointsGenerator.add(new CoordinationPoint(9, 2, 2));
        pointsGenerator.add(new CoordinationPoint(11, 2, 2));
        pointsGenerator.add(new CoordinationPoint(10, 3, 2));
        pointsGenerator.add(new CoordinationPoint(11, 3, 2));
        pointsGenerator.add(new CoordinationPoint(12, 3, 2));
        pointsGenerator.add(new CoordinationPoint(9, 4, 2));
        pointsGenerator.add(new CoordinationPoint(11, 4, 2));
        pointsGenerator.add(new CoordinationPoint(10, 5, 2));
        pointsGenerator.add(new CoordinationPoint(12, 5, 2));
        pointsGenerator.add(new CoordinationPoint(12, 6, 2));

//        Points points = new Points(pointsGenerator);
//        individual1.fitness(points);

        PopulationManager newPop = new PopulationManager(50);
        newPop.populationList();
        Points points = new Points(pointsGenerator);
        newPop.populationFitness(points);
    }
}

