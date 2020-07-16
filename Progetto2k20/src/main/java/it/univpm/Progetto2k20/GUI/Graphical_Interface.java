package it.univpm.Progetto2k20.GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.IconUIResource;


import it.univpm.Progetto2k20.model.*;
import it.univpm.Progetto2k20.service.*;
import it.univpm.Progetto2k20.stats.Statistiche;
import it.univpm.Progetto2k20.utils.*;

/**
 * Classe che modella l'interfaccia grafica
 *
 */

public class Graphical_Interface {
	
	public Graphical_Interface() {
		
		//creo la finestra 
		JFrame GUI = new JFrame("Twitter search");
		//scelgo le dimensioni della finestra e la rendo non ridimensionabile 
		GUI.setBounds(550, 250, 500, 500);
		GUI.setResizable(false);
		
		
		//colore di sfondo 
		//GridBagLayout divide la finestra in righe e colonne e tu decidi in quale riga e colonna inserire i componenti
		Container c = GUI.getContentPane();
		c.setBackground(new Color(180, 230, 240));
		c.setLayout(new GridBagLayout());
		GridBagConstraints g = new GridBagConstraints();

		//aggiunge il logo
		//gridx e gridy coordinate della posizione del bottone
		//i valori di x (colonna) aumentano da sinistra a destra, i valori di y (riga) aumentano dall'alto verso il basso
		ImageIcon logo = new ImageIcon(Graphical_Interface.class.getResource("logo4.png"));
		JLabel foto = new JLabel(logo);
		g.gridx = 0;
		g.gridy = 0;
		g.insets.bottom = 10;
		GUI.add(foto, g);

		//aggiunge l'etichetta 
		JLabel titolo = new JLabel("<html>Destinazione Marche</html>");
		titolo.setForeground(new Color(0, 112, 155));
		Font f = new Font("Forte", Font.ITALIC, 25);
		titolo.setFont(f);
		g.gridx = 1;
		g.gridy = 0;
		GUI.add(titolo, g);

		//lascia uno spazio tra il titolo e i tasti 
		JLabel spazio = new JLabel("<html><br></html>");
		g.gridx = 1;
		g.gridy = 1;
		GUI.add(spazio, g);
		
		//get data
		JButton bottone1 = new JButton("JSON dati");
		g.gridx = 0;
		g.gridy = 3;
		g.gridwidth = 2;
		GUI.add(bottone1, g);
		bottone1.addActionListener(new b1());
		
		//get metadati
		JButton bottone2 = new JButton("JSON metadati");
		g.gridx = 0;
		g.gridy = 4;
		g.gridwidth = 2;
		GUI.add(bottone2, g);
		bottone2.addActionListener(new b2());

		//get stat numero tweet esteri
		JButton bottone3 = new JButton("JSON numero tweet esteri");
		g.gridx = 0;
		g.gridy = 5;
		g.gridwidth = 2;
		GUI.add(bottone3, g);
		bottone3.addActionListener(new b3());
				
		//get stats per lingua o location 
		JButton bottone4 = new JButton("JSON statistiche");
		g.gridx = 0;
		g.gridy = 6;
		g.gridwidth = 2;
		GUI.add(bottone4, g);
		bottone4.addActionListener(new b4());
		
		//get frequenza
		JButton bottone5 = new JButton("JSON frequenza per lingua");
		g.gridx = 0;
		g.gridy = 7;
		g.gridwidth = 2;
		GUI.add(bottone5, g);
		bottone5.addActionListener(new b5());
						
		//rende visibile la finestra 
		GUI.setVisible(true);

		//chiude la finestra altrimenti il suo processo rimane in background 
		GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		UIManager.put("OptionPane.background", new ColorUIResource(180, 230, 240));
		UIManager.put("Panel.background", new ColorUIResource(180, 230, 240));
		UIManager.put("OptionPane.inputDialogTitle", "Inserisci...");
		ImageIcon ic = new ImageIcon(Graphical_Interface.class.getResource("logo4.png"));
		UIManager.put("OptionPane.questionIcon", new IconUIResource(ic));
		ImageIcon inf=new ImageIcon(Graphical_Interface.class.getResource("logo4.png"));
		UIManager.put("OptionPane.informationIcon", new IconUIResource(inf));
		UIManager.put("OptionPane.warningIcon", new IconUIResource(inf));
		UIManager.put("OptionPane.errorIcon", new IconUIResource(inf)); 
}
	
	/**
	 * Inner class che implementa ActionListener e permette il funzionamento del
	 * bottone1
	 * 
	 * @see ActionListener
	 *
	 */
		private class b1 implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String s;
				ArrayList<Tweet> st = JSONParse.parsaJson(JSONObject.downloadTweets());
				
				s="[\n";
				for (Tweet t : st) {
					
							s+="{\n" + "\"created_at\":" + t.getCreated_at() 
							+  "\n\"text\":" + t.getText()
							+ "\n\"id\":" + t.getId() 
							+ "\n\"language_post\":" + t.getlanguage_post()
							+ "\n\"user\": {"
							+ "\n\"name_user\":" + t.getname()
							+ "\n\"screen_name\":" + t.getScreen_name()
							+ "\n\"location_user\":" + t.getlocation_user()
							+ "\n\"id_user\":" + t.getid_user() 
							+ "\n\"numpost_user\":" + t.getnumpost_user()
							+ "\n}" + "\n}, \n";
				}
				
			     s+="]";
				
