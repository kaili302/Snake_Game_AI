class Cell implements Constants{
	
	private int x;
	private int y;
	public Cell(int x, int y){
		this.x=x;
		this.y=y;
	}

	public int getX(){ return x;}
	public int getY(){ return y;}
	public void setX(int x){ this.x=x;}
	public void setY(int y){ this.y=y;}
	public static int getSize(){ return CELL_EDGE_PIXELS;}

	public int hashcode(){
		return x*MAP_WIDTH+y;
	}
	
	public boolean equals(Cell o){
		return this.hashcode()==o.hashcode();
	}	

	public String toString(){
		return "Cell position: ("+getX()+" ,"+getY()+")";
	}
}