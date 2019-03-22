import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Mutation {
    private int chanceForMutation;
    private Random random = new Random();

    public Mutation(int chanceForMutation) {
        this.chanceForMutation = chanceForMutation;
    }

    List<Individual> matationOfPopulation(List<Individual> population){
        List<Individual> newGenerationAfterMutation = new ArrayList<>();
        for (Individual individual: population) {
            newGenerationAfterMutation.add(mutated(individual));
        }
        return newGenerationAfterMutation;
    }

    Individual mutated(Individual individual) {
        int coinToss = random.nextInt(101);
        if (coinToss <= chanceForMutation) {
            int indexTNT = random.nextInt(individual.getTakenNotTaken().size());
            int indexC = random.nextInt(individual.getCoefficients().size());

            int valueTNT = random.nextInt(2);

            //2 miejsca bound21
            double valueC = (random.nextDouble()*10);

            individual.getTakenNotTaken().set(indexTNT, valueTNT);
            individual.getCoefficients().set(indexC, valueC);
        }
        return individual;
    }
}
