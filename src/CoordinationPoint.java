import java.util.Objects;

public class CoordinationPoint {
    private double x;
    private double y;
    private int group;

    public CoordinationPoint(int x, int y, int group) {
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

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        CoordinationPoint point = (CoordinationPoint) o;
//        return Double.compare(point.x, x) == 0 &&
//                Double.compare(point.y, y) == 0 &&
//                group == point.group;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(x, y, group);
//    }
}
