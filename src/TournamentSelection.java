import java.util.*;

public class TournamentSelection {

    private int numberOfIndividuals;
    private int numberOfTournaments;
    private Random random = new Random();

    public TournamentSelection(int numberOfIndividuals, int numberOfTournaments) {
        this.numberOfIndividuals = numberOfIndividuals;
        this.numberOfTournaments = numberOfTournaments;
    }

    public int getNumberOfIndividuals() {
        return numberOfIndividuals;
    }

    public int getNumberOfTournaments() {
        return numberOfTournaments;
    }

    public List<Individual> nextGeneration(List<Individual> population) {
        List<Individual> nextGeneration = new ArrayList<>();
        List<Individual> populationCopy = new ArrayList<>(population);

        for (int i = 0; i < numberOfTournaments; i++) {
            Set<Individual> tournamentSet = new HashSet<>(numberOfIndividuals);
            for (int j = 0; j < numberOfIndividuals; j++) {
                tournamentSet.add(populationCopy.remove(random.nextInt(populationCopy.size())));
            }
            nextGeneration.add(tournamentSet.stream().max(Comparator.comparingDouble(Individual::getFitnessResult)).get().copy());

            populationCopy.addAll(tournamentSet);
            tournamentSet.clear();
        }
        return nextGeneration;
    }
}