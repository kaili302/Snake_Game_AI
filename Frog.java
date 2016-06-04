import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;

class Frog implements Constants{
	private Cell node;

	public Frog(Cell node){
		this.node=node;
	}
	
	public void setPosition(Cell node){
		this.node=node;
	} 

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		AffineTransform tr = g2.getTransform();
		g.setColor(FROG_COLOR);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        					RenderingHints.VALUE_ANTIALIAS_ON);
		g.fillRect(node.getX()*CELL_EDGE_PIXELS, node.getY()*CELL_EDGE_PIXELS, node.getSize(), node.getSize());
		g2.setTransform(tr);
	}

	public boolean isFrog(Cell node){
		return this.node.equals(node);
	}
}