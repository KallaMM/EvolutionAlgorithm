import java.util.ArrayList;
import java.util.List;

public class Points {
    List<CoordinationPoint> points;

    List<CoordinationPoint> groupByGroupNumber(int group) {
        List<CoordinationPoint> singleGroup = new ArrayList<>();
        for (CoordinationPoint point : points) {
            if (point.getGroup() == group) {
                singleGroup.add(point);
            }
        }
        return singleGroup;
    }

    Points(List<CoordinationPoint> points){
        this.points = points;
    }

    public List<CoordinationPoint> getPoints(){
        return points;
    }

}
