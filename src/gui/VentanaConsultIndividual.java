package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import VO.MascotaVo;
import VO.Nacimiento;
import VO.PersonaVo;
import controlador.Coordinador;

public class VentanaConsultIndividual extends JDialog implements ActionListener {
	private JTextField txtDocumento;
	private JButton btnConsultar, btnConsultarM, btnEliminarPersona,btnActualizar;
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
		etiDocumento.setBounds(90, 40, 150, 24);
		panel.add(etiDocumento);

		txtDocumento = new JTextField();
		txtDocumento.setBounds(165, 40, 150, 24);
		panel.add(txtDocumento);

		btnConsultar = new JButton("Buscar Persona");
		btnConsultar.setBounds(330, 40, 150, 24);
		btnConsultar.addActionListener(this);
		panel.add(btnConsultar);

		btnConsultarM = new JButton("Buscar Mascota");
		btnConsultarM.setBounds(330, 70, 150, 24);
		btnConsultarM.addActionListener(this);
		panel.add(btnConsultarM);

		area = new JTextArea();

		scroll = new JScrollPane(area);
		scroll.setBounds(20, 100, 420, 200);
		panel.add(scroll);

		btnEliminarPersona = new JButton("Eliminar P");
		btnEliminarPersona.setBounds(20, 310, 100, 24);
		btnEliminarPersona.setEnabled(false);
		btnEliminarPersona.addActionListener(this);
		panel.add(btnEliminarPersona);
		
		btnActualizar = new JButton("Axctualizar P");
		btnActualizar.setBounds(130,310, 100, 24);
		btnActualizar.setEnabled(false);
		btnActualizar.addActionListener(this);
		panel.add(btnActualizar);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsultar) {
			PersonaVo p = miCoordinador.buscarPersona(Long.parseLong(txtDocumento.getText()));
			Nacimiento n =miCoordinador.buscarNacimiento(p.getNacimiento().getIdNacimiento());
			area.setText("" + p+n);
			btnEliminarPersona.setEnabled(true);
			btnActualizar.setEnabled(true);

		} else if (e.getSource() == btnConsultarM) {
			MascotaVo m = miCoordinador.buscarMascota(Long.parseLong(txtDocumento.getText()));
			area.setText("" + m);

		} else if (e.getSource() == btnEliminarPersona) {
			PersonaVo p = miCoordinador.buscarPersona(Long.parseLong(txtDocumento.getText()));
			// String respuesta= miCoordinador.eliminarPersona(p.getIdPesona());
			String respuesta = miCoordinador.eliminarPersona(Long.parseLong(txtDocumento.getText()));
			area.setText("");
			btnEliminarPersona.setEnabled(false);
			btnActualizar.setEnabled(false);

			if (respuesta.equalsIgnoreCase("ok")) {
				String respuestaNacimiento = miCoordinador.eliminarNaciminto(p.getNacimiento().getIdNacimiento());
				JOptionPane.showMessageDialog(null, "se logro borrar la persona exitosamente", "Nota",
						JOptionPane.INFORMATION_MESSAGE);

			}
				
			}else if(e.getSource()==btnActualizar) {
				
				PersonaVo encontrado=miCoordinador.buscarPersona(Long.parseLong(txtDocumento.getText()));
				System.out.println("estamos imprimiendo encontrado"+encontrado);
				if(encontrado!=null) {
					
					encontrado.setNombre(JOptionPane.showInputDialog("ingrese el nuevo nombre"));
					encontrado.setProfesion(JOptionPane.showInputDialog("ingrese la nueva profesion"));
					encontrado.setTelefono(JOptionPane.showInputDialog("ingrese el nuevo numero Telefonico"));
					encontrado.setTipo(Integer.parseInt(JOptionPane.showInputDialog("ingrese el nuevo tipo")));
					System.out.println("modificado"+encontrado);
					String edictar=miCoordinador.actualizaPersona(encontrado);
					System.out.println(edictar);
					
					if (edictar.equalsIgnoreCase("ok")) {
						JOptionPane.showMessageDialog(null, "se logro actualizar correctamente", "Nota",
								JOptionPane.INFORMATION_MESSAGE);
					}
					
					area.setText("");
					btnEliminarPersona.setEnabled(false);
					btnActualizar.setEnabled(false);
					
				}
				

		}

	}

	public void setMiCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

}
