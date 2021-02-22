package telas_sistemas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes_de_conexao.Conexao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtLogin;
	private JPasswordField pswSenha;
	
	public void login() {
		try {
			Connection database = Conexao.faz_conexao();
			
			String sqlCommand = "select * from aps.login where login=? and senha=?;";
			
			PreparedStatement stmt = database.prepareStatement(sqlCommand);
			
			stmt.setString(1, txtLogin.getText());
			stmt.setString(2, new String (pswSenha.getPassword()) );
			
			ResultSet resultQuery = stmt.executeQuery();
			
			/**
			 * CRIAÇÃO DA TELA PRINCIPAL
			 */
			
			if (resultQuery.next()) {
				
				String cargo = resultQuery.getString(5);
				
				if (cargo.equals("Diretor")) {
					
					TelaPrincipal exibir = new TelaPrincipal();
					exibir.setVisible(true);	
					
					TelaPrincipal.cadastrosUsuarios.setEnabled(true);
					//TelaPrincipal.relatorioServicos.setEnabled(true);
					TelaPrincipal.user.setText(resultQuery.getString(2));
					TelaPrincipal.cargo.setText(resultQuery.getString(5));
					
					this.dispose();				
				} else {
					TelaPrincipal exibir = new TelaPrincipal();
					exibir.setVisible(true);
					
					TelaPrincipal.user.setText(resultQuery.getString(2));
					TelaPrincipal.cargo.setText(resultQuery.getString(5));
					
					this.dispose();		
				}
				

			} else {
				JOptionPane.showMessageDialog(null, "Usuário e/ou Senha Inválido!");
			}
			
			stmt.close();	//fechar o prepareStatement (segurança do db)
			database.close(); 	//fechar o db
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			e.printStackTrace();
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		setResizable(false);
		setTitle("Tela de Acesso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Login:");
		lblUsuario.setForeground(Color.BLACK);
		lblUsuario.setFont(new Font("Bitstream Vera Sans", Font.BOLD, 16));
		lblUsuario.setBounds(23, 41, 79, 27);
		contentPane.add(lblUsuario);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(185, 47, 187, 17);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(Color.BLACK);
		lblSenha.setFont(new Font("Bitstream Vera Sans", Font.BOLD, 16));
		lblSenha.setBounds(23, 80, 79, 27);
		contentPane.add(lblSenha);
		
		pswSenha = new JPasswordField();
		pswSenha.setBounds(185, 85, 92, 17);
		contentPane.add(pswSenha);
		
		JButton btnCadastrar = new JButton("Login");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				/**
				 *  CHAMAR O METODO LOGIN
				 */

				login();
				
			}
		});
		btnCadastrar.setBounds(150, 189, 159, 25);
		contentPane.add(btnCadastrar);
	}
}
