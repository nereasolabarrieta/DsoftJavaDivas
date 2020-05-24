package EasyBooking.LP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Toolkit;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDayChooser;

import Controller.Controller;
import EasyBooking.LD.Vuelo;

import com.toedter.calendar.JDateChooser;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JPanel PscrollPane;
	private ArrayList<Vuelo>Lista_vuelos;
	private Controller controller;
	private String origen;
	private String destino;
	private Date fecha;
	/**
	 * Create the frame.
	 * @param controller 
	 * @param objDate 
	 * @param string 
	 * @param object 
	 * @throws RemoteException 
	 */
	
	public Principal(Controller controller, String origen, String destino, Date objDate) throws RemoteException {
		this.controller = controller;
		this.destino = destino;
		this.origen = origen;
		this.fecha = objDate;
		Lista_vuelos = controller.Buscar_vuelos(origen, destino, objDate);
		System.out.println(Lista_vuelos.size());
		initComponents();
		this.setVisible(true);
		
	}
	public void initComponents()
	{
		//setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/EasyBooking/Img/Avion.jpg")));
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
		this.setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JPanel pArriba = new JPanel();
		pArriba.setBounds(0, 0, 1278, 159);
		pArriba.setBackground(new Color(0, 0, 128));
		contentPane.add(pArriba);
		pArriba.setLayout(null);
		
//		JLabel lblLogo = new JLabel();
//		lblLogo.setBounds(0, 0, 185, 64);
//		pArriba.add(lblLogo);
//		ImageIcon fot = new ImageIcon(Principal.class.getResource("/EasyBooking/Img/logo.png"));
//		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_DEFAULT));
//		lblLogo.setIcon(icono);
		
		JDateChooser dChooser_ida = new JDateChooser();
		dChooser_ida.setBounds(861, 70, 125, 26);
		Date objDate= new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		sdf.format(objDate);
		dChooser_ida.setDate(objDate);
		pArriba.add(dChooser_ida);
		
		JDateChooser dChooser_vuelta = new JDateChooser();
		dChooser_vuelta.setBounds(1091, 70, 125, 26);
		dChooser_vuelta.setDate(objDate);
		pArriba.add(dChooser_vuelta);
		
		JLabel lblIda = new JLabel("Ida:");
		lblIda.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblIda.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIda.setLabelFor(this);
		lblIda.setForeground(Color.WHITE);
		lblIda.setBounds(777, 76, 69, 20);
		pArriba.add(lblIda);
		
		JLabel lblVuelta = new JLabel("Vuelta: ");
		lblVuelta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVuelta.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblVuelta.setForeground(Color.WHITE);
		lblVuelta.setBounds(1007, 76, 69, 20);
		pArriba.add(lblVuelta);
		
		JLabel lblOrigen = new JLabel("Origen: ");
		lblOrigen.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrigen.setForeground(Color.WHITE);
		lblOrigen.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblOrigen.setBounds(276, 76, 69, 20);
		pArriba.add(lblOrigen);
		
		JLabel lblAeropuerto_Origen = new JLabel(origen);
		lblAeropuerto_Origen.setForeground(Color.WHITE);
		lblAeropuerto_Origen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAeropuerto_Origen.setBounds(360, 77, 69, 20);
		pArriba.add(lblAeropuerto_Origen);
		
		JLabel lblDestino = new JLabel("Destino: ");
		lblDestino.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDestino.setForeground(Color.WHITE);
		lblDestino.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblDestino.setBounds(475, 76, 93, 20);
		pArriba.add(lblDestino);
		
		JLabel lblAeropuerto_destino = new JLabel(destino);
		lblAeropuerto_destino.setForeground(Color.WHITE);
		lblAeropuerto_destino.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAeropuerto_destino.setBounds(570, 76, 69, 20);
		pArriba.add(lblAeropuerto_destino);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(new Color(255, 255, 255));
		btnBuscar.setBounds(1101, 114, 115, 29);	
		pArriba.add(btnBuscar);
		
		JLabel lblBuscar = new JLabel("");
		lblBuscar.setBounds(1048, 112, 38, 31);
		//ImageIcon fotBuscar = new ImageIcon(Principal.class.getResource("/EasyBooking/Img/Buscar.png"));
		//Icon iconoBuscar = new ImageIcon(fotBuscar.getImage().getScaledInstance(lblBuscar.getWidth(), lblBuscar.getHeight(), Image.SCALE_DEFAULT));
		//lblBuscar.setIcon(iconoBuscar);
		pArriba.add(lblBuscar);
		
		JPanel pIzquierda= new JPanel();
		pIzquierda.setBounds(0, 155, 218, 529);
		pIzquierda.setBackground(new Color(0, 0, 128));
		contentPane.add(pIzquierda);
		pIzquierda.setLayout(null);
		
		JLabel lblFiltros = new JLabel("FILTROS");
		lblFiltros.setForeground(new Color(255, 255, 255));
		lblFiltros.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFiltros.setHorizontalAlignment(SwingConstants.CENTER);
		lblFiltros.setBounds(15, 16, 188, 44);
		pIzquierda.add(lblFiltros);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPrecio.setForeground(new Color(255, 255, 255));
		lblPrecio.setBounds(15, 100, 69, 20);
		pIzquierda.add(lblPrecio);
		
		JSlider slPrecio = new JSlider();
		slPrecio.setMajorTickSpacing(100000);
		slPrecio.setBackground(new Color(0, 0, 128));
		slPrecio.setForeground(new Color(255, 255, 255));
		slPrecio.setPaintTicks(true);
		slPrecio.setBounds(15, 136, 173, 30);
		pIzquierda.add(slPrecio);
		
		JLabel lblFiltro_ida = new JLabel("Hora de ida:");
		lblFiltro_ida.setForeground(Color.WHITE);
		lblFiltro_ida.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFiltro_ida.setBounds(15, 182, 117, 20);
		pIzquierda.add(lblFiltro_ida);
		
		JSlider slHora_salida = new JSlider();
		slHora_salida.setPaintTicks(true);
		slHora_salida.setMajorTickSpacing(100000);
		slHora_salida.setForeground(Color.WHITE);
		slHora_salida.setBackground(new Color(0, 0, 128));
		slHora_salida.setBounds(15, 218, 173, 30);
		pIzquierda.add(slHora_salida);
		
		JLabel lblFiltro_regreso = new JLabel("Hora de regreso:");
		lblFiltro_regreso.setForeground(Color.WHITE);
		lblFiltro_regreso.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFiltro_regreso.setBounds(15, 264, 173, 20);
		pIzquierda.add(lblFiltro_regreso);
		
		JSlider slHora_regreso = new JSlider();
		slHora_regreso.setPaintTicks(true);
		slHora_regreso.setMajorTickSpacing(100000);
		slHora_regreso.setForeground(Color.WHITE);
		slHora_regreso.setBackground(new Color(0, 0, 128));
		slHora_regreso.setBounds(15, 300, 173, 30);
		pIzquierda.add(slHora_regreso);
		
		JLabel lblDuracion = new JLabel("Duracion: ");
		lblDuracion.setForeground(Color.WHITE);
		lblDuracion.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDuracion.setBounds(15, 346, 173, 20);
		pIzquierda.add(lblDuracion);
		
		JSlider slDuracion = new JSlider();
		slDuracion.setPaintTicks(true);
		slDuracion.setMajorTickSpacing(100000);
		slDuracion.setForeground(Color.WHITE);
		slDuracion.setBackground(new Color(0, 0, 128));
		slDuracion.setBounds(15, 377, 173, 30);
		pIzquierda.add(slDuracion);
			
		JPanel pCentro = new JPanel();
		pCentro.setBounds(215, 155, 1063, 529);
		contentPane.add(pCentro);
		pCentro.setLayout(new BorderLayout(0, 0));
		
		PscrollPane = new JPanel();
		scrollPane = new JScrollPane(PscrollPane);
		pCentro.add(scrollPane, BorderLayout.CENTER);
		
		
		scrollPane.setViewportView(PscrollPane);
		scrollPane .getViewport().setView(PscrollPane);
		GridBagLayout gbl_PscrollPane = new GridBagLayout();
		gbl_PscrollPane.columnWidths = new int[]{0};
		gbl_PscrollPane.rowHeights = new int[]{0};
		gbl_PscrollPane.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_PscrollPane.rowWeights = new double[]{Double.MIN_VALUE};
		PscrollPane.setLayout(gbl_PscrollPane);
		


	
		InsertarJPanel(Lista_vuelos);
		PscrollPane.repaint();
		scrollPane.repaint();

		

		

		
		
		
		
	}
	/**
	 * Metodo para insertar el panel de clsJPanelVuelo
	 */
	public void InsertarJPanel(ArrayList<Vuelo> Lista_vuelos)
	{		
		System.out.println("aqui llega");
		String[] columnNames = { "Origen", "Destino", "Precio", ""};
		DefaultTableModel modelo = new DefaultTableModel(columnNames,0);
		System.out.println(modelo.getColumnCount());
		System.out.println(modelo.getRowCount());
		JTable tabla = new JTable (modelo);
		Object[] fila = new Object[Lista_vuelos.size()];
		add(tabla);
		JButton seleccionar = new JButton("Seleccionar");
	    for(int i=0;i<Lista_vuelos.size();i++){
    	
    
		fila[i]=Lista_vuelos.get(i).getOrigen().getNomAeropuerto();
		System.out.println(Lista_vuelos.get(i).getOrigen().getNomAeropuerto());
		System.out.println(fila[i].toString());
		fila[i]=Lista_vuelos.get(i).getDestino().getNomAeropuerto();
		fila[i]=Lista_vuelos.get(i).getPrecio();
		fila[i]= seleccionar;
	        modelo.addRow(fila);
	    }
	   
    //CONTADORLISTA es para agregar n Filas, y esa n lo define un contador que va sumando 1, cada vez que 
    //se agrega una nueva persona (o sea, cada vez que se presiona el jbutton)

	    
	    scrollPane.add(tabla);


		
//			JPanelVuelo panel=new JPanelVuelo(Lista_vuelos);
//			panel.setVisible(true);
//			GridBagConstraints gbc_lblFoto = new GridBagConstraints();
//			gbc_lblFoto.ipadx = 1058;
//			gbc_lblFoto.ipady = 265;
//			gbc_lblFoto.gridx = x;
//			gbc_lblFoto.gridy = y;
//			PscrollPane.add(panel);
//
//			y=y+265;
			
		


	}

}
