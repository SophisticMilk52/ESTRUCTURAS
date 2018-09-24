package InterfazRational;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Options extends JPanel implements ActionListener {
	public static String SUMAR = "sumar";
	public static String RESTAR = "restar";
	public static String MULTIPLICAR = "multiplicar";
	public static String DIVIDIR = "dividir";
	public static String INVERTIR = "invertir";
	public static String KARATSUBA = "karatsuba";
	private JButton sumar, restar, multiplicar, dividir, invertir, karatsuba;

	private Principal pi;

	public Options(Principal fi) {
		pi = fi;
		setLayout(new GridLayout(3, 2));
		sumar = new JButton("Addition");
		sumar.setActionCommand(SUMAR);
		sumar.addActionListener(this);
		restar = new JButton("Substraccion");
		restar.setActionCommand(RESTAR);
		restar.addActionListener(this);
		multiplicar = new JButton("Multiplication");
		multiplicar.setActionCommand(MULTIPLICAR);
		multiplicar.addActionListener(this);
		dividir = new JButton("Division");
		dividir.setActionCommand(DIVIDIR);
		dividir.addActionListener(this);
		invertir = new JButton("Inverse");
		invertir.setActionCommand(INVERTIR);
		invertir.addActionListener(this);
		karatsuba = new JButton("Karatsuba");
		karatsuba.setActionCommand(KARATSUBA);
		karatsuba.addActionListener(this);

		add(sumar);
		add(restar);
		add(multiplicar);
		add(dividir);
		add(invertir);
		add(karatsuba);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals(SUMAR)) {
			try {
				pi.sumar();
				pi.cambiar();
			} catch (Exception e) {

			}
		} else if (arg0.getActionCommand().equals(RESTAR)) {
			try {
				pi.restar();
				pi.cambiar();	
			}catch(Exception e) {
				
			}
			
		} else if (arg0.getActionCommand().equals(MULTIPLICAR)) {
			try {
				pi.multiplicar();
				pi.cambiar();
			}catch(Exception e) {
				
			}
			
		} else if (arg0.getActionCommand().equals(DIVIDIR)) {
			try {
				pi.dividir();
				pi.cambiar();
			}catch(Exception e) {
				
			}
		} else if (arg0.getActionCommand().equals(INVERTIR)) {
			try {
				pi.invertir();
				pi.cambiar();
			}catch(Exception e) {
				
			}
		} else if (arg0.getActionCommand().equals(KARATSUBA)) {
			pi.karatsuba1();
			// pi.karatsuba2();
			pi.cambiar1();
			// pi.cambiar2();
		}

	}

}
