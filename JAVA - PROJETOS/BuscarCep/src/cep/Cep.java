package cep;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import Atxy2k.CustomTextField.RestrictedTextField;

public class Cep extends JFrame {
	
	
	/*DEFINIÇÔES AUTOMATICAS DAS ESTRUTURAS DO SWING*/
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCep;
	private JTextField txtEndereco;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JComboBox cboUf;
	private JLabel lblStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cep frame = new Cep();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Cep() {
		setTitle("Buscar CEP");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cep.class.getResource("/img/home.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("CEP");
		lblNewLabel.setBounds(10, 30, 46, 14);
		contentPane.add(lblNewLabel);

		txtCep = new JTextField();
		txtCep.setBounds(76, 27, 97, 20);
		contentPane.add(txtCep);
		txtCep.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("ENDEREÇO");
		lblNewLabel_1.setBounds(10, 71, 64, 14);
		contentPane.add(lblNewLabel_1);

		txtEndereco = new JTextField();
		txtEndereco.setBounds(76, 68, 348, 20);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);

		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(76, 114, 348, 20);
		contentPane.add(txtBairro);

		JLabel lblNewLabel_1_1 = new JLabel("BAIRRO");
		lblNewLabel_1_1.setBounds(10, 117, 64, 14);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("CIDADE");
		lblNewLabel_1_1_1.setBounds(10, 158, 64, 14);
		contentPane.add(lblNewLabel_1_1_1);

		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(76, 155, 226, 20);
		contentPane.add(txtCidade);

		JLabel lblNewLabel_2 = new JLabel("UF");
		lblNewLabel_2.setBounds(313, 158, 46, 14);
		contentPane.add(lblNewLabel_2);

		cboUf = new JComboBox();
		cboUf.setModel(new DefaultComboBoxModel(
				new String[] { "", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA",
						"PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		cboUf.setBounds(346, 154, 55, 22);
		contentPane.add(cboUf);
		
	/*FIM DAS DEFINIÇÔES AUTOMATICAS DAS ESTRUTURAS DO SWING*/
		
	/*DEFINIÇÔES DOS BOTÕES E DE SUAS LÓGICAS*/

		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setBounds(10, 211, 89, 23);
		contentPane.add(btnLimpar);

		JButton btnCep = new JButton("BUSCAR");
		btnCep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtCep.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe o CEP");
					txtCep.requestFocus();
				} else {
					buscarCep();
				}
			}
		});
		btnCep.setBounds(235, 26, 89, 23);
		contentPane.add(btnCep);

		JButton btnSobre = new JButton("");
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre sobre = new Sobre();
				sobre.setVisible(true);

			}
		});
		btnSobre.setToolTipText("SOBRE");
		btnSobre.setIcon(new ImageIcon(Cep.class.getResource("/img/about.png")));
		btnSobre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSobre.setBorder(null);
		btnSobre.setBackground(SystemColor.control);
		btnSobre.setBounds(363, 11, 48, 48);
		contentPane.add(btnSobre);
		
	/*FIM DEFINIÇÔES DOS BOTÕES E DE SUAS LÓGICAS*/

		/* USO LIB ATXY2K */

		RestrictedTextField validar = new RestrictedTextField(txtCep);
		
		lblStatus = new JLabel("");
		lblStatus.setBounds(178, 27, 20, 20);
		contentPane.add(lblStatus);
		validar.setOnlyNums(true);
		validar.setLimit(8);

	}

	private void buscarCep() {
		String logradouro = "", tipoLogradouro = "", resultado, cep = txtCep.getText();

		try {
			URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=xml");
			SAXReader xml = new SAXReader();
			Document documento = xml.read(url);
			Element root = documento.getRootElement();

			for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
				Element element = it.next();
				
				if(element.getQualifiedName().equals("cidade")) {
					txtCidade.setText(element.getText());
				}
				
				if(element.getQualifiedName().equals("bairro")) {
					txtBairro.setText(element.getText());
				}
				
				if(element.getQualifiedName().equals("uf")) {
					cboUf.setSelectedItem(element.getText());
				}
				
				if(element.getQualifiedName().equals("tipo_logradouro")) {
					tipoLogradouro = element.getText();
				}
				
				if(element.getQualifiedName().equals("logradouro")) {
					logradouro = element.getText();
				}
				
				if(element.getQualifiedName().equals("resultado")) {
					resultado = element.getText();
					
					if(resultado.equals("1")) {
						lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/check.png")));
					}else {
						JOptionPane.showMessageDialog(null, "CEP não encontrado");
					}
				}
				
				//Setando o endereço
				txtEndereco.setText(tipoLogradouro + " - " + logradouro);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	private void limpar() {
		txtCep.setText(null);
		txtEndereco.setText(null);
		txtBairro.setText(null);
		txtCidade.setText(null);
		cboUf.setSelectedItem(null);
		txtCep.requestFocus();
		lblStatus.setIcon(null);
	}
}














