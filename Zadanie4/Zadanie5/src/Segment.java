public class Segment {
    private Point start, end;

    public Segment(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public double length() {
        return Math.sqrt(Math.pow(end.getX() - start.getX(), 2) + Math.pow(end.getY() - start.getY(), 2));
    }

    @Override
    public String toString() {
        return "Segment: " + start + " -> " + end + ", length=" + length();
    }
}