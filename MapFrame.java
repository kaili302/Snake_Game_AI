import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MapFrame extends JFrame implements Constants{
	private JPanel content;

	public MapFrame(){
		super("Snake Game: an AI version");
		prepareGUI();
	}

	private void prepareGUI(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		content = new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Map.getMap().paintMap(g);
			}
		};
		content.setPreferredSize(new Dimension(
            		MAP_WIDTH * CELL_EDGE_PIXELS,
                    MAP_HEIGHT * CELL_EDGE_PIXELS));
		setContentPane(content);
		new Thread(new Runnable() {
			@Override
			public void run() {
			    while (Map.getMap().run()){
					try {
		                Thread.sleep(SLEEP);
		            } catch (Exception e) {
		            }
					content.repaint();
				}
				//System.exit(0);
			}
		}).start();
	}

	public static void main(String[] args){
		MapFrame mapFrame =new MapFrame();
		mapFrame.pack();
        mapFrame.setLocationRelativeTo(null);
        mapFrame.setVisible(true);
	}
}