package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import VO.MascotaVo;
import VO.Nacimiento;
import VO.PersonaVo;
import VO.ProductoVo;
import controlador.Coordinador;

public class VentanaConsultIndividual extends JDialog implements ActionListener {
	private JTextField txtDocumento;
<<<<<<< HEAD
	private JButton btnConsultar, btnConsultarM, btnEliminarPersona,btnActualizar;
=======
	private JButton btnConsultar,btnConsultarM,btnActualizarM,btnConsultarP,btnActualizarP;
>>>>>>> 400d9e80cb9b8047a6976992586086410b79aa11
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
<<<<<<< HEAD

		area = new JTextArea();

		scroll = new JScrollPane(area);
		scroll.setBounds(20, 100, 420, 200);
=======
		
		btnConsultarP = new JButton("Buscar Producto");
		btnConsultarP.setBounds(330,10,150,20);
		btnConsultarP.addActionListener(this);
		panel.add(btnConsultarP);
		
		
		btnActualizarM = new JButton("Editar Mascota");
		btnActualizarM.setBounds(10,320,150,30);
		btnActualizarM.addActionListener(this);
		panel.add(btnActualizarM);
		
		btnActualizarP = new JButton("Editar Producto");
		btnActualizarP.setBounds(200,320,150,30);
		btnActualizarP.addActionListener(this);
		panel.add(btnActualizarP);
		
		
		area=new JTextArea();
		
		
		scroll=new JScrollPane(area);
		scroll.setBounds(20,100,400,200);
>>>>>>> 400d9e80cb9b8047a6976992586086410b79aa11
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
<<<<<<< HEAD

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

=======
		}else if (e.getSource() == btnActualizarM) {
			MascotaVo miMascota = miCoordinador.buscarMascota(Long.parseLong(txtDocumento.getText()));
			if (miMascota != null) {
					miMascota.setColorMascota(JOptionPane.showInputDialog("Ingrese el nuevo color de la mascota: "));
					miMascota.setNombre(JOptionPane.showInputDialog("Ingrese el nuevo nombre de la mascota: "));
					miMascota.setRaza(JOptionPane.showInputDialog("Ingrese la nueva raza de la mascota: "));
					miMascota.setSexo(JOptionPane.showInputDialog("Ingrese el nuevo sexo de la mascota: "));
					String n = miCoordinador.actualizarMascota(miMascota);
					if (n.equals("ok")) {
						JOptionPane.showMessageDialog(null, "Actualizado");
						System.out.println("VALIDANDO OK");
					}
				}
			}else if (e.getSource() == btnConsultarP) {
				ProductoVo p = miCoordinador.buscarProducto(Long.parseLong(txtDocumento.getText()));
				area.setText(""+p);
			}else if (e.getSource() == btnActualizarP) {
				ProductoVo miProducto= miCoordinador.buscarProducto(Long.parseLong(txtDocumento.getText()));
				if (miProducto!= null) {
					miProducto.setNombreProducto(JOptionPane.showInputDialog("Ingrese el nuevo nombre del producto: "));
					miProducto.setPrecioProducto(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo precio del producto: ")));
					String n = miCoordinador.actualizarProducto(miProducto);
						if (n.equals("ok")) {
							JOptionPane.showMessageDialog(null, "Actualizado");
							System.out.println("VALIDANDO OK");
						}
					}
				
			}
			
}
	
>>>>>>> 400d9e80cb9b8047a6976992586086410b79aa11
	public void setMiCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

}
