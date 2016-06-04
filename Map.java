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
		snake=new Snake(nextRandomPosition());
		frog=new Frog(nextRandomPosition());
	}

	public static Map getMap(){
		if (instance==null) instance=new Map();
		return instance;
	}

	public boolean run(){
		step++;
		if (MAP_HEIGHT%2==0){
			Cell head=snake.getHead();
			int col=head.getX();
			int line=head.getY();
			if (col==MAP_WIDTH-1 && line!=0) return moveSnake(UP);
			else if (col==MAP_WIDTH-1 && line==0) return moveSnake(LEFT);
			else if (line%2==0) {
				if (col==0) return moveSnake(DOWN);
				else return moveSnake(LEFT);
			}else{
				if (col==MAP_WIDTH-2 && line != MAP_HEIGHT-1) return moveSnake(DOWN);
				else return moveSnake(RIGHT);
			}
		}	
		return false;
	}

	public boolean moveSnake(char direct){
		Cell nextPosition =null;
		Cell snakeHead =snake.getHead();
		switch(direct){
			case LEFT:
				nextPosition=snakeHead.getLeft();
				break;
			case RIGHT:
				nextPosition=snakeHead.getRight();
				break;
			case UP:
				nextPosition=snakeHead.getUp();
				break;
			case DOWN:
				nextPosition=snakeHead.getDown();
				break;
		}
		if (!nextPosition.isValid() || snake.contains(nextPosition)) return false;

		if (frog.isFrog(nextPosition)){
			snake.addHead(nextPosition);
			frog.setPosition(nextRandomPosition());
		}else {
			snake.addHead(nextPosition);
			snake.removeTail();
		}
		return true;
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
		}while (snake!=null && snake.contains(nextPosition));
		return nextPosition;
	}

	public void paintMap(Graphics g) {
		this.snake.paint(g);
		this.frog.paint(g);
		g.setColor(Color.BLUE);
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		g.drawString(String.valueOf(step), 5, 25);
	}
}