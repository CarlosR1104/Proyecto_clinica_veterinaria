package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class VentanaPrincipal extends JFrame implements ActionListener{

	private JPanel contentPane;
	private AbstractButton itemRegistrarPersonas;
	private JMenuItem itemConsultarPersonas;
	private JMenuItem itemActualizarPersonas;
	private JMenuItem itemEliminarPersonas;
	private JMenuItem itemRegistrarMascotas;
	private JMenuItem itemConsultarMascotas;
	private JMenuItem itemActualizarMascotas;
	private JMenuItem itemEliminarMascotas;
	private JMenuItem itemEliminarProductos;
	private JMenuItem itemActualizarProductos;
	private JMenuItem itemConsultaProductos;
	private JMenuItem itemRegistroProductos;
	private Coordinador miCoordinador;
	private JMenuItem itemConsultaPersonas;
	private JMenuItem itemConsultaMascotas;
	private JMenuItem itemConsultarProductos;

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		iniciarComponentes();	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,500);
		setResizable(false);
		setTitle("Clinica Veterinaria");
		setLocationRelativeTo(null);
	}

	private void iniciarComponentes() {
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuPersonas = new JMenu("Gestionar Personas");
		menuBar.add(menuPersonas);
		
		itemRegistrarPersonas = new JMenuItem("Registrar");
		itemRegistrarPersonas.addActionListener(this);
		menuPersonas.add(itemRegistrarPersonas);
		
		itemConsultarPersonas = new JMenuItem("Consultar");
		itemConsultarPersonas.addActionListener(this);
		menuPersonas.add(itemConsultarPersonas);
		
		itemActualizarPersonas = new JMenuItem("Actualizar");
		itemActualizarPersonas.addActionListener(this);
		menuPersonas.add(itemActualizarPersonas);
		
		itemEliminarPersonas = new JMenuItem("Eliminar");
		itemEliminarPersonas.addActionListener(this);
		menuPersonas.add(itemEliminarPersonas);
		
		JMenu MenuMascotas = new JMenu("Gestionar Mascotas");
		menuBar.add(MenuMascotas);
		
		itemRegistrarMascotas = new JMenuItem("Registrar");
		itemRegistrarMascotas.addActionListener(this);
		MenuMascotas.add(itemRegistrarMascotas);
		
		itemConsultarMascotas = new JMenuItem("Consultar");
		itemConsultarMascotas.addActionListener(this);
		MenuMascotas.add(itemConsultarMascotas);
		
		itemActualizarMascotas = new JMenuItem("Actualizar");
		itemActualizarMascotas.addActionListener(this);
		MenuMascotas.add(itemActualizarMascotas);
		
		itemEliminarMascotas = new JMenuItem("Eliminar");
		itemEliminarMascotas.addActionListener(this);
		MenuMascotas.add(itemEliminarMascotas);
		
		JMenu menuProductos = new JMenu("Gestionar Productos");
		menuBar.add(menuProductos);
		
		itemRegistroProductos = new JMenuItem("Registrar");
		itemRegistroProductos.addActionListener(this);
		menuProductos.add(itemRegistroProductos);
		
		itemConsultaProductos = new JMenuItem("Consultar");
		itemConsultaProductos.addActionListener(this);
		menuProductos.add(itemConsultaProductos);
		
		itemActualizarProductos = new JMenuItem("Actualizar");
		itemActualizarProductos.addActionListener(this);
		menuProductos.add(itemActualizarProductos);
		
		itemEliminarProductos = new JMenuItem("Eliminar");
		itemEliminarProductos.addActionListener(this);
		
		menuProductos.add(itemEliminarProductos);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitulo = new JLabel("GESTION CLINICA VETERINARIA");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		contentPane.add(lblTitulo, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);
		
		JLabel lblImagen = new JLabel();
		lblImagen.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/images/veterinario.jpg")));
		panel.add(lblImagen, BorderLayout.CENTER);
		
		itemConsultaPersonas = new JMenuItem("Consultar Total");
		itemConsultaPersonas.addActionListener(this);
		menuPersonas.add(itemConsultaPersonas);
		
		itemConsultaMascotas = new JMenuItem("Consultar Total");
		itemConsultaMascotas.addActionListener(this);
		MenuMascotas.add(itemConsultaMascotas);
		
		itemConsultarProductos = new JMenuItem("Consultar Total");
		itemConsultarProductos.addActionListener(this);
		menuProductos.add(itemConsultarProductos);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==itemRegistrarPersonas) {
			miCoordinador.mostrarRegistroPersonas();
		}
		if (e.getSource()==itemRegistrarMascotas) {
			miCoordinador.mostrarRegistroMascotas();
		}
		if (e.getSource()==itemRegistroProductos) {
			miCoordinador.mostrarRegistroProductos();
		}
		if(e.getSource()==itemConsultarPersonas) {
			miCoordinador.mostrarConsultaIndividual();
		}
		if (e.getSource() == itemConsultarMascotas) {
			miCoordinador.mostrarEliminarMascotas();
		}
		if (e.getSource() == itemEliminarMascotas) {
			miCoordinador.mostrarEliminarMascotas();
		}
		if (e.getSource() == itemConsultaProductos) {
			miCoordinador.mostrarEliminarProductos();
		}
		if (e.getSource() == itemEliminarProductos) {
			miCoordinador.mostrarEliminarProductos();
		}
		if (e.getSource() == itemEliminarPersonas) {
			miCoordinador.mostrarConsultaIndividual();
		}
		if (e.getSource() == itemActualizarMascotas) {
			miCoordinador.mostrarEliminarMascotas();
		}if(e.getSource()==itemActualizarPersonas) {
			miCoordinador.mostrarVenActualizar();
		}
		if (e.getSource() == itemActualizarProductos) {
			miCoordinador.mostrarEliminarProductos();
		}
		if (e.getSource() == itemEliminarProductos) {
			miCoordinador.mostrarEliminarProductos();
		}
		if (e.getSource() == itemConsultaPersonas) {
			miCoordinador.mostrarConsultarPersonas();
		}
		if (e.getSource() == itemConsultaMascotas) {
			miCoordinador.mostrarConsultarMascotas();
		}
		if (e.getSource() == itemConsultarProductos) {
			miCoordinador.mostrarConsultarProducto();
		}
	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador= miCoordinador;
	}
}
