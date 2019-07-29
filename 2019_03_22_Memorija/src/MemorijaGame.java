import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MemorijaGame extends JFrame
{
	MemorijaEngine engine = new MemorijaEngine();
	
	JPanel jpNorth = null;
	JPanel jpCenter = null;
	JPanel jpSouth = null;
	
	JLabel lbBrojPogodjenih = null;
	JLabel lbBrojPokusaja = null;
	
	MemorijaButton buttons[][] = new MemorijaButton[5][6];
	
	public MemorijaGame() 
	{
		super("Igra memorije");
		setBounds(100, 100, 500, 500);
		setMinimumSize(new Dimension(500, 500));
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().setBackground(Color.GRAY);
	
		setNorth();
		setCentar();
		setSouth();
	}
	
	void setNorth()
	{
		// setovanje panela na vrhu
		
		jpNorth = new JPanel();
		jpNorth.setLayout(new GridLayout(1, 2, 5, 5));
		
		lbBrojPogodjenih = new JLabel("Broj pogodjenih: " + engine.getBrojPogodjenih());
		lbBrojPogodjenih.setForeground(Color.WHITE);
		lbBrojPogodjenih.setFont(new Font("Arial", 1, 20));
		lbBrojPokusaja = new JLabel("Broj pokusaja: " + engine.getBrojPokusaja());
		lbBrojPokusaja.setForeground(Color.WHITE);
		lbBrojPokusaja.setFont(new Font("Arial", Font.BOLD, 20));
		
		jpNorth.add(lbBrojPogodjenih);
		jpNorth.add(lbBrojPokusaja);
		
		getContentPane().add(jpNorth, BorderLayout.NORTH);
		pack();
	}
	
	void setCentar()
	{
		jpCenter = new JPanel();
		jpCenter.setLayout(new GridLayout(5, 6));
		
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[i].length; j++) 
			{
				buttons[i][j] = new MemorijaButton(i, j);
				buttons[i][j].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						MemorijaButton b = (MemorijaButton)e.getSource();
						engine.odograjPotez(b.getI(), b.getJ());
						refeshGui();
						
					}
				});
				jpCenter.add(buttons[i][j]);
			}
		}
		getContentPane().add(jpCenter, BorderLayout.CENTER);
		pack();
	}
	
	void setSouth()
	{
		jpSouth = new JPanel();
		jpSouth.setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton novaPartija = new JButton("Nova partija");
		novaPartija.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				engine.newGame();
				refeshGui();
				
			}
		});
		jpSouth.add(novaPartija);
		getContentPane().add(jpSouth, BorderLayout.SOUTH);
		pack();
		
	}
	
	void refeshGui()
	{
		lbBrojPogodjenih.setText("Broj pogodjenih: " 
								+ engine.getBrojPogodjenih());
		lbBrojPokusaja.setText("Broj pokusaja: " 
								+ engine.getBrojPokusaja());
		for (int i = 0; i < buttons.length; i++) 
		{
			for (int j = 0; j < buttons[i].length; j++)
			{
				ImageIcon icon = null;
				int vrednost = engine.getVrednostPolja(i, j);
				if(vrednost != -1)
					icon = new ImageIcon("src\\images\\"+ vrednost +".png");
				else
					icon = new ImageIcon();
				buttons[i][j].setIcon(icon);
			}
		}
		pack();
	}
	
	public static void main(String[] args) {
		new MemorijaGame();
	}
}
