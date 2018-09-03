package InterfazRational;

import java.awt.BorderLayout;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JTextField;

import racional.RationalNumber;

public class Principal extends JFrame {
	private Text texto;
	private Options op;
	private RationalNumber mundo;

	public Principal() {
		mundo = new RationalNumber(0, 0);
		texto = new Text(this);
		setLayout(new BorderLayout());
		setSize(600, 600);
		op = new Options(this);
		add(texto, BorderLayout.NORTH);
		add(op, BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();

	}

	public static void main(String[] args) {

		Principal v = new Principal();
		v.setVisible(true);

	}

	public void simplify() {
		this.mundo.setNumerador(this.numerator1());
		this.mundo.setDenominador(this.denominador1());
		mundo.simplifyRational();
	}

	public void scuare() {
		this.mundo.setNumerador(this.numerator1());
		this.mundo.setDenominador(this.denominador1());
		mundo.squaredRational();
	}

	public void refrescar() {
		texto.removeAll();
		texto.repaint();
		texto.revalidate();
	}

	public void sumar() {
		this.mundo.setNumerador(this.numerator1());
		this.mundo.setDenominador(this.denominador1());
		this.mundo.addRational(new RationalNumber(this.numerator2(), this.denominador2()));

	}

	public void restar() {
		this.mundo.setNumerador(this.numerator1());
		this.mundo.setDenominador(this.denominador1());
		System.out.println(this.mundo.getNumerator() + " " + this.mundo.getDenominator());
		this.mundo.substractRational(new RationalNumber(this.numerator2(), this.denominador2()));

	}

	public void dividir() {
		this.mundo.setNumerador(this.numerator1());
		this.mundo.setDenominador(this.denominador1());
		this.mundo.divideRational(new RationalNumber(this.numerator2(), this.denominador2()));

	}

	public void multiplicar() {
		this.mundo.setNumerador(this.numerator1());
		this.mundo.setDenominador(this.denominador1());
		this.mundo.multiplyRational(new RationalNumber(this.numerator2(), this.denominador2()));

	}

	public int respuesta1() {
		return (int) this.mundo.getNumerator();

	}

	public int respuesta2() {
		return (int) this.mundo.getDenominator();

	}

	public void cambiar() {
		this.texto.cambiar();
	}

	public void invertir() {
		this.mundo.setNumerador(this.numerator1());
		this.mundo.setDenominador(this.denominador1());
		this.mundo.rationalInverse();
	}

	public int numerator1() {
		return texto.numerador1();
	}

	public int denominador1() {
		return texto.denominador1();
	}

	public int numerator2() {
		return texto.numerador2();
	}

	public int denominador2() {
		return texto.denominador2();
	}
}
