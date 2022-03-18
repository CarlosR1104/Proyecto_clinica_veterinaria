package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import VO.MascotaVo;
import VO.PersonaVo;
import VO.ProductoVo;
import controlador.Coordinador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaEliminar extends JFrame implements ActionListener {

	private JTextField txtDocumento;
	private JButton btnConsultar, btnEliminarPersona, btnEliminar;
	private JPanel contentPane;
	private JTextArea area;
	private JScrollPane scroll;
	Coordinador miCoordinador;

	public VentanaEliminar() {
		setSize(624, 423);
		setLayout(null);
		setTitle("Consulta ");
		setLocationRelativeTo(null);
		setTitle("Eliminar");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		iniciarComponentes();
	}

	private void iniciarComponentes() {

		contentPane.setLayout(null);

		JLabel etiDocumento = new JLabel("Documento");
		etiDocumento.setBounds(100, 40, 150, 24);
		//etiDocumento.setFont(new Font("arial", 3, 20));
		//etiDocumento.setForeground(Color.WHITE);
		etiDocumento.setBackground(Color.BLACK);
		contentPane.add(etiDocumento);

		txtDocumento = new JTextField();
		txtDocumento.setBounds(230, 40, 150, 24);
		contentPane.add(txtDocumento);

		btnConsultar = new JButton("Buscar");
		btnConsultar.setBounds(400, 40, 100, 24);
		btnConsultar.addActionListener(this);
		contentPane.add(btnConsultar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(100, 310, 100, 24);
		btnEliminar.setEnabled(false);
		btnEliminar.addActionListener(this);
		contentPane.add(btnEliminar);
			
		area = new JTextArea();
		area.setFont(new Font("arial", 3, 15));
		area.setEditable(false);

		scroll = new JScrollPane(area);
		scroll.setBounds(100, 100, 350, 200);
		contentPane.add(scroll);

		

		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		 if (e.getSource() == btnConsultar) {
			MascotaVo miMascota = miCoordinador.buscarMascotaIdPersona(Long.parseLong(txtDocumento.getText()));
			PersonaVo miPersonaVo=miCoordinador.buscarPersona(Long.parseLong(txtDocumento.getText()));
			if (miMascota != null) {
				
				area.setText("\n\tDatos de la Mascota\n" + miMascota.cadenaMascota()+"\n\n\tDatos del Dueño\n"+"\n  Nombre: "+
			miPersonaVo.getNombre()+"\n  Telefono: "+miPersonaVo.getTelefono()+"\n  Documento: "+miPersonaVo.getIdPesona());
				btnEliminar.setEnabled(true);

			}

		}else if (e.getSource() == btnEliminar) {
			String eliminar = null;
			MascotaVo m = miCoordinador.buscarMascota(txtDocumento.getText());
			area.setText("" + m);
			eliminar = miCoordinador.eliminarMascota(Long.parseLong(txtDocumento.getText()));
			System.out.println(eliminar);
			JOptionPane.showMessageDialog(null, "Mascota eliminada exitosamente");

		}
	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

}
