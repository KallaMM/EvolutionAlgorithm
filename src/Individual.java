import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Individual {

    List<Integer> takenNotTaken;
    List<Integer> coefficients;
    int degree;

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

    void initialise() {
        Random random = new Random();

        for (int i = 0; i < (degree + 1); i++) {
            takenNotTaken.add(random.nextInt(2));
            coefficients.add(random.nextInt());
        }
    }

    @Override
    public String toString() {
        return "Individual{" +
                "takenNotTaken=" + takenNotTaken +
                ", coefficients=" + coefficients +
                ", degree=" + degree +
                '}';
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

    double fitness(Points ourPoints) {
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

        groupOne.removeAll(correctGroupOne);

//        System.out.println(groupOne.size());
//        System.out.println(correctGroupOne.size());

        result = groupOne.size()/correctGroupOne.size();

        System.out.println(result);

        return result;
    }
}
