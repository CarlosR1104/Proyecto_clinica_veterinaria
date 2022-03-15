package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import VO.MascotaVo;
import VO.Nacimiento;
import VO.PersonaVo;
import VO.PersonasProductosVo;
import VO.ProductoVo;
import controlador.Coordinador;
import modelo.dao.PersonaProductoDao;

public class VentanaConsultIndividual extends JDialog implements ActionListener {
	private JTextField txtDocumento;

	private JButton btnConsultar, btnConsultarM, btnEliminarPersona, btnActualizar;

	private JButton btnActualizarM, btnConsultarP, btnActualizarP;

	private JPanel panel;
	private JTextArea area;
	private JScrollPane scroll;

	Coordinador miCoordinador;

	public VentanaConsultIndividual() {
		setSize(500, 500);
		setLayout(null);
		setTitle("Consulta ");
		setLocationRelativeTo(null);
		iniciarComponentes();

	}

	public void iniciarComponentes() {

		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);
		setContentPane(panel);

		JLabel etiDocumento = new JLabel("Documento");
		etiDocumento.setBounds(25, 40, 150, 24);
		panel.add(etiDocumento);

		txtDocumento = new JTextField();
		txtDocumento.setBounds(90, 40, 150, 24);
		panel.add(txtDocumento);

		btnConsultar = new JButton("Buscar");
		btnConsultar.setBounds(250, 40, 70, 24);
		btnConsultar.addActionListener(this);
		panel.add(btnConsultar);

		btnEliminarPersona = new JButton("Eliminar P");
		btnEliminarPersona.setBounds(20, 310, 100, 24);
		btnEliminarPersona.setEnabled(false);
		btnEliminarPersona.addActionListener(this);
		panel.add(btnEliminarPersona);

		area = new JTextArea();
		area.setBounds(30, 100, 350, 200);
		area.setEditable(false);
		panel.add(area);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsultar) {
			PersonaVo p = miCoordinador.buscarPersona(Long.parseLong(txtDocumento.getText()));
			Nacimiento n = miCoordinador.buscarNacimiento(p.getNacimiento().getIdNacimiento());
			area.setText("" + p + n);
			btnEliminarPersona.setEnabled(true);

		} else if (e.getSource() == btnEliminarPersona) {
			System.out.println("esto em el boton eliminar personas");

			PersonaVo p = miCoordinador.buscarPersona(Long.parseLong(txtDocumento.getText()));
			System.out.println(p);
			
			String respuestaMascota = miCoordinador.eliminarMascota(p.getIdPesona());
			System.out.println("hbhbhb " + respuestaMascota);

			if (respuestaMascota.equalsIgnoreCase("ok")) {
				System.out.println("estoy el if de confirmacion de la respuestaMoscota");
					
				String respuesta = miCoordinador.eliminarPersona(Long.parseLong(txtDocumento.getText()));
				System.out.println("respuesta eliminarpersona "+respuesta);
				
				String respuestaNacimiento = miCoordinador.eliminarNaciminto(p.getNacimiento().getIdNacimiento());
				System.out.println("respuesta naacimiento "+respuestaNacimiento);
					
				
				
				JOptionPane.showMessageDialog(null, "se logro borrar la persona exitosamente", "Nota",
						JOptionPane.INFORMATION_MESSAGE);
				area.setText("");
				btnEliminarPersona.setEnabled(false);				

			}

		}

	}

	public void setMiCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

}

/**
 * //PersonasProductosVo Personap = miCoordinador.buscarPersonaProducto(p.getIdPesona());
				//System.out.println("####" + Personap);

				//String respuestaP = miCoordinador.eliminarProduct(Personap.getPersonaId());

				//System.out.println("persona producto respuesta "+respuestaP);
				 * //String repuestaProducto = miCoordinador.eliminarProductoPersona(p.getIdPesona());
				//System.out.println("eliminar productopersona "+repuestaProducto);
 */
