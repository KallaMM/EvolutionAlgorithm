public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
//        Individual individual1 = new Individual(3);
//        System.out.println(individual1);
//        individual1.initialise();
//        System.out.println(individual1);


        Individual individual1 = new Individual(2);
        System.out.println(individual1);

        CoordinationPoint point = new CoordinationPoint(2, 2, 1);

        individual1.getTakenNotTaken().add(1);
        individual1.getTakenNotTaken().add(0);
        individual1.getTakenNotTaken().add(1);

        individual1.getCoefficients().add(4);
        individual1.getCoefficients().add(3);
        individual1.getCoefficients().add(2);

        System.out.println(individual1);

        System.out.println(individual1.functionResult(point));

    }

}
