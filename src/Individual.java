import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Individual {

   private List<Integer> takenNotTaken;
   private List<Integer> coefficients;
   private int degree;
   private double fitnessResult;

    Individual(int degree) {
        takenNotTaken = new ArrayList<>();
        coefficients = new ArrayList<>();
        this.degree = degree;
    }

    public List<Integer> getTakenNotTaken() {
        return takenNotTaken;
    }

    public List<Integer> getCoefficients() {
        return coefficients;
    }

    public int getDegree() {
        return degree;
    }

    public double getFitnessResult() {
        return fitnessResult;
    }

    public void setTakenNotTaken(List<Integer> takenNotTaken) {
        this.takenNotTaken = takenNotTaken;
    }

    public void setCoefficients(List<Integer> coefficients) {
        this.coefficients = coefficients;
    }

    void initialise() {
        Random random = new Random();

        for (int i = 0; i < (degree + 1); i++) {
            takenNotTaken.add(random.nextInt(2));
            coefficients.add(random.nextInt(21));
        }
    }

    @Override
    public String toString() {
        return "Individual{" +
                "takenNotTaken=" + takenNotTaken +
                ", coefficients=" + coefficients +
                ", degree=" + degree +
                '}' + "\n";
    }

    double functionResult(CoordinationPoint point) {
        int deegreeInternal = degree;
        double result = 0;
        List<Double> listOfListMultiplication = new ArrayList<>();

        for (int i = 0; i < takenNotTaken.size(); i++) {
            double coefficientResult = takenNotTaken.get(i) * coefficients.get(i);
            listOfListMultiplication.add(coefficientResult);
        }

        for (int i = 0; i < listOfListMultiplication.size(); i++) {
            result += Math.pow(point.getX(), deegreeInternal) * listOfListMultiplication.get(i);
            deegreeInternal--;
        }

        return result;
    }


    Individual copy(){
        Individual individual = new Individual(degree);
        individual.coefficients = this.coefficients;
        individual.takenNotTaken = this.takenNotTaken;
        return individual;
    }

    void fitness(Points ourPoints) {
        double result = 0;
        List<CoordinationPoint> groupOne = new ArrayList<>();
        List<CoordinationPoint> groupTwo = new ArrayList<>();

        for (CoordinationPoint point : ourPoints.getPoints()) {
            if (functionResult(point) >= point.getY()) {
                groupTwo.add(point);
            }
            else {
                groupOne.add(point);
            }
        }

        List<CoordinationPoint> correctGroupOne = ourPoints.groupByGroupNumber(1);
        List<CoordinationPoint> correctGroupTwo = ourPoints.groupByGroupNumber(2);


        groupOne.removeAll(correctGroupTwo);
        groupTwo.removeAll(correctGroupOne);

//        System.out.println(groupOne.size());
//        System.out.println(correctGroupOne.size());
        double doubleGroupOne = (double) groupOne.size();
        double doubleCorrectGroupOne = (double)correctGroupOne.size();
        double doubleGroupTwo = (double) groupTwo.size();
        double doubleCorrectGroupTwo = (double)correctGroupTwo.size();

//        result = doubleGroupOne/doubleCorrectGroupOne;

        double resultCorrectOne = doubleGroupOne/doubleCorrectGroupOne;
        double resultCorrectTwo = doubleGroupTwo/doubleCorrectGroupTwo;
        double percent = ((resultCorrectOne + resultCorrectTwo)*100)/2;

        this.fitnessResult = percent;

//        System.out.println( "ResultOne:" + resultCorrectOne + "resultTwo:" + resultCorrectTwo + "Percent:" + percent + " " + toString());
    }
}
