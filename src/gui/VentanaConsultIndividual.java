package gui;

import java.awt.*;
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
	JLabel imagen;

	Coordinador miCoordinador;

	public VentanaConsultIndividual() {
		setSize(624, 423);
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
		etiDocumento.setBounds(100, 40, 150, 24);
		etiDocumento.setFont(new Font("arial", 3, 20));
		etiDocumento.setForeground(Color.WHITE);
		etiDocumento.setBackground(Color.BLACK);
		panel.add(etiDocumento);

		txtDocumento = new JTextField();
		txtDocumento.setBounds(230, 40, 150, 24);
		panel.add(txtDocumento);

		btnConsultar = new JButton("Buscar");
		btnConsultar.setBounds(400, 40, 100, 24);
		btnConsultar.addActionListener(this);
		panel.add(btnConsultar);

		btnEliminarPersona = new JButton("Eliminar");
		btnEliminarPersona.setBounds(100, 310, 100, 24);
		btnEliminarPersona.setEnabled(false);
		btnEliminarPersona.addActionListener(this);
		panel.add(btnEliminarPersona);

		area = new JTextArea();
		area.setFont(new Font("arial", 3, 15));
		area.setEditable(false);

		scroll = new JScrollPane(area);
		scroll.setBounds(100, 100, 350, 200);
		panel.add(scroll);

		ImageIcon imagen2 = new ImageIcon("dog.JPG");
		imagen = new JLabel();
		imagen.setBounds(0, 0, 600, 383);// agregamos la pocision de la imagen
		imagen.setIcon(new ImageIcon(
				imagen2.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH)));
		panel.add(imagen);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
			if (e.getSource() == btnConsultar) {
				PersonaVo p = miCoordinador.buscarPersona(Long.parseLong(txtDocumento.getText()));
				if (p != null) {
					Nacimiento n = miCoordinador.buscarNacimiento(p.getNacimiento().getIdNacimiento());
					MascotaVo m= miCoordinador.buscarMascotaIdPersona(p.getIdPesona());
					PersonasProductosVo Personap = miCoordinador.buscarPersonaProducto(p.getIdPesona());// A
					if(Personap!=null) {
						ProductoVo  pv=miCoordinador.bucarProductoID(Personap.getProductoId());
						area.setText("\tDatos del dueño\n\n" + p + n+"\n\n\tDatos de la mascota\n"+m.cadenaMascota()+
								"\n\n\tDatos de productos Comprados\n\n"+pv);
						btnEliminarPersona.setEnabled(true);
					}else {
						area.setText("\tDatos del dueño\n\n" + p + n+"\n\n\tDatos de la mascota\n"+m.cadenaMascota());
						btnEliminarPersona.setEnabled(true);
					}
					
				} else {

					JOptionPane.showMessageDialog(null,
							"Es posible que el numero este mal o no exista en la base de datos", "Nota",
							JOptionPane.INFORMATION_MESSAGE);
				}

			} else if (e.getSource() == btnEliminarPersona) {
				
				
				System.out.println("esto em el boton eliminar personas");

				PersonaVo p = miCoordinador.buscarPersona(Long.parseLong(txtDocumento.getText()));
				System.out.println(p);

				String respuestaMascota = miCoordinador.eliminarMascota(p.getIdPesona());
				System.out.println("hbhbhb " + respuestaMascota);

				if (respuestaMascota.equalsIgnoreCase("ok")) {
					System.out.println("estoy el if de confirmacion de la respuestaMoscota");

					String repuestaProducto = miCoordinador.eliminarProductoPersona(p.getIdPesona());// A
					System.out.println("mirando pesona respuesta de productos:===  " + repuestaProducto);
					

					String respuesta = miCoordinador.eliminarPersona(Long.parseLong(txtDocumento.getText()));
					
					
					System.out.println("respuesta eliminarpersona " + respuesta);

					String respuestaNacimiento = miCoordinador.eliminarNaciminto(p.getNacimiento().getIdNacimiento());
					System.out.println("respuesta naacimiento " + respuestaNacimiento);
					
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

