package telas_sistemas;

import javax.swing.JInternalFrame;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import classes_de_conexao.Conexao;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;

public class TelaUsuarios extends JInternalFrame {
	private JTextField txtLogin;
	private JPasswordField pwdSenha;
	private JTextField txtTelefone;
	private JTextField txtEstado;
	private JTextField txtCidade;
	private JTextField txtEmail;
	private JTextField txtUsuario;
	private JTextField txtCEP;
	private JTextField txtDataNascimento;
	private JTextField txtCPF;
	private JComboBox cargo;
	Connection conexao = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	@SuppressWarnings("unchecked")
	public TelaUsuarios() throws SQLException {
		/**
		 * CONEXÃO COM O DATABASE;
		 */
		
		conexao = Conexao.faz_conexao();
		
		/**
		 * CRIAÇÃO DA TELA
		 */
		
		setIconifiable(true);
		setClosable(true);
		setMaximizable(true);
		setTitle("Usuários");
		setNormalBounds(new Rectangle(0, 0, 621, 523));
		setBounds(0, 0, 621, 523);
		
		JDesktopPane desktopPane = new JDesktopPane();
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		/**
		 * USUARIO
		 */
		
		JLabel lblUsuario = new JLabel("Usuario*");
		lblUsuario.setBounds(12, 29, 70, 15);
		desktopPane.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(82, 27, 315, 19);
		desktopPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		/**
		 * EMAIL
		 */
		
		JLabel lblEmail = new JLabel("E-mail*");
		lblEmail.setBounds(12, 71, 70, 15);
		desktopPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(66, 69, 263, 19);
		desktopPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		/**
		 * DATA DE NASCIMENTO
		 */
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento*");
		lblDataDeNascimento.setBounds(12, 108, 168, 15);
		desktopPane.add(lblDataDeNascimento);
		
		txtDataNascimento = new JTextField();
		txtDataNascimento.setBounds(175, 106, 114, 19);
		desktopPane.add(txtDataNascimento);
		txtDataNascimento.setColumns(10);
		
		/**
		 * CPF
		 */
				
		JLabel lblRg = new JLabel("CPF*");
		lblRg.setBounds(12, 152, 70, 15);
		desktopPane.add(lblRg);
		
		txtCPF = new JTextField();
		txtCPF.setBounds(62, 150, 168, 19);
		desktopPane.add(txtCPF);
		txtCPF.setColumns(10);
		
		/**
		 * LOGIN
		 */
		
		JLabel lblLogin = new JLabel("Login *");
		lblLogin.setBounds(12, 198, 70, 15);
		desktopPane.add(lblLogin);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(68, 194, 171, 19);
		desktopPane.add(txtLogin);
		txtLogin.setColumns(10);		
		
		/**
		 * SENHA
		 */
		
		JLabel lblSenha = new JLabel("Senha *");
		lblSenha.setBounds(12, 243, 70, 15);
		desktopPane.add(lblSenha);
		
		pwdSenha = new JPasswordField();
		pwdSenha.setBounds(82, 241, 114, 19);
		desktopPane.add(pwdSenha);
		
		
		/**
		 * TELEFONE
		 */
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(392, 179, 70, 15);
		desktopPane.add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(467, 177, 114, 19);
		desktopPane.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		/**
		 * CIDADE
		 */
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(392, 125, 70, 15);
		desktopPane.add(lblCidade);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(449, 123, 114, 19);
		desktopPane.add(txtCidade);
		txtCidade.setColumns(10);
		
		/**
		 * ESTADO
		 */
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(392, 152, 70, 15);
		desktopPane.add(lblEstado);
		
		txtEstado = new JTextField();
		txtEstado.setBounds(450, 150, 60, 19);
		desktopPane.add(txtEstado);
		txtEstado.setColumns(10);
		
		/**
		 * CEP
		 */
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(395, 98, 70, 15);
		desktopPane.add(lblCep);
		
		txtCEP = new JTextField();
		txtCEP.setBounds(449, 96, 114, 19);
		desktopPane.add(txtCEP);
		txtCEP.setColumns(10);
		
		/**
		 *  CARGO
		 */
		
		JLabel lblCargo = new JLabel("Cargo*");
		lblCargo.setBounds(395, 206, 70, 15);
		desktopPane.add(lblCargo);
		
		cargo = new JComboBox();
		cargo.setModel(new DefaultComboBoxModel(new String[] {"<Selecione uma das Opções>", "Presidente", "Diretor", "Gerente", "Funcionario"}));
		cargo.setBounds(392, 222, 171, 24);
		desktopPane.add(cargo);
		
		/**
		 * INSERT BUTTOM
		 */
		
		JButton create = new JButton(" ");
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inserir();
			}
		});
		create.setIcon(new ImageIcon("/home/gustavo/Downloads/3209288-64.png"));
		create.setBounds(12, 341, 117, 85);
		desktopPane.add(create);
		
		/**
		 * SELECT BUTTOM
		 */
		
		JButton read = new JButton(" ");
		read.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consultar();
			}
		});
		read.setIcon(new ImageIcon("/home/gustavo/Downloads/4831045-64.png"));
		read.setBounds(162, 341, 117, 85);
		desktopPane.add(read);
		
		/**
		 * UPDATE BUTTOM
		 */
		
		JButton update = new JButton(" ");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				alterar();
			}
		});
		update.setIcon(new ImageIcon("/home/gustavo/Downloads/iconfinder_update_172618.png"));
		update.setBounds(312, 341, 117, 85);
		desktopPane.add(update);
		
		/**
		 * DELETE BUTTOM
		 */
		
		JButton delete = new JButton(" ");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deletar();
			}
		});
		delete.setIcon(new ImageIcon("/home/gustavo/Downloads/iconfinder_basket_1814090.png"));
		delete.setBounds(462, 341, 117, 85);
		desktopPane.add(delete);
		
		/**
		 * INFORMAR AO USUARIO OS CAMPOS OBRIGÁTORIOS
		 */
		
		JLabel lblcamposObrigtorios = new JLabel("*Campos Obrigátorios");
		lblcamposObrigtorios.setBounds(188, 281, 168, 15);
		desktopPane.add(lblcamposObrigtorios);
	}
	
	private void inserir() {
		String sqlCommand = "INSERT INTO aps.login (usuario,login,senha,cargo,email,datanascimento,cpf,telefone,cidade,estado,cep) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
			try {
				pst = conexao.prepareStatement(sqlCommand);
				pst.setString(1, txtUsuario.getText());
				pst.setString(2, txtLogin.getText());
				pst.setString(3, new String (pwdSenha.getPassword()));
				pst.setString(4, cargo.getSelectedItem().toString());
				pst.setString(5, txtEmail.getText());
				pst.setString(6, txtDataNascimento.getText());
				pst.setString(7, txtCPF.getText());
				pst.setString(8, txtTelefone.getText());
				pst.setString(9, txtCidade.getText());
				pst.setString(10, txtEstado.getText());
				pst.setString(11, txtCEP.getText());
				
				/**
				 * VALIDAÇÃO DOS CAMPOS OBRIGATÓRIOS
				 */
				if(validacaoCamposObrigatorios()) {
					int adicionado = pst.executeUpdate();
					
					/**
					 * EM CASO DE SUCESSO DA QUERY
					 */
					
					if (adicionado > 0) {
						JOptionPane.showMessageDialog(null, "Dados do Usuário Inserido com Sucesso!");
						
						/**
						 * LIMPAR OS DADOS APÓS O INSERT
						 */
						
						txtUsuario.setText(null);
						txtEmail.setText(null);
						txtDataNascimento.setText(null);
						txtCPF.setText(null);
						txtCEP.setText(null);
						txtCidade.setText(null);
						txtEstado.setText(null);
						txtTelefone.setText(null);
						cargo.setSelectedItem(null);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Preencha Todos os Campos Obrigatórios(*)");
				};
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
	}
	
	private void consultar() {
		/**
		 * MONTANDO A QUERY DE PESQUISA
		 */
		
		String sqlCommand = "SELECT * FROM aps.login where usuario like ?";
				try {
					pst = conexao.prepareStatement(sqlCommand);
					pst.setString(1, txtUsuario.getText() + "%");
					rs = pst.executeQuery();
					
					/**
					 * LOGICA PARA CASO A QUERY EXISTA
					 */
					if (rs.next()) {
						txtUsuario.setText(rs.getString(2));
						txtEmail.setText(rs.getString(6));
						txtDataNascimento.setText(rs.getString(7));
						txtCPF.setText(rs.getString(8));
						txtCEP.setText(rs.getString(12));
						txtCidade.setText(rs.getString(10));
						txtEstado.setText(rs.getString(11));
						txtTelefone.setText(rs.getString(9));
						cargo.setSelectedItem(rs.getString(5));
					}else {
						JOptionPane.showMessageDialog(null, "Usuário não cadastrado!");
						
						txtUsuario.setText(null);
						txtEmail.setText(null);
						txtDataNascimento.setText(null);
						txtCPF.setText(null);
						txtCEP.setText(null);
						txtCidade.setText(null);
						txtEstado.setText(null);
						txtTelefone.setText(null);
						cargo.setSelectedItem(null);
					}
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
	}
	
	private void alterar() {
		String sqlCommand = "UPDATE aps.login SET login=?, senha=?,cargo=?,email=?,datanascimento=?,cpf=?,telefone=?,cidade=?,estado=?,cep=? where usuario=?;";
			try {
				pst = conexao.prepareStatement(sqlCommand);
				pst.setString(1, txtLogin.getText());
				pst.setString(2, new String (pwdSenha.getPassword()));
				pst.setString(3, cargo.getSelectedItem().toString());
				pst.setString(4, txtEmail.getText());
				pst.setString(5, txtDataNascimento.getText());
				pst.setString(6, txtCPF.getText());
				pst.setString(7, txtTelefone.getText());
				pst.setString(8, txtCidade.getText());
				pst.setString(9, txtEstado.getText());
				pst.setString(10, txtCEP.getText());
				
				pst.setString(11, txtUsuario.getText());
				
				/**
				 * EM CASO DE TODOS OS CAMPOS OBRIGATORIOS ESTIVEREM PREENCHIDOS
				 */
				
				if(validacaoCamposObrigatorios()) {
					int alteracao = pst.executeUpdate();
					
					/**
					 * EM CASO DE SUCESSO DA QUERY
					 */
					
					if (alteracao > 0) {
						JOptionPane.showMessageDialog(null, "Dados do Usuário Alterado com Sucesso!");
						
						/**
						 * LIMPAR OS DADOS APÓS O UPDATE
						 */
						
						txtUsuario.setText(null);
						txtEmail.setText(null);
						txtDataNascimento.setText(null);
						txtCPF.setText(null);
						txtCEP.setText(null);
						txtCidade.setText(null);
						txtEstado.setText(null);
						txtTelefone.setText(null);
						cargo.setSelectedItem(null);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Preencha Todos os Campos Obrigatórios(*)");
				};
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		
	}
	
	private void deletar() {
		
		/**
		 * LOGICA CONTRA USUARIO BURRO
		 */
		
		int confirmacaoDelecao = JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja remover este usuário?", "Atenção!", JOptionPane.YES_NO_OPTION);
		
		if (confirmacaoDelecao == JOptionPane.YES_OPTION) {
			String sqlCommand = "DELETE FROM aps.login where usuario=?;";
				try {
					 pst = conexao.prepareStatement(sqlCommand);
					 pst.setString(1, txtUsuario.getText());
					 
					 int apagar = pst.executeUpdate();
					 
					 if(apagar > 0) {
						 JOptionPane.showMessageDialog(null, "Usuário Removido com Sucesso!");
						 
						 /**
						  * ZERAR OS CAMPOS 
						  */
						 
						 txtUsuario.setText(null);
						 txtEmail.setText(null);
					 	 txtDataNascimento.setText(null);
					 	 txtCPF.setText(null);
						 txtCEP.setText(null);
						 txtCidade.setText(null);
						 txtEstado.setText(null);
						 txtTelefone.setText(null);
						 cargo.setSelectedItem(null);
					 }
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}	
		}
	}
	
	private boolean validacaoCamposObrigatorios () {
		if(txtUsuario.getText().isEmpty() || txtEmail.getText().isEmpty() || txtDataNascimento.getText().isEmpty()
		|| txtCPF.getText().isEmpty() || txtLogin.getText().isEmpty() || pwdSenha.getPassword().equals(null)) {
			return false;
		}else {
			return true;
		}
	}
}
