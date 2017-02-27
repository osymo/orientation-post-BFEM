package ClasseGraphique;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class AboutApp extends JFrame{
private Dimension screenSize;

private JPanel mainPanel,secondaryPanel;

	public AboutApp(){
		try { UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");} 
		catch (Exception e) {}
		this.setTitle("A propos de High School Succces");
		this.setSize(new Dimension(400,450));
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		this.setResizable(false);
		this.setIconImage(new ImageIcon("toolbarIcones/about.png").getImage());
		this.setLocation(screenSize.width/2-this.getWidth()/2, screenSize.height/2-this.getHeight()/2);
		this.setVisible(true);
	
		mainPanel=new JPanel();
		secondaryPanel=new JPanel();
		mainPanel.setBackground(Color.white);
		mainPanel.setPreferredSize(new Dimension(this.getWidth(),350));
		secondaryPanel.setPreferredSize(new Dimension(this.getWidth(),50));
		secondaryPanel.setBackground(new Color(238,238,238));
		mainPanel.add(new JLabel("<html>"
																+ "<span style='color:rgb(28,164,217);font-style:italic;font-size:1.3em;font-weight:bold;'>High School Success</span> est une "
																+"<span style='color:rgb(187,121,91); font-size:1.4em;font-weight:bold;font-style:italic;'> Application </span> pour faciliter"
															
																		
													+ "</html>"));
		mainPanel.add(new JLabel("<html><span style='color:orange;font-size:2em;font-weight:bold;'>l'orientation </span>"
																	+ "des élèves après le <span  style='color:rgb(28,164,217);font-style:italic;font-size:1.7em;font-weight:bold;'> BFEM </span>"
																	+ " en se</html>"));
		mainPanel.add(new JLabel("<html>basant sur la <span style='color:rgb(28,164,217);font-size:1.3em;font-weight:bold;'>Mo</span>"
				+ "<span style='color:red;font-size:2em;font-weight:bold;'>Ye</span><span style='color:rgb(28,164,217);font-size:1.2em;font-weight:bold;'>nne</span> générale  obtenue en classe, les notes</html>"));
		mainPanel.add(new JLabel("<html>dans les matières <span style='color:orange;font-size:2em;font-weight:bold;'>dominantes</span> et les <span style='color:rgb(187,121,91); font-size:1.8em;font-weight:bold;'>"
				+ " Séries </span></html>"));
		mainPanel.add(new JLabel("<html>dans l'ordre de<span style='font-size:1.9em;font-weight:bold;'> préférence</span> de l'élève </html>"));
		mainPanel.add(new JLabel("<html>---------Copyright : juillet 2016---------</html>"));
		mainPanel.setBorder(BorderFactory.createTitledBorder("<html><u>information</u></html>"));
		
		secondaryPanel.add(new JLabel("<html><u style='color:cyan; font-weight:bold;''>DevTeam: </u>"
				+ "<span style='font-size:1.1em;'>  Omar Sidy Moctar Diop, </span></html>"));
		secondaryPanel.add(new JLabel("<html><span style='font-size:0.9em; font-weight:bold;'>Ousseynou Dieng,  </span></html>"));
		secondaryPanel.add(new JLabel("<html>Mor Seck, </html>"));
		secondaryPanel.add(new JLabel("<html>Cheikh Magueye Sylla, </html>"));
		secondaryPanel.add(new JLabel("<html>Mamadou Khabane Dia</html>"));
		secondaryPanel.add(new JLabel("<html><span style='font-size:0.9em; font-weight:bold;'>Djiby Faye, </span></html>"));
	
		
		this.getContentPane().setLayout(new FlowLayout());
		this.getContentPane().add(mainPanel);
		this.getContentPane().add(secondaryPanel);
		this.getContentPane().setBackground(new Color(255,255,255));
		
	}
	
	public static void main(String[] args)  {
		 JFrame.setDefaultLookAndFeelDecorated( true );
		 JDialog.setDefaultLookAndFeelDecorated( true );
		new AboutApp().setVisible(true);
	}
}
