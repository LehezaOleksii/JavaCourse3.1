package oleksii.leheza.java.lab3.entities;

public class Triangle extends Shape {

	private double firstSide;
	private double secondSide;
	private double thirdSide;

	public Triangle(double firstSide, double secondSide, double thirdSide) {
		super();
		this.firstSide = firstSide;
		this.secondSide = secondSide;
		this.thirdSide = thirdSide;
	}

	public Triangle(double firstSide, double secondSide, double thirdSide, String shapeColor) {
		super(shapeColor);
		this.firstSide = firstSide;
		this.secondSide = secondSide;
		this.thirdSide = thirdSide;
	}

	@Override
	public void draw() {
		System.out.println(this.toString() + " was drawn");
	}

	@Override
	public double calcArea() {
		// Обчислення площі за формулою Герона
		double s = (firstSide + secondSide + thirdSide) / 2;
		double area = Math.sqrt(s * (s - firstSide) * (s - secondSide) * (s - thirdSide));
		return area;
	}

	public double getFirstSide() {
		return firstSide;
	}

	public void setFirstSide(double firstSide) {
		this.firstSide = firstSide;
	}

	public double getSecondSide() {
		return secondSide;
	}

	public void setSecondSide(double secondSide) {
		this.secondSide = secondSide;
	}

	public double getThirdSide() {
		return thirdSide;
	}

	public void setThirdSide(double thirdSide) {
		this.thirdSide = thirdSide;
	}

	@Override
	public String toString() {
		return "Triangle [firstSide=" + firstSide + ", secondSide=" + secondSide + ", thirdSide=" + thirdSide + "]";
	}

}
