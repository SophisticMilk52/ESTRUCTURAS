package InterfazRational;

import java.awt.BorderLayout;
import java.math.BigInteger;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import racional.RationalNumber;

public class Principal extends JFrame {
	private Text texto;
	private Options op;
	private String kat;
	private String kat1;
	private RationalNumber mundo;

	public Principal() {
	mundo= new RationalNumber(0,0);
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
		try {
			Principal v = new Principal();
			v.setVisible(true);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	public void refrescar() {
		texto.removeAll();
		texto.repaint();
		texto.revalidate();
	}
	public void karatsuba1() {
		this.mundo.setNumerador(this.numerator1Big());
		this.mundo.setDenominador(this.numerator2Big());
kat=this.mundo.karatsuba(this.numerator2Big(),this.numerator1Big())+"";
	}
//	public void karatsuba2() {
//		this.mundo.setNumerador(this.denominador1Big());
//		this.mundo.setDenominador(this.denominador2Big());
//kat1=this.mundo.karatsuba(this.denominador1Big(),this.denominador2Big())+"";
//	}
	public String respuestabig1() {
		JOptionPane.showMessageDialog(null, "RESPUESTA KARATSUBA:"+  kat);
	//	System.out.println("RESPUESTA: "+kat);
		return  kat+"";

		}
	public String respuestabig2() {
		System.out.println("RESPUESTA: "+kat1);
		return  kat1+"";

		}
public void sumar() {
	this.mundo.setNumerador(this.numerator1());
	this.mundo.setDenominador(this.denominador1());
	this.mundo.addRational(new RationalNumber(this.numerator2(),this.denominador2()));

}
public void restar() {
	this.mundo.setNumerador(this.numerator1());
	this.mundo.setDenominador(this.denominador1());
	System.out.println(this.mundo.getNumerator()+" "+this.mundo.getDenominator());
	this.mundo.substractRational(new RationalNumber(this.numerator2(),this.denominador2()));

}
public void dividir() {
	this.mundo.setNumerador(this.numerator1());
	this.mundo.setDenominador(this.denominador1());
	this.mundo.divideRational(new RationalNumber(this.numerator2(),this.denominador2()));

}
public void multiplicar() {
	this.mundo.setNumerador(this.numerator1());
	this.mundo.setDenominador(this.denominador1());
	this.mundo.multiplyRational(new RationalNumber(this.numerator2(),this.denominador2()));

}
public String respuesta1() {
return  this.mundo.getNumerator()+"";

}

public String respuesta2() {
return this.mundo.getDenominator()+"";

}
public void cambiar() {
	this.texto.cambiar();
}
public void cambiar2() {
	this.texto.cambiar2();
}
public void cambiar1() {
	this.texto.cambiar1();
}
public void invertir() {
	this.mundo.setNumerador(this.numerator1());
	this.mundo.setDenominador(this.denominador1());
	this.mundo.rationalInverse();
}
public int numerator1() {
		return texto.numerador1();
	}
public BigInteger numerator1Big() {
	return texto.numerador1Big();
}
public BigInteger numerator2Big() {
	return texto.numerador2Big();
}

//public BigInteger denominador1Big() {
//	return texto.denominador1Big();
//}
//public BigInteger denominador2Big() {
//	return texto.denominador2Big();
//}

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
