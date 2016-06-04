import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

class Frog{
	private Cell node;
	
	public Frog(){
	}

	public void setPosition(Cell node){
		this.node=node;
	} 

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		AffineTransform tr = g2.getTransform();
		g.setColor(Color.GREEN);
		g.fillRect(node.getX(), node.getY(), node.getSize(), node.getSize());
		g2.setTransform(tr);
	}

	
}