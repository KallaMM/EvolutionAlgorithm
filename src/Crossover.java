import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Crossover {
    int chanceForCrossover;
    Random random = new Random();

    public Crossover(int chanceForCrossover) {
        this.chanceForCrossover = chanceForCrossover;
    }

    Individual copuulationessseee(Individual parentOne, Individual parentTwo){
        int coinToss = random.nextInt(101);
        if(coinToss <= chanceForCrossover){
            int cut = random.nextInt(parentOne.getTakenNotTaken().size());
            List<Integer> childTNT = new ArrayList<>();
            List<Integer> childC = new ArrayList<>();

            childTNT.addAll(parentOne.getTakenNotTaken().subList(0,cut));
            childC.addAll(parentOne.getCoefficients().subList(0,cut));

            childTNT.addAll(parentTwo.getTakenNotTaken().subList(0,(parentTwo.getTakenNotTaken().size()-cut)));
            childC.addAll(parentTwo.getCoefficients().subList(0,parentTwo.getCoefficients().size()-cut));

            Individual child = new Individual(parentOne.getDegree());
            child.setTakenNotTaken(childTNT);
            child.setCoefficients(childC);

            return child;
        }
        return parentOne;
    }
}
