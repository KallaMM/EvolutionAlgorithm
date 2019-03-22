import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        List<CoordinationPoint> pointsGenerator = new ArrayList<>();


        pointsGenerator.add(new CoordinationPoint(-3.33607181, -1.64433742, 1));
        pointsGenerator.add(new CoordinationPoint(-5.55257423, 0.4551153, 1));
        pointsGenerator.add(new CoordinationPoint(-3.3076195, -1.07698453, 1));
        pointsGenerator.add(new CoordinationPoint(-4.85663273, 0.36716897, 1));
        pointsGenerator.add(new CoordinationPoint(-4.75661364, 0.10709777, 1));
        pointsGenerator.add(new CoordinationPoint(-5.2068361, 1.11589055, 1));
        pointsGenerator.add(new CoordinationPoint(-4.26164616, 0.78103762, 1));
        pointsGenerator.add(new CoordinationPoint(-5.1419014, 0.59384734, 1));
        pointsGenerator.add(new CoordinationPoint(-4.03684201, 1.38443439, 1));
        pointsGenerator.add(new CoordinationPoint(-4.3793199, 1.99119714, 1));
        pointsGenerator.add(new CoordinationPoint(-4.02895952, -0.84764317, 1));
        pointsGenerator.add(new CoordinationPoint(-5.57766872, 1.60821501, 1));
        pointsGenerator.add(new CoordinationPoint(-4.78479033, -1.69791994, 1));
        pointsGenerator.add(new CoordinationPoint(-3.74395861, 2.15553056, 1));
        pointsGenerator.add(new CoordinationPoint(-4.33641207, 1.98617941, 1));
        pointsGenerator.add(new CoordinationPoint(-3.56782813, -0.62136017, 1));
        pointsGenerator.add(new CoordinationPoint(-2.69436209, -0.90174858, 1));
        pointsGenerator.add(new CoordinationPoint(-4.20600969, -0.67210531, 1));
        pointsGenerator.add(new CoordinationPoint(-3.50283362, -0.63888506, 1));
        pointsGenerator.add(new CoordinationPoint(-3.69811687, 0.8927685, 1));
        pointsGenerator.add(new CoordinationPoint(-4.77298396, -0.29986526, 1));
        pointsGenerator.add(new CoordinationPoint(-3.13375771, 1.55028992, 1));
        pointsGenerator.add(new CoordinationPoint(-7.09764297, -0.7552884, 1));
        pointsGenerator.add(new CoordinationPoint(-3.53874194, 0.46563881, 1));
        pointsGenerator.add(new CoordinationPoint(-4.4821113, 2.37470145, 1));


        //groupTWo
        pointsGenerator.add(new CoordinationPoint(0.09216603 ,3.13908069,2));
        pointsGenerator.add(new CoordinationPoint(-0.2979067  , 5.04757883,2));
        pointsGenerator.add(new CoordinationPoint(0.41930841 ,3.57436207,2));
        pointsGenerator.add(new CoordinationPoint(0.21219196, 1.74387328,2));
        pointsGenerator.add(new CoordinationPoint(0.65968729, 2.41981542,2));
        pointsGenerator.add(new CoordinationPoint(-0.60732739 , 4.8096319,2));
        pointsGenerator.add(new CoordinationPoint(1.06599169 ,3.75827904,2));
        pointsGenerator.add(new CoordinationPoint(-1.23229972 , 3.89519459,2));
        pointsGenerator.add(new CoordinationPoint(2.50210641, 4.39967272,2));
        pointsGenerator.add(new CoordinationPoint(2.13993601, 4.03104222,2));
        pointsGenerator.add(new CoordinationPoint(-0.22816528  ,3.53653954,2));
        pointsGenerator.add(new CoordinationPoint(0.97213988 ,3.68573842,2));
        pointsGenerator.add(new CoordinationPoint(0.93321657, 3.53595578,2));
        pointsGenerator.add(new CoordinationPoint(1.99832549 ,3.06188882,2));
        pointsGenerator.add(new CoordinationPoint(1.76101432, 6.13906724,2));
        pointsGenerator.add(new CoordinationPoint(0.73856985, 3.80819747,2));
        pointsGenerator.add(new CoordinationPoint(1.89727609 ,5.87252952,2));
        pointsGenerator.add(new CoordinationPoint(2.12414555 ,5.28234711,2));
        pointsGenerator.add(new CoordinationPoint(-0.16908848 , 3.95730655,2));
        pointsGenerator.add(new CoordinationPoint(1.64120302 ,4.00244309,2));
        pointsGenerator.add(new CoordinationPoint(-0.00782709  ,3.44996325,2));
        pointsGenerator.add(new CoordinationPoint(0.2471217 , 3.93292573,2));
        pointsGenerator.add(new CoordinationPoint(2.02914149, 5.01575429,2));
        pointsGenerator.add(new CoordinationPoint(0.4705981 , 2.61647914,2));
        pointsGenerator.add(new CoordinationPoint(0.14207575, 4.19267027,2));


        //initialise
        PopulationManager newPop = new PopulationManager(200);
        newPop.populationList();
        Points points = new Points(pointsGenerator);

        //fitness
        newPop.populationFitness(points);
        System.out.println("MyPop:" + newPop.populationList());

        //selection
        int generation = 200;
        TournamentSelection tour = new TournamentSelection(5, 200);
        Crossover crossover = new Crossover(70);
        Mutation mutation = new Mutation(10);

        //loop for 100 generations
        for (int i = 0; i < generation; i++) {
            List<Individual> nextGeneration = tour.nextGeneration(newPop.getPopulation());
            newPop.setPopulation(nextGeneration);

            //crossover
            crossover.populationCrossover(newPop.getPopulation());

            //mutation
            mutation.matationOfPopulation(newPop.getPopulation());

            //fitness
            newPop.populationFitness(points);

            System.out.println("fitness: " + (i + 1) + " , " + getBestIndividual(newPop));
//            System.out.println(getBestIndividual(newPop).getFitnessResult());
        }


//
//        PopulationManager newPop = new PopulationManager(10);
//        System.out.println("MyPop:" + newPop.populationList());



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

//        List<CoordinationPoint> pointsGenerator = new ArrayList<>();
        //groupOne

//        Points points = new Points(pointsGenerator);
//        individual1.fitness(points);

//        PopulationManager newPop = new PopulationManager(200);
//        newPop.populationList();
//        Points points = new Points(pointsGenerator);
//        newPop.populationFitness(points);

    }

    public static Individual getBestIndividual(PopulationManager newPop) {
        return newPop.getPopulation().stream().max(Comparator.comparingDouble(Individual::getFitnessResult)).get();
    }

}

