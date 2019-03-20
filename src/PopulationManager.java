import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PopulationManager {

    int populationSize;

    public PopulationManager(int populationSize) {
        this.populationSize = populationSize;
    }

    public List populationList(){
        List<Individual> population = new ArrayList<>();
        for (int i = 0; i < populationSize; i++) {
            Individual newIndividual = new Individual(2);
            newIndividual.initialise();
            population.add(newIndividual);
        }
        return population;
    }
}
