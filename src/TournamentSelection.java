import java.util.*;

public class TournamentSelection {

    private int numberOfTakenIndividualsToTournament;
    private int numberOfTournaments;
    private Random random = new Random();

    public TournamentSelection(int numberOfTakenIndividualsToTournament, int numberOfTournaments) {
        this.numberOfTakenIndividualsToTournament = numberOfTakenIndividualsToTournament;
        this.numberOfTournaments = numberOfTournaments;
    }

    public int getNumberOfTakenIndividualsToTournament() {
        return numberOfTakenIndividualsToTournament;
    }

    public int getNumberOfTournaments() {
        return numberOfTournaments;
    }

    public List<Individual> nextGeneration(List<Individual> population) {
        List<Individual> nextGeneration = new ArrayList<>();
        List<Individual> populationCopy = new ArrayList<>(population);
        nextGeneration.addAll(theBestIndividualsFromPopulation(population));

        for (int i = 0; i < numberOfTournaments; i++) {
            Set<Individual> tournamentSet = new HashSet<>(numberOfTakenIndividualsToTournament);
            for (int j = 0; j < numberOfTakenIndividualsToTournament; j++) {
                tournamentSet.add(populationCopy.remove(random.nextInt(populationCopy.size())));
            }
            Individual best = tournamentSet.stream().max(Comparator.comparingDouble(Individual::getFitnessResult)).get();
            nextGeneration.add(best.copy());

            populationCopy.addAll(tournamentSet);
            tournamentSet.clear();
        }
        return nextGeneration;
    }

    List<Individual> theBestIndividualsFromPopulation(List<Individual> population){
        population.sort(Comparator.comparingDouble(Individual::getFitnessResult));
        return population.subList(population.size()-10,population.size());
    }
}