import java.util.Random;

public class Mutation {
    private int chanceForMutation;
    private Random random = new Random();

    public Mutation(int chanceForMutation) {
        this.chanceForMutation = chanceForMutation;
    }

    Individual mutated(Individual individual) {
        int coinToss = random.nextInt(101);
        if (coinToss <= chanceForMutation) {
            int indexTNT = random.nextInt(individual.getTakenNotTaken().size());
            int indexC = random.nextInt(individual.getCoefficients().size());

            int valueTNT = random.nextInt(2);

            //2 miejsca bound21
            int valueC = random.nextInt(21);

            individual.getTakenNotTaken().set(indexTNT, valueTNT);
            individual.getCoefficients().set(indexC, valueC);
        }
        return individual;
    }
}
