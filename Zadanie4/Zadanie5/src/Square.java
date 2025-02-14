public class Square {
    private Point[] points;
    private String color;

    public Square(Point topLeft, double sideLength, String color) {
        this.color = color;
        points = new Point[4];
        points[0] = topLeft;
        points[1] = new Point(topLeft.getX() + sideLength, topLeft.getY());
        points[2] = new Point(topLeft.getX() + sideLength, topLeft.getY() - sideLength);
        points[3] = new Point(topLeft.getX(), topLeft.getY() - sideLength);
    }

    public void resize(double factor) {
        double centerX = (points[0].getX() + points[2].getX()) / 2;
        double centerY = (points[0].getY() + points[2].getY()) / 2;
        for (int i = 0; i < 4; i++) {
            double newX = centerX + (points[i].getX() - centerX) * factor;
            double newY = centerY + (points[i].getY() - centerY) * factor;
            points[i] = new Point(newX, newY);
        }
    }

    public void changeColor(String newColor) {
        this.color = newColor;
    }

    @Override
    public String toString() {
        return "Square{" + "color='" + color + '\'' + ", points=" +
                points[0] + ", " + points[1] + ", " + points[2] + ", " + points[3] + "}";
    }
}