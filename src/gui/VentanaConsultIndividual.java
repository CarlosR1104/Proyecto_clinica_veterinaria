package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import VO.MascotaVo;
import VO.PersonaVo;
import controlador.Coordinador;

public class VentanaConsultIndividual extends JDialog implements ActionListener {
	private JTextField txtDocumento;
	private JButton btnConsultar,btnConsultarM;
	private JPanel panel;
	private JTextArea area;
	private JScrollPane scroll;
	
	Coordinador miCoordinador;
	
	
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
		
		btnConsultar=new JButton("Buscar Persona");
		btnConsultar.setBounds(330,40,150,24);
		btnConsultar.addActionListener(this);
		panel.add(btnConsultar);
		
		btnConsultarM=new JButton("Buscar Mascota");
		btnConsultarM.setBounds(330,70,150,24);
		btnConsultarM.addActionListener(this);
		panel.add(btnConsultarM);
		
		area=new JTextArea();
		
		
		scroll=new JScrollPane(area);
		scroll.setBounds(20,100,400,300);
		panel.add(scroll);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnConsultar) {
			PersonaVo p=miCoordinador.buscarPersona(Long.parseLong(txtDocumento.getText()));
			area.setText(""+p);
		}else if (e.getSource() == btnConsultarM) {
			MascotaVo m = miCoordinador.buscarMascota(Long.parseLong(txtDocumento.getText()));
			area.setText("" + m);
		}
		
	}
	
	public void setMiCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}
	
}
