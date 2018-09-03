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
	public static String SCUARE = "scuare";
	public static String SIMP = "simplify";
	private JButton sumar, restar, multiplicar, dividir, invertir, scuare, simplificar;

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
		scuare = new JButton("Scuare");
		scuare.setActionCommand(SCUARE);
		scuare.addActionListener(this);
		simplificar = new JButton("Simplify");
		simplificar.setActionCommand(SIMP);
		simplificar.addActionListener(this);
		add(sumar);
		add(restar);
		add(multiplicar);
		add(dividir);
		add(invertir);
		add(scuare);
		add(simplificar);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals(SUMAR)) {
			pi.sumar();
			pi.cambiar();
		} else if (arg0.getActionCommand().equals(RESTAR)) {
			pi.restar();
			pi.cambiar();
		} else if (arg0.getActionCommand().equals(MULTIPLICAR)) {
			pi.multiplicar();
			pi.cambiar();
		} else if (arg0.getActionCommand().equals(DIVIDIR)) {
			pi.dividir();
			pi.cambiar();
		} else if (arg0.getActionCommand().equals(INVERTIR)) {
			pi.invertir();
			pi.cambiar();
		} else if (arg0.getActionCommand().equals(SCUARE)) {
			pi.scuare();
			pi.cambiar();
		}else if (arg0.getActionCommand().equals(SIMP)) {
			pi.simplify();
			pi.cambiar();
		}

	}

}
