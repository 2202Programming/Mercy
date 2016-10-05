package Math;

/**
 * A general-purpose double-based [<i>non-immutable</i>] 2D Point class
 * containing many useful methods <br>
 * <br>
 * *many of these methods are easier to use and are not included in either the
 * Point class built into Java or the Point2D class
 * 
 * @author David Harmeyer
 *
 */
public class Point {
	/**
	 * The (x, y) coordinates of the point on the cartesian plane in which up is
	 * +y and right is +x
	 */
	public double x, y;

	/**
	 * Constructs a new point with coordinates (0, 0)
	 */
	public Point() {
		this(0, 0);
	}

	/**
	 * Constructs a new point with the given coordinates
	 * 
	 * @param x
	 *            The x-coordinate of the constructed Point
	 * @param y
	 *            The y-coordinate of the constructed Point
	 */
	public Point(double x, double y) {
		this.x=x;
		this.y=y;
	}

	/**
	 * Returns the Euclidean distance between this point and <i>other</i>
	 * 
	 * @param other
	 *            The point to measure the distance between
	 * @return The distance between this and <i>other</i>
	 */
	public double distance(Point other) {
		return Math.sqrt((this.x-other.x)*(this.x-other.x)+(this.y-other.y)*(this.y-other.y));
	}

	/**
	 * Gets the midpoint of this point and <i>other</i>
	 * 
	 * @param other
	 *            The other point
	 * @return The midpoint of this and <i>other</i>
	 */
	public Point midpoint(Point other) {
		return new Point((x+other.x)/2, (y+other.y)/2);
	}

	/**
	 * Gets the direction from this point to <i>other</i> in radians
	 * 
	 * @param other
	 *            The other point to get the direction to
	 * @return The direction from this to <i>other</i> in radians
	 */
	public double directionTo(Point other) {
		return Math.atan2(other.y-y, other.x-x);
	}

	public String toString() {
		return "{"+x+", "+y+"}";
	}

	/**
	 * Calculates the magnitude of a 2D vector with components xi+yj, or <x, y>.
	 * This is always equal to the distance between this point and the origin
	 * 
	 * @return The magnitude of vector <x, y>
	 */
	public double magnitude() {
		return Math.sqrt(x*x+y*y);
	}

	/**
	 * Calculates the direction of the 2D vector with components xi+yj or <x, y>
	 * in radians.
	 * 
	 * @return The direction of <x, y> in radians.
	 */
	public double direction() {
		return Math.atan2(y, x);
	}

}
