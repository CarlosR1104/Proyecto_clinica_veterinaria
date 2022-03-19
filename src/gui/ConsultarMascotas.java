package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import VO.MascotaVo;
import VO.Nacimiento;
import VO.PersonaVo;
import controlador.Coordinador;
import modelo.dao.MascotaDao;

public class ConsultarMascotas extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable tablaMascotas;
	private JButton btnConsultarMascotas;
	private Coordinador miCoordinador;
	private JScrollPane scroll;

	public ConsultarMascotas() {

		setTitle("Consultar Animal");
		setSize(812, 365);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnConsultarMascotas = new JButton("Consultar Mascotas");
		btnConsultarMascotas.setBounds(278, 21, 206, 40);
		btnConsultarMascotas.addActionListener(this);
		contentPane.add(btnConsultarMascotas);

		scroll = new JScrollPane();
		scroll.setBounds(10, 99, 776, 174);
		contentPane.add(scroll);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsultarMascotas) {
			ArrayList<PersonaVo> lista = miCoordinador.consultarPersonas();
			ArrayList<MascotaVo> listaMascota = miCoordinador.consultarMascota();

			System.out.println("LISTA PERSONAS" + lista);
			System.out.println("lista Mascota " + listaMascota);
			Lista(lista, listaMascota);
		}
	}

	public void Lista(ArrayList<PersonaVo> personas, ArrayList<MascotaVo> mascota) {
		String titulos[] = { "Nombre", "Color", "Raza", "Sexo", "Dueño" };
		System.out.println(personas.size());
		System.out.println(mascota.size());
		int celdas;
		if (mascota.size() > 15) {
			celdas = 10;
		} else {
			celdas = mascota.size();
		}
		// Nacimiento
		// n=miCoordinador.consultarNacimiento(personas.get(i).getNacimiento().getIdNacimiento());
		String cuadro[][] = new String[celdas][5];

		if (mascota.size() > 0) {
			System.out.println("jairo");
			for (int i = 0; i < personas.size(); i++) {
				for (int e = 0; e <  mascota.size(); e++) {
					// cuadro[i][0] = personas.get(i).getNombre();
					cuadro[e][0] = mascota.get(e).getNombre();
					cuadro[e][1] = mascota.get(e).getColorMascota();
					cuadro[e][2] = mascota.get(e).getRaza();
					cuadro[e][3] = mascota.get(e).getSexo();
					cuadro[e][4] = personas.get(i).getNombre();
				}
			}
		} else {
			cuadro = new String[10][5];

		}

		tablaMascotas = new JTable(cuadro, titulos);
		scroll.setViewportView(tablaMascotas);

	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

}
