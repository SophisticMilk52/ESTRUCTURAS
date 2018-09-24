package InterfazRational;

import java.awt.GridLayout;
import java.math.BigInteger;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class Text extends JPanel {

private JTextField nominatro1,nominatro2,denominator1,denominator2,respuestanominator,respuestadenominator;
private Principal fi;
public Text(Principal fi) {
	this.fi= fi;
setLayout(new GridLayout(1,3));
nominatro1=new JTextField();
denominator1= new JTextField();
nominatro2=new JTextField();
denominator2=new JTextField();
respuestanominator=new JTextField();
respuestadenominator=new JTextField();
respuestanominator.setEditable(false);
respuestadenominator.setEditable(false);
add(nominatro1);
add(nominatro2);
add(respuestanominator);
//add(denominator1);
//add(denominator2);
//add(respuestadenominator);
}

public BigInteger numerador1Big() {
BigInteger aux= new BigInteger(nominatro1.getText());
	return aux;
}
public BigInteger numerador2Big() {
BigInteger aux= new BigInteger(nominatro2.getText());
	return aux;
}
//public BigInteger denominador1Big() {
//BigInteger aux= new BigInteger(denominator1.getText());
//	return aux;
//}
//public BigInteger denominador2Big() {
//BigInteger aux= new BigInteger(denominator2.getText());
//	return aux;
//}
public int numerador1() {
	int numero= Integer.parseInt(nominatro1.getText());
	return numero;
}
public int denominador1() {
	int numero=  Integer.parseInt(denominator1.getText());
	return numero;
}
public int numerador2() {
	int numero= Integer.parseInt(nominatro2.getText());
	return numero;
}
public int denominador2() {
	int numero=  Integer.parseInt(denominator2.getText());
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
this.respuestanominator.setText(fi.respuesta1()+"");	
this.respuestadenominator.setText(fi.respuesta2()+"");	

}
public void cambiar1() {
this.respuestanominator.setText(fi.respuestabig1()+"");	


}
public void cambiar2() {
this.respuestadenominator.setText(fi.respuestabig2()+"");	


}
}
