

import java.awt.Graphics;
import java.awt.Polygon;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

//"/home/alan/Dropbox/FAP/8 semestre/Computação Gráfica/dino.dat"
public class DinoDotDat extends JPanel {

//	int[] xValues = new int[500];
//	int[] yValues = new int[500];
	
	int xValue;
	int yValue;

	int groupSize;
	
	List<String> lineByLine = new ArrayList<>();

	public static void main(String[] args) {
		DinoDotDat dino = new DinoDotDat();
		dino.readDotDatArch("/home/alan/Dropbox/FAP/8 semestre/Computação Gráfica/dino.dat");
		JFrame frame = new JFrame("Dino");
		frame.add(dino);
		frame.setBounds(20, 20, 600, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int pontoAtual = 0;
		int qtdDeLinhas = 0;
		int cont = 0;
		String poligono;
		Polygon polygon = new Polygon();
		for(int i=0; i < groupSize; i++){
			qtdDeLinhas = Integer.parseInt(lineByLine.get(pontoAtual));
					pontoAtual++;
			System.out.println(pontoAtual);
			for (int j=1; j <= qtdDeLinhas; j++) {
				poligono = lineByLine.get(pontoAtual);
				String[] temp = poligono.split(" ");
				xValue = Integer.parseInt(temp[0]);
				yValue = Integer.parseInt(temp[1]);
				cont ++;
				pontoAtual++;
				polygon.addPoint(xValue, yValue);
				System.out.println(cont);
				System.out.println(pontoAtual);
			}
			//pontoAtual++;???
		}
		g.drawPolygon(polygon);
//		Polygon polygon = new Polygon(xValues, yValues, qtdDeLinhas);
//		polygon.addPoint(x, y);
//		g.drawPolygon(polygon);
	}

	public void readDotDatArch(String path) {
		try {
			FileReader arch = new FileReader(path);
			BufferedReader rdArch = new BufferedReader(arch);
			String line = rdArch.readLine();
			groupSize = Integer.parseInt(line);
			while (line != null) {
				line = rdArch.readLine();
				lineByLine.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}