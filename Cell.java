class Cell implements Constants{
	
	private int x;	//colum number
	private int y;	//line number
	public Cell(int x, int y){
		this.x=x;
		this.y=y;
	}

	public int getX(){ return x;}
	public int getY(){ return y;}
	public void setX(int x){ this.x=x;}
	public void setY(int y){ this.y=y;}
	public static int getSize(){ return CELL_EDGE_PIXELS;}

	public int hashCode(){
		return y*MAP_WIDTH+x;
	}
	
	public boolean equals(Cell o){
		return this.hashCode()==o.hashCode();
	}	

	public String toString(){
		return "Cell position: ("+getX()+" ,"+getY()+")";
	}

	public boolean isValid(){
		return y>=0 && y< MAP_HEIGHT && x>=0 && x<MAP_WIDTH;
	}

	public Cell getUp(){
		return new Cell(x, y-1);
	}

	public Cell getDown(){
		return new Cell(x, y+1);
	}

	public Cell getLeft(){
		return new Cell(x-1, y);
	}

	public Cell getRight(){
		return new Cell(x+1, y);
	}
}