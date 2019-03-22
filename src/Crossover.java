import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Crossover {
    int chanceForCrossover;
    Random random = new Random();

    public Crossover(int chanceForCrossover) {
        this.chanceForCrossover = chanceForCrossover;
    }

    List<Individual> populationCrossover(List<Individual> population) {
        List<Individual> newGenerationAfterCrossover = new ArrayList<>();
        for (int i = 0; i < (population.size() / 2); i++) {
            List<List<Individual>> parents = createPairsForCrossover(population);
            for (List<Individual> pair : parents) {
                Individual childOne = crossover(pair.get(0), pair.get(1));
                Individual childTwo = crossover(pair.get(1), pair.get(0));

                newGenerationAfterCrossover.add(childOne);
                newGenerationAfterCrossover.add(childTwo);
            }
        }
        return newGenerationAfterCrossover;
    }

    private List<List<Individual>> createPairsForCrossover(List<Individual> population) {
        List<Individual> source = new ArrayList<>(population);
        Collections.shuffle(source);
        List<List<Individual>> result = new ArrayList<>();
        for (int i = 0; i < (population.size() / 2); i++) {
            List<Individual> twoParents = new ArrayList<>();
            twoParents.add(source.get(2 * i));
            twoParents.add(source.get(2 * i + 1));
            result.add(twoParents);
        }
        return result;
    }

    private Individual crossover(Individual parentOne, Individual parentTwo) {
        int coinToss = random.nextInt(101);
        if (coinToss <= chanceForCrossover) {
            int cut = random.nextInt(parentOne.getTakenNotTaken().size());
            List<Integer> childTNT = new ArrayList<>();
            List<Double> childC = new ArrayList<>();

            childTNT.addAll(parentOne.getTakenNotTaken().subList(0, cut));
            childC.addAll(parentOne.getCoefficients().subList(0, cut));

            childTNT.addAll(parentTwo.getTakenNotTaken().subList(0, (parentTwo.getTakenNotTaken().size() - cut)));
            childC.addAll(parentTwo.getCoefficients().subList(0, parentTwo.getCoefficients().size() - cut));

            Individual child = new Individual(parentOne.getDegree());
            child.setTakenNotTaken(childTNT);
            child.setCoefficients(childC);

            return child;
        }
        return parentOne;
    }
}