				JTextArea textArea = new JTextArea(s);
				JScrollPane scrollPane = new JScrollPane(textArea);  
				textArea.setLineWrap(true);  
				textArea.setWrapStyleWord(true); 
				textArea.setEditable(false);
				textArea.setEnabled(true);
				scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
				JOptionPane.showMessageDialog(null, scrollPane, "Dati JSON",  
				                                       JOptionPane.YES_NO_OPTION);
				
				
			}

		}
		
		/**
		 * Inner class che implementa ActionListener e permette il funzionamento del
		 * bottone2
		 * 
		 * @see ActionListener
		 *
		 */
		private class b2 implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String s;
				ArrayList<Metadata> md = Metadati.getMetadata();
				
				s="[\n";
				for (Metadata m : md) {
					
				  s+=("{ \n" + "\"nome\":" + m.getName() + "\n\"descrizione\":"
							+ m.getSourceField() + "\n\"tipo\":" + m.getType() + "\n}\n");
				}
				
				s+="]";
				
				JTextArea textArea = new JTextArea(s);
				JScrollPane scrollPane = new JScrollPane(textArea);  
				textArea.setLineWrap(true);  
				textArea.setWrapStyleWord(true); 
				textArea.setEditable(false);
				textArea.setEnabled(true);
				scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
				JOptionPane.showMessageDialog(null, scrollPane, "Metadati JSON",  
				                                       JOptionPane.YES_NO_OPTION);

			}

		}
		
		/**
		 * Inner class che implementa ActionListener e permette il funzionamento del
		 * bottone3
		 * 
		 * @see ActionListener
		 *
		 */
		private class b3 implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
					
					
					Stat st = UploadStat.getStat();
					String s="{\n" + "\"utentiEstero\":" + st.getUtentiEstero()+ "\n} \n";
					
					JTextArea textArea = new JTextArea(s);
					JScrollPane scrollPane = new JScrollPane(textArea);  
					textArea.setLineWrap(true);  
					textArea.setWrapStyleWord(true); 
					textArea.setEditable(false);
					textArea.setEnabled(true);
					scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
					JOptionPane.showMessageDialog(null, scrollPane, "Numero di tweet esteri",  
					                                       JOptionPane.YES_NO_OPTION);
				

			}

		}
		/**
		 * Inner class che implementa ActionListener e permette il funzionamento del
		 * bottone4
		 * 
		 * @see ActionListener
		 *
		 */
		private class b4 implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
					
				String s=JOptionPane.showInputDialog("Field consentiti:\n"
						+ "language_post -> conta e stampa le varie lingue dei tweet\n"
						+ "location_user -> stampa tutte le location con conteggio dei tweet\n"
						);
					Stats s1 = StatsService.getStats(JSONParse.parsaJson(JSONObject.downloadTweets()), s);
					String s2="{\n" + "\"result\":" + s1.getResult()+ "\n} \n";
					
					JTextArea textArea = new JTextArea(s2);
					JScrollPane scrollPane = new JScrollPane(textArea);  
					textArea.setLineWrap(true);  
					textArea.setWrapStyleWord(true); 
					textArea.setEditable(false);
					textArea.setEnabled(true);
					scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
					JOptionPane.showMessageDialog(null, scrollPane, "Statistiche",  
					                                       JOptionPane.YES_NO_OPTION);
				

			}

		}
		/**
		 * Inner class che implementa ActionListener e permette il funzionamento del
		 * bottone5
		 * 
		 * @see ActionListener
		 *
		 */
		 private class b5 implements ActionListener {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
					
					String s=JOptionPane.showInputDialog("Inserisci la lingua del post (es. en) : ");
					
					if(s!=null) {
						
						String s2="";
						ArrayList<Frequenze> fre = new ArrayList<Frequenze>();
						ArrayList<Tweet> twe = JSONParse.parsaJson(JSONObject.downloadTweets());
						ArrayList<Tweet> t1 =new ArrayList<Tweet>();
						for(Tweet t: twe) {
							if(t.getlanguage_post().equals(s)) 
								t1.add(t);
						}
						if(!t1.isEmpty()) {
					

						fre = Statistiche.frequenza_settimana(t1);
						s2="[\n";
						for (Frequenze f : fre) {
							s2+="{ \n" + "\"numpost\":" + f.getNumpost() + "\n\"giorno\":"
									+ f.getGiorno() + "\n}";
						}
						s2+="\n]";
						JTextArea textArea = new JTextArea(s2);
						JScrollPane scrollPane = new JScrollPane(textArea);  
						textArea.setLineWrap(true);  
						textArea.setWrapStyleWord(true); 
						textArea.setEditable(false);
						textArea.setEnabled(true);
						scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
						JOptionPane.showMessageDialog(null, scrollPane, "Frequenza per lingua JSON",  
						                                       JOptionPane.YES_NO_OPTION);
						} 
						else {
							s2+="La lingua non esiste";
							JTextArea textArea = new JTextArea(s2);
							JScrollPane scrollPane = new JScrollPane(textArea);  
							textArea.setLineWrap(true);  
							textArea.setWrapStyleWord(true); 
							textArea.setEditable(false);
							textArea.setEnabled(true);
							scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
							JOptionPane.showMessageDialog(null, scrollPane, "Frequenza per lingua JSON",  
							                                       JOptionPane.YES_NO_OPTION);
						}
					
					}
					else {
						
						String s3="";
						s3+="Non hai passato una lingua";
						JTextArea textArea = new JTextArea(s3);
						JScrollPane scrollPane = new JScrollPane(textArea);  
						textArea.setLineWrap(true);  
						textArea.setWrapStyleWord(true); 
						textArea.setEditable(false);
						textArea.setEnabled(true);
						scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
						JOptionPane.showMessageDialog(null, scrollPane, "Frequenza per lingua JSON",  
						                                       JOptionPane.YES_NO_OPTION);
						
					}
					
						

			}
		 }
			




}


		
	

