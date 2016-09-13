
import java.awt.Color;
import java.awt.Graphics;


import javax.swing.JComponent;

public class CarStage extends JComponent {

	private static final long serialVersionUID = 1L;

	static int counter = 0;

	MutableCar theCar = new MutableCar(0,0, Color.BLUE, 100, 1);

	boolean wallHit = false;

	boolean carReachedBottom = false;

	public boolean getReachedBottom() { return carReachedBottom; }
	public void paintComponent (Graphics g) {

		theCar.draw(g);

		if (theCar.getYPos() + 70 > this.getHeight()) {
			carReachedBottom = true;
		}

		if (wallHit){
			theCar.setPosition(theCar.getXPos(), theCar.getYPos() + 40);
			theCar.setHorizontalDirection(theCar.getHorizontalDirection()*-1);
			wallHit = false;
		}

		else{

			if (theCar.getXPos() + 60 >= this.getWidth() && theCar.getHorizontalDirection() > 0){
				theCar.setPosition(this.getWidth() - 60, theCar.getYPos());
				wallHit = true;
			}

			else if(theCar.getXPos() <= 0 && theCar.getHorizontalDirection() < 0){
				theCar.setPosition(0,  theCar.getYPos());
				wallHit = true;
			}

			else {
				theCar.setPosition(theCar.getXPos() + theCar.getHorizontalDirection()*theCar.getHorizontalSpeed(), theCar.getYPos());
			}
		}

		System.out.println(counter++);//To know how many times is the frame being repainted
	}
}
