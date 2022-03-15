package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import VO.MascotaVo;
import VO.ProductoVo;
import controlador.Coordinador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaEliminar extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JLabel lblDocumento,etiNombre,etiColor,etiRaza,etiSexo,etiDueño;
	private JTextField txtDocumento,txtId,txtNombre,txtColor,txtRaza,txtSexo,txtDueño;
	private JButton btnEliminar,btnActualizarMascota,btnConfirmar;
	private JTextArea txtArea;
	private JScrollPane scroll;
	private Coordinador miCoordinador;
	private JLabel etiId;
	
	public VentanaEliminar() {
		setBounds(100, 100, 450, 300);
		setTitle("Eliminar");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		iniciarComponentes();		
	}

	private void iniciarComponentes() {
		
		contentPane.setLayout(null);
		
		lblDocumento = new JLabel("Ingrese el nombre");
		lblDocumento.setBounds(10,10,150,20);
		contentPane.add(lblDocumento);
		
		txtDocumento = new JTextField();
		txtDocumento.setBounds(10,30,200,40);
		contentPane.add(txtDocumento);
	
		btnEliminar = new JButton("Eliminar Mascota");
		btnEliminar.setBounds(220,15,150,30);
		btnEliminar.addActionListener(this);
		contentPane.add(btnEliminar);
		
		btnActualizarMascota= new JButton("Actualizar Mascota");
		btnActualizarMascota.setBounds(220,50,150,30);
		btnActualizarMascota.addActionListener(this);
		contentPane.add(btnActualizarMascota);
		
		etiId = new JLabel("Id");
		etiId.setBounds(10,80,100,20);
		contentPane.add(etiId);
		
		txtId = new JTextField();
		txtId.setBounds(80,80,100,30);
		contentPane.add(txtId);
		
		etiSexo = new JLabel("Sexo");
		etiSexo.setBounds(230,100,100,20);
		contentPane.add(etiSexo);
		
		txtSexo = new JTextField();
		txtSexo.setBounds(260,100,100,30);
		contentPane.add(txtSexo);	
		
		etiDueño = new JLabel("Id Dueño");
		etiDueño.setBounds(200,150,100,20);
		contentPane.add(etiDueño);
		
		txtDueño = new JTextField();
		txtDueño.setBounds(260,150,100,30);
		contentPane.add(txtDueño);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(260,190,100,40);
		btnConfirmar.addActionListener(this);
		btnConfirmar.setEnabled(false);
		contentPane.add(btnConfirmar);
		
		etiNombre = new JLabel("Nombre");
		etiNombre.setBounds(10,110,100,20);
		contentPane.add(etiNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(80,120,100,30);
		contentPane.add(txtNombre);
		
		etiColor = new JLabel("Color");
		etiColor.setBounds(10,150,100,20);
		contentPane.add(etiColor);
		
		txtColor = new JTextField();
		txtColor.setBounds(80,160,100,30);
		contentPane.add(txtColor);
		
		etiRaza = new JLabel("Raza");
		etiRaza.setBounds(10,200,100,20);
		contentPane.add(etiRaza);
		
		txtRaza = new JTextField();
		txtRaza.setBounds(80,200,100,30);
		contentPane.add(txtRaza);
			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			String eliminar = null;
			MascotaVo m = miCoordinador.buscarMascota(txtDocumento.getText());
			txtArea.setText("" + m);
			eliminar = miCoordinador.eliminarMascota(Long.parseLong(txtDocumento.getText()));
			System.out.println(eliminar);
			JOptionPane.showMessageDialog(null, "Mascota eliminada exitosamente");
		
		}else if (e.getSource() == btnActualizarMascota) {
			MascotaVo miMascota = miCoordinador.buscarMascota(txtDocumento.getText());
			if (miMascota != null) {
				txtId.setEnabled(false);
				txtDueño.setEnabled(false);
				txtId.setText(String.valueOf(miMascota.getIdMascota()));
				txtNombre.setText(miMascota.getNombre());
				txtColor.setText(miMascota.getColorMascota());
				txtRaza.setText(miMascota.getRaza());
				txtSexo.setText(miMascota.getSexo());
				txtDueño.setText(String.valueOf(miMascota.getPersona().getIdPesona()));
				btnConfirmar.setEnabled(true);
			}
			
		}else if (e.getSource() == btnConfirmar) {
			MascotaVo miMascota = miCoordinador.buscarMascota(txtDocumento.getText());
			miMascota.setColorMascota(txtColor.getText());
			miMascota.setNombre(txtNombre.getText());
			miMascota.setRaza(txtRaza.getText());
			miMascota.setSexo(txtSexo.getText());
			String n = miCoordinador.actualizarMascota(miMascota);
				if (n.equals("ok")) {
					JOptionPane.showMessageDialog(null, "Mascota actualizada exitosamente");
				}
		}
	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

}
