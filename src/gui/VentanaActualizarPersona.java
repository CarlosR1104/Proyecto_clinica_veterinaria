package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import VO.Nacimiento;
import VO.PersonaVo;
import controlador.Coordinador;

public class VentanaActualizarPersona extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtDocumento;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtProfesion;
	private JTextField txtTipo;
	private JFormattedTextField txtDia;
	private JFormattedTextField txtMes;
	private JFormattedTextField txtAnio;
	private JTextField txtCiudad;
	private JTextField txtDepartamento;
	private JTextField txtPais;
	private JLabel imagen;
	private JButton btnBuscar;
	private JButton btnRegistrar;
	private Coordinador miCoordinador;
	MaskFormatter mascara1, mascara2, mascara3;
	Nacimiento miNacimiento;
	private LocalDate fechaNacimiento;

	public VentanaActualizarPersona(VentanaPrincipal ventanaPrincipal, boolean modal) throws ParseException {
		super(ventanaPrincipal, modal);
		setSize(624, 423);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		iniciarComponentes();
		setTitle("Gestion de Personas");

	}

	private void iniciarComponentes() throws ParseException {
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		try {
			mascara1 = new MaskFormatter("##");
			mascara2 = new MaskFormatter("##");
			mascara3 = new MaskFormatter("####");

		} catch (Exception e) {
			// TODO: handle exception
		}
		JLabel lblTitulo = new JLabel("Actualizar Persona");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblTitulo.setBounds(10, 10, 599, 28);
		contentPanel.add(lblTitulo);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(10, 49, 588, 324);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Documento:");
		lblNewLabel.setBounds(24, 22, 71, 21);
		lblNewLabel.setForeground(Color.WHITE);
		panel.add(lblNewLabel);

		txtDocumento = new JTextField();
		txtDocumento.setBounds(99, 22, 86, 20);
		panel.add(txtDocumento);
		txtDocumento.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(195, 22, 71, 21);
		lblNombre.setForeground(Color.WHITE);
		panel.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(259, 22, 303, 20);
		panel.add(txtNombre);

		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(24, 54, 71, 21);
		lblTelefono.setForeground(Color.WHITE);
		panel.add(lblTelefono);

		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(78, 54, 86, 20);
		panel.add(txtTelefono);

		JLabel lblProfesion = new JLabel("Profesion:");
		lblProfesion.setBounds(180, 54, 92, 21);
		lblProfesion.setForeground(Color.WHITE);
		lblProfesion.setFont(new Font("arial", 3, 15));
		panel.add(lblProfesion);

		txtProfesion = new JTextField();
		txtProfesion.setColumns(10);
		txtProfesion.setBounds(260, 54, 167, 20);
		panel.add(txtProfesion);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(433, 54, 71, 21);
		lblTipo.setForeground(Color.WHITE);
		panel.add(lblTipo);

		txtTipo = new JTextField();
		txtTipo.setColumns(10);
		txtTipo.setBounds(476, 54, 86, 20);
		panel.add(txtTipo);

		JPanel panelNacimiento = new JPanel();
		panelNacimiento.setBorder(new TitledBorder(null, "Datos de Nacimiento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelNacimiento.setBounds(24, 99, 538, 109);
		panel.add(panelNacimiento);
		panelNacimiento.setLayout(null);

		JLabel lblFecha = new JLabel("Fecha (dd/mm/aaaa):");
		lblFecha.setBounds(10, 29, 122, 14);
		panelNacimiento.add(lblFecha);

		txtDia = new JFormattedTextField(mascara1);
		txtDia.setFocusLostBehavior(txtDia.COMMIT);
		txtDia.setBounds(142, 28, 25, 20);
		panelNacimiento.add(txtDia);
		txtDia.setColumns(10);

		txtMes = new JFormattedTextField(mascara2);
		txtMes.setColumns(10);
		txtMes.setFocusLostBehavior(txtMes.COMMIT);
		txtMes.setBounds(190, 28, 25, 20);
		panelNacimiento.add(txtMes);

		txtAnio = new JFormattedTextField(mascara3);
		txtAnio.setFocusLostBehavior(txtAnio.COMMIT);
		txtAnio.setColumns(10);
		txtAnio.setBounds(238, 28, 54, 20);
		panelNacimiento.add(txtAnio);

		JLabel lblNewLabel_1 = new JLabel("/");
		lblNewLabel_1.setBounds(177, 31, 38, 14);
		panelNacimiento.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("/");
		lblNewLabel_1_1.setBounds(224, 31, 38, 14);
		panelNacimiento.add(lblNewLabel_1_1);

		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setBounds(10, 59, 71, 21);
		panelNacimiento.add(lblCiudad);

		txtCiudad = new JTextField();
		txtCiudad.setColumns(10);
		txtCiudad.setBounds(74, 59, 86, 20);
		panelNacimiento.add(txtCiudad);

		JLabel lblDepartamento = new JLabel("Departamento:");
		lblDepartamento.setBounds(185, 59, 92, 21);
		panelNacimiento.add(lblDepartamento);

		txtDepartamento = new JTextField();
		txtDepartamento.setColumns(10);
		txtDepartamento.setBounds(281, 59, 86, 20);
		panelNacimiento.add(txtDepartamento);

		JLabel lblPais = new JLabel("Pais:");
		lblPais.setBounds(385, 59, 54, 21);
		panelNacimiento.add(lblPais);

		txtPais = new JTextField();
		txtPais.setColumns(10);
		txtPais.setBounds(424, 59, 86, 20);
		panelNacimiento.add(txtPais);

		JSeparator separator = new JSeparator();
		separator.setBounds(24, 253, 538, 12);
		panel.add(separator);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(463, 276, 89, 23);
		btnBuscar.addActionListener(this);
		panel.add(btnBuscar);

		btnRegistrar = new JButton("Actualizar");
		btnRegistrar.setBounds(364, 276, 89, 23);
		btnRegistrar.setEnabled(false);
		btnRegistrar.addActionListener(this);
		panel.add(btnRegistrar);

		 
		ImageIcon imagen2=new ImageIcon("dog.JPG");
		imagen=new JLabel();
		imagen.setBounds(0, 0, 600, 383);//agregamos la pocision de la imagen
		imagen.setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH)));
		panel.add(imagen);
		
		invalidarCampos();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {

			if (e.getSource() == btnBuscar) {
				PersonaVo p = miCoordinador.buscarPersona(Long.parseLong(txtDocumento.getText()));

				validarCampos();
				txtNombre.setText(p.getNombre());
				txtProfesion.setText(p.getProfesion());
				txtTelefono.setText(p.getTelefono());
				txtTipo.setText(String.valueOf(p.getTipo()));
				txtDocumento.setEnabled(false);
				btnRegistrar.setEnabled(true);

				// LocalDate date = LocalDate.of(Integer.parseInt(txtAnio.getText()),
				// Integer.parseInt(txtMes.getText()),Integer.parseInt(txtDia.getText()));

				Nacimiento n = miCoordinador.buscarNacimiento(p.getNacimiento().getIdNacimiento());
				if (p.getNacimiento().getIdNacimiento() == n.getIdNacimiento()) {
					txtDepartamento.setText(n.getDepartamentoNacimiento());
					txtCiudad.setText(n.getCiudadNacimiento());
					txtPais.setText(n.getPaisNacimiento());
					txtAnio.setText((String.valueOf(n.getFechaNacimiento().getYear())));
					txtMes.setText(String.valueOf(n.getFechaNacimiento().getMonthValue()));
					txtDia.setText(String.valueOf(n.getFechaNacimiento().getDayOfMonth()));

				} else {
					System.out.println("error");
				}

			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "verifique si escribio el numero correcto", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
		try {
			if (e.getSource() == btnRegistrar) {
				PersonaVo encontrado = miCoordinador.buscarPersona(Long.parseLong(txtDocumento.getText()));
				if (encontrado != null) {

					validarCampos();

					encontrado.setNombre(txtNombre.getText());
					encontrado.setProfesion(txtProfesion.getText());
					encontrado.setTelefono(txtTelefono.getText());
					encontrado.setTipo(Integer.parseInt(txtTipo.getText()));
					String edictar = miCoordinador.actualizaPersona(encontrado);
					Nacimiento encontradoNacimiento = miCoordinador
							.buscarNacimiento(encontrado.getNacimiento().getIdNacimiento());

					if (encontradoNacimiento != null) {
						LocalDate date = LocalDate.of(Integer.parseInt(txtAnio.getText()),
								Integer.parseInt(txtMes.getText()), Integer.parseInt(txtDia.getText()));

						encontradoNacimiento.setFechaNacimiento(date);
						encontradoNacimiento.setCiudadNacimiento(txtCiudad.getText());
						encontradoNacimiento.setDepartamentoNacimiento(txtDepartamento.getText());
						encontradoNacimiento.setPaisNacimiento(txtPais.getText());
						String dictar2 = miCoordinador.actualizarNacimiento(encontradoNacimiento);
						if (dictar2.equalsIgnoreCase("ok"))
							JOptionPane.showMessageDialog(null, "se actualizo correctamente la persona");
						txtAnio.setText("");
						txtCiudad.setText("");
						txtDepartamento.setText("");
						txtDocumento.setText("");
						txtMes.setText("");
						txtDia.setText("");
						txtNombre.setText("");
						txtProfesion.setText("");
						txtTelefono.setText("");
						txtTipo.setText("");
						txtPais.setText("");
						invalidarCampos();
						btnRegistrar.setEnabled(false);
						txtDocumento.setEnabled(true);

					}
				}

			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "verifique los campos numericos y vuelva intentarlo", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public void validarCampos() {
		txtAnio.setEnabled(true);
		txtCiudad.setEnabled(true);
		txtDepartamento.setEnabled(true);
		txtMes.setEnabled(true);
		txtDia.setEnabled(true);
		txtNombre.setEnabled(true);
		txtProfesion.setEnabled(true);
		txtTelefono.setEnabled(true);
		txtTipo.setEnabled(true);
		txtPais.setEnabled(true);

	}

	public void invalidarCampos() {
		txtAnio.setEnabled(false);
		txtCiudad.setEnabled(false);
		txtDepartamento.setEnabled(false);
		txtMes.setEnabled(false);
		txtDia.setEnabled(false);
		txtNombre.setEnabled(false);
		txtProfesion.setEnabled(false);
		txtTelefono.setEnabled(false);
		txtTipo.setEnabled(false);
		txtPais.setEnabled(false);

	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

}