package cep;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.net.URI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sobre extends JDialog {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sobre dialog = new Sobre();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Sobre() {
		setModal(true);
		setResizable(false);
		setTitle("SOBRE");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sobre.class.getResource("/img/home.png")));
		setBounds(150, 150, 450, 300);
		getContentPane().setLayout(null);
		
		JTextArea txtrBuscarCep = new JTextArea();
		txtrBuscarCep.setEditable(false);
		txtrBuscarCep.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtrBuscarCep.setBackground(SystemColor.control);
		txtrBuscarCep.setForeground(SystemColor.desktop);
		txtrBuscarCep.setText("Buscar CEP - Versão 1");
		txtrBuscarCep.setBounds(20, 37, 176, 22);
		getContentPane().add(txtrBuscarCep);
		
		JTextArea txtrauthorEuMesmo = new JTextArea();
		txtrauthorEuMesmo.setEditable(false);
		txtrauthorEuMesmo.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtrauthorEuMesmo.setBackground(SystemColor.control);
		txtrauthorEuMesmo.setText("@Author Eu Mesmo");
		txtrauthorEuMesmo.setBounds(20, 81, 176, 22);
		getContentPane().add(txtrauthorEuMesmo);
		
		JTextArea txtrWebService = new JTextArea();
		txtrWebService.setEditable(false);
		txtrWebService.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtrWebService.setBackground(SystemColor.control);
		txtrWebService.setText("WEB Service: ");
		txtrWebService.setBounds(20, 126, 101, 22);
		getContentPane().add(txtrWebService);
		
		JTextArea lblWebService = new JTextArea();
		lblWebService.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				link("https://www.republicavirtual.com.br/cep/index.php");
			}
		});
		lblWebService.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblWebService.setBackground(SystemColor.control);
		lblWebService.setForeground(SystemColor.textHighlight);
		lblWebService.setText("republicavirtual.com.br");
		lblWebService.setBounds(129, 126, 189, 22);
		getContentPane().add(lblWebService);
		
		JButton btnYoutube = new JButton("");
		btnYoutube.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnYoutube.setBorder(null);
		btnYoutube.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				link("https://youtube.com/playlist?list=PLbEOwbQR9lqxVuDWNIrG57_JGcbIL3FWP&si=np4FVtJcp0-qi1qc");
			}
		});
		btnYoutube.setBackground(SystemColor.control);
		btnYoutube.setIcon(new ImageIcon(Sobre.class.getResource("/img/youtube.png")));
		btnYoutube.setBounds(20, 177, 48, 48);
		getContentPane().add(btnYoutube);
		
		JButton btnGithub = new JButton("");
		btnGithub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				link("https://github.com/SergioLuizFilho");
			}
		});
		btnGithub.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGithub.setBorder(null);
		btnGithub.setIcon(new ImageIcon(Sobre.class.getResource("/img/github.png")));
		btnGithub.setBackground(SystemColor.control);
		btnGithub.setBounds(109, 177, 48, 48);
		getContentPane().add(btnGithub);

	}
	
	private void link(String site) {
		Desktop desktop = Desktop.getDesktop();
		
		try {
			URI uri = new URI(site);
			desktop.browse(uri);
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
}

















