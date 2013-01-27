package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.GridLayout;

public class Accueil extends JPanel {
	
	private final static String IMAGE = ".\\image\\menu.jpg";
	private Image background;

	public Accueil() {
		setLayout(new GridLayout(1, 0, 0, 0));
		background = getToolkit().getImage(IMAGE);

	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background, 0, 0, this);

	}
}
