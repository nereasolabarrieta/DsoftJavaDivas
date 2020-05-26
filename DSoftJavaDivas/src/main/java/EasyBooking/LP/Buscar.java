package EasyBooking.LP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;

import Controller.Controller;
import EasyBooking.LD.Aeropuerto;

import javax.swing.JButton;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;

public class Buscar extends JFrame {

	private JPanel contentPane;
	private JDateChooser datechooser;
	private List<Aeropuerto> Lista_Aeropuerto;
	private Controller controller;
	private JComboBox<String> combito;
	private JComboBox<String> comboBox_1;

	/**
	 * Create the frame.
	 * 
	 * @param controller
	 */
	public Buscar(Controller controller) {

		this.controller = controller;
		try {
			Lista_Aeropuerto = this.controller.getAeropuertos().stream().distinct().collect(Collectors.toList());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Lista_Aeropuerto=this.controller.getAeropuertos();
		System.out.println("ULTIMO PASO: " + Lista_Aeropuerto.size());
		initComponents();
		this.setVisible(true);

	}

	public void initComponents() {

		// setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/EasyBooking/Img/Avion.jpg")));
		setFont(new Font("Franklin Gothic Medium", Font.BOLD, 12));
		setTitle("EasyBooking");
		setForeground(Color.BLACK);
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 740);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);

		ButtonGroup grupoIda = new ButtonGroup();

		JPanel pIzquierda = new JPanel();
		pIzquierda.setForeground(new Color(255, 255, 255));
		pIzquierda.setBackground(Color.WHITE);
		pIzquierda.setBounds(0, 163, 1278, 521);
		contentPane.add(pIzquierda);
		pIzquierda.setLayout(null);

		JLabel lblNewLabel = new JLabel("Origen:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setBounds(365, 40, 76, 20);
		pIzquierda.add(lblNewLabel);

		combito = new JComboBox<String>();
		// DefaultComboBoxModel<String> modelito = new
		// DefaultComboBoxModel<String>();
		// combito.setModel(modelito);

		combito.setBounds(483, 37, 297, 26);
		Lista_Aeropuerto.stream().forEach(element -> {
			combito.addItem(element.getNomAeropuerto());
			// combito.add(element.getNomAeropuerto());
		});
		pIzquierda.add(combito);
		datechooser = new JDateChooser(null, null, null, new JSpinnerDateEditor());
		Date objDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.format(objDate);
		datechooser.setDate(objDate);
		datechooser.setBounds(800, 37, 175, 26);
		pIzquierda.add(datechooser);

		JLabel lblNewLabel_1 = new JLabel("Destino:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(365, 99, 81, 20);
		pIzquierda.add(lblNewLabel_1);

		comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(483, 96, 297, 26);
		Lista_Aeropuerto.stream().forEach(element -> {
			comboBox_1.addItem(element.getNomAeropuerto());
		});

		pIzquierda.add(comboBox_1);
		datechooser = new JDateChooser(null, null, null, new JSpinnerDateEditor());
		datechooser.setDate(objDate);
		datechooser.setBounds(800, 96, 175, 26);
		pIzquierda.add(datechooser);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setForeground(new Color(255, 255, 255));
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscar.setBackground(new Color(0, 0, 128));
		btnBuscar.setBounds(849, 405, 126, 43);
//		btnBuscar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				
//				System.out.println(estado_rdbtn);
//			
//				System.out.println();
//				Principal a = null;
//				JPanelVuelo b = null;
//				if (estado_rdbtn = false || viajeros.equals("0")) {
//					JOptionPane.showMessageDialog(null, "Por favor, rellene todos los campos");
//					return;
//				} else {
//
//					try {
//
//						a = new Principal(controller, comboBox_1.getSelectedItem().toString(),
//								combito.getSelectedItem().toString(), objDate);
//
//					} catch (RemoteException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					a.setVisible(true);
//
//				}
//			}
//		});
		pIzquierda.add(btnBuscar);

		JPanel pNorte = new JPanel();
		pNorte.setBackground(new Color(0, 0, 128));
		pNorte.setBounds(0, 0, 1278, 163);
		contentPane.add(pNorte);
		pNorte.setLayout(null);

		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(15, 16, 202, 73);
		// ImageIcon fot = new
		// ImageIcon(Buscar.class.getResource("/EasyBooking/Img/logo.png"));
		// Icon icono = new
		// ImageIcon(fot.getImage().getScaledInstance(lblLogo.getWidth(),
		// lblLogo.getHeight(), Image.SCALE_DEFAULT));
		// lblLogo.setIcon(icono);
		pNorte.add(lblLogo);

	}

	public static void main(String[] args) {

		Controller c = null;
		try {
			c = new Controller();
		} catch (RemoteException e) {
			
			e.printStackTrace();
		}
		Buscar b = new Buscar(c);

	}
}
