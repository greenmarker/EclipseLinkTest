import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Kamil on 2015-12-21.
 */
@Entity
public class Point {

    @Id
    @GeneratedValue
    private long id;
    protected Point(){};

    private double x, y;

    public Point(double y, double x) {
        this.y = y;
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getDistance(Point p){
        double dx = p.x - x;
        double dy = p.y - y;
        return Math.sqrt(dx*dx + dy*dy);
    }
}
