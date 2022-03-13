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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaEliminar extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JLabel lblDocumento;
	private JTextField txtDocumento;
	private JButton btnEliminar,btnEliminarProducto;
	private JTextArea txtArea;
	private JScrollPane scroll;
	private Coordinador miCoordinador;
	
	public VentanaEliminar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		lblDocumento = new JLabel("Ingrese el documento/id");
		lblDocumento.setBounds(10,10,150,20);
		contentPane.add(lblDocumento);
		
		txtDocumento = new JTextField();
		txtDocumento.setBounds(10,30,200,40);
		contentPane.add(txtDocumento);
	
		btnEliminar = new JButton("Eliminar Mascota");
		btnEliminar.setBounds(220,15,150,30);
		btnEliminar.addActionListener(this);
		contentPane.add(btnEliminar);
		
		btnEliminarProducto = new JButton("Eliminar Producto");
		btnEliminarProducto.setBounds(220,50,150,30);
		btnEliminarProducto.addActionListener(this);
		contentPane.add(btnEliminarProducto);
	
		txtArea=new JTextArea();
		
		
		scroll=new JScrollPane(txtArea);
		scroll.setBounds(10,90,410,170);
		contentPane.add(scroll);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			String eliminar = null;
			MascotaVo m = miCoordinador.buscarMascota(Long.parseLong(txtDocumento.getText()));
			txtArea.setText("" + m);
			eliminar = miCoordinador.eliminarMascota(Long.parseLong(txtDocumento.getText()));
			System.out.println(eliminar);
		}else if (e.getSource() == btnEliminarProducto) {
			String eliminarProducto = null;
			ProductoVo p = miCoordinador.buscarProducto(Long.parseLong(txtDocumento.getText()));
			txtArea.setText(""+p);
			eliminarProducto = miCoordinador.eliminarProducto(Long.parseLong(txtDocumento.getText()));
			System.out.println(eliminarProducto);
		}
	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

}
