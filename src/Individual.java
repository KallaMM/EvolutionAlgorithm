import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Individual {

    List<Integer> takenNotTaken;
    List<Integer> coefficients;
    int degree;

    Individual(int degree){
        takenNotTaken = new ArrayList<>();
        coefficients = new ArrayList<>();
        this.degree = degree;
    }

   void initialise(){
       Random random = new Random();

       for (int i = 0; i < (degree+1) ; i++) {
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
}
