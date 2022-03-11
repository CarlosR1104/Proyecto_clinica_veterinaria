package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class VentanaConsultIndividual extends JDialog {
	private JTextField txtDocumento;
	private JButton btnConsultar;
	private JPanel panel;
	private JTextArea area;
	private JScrollPane scroll;
	
	
	public VentanaConsultIndividual() {
		setSize(500,500);
		setLayout(null);
		setTitle("Consulta ");
		setLocationRelativeTo(null);
		iniciarComponentes();
		
	}
	
	public void iniciarComponentes() {
	
		
		panel= new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);
		setContentPane(panel);
		
		
		
		JLabel etiDocumento=new JLabel("Documento");
		etiDocumento.setBounds(90,40,150,24);
		panel.add(etiDocumento);
		
		txtDocumento=new JTextField();
		txtDocumento.setBounds(165,40,150,24);
		panel.add(txtDocumento);
		
		btnConsultar=new JButton("Buscar");
		btnConsultar.setBounds(330,40,90,24);
		panel.add(btnConsultar);
		
		area=new JTextArea();
		
		
		scroll=new JScrollPane(area);
		scroll.setBounds(20,100,400,300);
		panel.add(scroll);
		
		
	}
	public static void main(String[] args) {
		VentanaConsultIndividual v =new VentanaConsultIndividual();
		v.setVisible(true);
	}
}
