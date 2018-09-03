package InterfazRational;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Text extends JPanel {

	private JTextField nominatro1, nominatro2, denominator1, denominator2, respuestanominator, respuestadenominator;
	private Principal fi;
	private JLabel mensaje, vacio1, vacio2;

	public Text(Principal fi) {
		this.fi = fi;
		setLayout(new GridLayout(3, 3));
		nominatro1 = new JTextField();
		mensaje = new JLabel("If you want to Inverse,simplify or scuared just but the values here");
		vacio1 = new JLabel();
		vacio2 = new JLabel();
		denominator1 = new JTextField();
		nominatro2 = new JTextField();
		denominator2 = new JTextField();
		respuestanominator = new JTextField();
		respuestadenominator = new JTextField();
		respuestanominator.setEditable(false);
		respuestadenominator.setEditable(false);
		add(mensaje);
		add(vacio1);
		add(vacio2);
		add(nominatro1);
		add(nominatro2);
		add(respuestanominator);
		add(denominator1);
		add(denominator2);
		add(respuestadenominator);
	}

	public int numerador1() {
		int numero = 0;
		if (nominatro1.getText().equals("")) {
			numero = 0;
		} else {

			try {

				numero = Integer.parseInt(nominatro1.getText());
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "mucho kevin le metio letra");
			}
		}

		return numero;
	}

	public int denominador1() {
		int numero = 0;
		if (denominator1.getText().equals("")) {
			numero = 0;
		} else {
			try {
				numero = Integer.parseInt(denominator1.getText());
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "mucho kevin le metio letra");
			}
		}

		return numero;
	}

	public int numerador2() {
		int numero = 0;
		if (nominatro2.getText().equals("")) {
			numero = 0;
		} else {

			try {

				numero = Integer.parseInt(nominatro2.getText());
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "mucho kevin le metio letra");
			}
		}

		return numero;
	}

	public int denominador2() {
		int numero = 0;
		if (denominator2.getText().equals("")) {
			numero = 0;
		} else {

			try {

				numero = Integer.parseInt(denominator2.getText());
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "mucho kevin le metio letra");
			}
		}

		return numero;
	}

	public JTextField getRespuestanominator() {
		return respuestanominator;
	}

	public void setRespuestanominator(JTextField respuestanominator) {
		this.respuestanominator = respuestanominator;
	}

	public JTextField getRespuestadenominator() {
		return respuestadenominator;
	}

	public void setRespuestadenominator(JTextField respuestadenominator) {
		this.respuestadenominator = respuestadenominator;
	}

	public void cambiar() {
		this.respuestanominator.setText(fi.respuesta1() + "");
		this.respuestadenominator.setText(fi.respuesta2() + "");

	}
}
