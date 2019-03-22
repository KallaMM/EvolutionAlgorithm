import java.util.List;
import java.util.Objects;

public class CoordinationPoint {
    private double x;
    private double y;
    private int group;

    public CoordinationPoint(double x, double y, int group) {
        this.x = x;
        this.y = y;
        this.group = group;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getGroup() {

        return group;
    }

}
