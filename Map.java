import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.Random;

class Map implements Constants{
	private static Map instance;
	private Snake snake;
	private Frog frog;
	private int step;

	private Map(){
		step=0;
		snake=new Snake();
		snake.insertHead(nextRandomPosition());
		frog=new Frog();
	}

	public static Map getMap(){
		if (instance==null) instance=new Map();
		return instance;
	}

	private Random random=null;
	public Cell nextRandomPosition(){
		if (random==null) {
			random=new Random();
		}
		Cell nextPosition=null;
		int x, y;
		do{
			x=random.nextInt(MAP_WIDTH);
			y=random.nextInt(MAP_HEIGHT);
			nextPosition=new Cell(x, y);
		}while (snake.contains(nextPosition));
		return nextPosition;
	}

	public void paintMap(Graphics g) {
		this.snake.paint(g);
		this.frog.paint(g);
		g.setColor(Color.BLUE);
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		g.drawString(String.valueOf(step), 5, 25);
	}
}