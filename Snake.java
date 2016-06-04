import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.LinkedList;
import java.util.HashSet;

class Snake{
	private LinkedList<Cell> nodes;
	private HashSet<Cell> hashSet;

	public Snake(){
		nodes=new LinkedList<Cell>();
		hashSet=new HashSet<Cell>();
		//insertHead(node);
	}

	public void insertHead(Cell node){
		nodes.addFirst(node);
		hashSet.add(node);
	}

	public Cell removeTail(){
		Cell node=nodes.removeLast();
		hashSet.remove(node);
		return node;
	}

	public boolean contains(Cell node){
		return hashSet.contains(node);
	}

	public void paint(Graphics g) {
          Graphics2D g2 = (Graphics2D) g;
          g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                              RenderingHints.VALUE_ANTIALIAS_ON);
    	  for (Cell cell : this.nodes) {
              g.fillOval(cell.getX(), cell.getY(), cell.getSize(), cell.getSize());
        }
	}
}