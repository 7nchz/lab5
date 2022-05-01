import java.awt.*;
import java.util.Random;

class Side {
    private final Point a, b;
    private static final Random random = new Random();

    public Side(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    public double distance() {
        return a.distance(b);
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public static Side generateRandom() {
        return new Side(new Point(random.nextInt(100), (random.nextInt(100))), new Point(random.nextInt(100), (random.nextInt(100))));
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Side{");
        sb.append("a=").append(a);
        sb.append(", b=").append(b);
        sb.append('}');
        return sb.toString();
    }
}

class Square {
    private final Side a;

    public Square(Side a) {
        this.a = a;
    }

    public Side getA() {
        return a;
    }

    public double area() {
        double t;
        return (t = a.distance()) * t;
    }

    public double diagonal() {
        return a.distance() * Math.sqrt(2);
    }

    public static Square generateRandom() {
        return new Square(Side.generateRandom());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Square{");
        sb.append("a=").append(a.distance()).append(", ");
        sb.append("diagonal=").append(diagonal()).append(", ");
        sb.append("area=").append(area());
        sb.append('}');
        return sb.toString();
    }
}

class Cube {
    private final Square a;

    public Cube(Square a) {
        this.a = a;
    }

    public Square getA() {
        return a;
    }

    public double volume() {
        return Math.pow(a.getA().distance(), 3);
    }

    public double diagonal() {
        return a.getA().distance() * Math.sqrt(3);
    }

    public static Cube generateRandom() {
        return new Cube(Square.generateRandom());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cube{");
        sb.append("a=").append(a).append(", ");
        sb.append("diagonal=").append(diagonal()).append(", ");
        sb.append("volume=").append(volume());
        sb.append('}');
        return sb.toString();
    }
}

public class lab5 {
    public static void main(String[] args) {
        Cube c = Cube.generateRandom();
        Square s1 = Square.generateRandom(), s2 = Square.generateRandom();
        System.out.println(c);
        System.out.println(s1);
        System.out.println(s2);
    }
}