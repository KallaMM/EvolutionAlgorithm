import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PopulationManager {

    int populationSize;
    List<Individual> population = new ArrayList<>();

    public PopulationManager(int populationSize) {
        this.populationSize = populationSize;
    }

    public List<Individual> getPopulation() {
        return population;
    }

    public List populationList(){
        for (int i = 0; i < populationSize; i++) {
            Individual newIndividual = new Individual(2);
            newIndividual.initialise();
            population.add(newIndividual);
        }
        return population;
    }

    public void populationFitness(Points myPoints){
        for (Individual individual: population) {
            individual.fitness(myPoints);
        }
    }
}
