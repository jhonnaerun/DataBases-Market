package interfaces;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import Logic.Consultas;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Ventana extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldArticulo;
	private JTextField textFieldPrecio;
	private JTextField textFieldCodigo;
	private JTextField textFieldDesArticulo;
	private JTextField textFieldDesPrecio;
	private JTextField textFieldConCodigo;
	private JButton btnRegistrar, btnBuscar, btnConsultar, btnEliminar, btnEditar;
	private JButton btnCerrar;
	private Consultas miConsultas;

	/**
	 * Create the frame.
	 */
	public Ventana() {
		inicializarVentana(); 
		miConsultas = new Consultas(this);
		
	}

	public void inicializarVentana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 127);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblArticulo = new JLabel("Articulo");
		lblArticulo.setBounds(44, 26, 46, 14);
		panel.add(lblArticulo);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(44, 68, 46, 14);
		panel.add(lblPrecio);

		textFieldArticulo = new JTextField();
		textFieldArticulo.setBounds(142, 23, 136, 20);
		panel.add(textFieldArticulo);
		textFieldArticulo.setColumns(10);

		textFieldPrecio = new JTextField();
		textFieldPrecio.setBounds(142, 65, 136, 20);
		panel.add(textFieldPrecio);
		textFieldPrecio.setColumns(10);

		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setBounds(300, 93, 104, 23);
		panel.add(btnRegistrar);
		btnRegistrar.addActionListener(this);

		btnCerrar = new JButton("CERRAR");
		btnCerrar.setBounds(315, 22, 89, 23);
		panel.add(btnCerrar);
		btnCerrar.addActionListener(this);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 149, 414, 99);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(44, 41, 46, 14);
		panel_1.add(lblCodigo);

		textFieldCodigo = new JTextField();
		textFieldCodigo.setBounds(143, 38, 132, 20);
		panel_1.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);

		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(299, 65, 105, 23);
		panel_1.add(btnBuscar);
		btnBuscar.addActionListener(this);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 259, 414, 212);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblDesArticulo = new JLabel("Des. Articulo");
		lblDesArticulo.setBounds(43, 36, 76, 14);
		panel_2.add(lblDesArticulo);

		JLabel lblDesPrecio = new JLabel("Des. Precio");
		lblDesPrecio.setBounds(43, 69, 76, 14);
		panel_2.add(lblDesPrecio);

		textFieldDesArticulo = new JTextField();
		textFieldDesArticulo.setBounds(144, 33, 130, 20);
		panel_2.add(textFieldDesArticulo);
		textFieldDesArticulo.setColumns(10);

		textFieldDesPrecio = new JTextField();
		textFieldDesPrecio.setBounds(144, 66, 130, 20);
		panel_2.add(textFieldDesPrecio);
		textFieldDesPrecio.setColumns(10);

		textFieldConCodigo = new JTextField();
		textFieldConCodigo.setBounds(188, 97, 86, 20);
		panel_2.add(textFieldConCodigo);
		textFieldConCodigo.setColumns(10);

		btnConsultar = new JButton("CONSULTAR");
		btnConsultar.setBounds(30, 96, 112, 23);
		panel_2.add(btnConsultar);
		btnConsultar.addActionListener(this);

		btnEditar = new JButton("EDITAR");
		btnEditar.setBounds(30, 130, 112, 23);
		panel_2.add(btnEditar);
		btnEditar.addActionListener(this);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(30, 161, 112, 23);
		panel_2.add(btnEliminar);
		btnEliminar.addActionListener(this);

		this.setTitle("DATABASES MARKET");
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.blue);
		g.drawRoundRect(15, 50, 420, 140, 50, 50);
		g.drawRoundRect(15, 200, 420, 90, 50, 50);
		g.drawRoundRect(15, 300, 420, 180, 50, 50);
	}

	public void limpiarCampos() {
		textFieldArticulo.setText("");
		textFieldPrecio.setText("");
		textFieldCodigo.setText("");
		textFieldConCodigo.setText("");
		textFieldDesArticulo.setText("");
		textFieldDesPrecio.setText("");
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			System.exit(0);
		}
		if (e.getSource() == btnRegistrar) {
			miConsultas.registrarArticulo(textFieldArticulo.getText(), textFieldPrecio.getText());
			limpiarCampos();
		}
		if (e.getSource() == btnBuscar) {
			miConsultas.buscarArticulo(textFieldCodigo.getText());
			textFieldCodigo.setText("");
		}
		if (e.getSource() == btnConsultar) {
			miConsultas.consultarArticulo(textFieldConCodigo.getText());
		}
		if(e.getSource()==btnEliminar) {
			miConsultas.eliminarArticulo(textFieldConCodigo.getText());
			limpiarCampos();
		}
		if(e.getSource()==btnEditar) {
			miConsultas.editarArticulo(textFieldDesArticulo.getText(), textFieldDesPrecio.getText(), textFieldConCodigo.getText());
			limpiarCampos();
		}
	}

	public JTextField getTextFieldArticulo() {
		return textFieldArticulo;
	}

	public void setTextFieldArticulo(JTextField textFieldArticulo) {
		this.textFieldArticulo = textFieldArticulo;
	}

	public JTextField getTextFieldPrecio() {
		return textFieldPrecio;
	}

	public void setTextFieldPrecio(JTextField textFieldPrecio) {
		this.textFieldPrecio = textFieldPrecio;
	}

	public JTextField getTextFieldDesArticulo() {
		return textFieldDesArticulo;
	}

	public void setTextFieldDesArticulo(JTextField textFieldDesArticulo) {
		this.textFieldDesArticulo = textFieldDesArticulo;
	}

	public JTextField getTextFieldDesPrecio() {
		return textFieldDesPrecio;
	}

	public void setTextFieldDesPrecio(JTextField textFieldDesPrecio) {
		this.textFieldDesPrecio = textFieldDesPrecio;
	}

}
