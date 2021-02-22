package telas_sistemas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.awt.event.InputEvent;
import javax.swing.JDesktopPane;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends TelaLogin {

	private JDesktopPane desktopPane;
	public static JCheckBoxMenuItem relatorioServicos, cadastrosUsuarios;
	private JPanel tela;
	public static JTextField cargo;
	public static JTextField user;
	private JTextField data;

	/**
	 * CRIAÇÃO DA TELA
	 */
	
	@SuppressWarnings("deprecation")
	
	public TelaPrincipal() {
		setResizable(false);
		setTitle("Tela Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 915, 590);
		
		/**
		 * CRIAÇÃO DO MENU
		 */
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		/**
		 * CRIAÇÃO DO CADASTRO E DE SUA(S) "ABA(S)"
		 */
		
		JMenu cadastroMenu = new JMenu("Cadastro");
		menuBar.add(cadastroMenu);
		
		JCheckBoxMenuItem cadastroCliente = new JCheckBoxMenuItem("Cliente");
		cadastroCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					cadastrosClientesActionPerformed(arg0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		cadastroCliente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_MASK));
		cadastroMenu.add(cadastroCliente);
		
		JCheckBoxMenuItem cadastroServicos = new JCheckBoxMenuItem("OS");
		cadastroServicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					cadastroServicosActionPerformed(arg0);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		cadastroServicos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.ALT_MASK));
		cadastroMenu.add(cadastroServicos);
		
		cadastrosUsuarios = new JCheckBoxMenuItem("Usuários");
		cadastrosUsuarios.setEnabled(false);
		cadastrosUsuarios.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.ALT_MASK));
		cadastroMenu.add(cadastrosUsuarios);
		cadastrosUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					cadastrosUsuariosActionPerformed(arg0);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		
		/**
		 * CRIAÇÃO DO RELATÓRIO E DE SUA(S) "ABA(S)"
		 */
		
		JMenu mnRelatrio = new JMenu("Relatório");
		menuBar.add(mnRelatrio);
		
		relatorioServicos = new JCheckBoxMenuItem("Serviços");
		relatorioServicos.setEnabled(false);
		relatorioServicos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_MASK));
		mnRelatrio.add(relatorioServicos);
		
		/**
		 * CRIAÇÃO DA AJUDA E DE SUA(S) "ABA(S)"
		 */
		
		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		JCheckBoxMenuItem ajudaSobre = new JCheckBoxMenuItem("Sobre");
		ajudaSobre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, InputEvent.ALT_MASK));
		mnAjuda.add(ajudaSobre);
		ajudaSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ajudaSobreActionPerformed(arg0);
			}
		});
		/*
		ajudaSobre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, InputEvent.ALT_MASK));
		mnAjuda.add(ajudaSobre);
		*/
		
		/**
		 * CRIAÇÃO DA OPÇÕES E DE SUA(S) "ABA(S)"
		 */
		
		JMenu MenOpc = new JMenu("Opções");
		menuBar.add(MenOpc);
		
		JCheckBoxMenuItem MenOpcSai = new JCheckBoxMenuItem("Sair");
		MenOpcSai.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		MenOpc.add(MenOpcSai);
		MenOpcSai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				MenOpcSaiActionPerformed(arg0);
			}
		});
		
		tela = new JPanel();
		tela.setBorder(new EmptyBorder(5, 5, 5, 5));
		tela.setLayout(new BorderLayout(0, 0));
		setContentPane(tela);
		
		JDesktopPane desktop = new JDesktopPane();
		tela.add(desktop, BorderLayout.CENTER);
		
		JLabel logoUnifal = new JLabel("Unifal-MG");
		logoUnifal.setIcon(new ImageIcon("/home/gustavo/Desktop/unifal.png"));
		logoUnifal.setBounds(633, 435, 260, 65);
		desktop.add(logoUnifal);
		
		/**
		 * SEPARAR ABA(S) DE LOGIN COM AS DEMAIS INFORMAÇÕES
		 */
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(621, 0, 3, 523);
		desktop.add(spinner);
		
		/**
		 *  ID DO PROCESSO DE LOGIN
		 */
		
		JLabel labelPerfil = new JLabel("Perfil de Acesso: ");
		desktop.add(labelPerfil);
		labelPerfil.setForeground(Color.BLACK);
		labelPerfil.setFont(new Font("Bitstream Vera Sans", Font.BOLD, 16));
		labelPerfil.setBounds(633, 0, 163, 27);
		
		cargo = new JTextField();
		cargo.setEditable(false);
		cargo.setBounds(793, 5, 100, 19);
		desktop.add(cargo);
		cargo.setColumns(10);
		
		/**
		 *  USUÁRIO
		 */
		
		JLabel labelUser = new JLabel("Usuário: ");
		labelUser.setForeground(Color.BLACK);
		labelUser.setFont(new Font("Bitstream Vera Sans", Font.BOLD, 16));
		labelUser.setBounds(633, 35, 100, 27);
		desktop.add(labelUser);
		
		user = new JTextField();
		user.setEditable(false);
		user.setBounds(714, 40, 146, 19);
		desktop.add(user);
		user.setColumns(10);
		
		
		/**
		 *  DATA
		 */
		
		JLabel labelData = new JLabel("Data: ");
		labelData.setForeground(Color.BLACK);
		labelData.setFont(new Font("Bitstream Vera Sans", Font.BOLD, 16));
		labelData.setBounds(633, 74, 100, 27);
		desktop.add(labelData);
		
		data = new JTextField();
		data.setEditable(false);
		data.setBounds(690, 79, 100, 19);
		desktop.add(data);
		data.setColumns(10);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		desktopPane.setBackground(Color.LIGHT_GRAY);
		desktopPane.setBounds(0, 0, 621, 523);
		desktop.add(desktopPane);
		
		formWindowActivated(null);
		
	}
	
	private void formWindowActivated(java.awt.event.WindowEvent evt) {
		Date date = new Date();
		DateFormat format = DateFormat.getDateInstance(DateFormat.SHORT);
		data.setText(format.format(date));
	}
	
	private void MenOpcSaiActionPerformed(java.awt.event.ActionEvent evt) {
		int exit = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?","Atenção",JOptionPane.YES_NO_OPTION);
		
		if (exit == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	private void ajudaSobreActionPerformed(java.awt.event.ActionEvent evt) {
		TelaSobre sobre = new TelaSobre();
		sobre.setVisible(true);
	}
	
	private void cadastrosUsuariosActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {                                          
        TelaUsuarios usuario = new TelaUsuarios();
        usuario.setVisible(true);
        desktopPane.add(usuario);
    }
	
	private void cadastrosClientesActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
		TelaClientes clientes = new TelaClientes();
		clientes.setVisible(true);
		desktopPane.add(clientes);
	}
	
	private void cadastroServicosActionPerformed(java.awt.event.ActionEvent evt) throws SQLException{
		TelaOS telaOS = new TelaOS();
		telaOS.setVisible(true);
		desktopPane.add(telaOS);
	}
}
