package telas_sistemas;

import java.awt.Rectangle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

import classes_de_conexao.Conexao;

import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import net.proteanit.sql.DbUtils;
import javax.swing.JScrollPane;

public class TelaClientes extends JInternalFrame {

	Connection conexao = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private JTextField txtTelClientes;
	private JTextField txtCNPJFiltro;
	private JTextField nomeClientes;
	private JTextField txtendereco;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtDataEmissao;
	private JTextField txtCnpj;
	private JTextField txtEmail;
	private JTextField txtCelular;
	private JTextField txtEstado;
	private JTable tabelaClientes;
	private JComboBox comboBoxTipo;
	private JButton create;


	@SuppressWarnings("unchecked")
	public TelaClientes() throws SQLException{
		
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
		setTitle("Clientes");
		setNormalBounds(new Rectangle(0, 0, 621, 523));
		setBounds(0, 0, 621, 523);
		
		JDesktopPane desktopPane = new JDesktopPane();
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		/**
		 * PESQUISAR POR TELEFONE
		 */
		
		JLabel lblPesquisarTelefone = new JLabel("Pesquisar Telefone: ");
		lblPesquisarTelefone.setBounds(12, 84, 155, 15);
		desktopPane.add(lblPesquisarTelefone);
		
		txtTelClientes = new JTextField();
		txtTelClientes.setBounds(12, 119, 155, 24);
		desktopPane.add(txtTelClientes);
		txtTelClientes.setColumns(10);
		
		/**
		 * CNPJ DO CLIENTE
		 */
		
		JLabel lblPesquisarCnpj = new JLabel("Pesquisar CNPJ do Cliente:");
		lblPesquisarCnpj.setBounds(284, 84, 211, 15);
		desktopPane.add(lblPesquisarCnpj);
		
		txtCNPJFiltro = new JTextField();
		txtCNPJFiltro.setColumns(10);
		txtCNPJFiltro.setBounds(284, 119, 247, 24);
		desktopPane.add(txtCNPJFiltro);
		
		/**
		 * MONTANDO A TABELA QUE EXIBIRÁ PARA O USUARIO OS CLIENTES
		 */
		
		JLabel lblcamposObrigatrios = new JLabel("*Campos Obrigatórios");
		lblcamposObrigatrios.setBounds(338, 155, 184, 15);
		desktopPane.add(lblcamposObrigatrios);
		
		/**
		 * NOME
		 */
		
		JLabel lblNome = new JLabel("Nome*");
		lblNome.setBounds(12, 195, 70, 15);
		desktopPane.add(lblNome);
		
		nomeClientes = new JTextField();
		nomeClientes.setBounds(68, 193, 280, 19);
		desktopPane.add(nomeClientes);
		nomeClientes.setColumns(10);
		
		/**
		 * ENDEREÇO
		 */
		
		JLabel lblEndereo = new JLabel("Endereço:");
		lblEndereo.setBounds(12, 222, 84, 15);
		desktopPane.add(lblEndereo);
		
		txtendereco = new JTextField();
		txtendereco.setBounds(92, 220, 334, 19);
		desktopPane.add(txtendereco);
		txtendereco.setColumns(10);
		
		/**
		 * BAIRRO
		 */
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(12, 280, 70, 15);
		desktopPane.add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(69, 278, 199, 19);
		desktopPane.add(txtBairro);
		txtBairro.setColumns(10);
		
		/**
		 * CIDADE
		 */
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(12, 253, 70, 15);
		desktopPane.add(lblCidade);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(81, 249, 174, 19);
		desktopPane.add(txtCidade);
		txtCidade.setColumns(10);
		
		JLabel lblDataEmissao = new JLabel("Data de Emissão*");
		lblDataEmissao.setBounds(376, 195, 155, 15);
		desktopPane.add(lblDataEmissao);
		
		txtDataEmissao = new JTextField();
		txtDataEmissao.setBounds(515, 193, 84, 19);
		desktopPane.add(txtDataEmissao);
		txtDataEmissao.setColumns(10);
		
		/**
		 * RG
		 */
		
		JLabel lblCnpj = new JLabel("CNPJ*");
		lblCnpj.setBounds(12, 168, 70, 15);
		desktopPane.add(lblCnpj);
		
		txtCnpj = new JTextField();
		txtCnpj.setBounds(68, 164, 174, 19);
		desktopPane.add(txtCnpj);
		txtCnpj.setColumns(10);
		
		/**
		 * EMAIL
		 */
		
		JLabel lblEmail = new JLabel("E-mail*");
		lblEmail.setBounds(316, 280, 70, 15);
		desktopPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(376, 278, 223, 19);
		desktopPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		/**
		 * CELULAR
		 */
		
		JLabel lblCelular = new JLabel("Celular*");
		lblCelular.setBounds(316, 249, 70, 15);
		desktopPane.add(lblCelular);
		
		txtCelular = new JTextField();
		txtCelular.setBounds(391, 251, 159, 19);
		desktopPane.add(txtCelular);
		txtCelular.setColumns(10);
		
		/**
		 * ESTADO
		 */
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(444, 222, 70, 15);
		desktopPane.add(lblEstado);
		
		txtEstado = new JTextField();
		txtEstado.setBounds(503, 220, 47, 19);
		desktopPane.add(txtEstado);
		txtEstado.setColumns(10);
		
		
		JLabel lblRamoAtividade = new JLabel("Atividade*");
		lblRamoAtividade.setBounds(316, 307, 91, 15);
		desktopPane.add(lblRamoAtividade);
		
		
		/**
		 * COMBO BOX PARA DECIDIR SE A PESSOA É FISICA OU JURIDICA
		 */
		
		
		comboBoxTipo = new JComboBox();
		comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] {"<Selecione uma opção>", "JDE", "Java"}));
		comboBoxTipo.setBounds(316, 329, 192, 24);
		desktopPane.add(comboBoxTipo);
		
			
		
		/**
		 * CREATE BUTTOM
		 */
		
		create = new JButton(" ");
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adicionar();
			}
		});
		create.setIcon(new ImageIcon("/home/gustavo/Downloads/3209288-64.png"));
		create.setBounds(25, 394, 117, 85);
		desktopPane.add(create);
		
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
		update.setBounds(244, 394, 117, 85);
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
		delete.setBounds(454, 394, 117, 85);
		desktopPane.add(delete);
		
		/**
		 * PESQUISAR POR TELEFONE
		 */
		
		JButton pesquisaCel = new JButton("");
		pesquisaCel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pesquisarTelefone();
			}
		});
		pesquisaCel.setForeground(Color.WHITE);
		pesquisaCel.setBackground(Color.LIGHT_GRAY);
		pesquisaCel.setIcon(new ImageIcon("/home/gustavo/Downloads/3403727-48.png"));
		pesquisaCel.setBounds(179, 101, 61, 42);
		desktopPane.add(pesquisaCel);
		
		/**
		 * PESQUISAR POR NOME
		 */
		
		JButton pesquisaCnpj = new JButton("");
		pesquisaCnpj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pesquisarCpnj();
			}
		});
		pesquisaCnpj.setIcon(new ImageIcon("/home/gustavo/Downloads/2203508-32.png"));
		pesquisaCnpj.setForeground(Color.WHITE);
		pesquisaCnpj.setBackground(Color.LIGHT_GRAY);
		pesquisaCnpj.setBounds(538, 101, 61, 42);
		desktopPane.add(pesquisaCnpj);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 611, 68);
		desktopPane.add(scrollPane);
		
		tabelaClientes = new JTable();
		scrollPane.setViewportView(tabelaClientes);
		tabelaClientes.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Nome Cliente", "Data Emissão", "Email", "Celular", "Atividade", "CNPJ", "Endereço", "Bairro", "Cidade", "Estado"
			}
		));
		tabelaClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int setar = tabelaClientes.getSelectedRow();
				
				nomeClientes.setText(tabelaClientes.getModel().getValueAt(setar, 0).toString());
				txtDataEmissao.setText(tabelaClientes.getModel().getValueAt(setar, 1).toString());
				txtEmail.setText(tabelaClientes.getModel().getValueAt(setar, 2).toString());
				txtCelular.setText(tabelaClientes.getModel().getValueAt(setar, 3).toString());
				comboBoxTipo.setSelectedItem(tabelaClientes.getModel().getValueAt(setar, 4).toString());
				txtCnpj.setText(tabelaClientes.getModel().getValueAt(setar, 5).toString());
				txtendereco.setText(tabelaClientes.getModel().getValueAt(setar, 6).toString());
				txtBairro.setText(tabelaClientes.getModel().getValueAt(setar, 7).toString());
				txtCidade.setText(tabelaClientes.getModel().getValueAt(setar, 8).toString());
				txtEstado.setText(tabelaClientes.getModel().getValueAt(setar, 9).toString());
				
				/**
				 * DESABILITAR O BUTÃO ADICIONAR PARA EVITAR DUPLICIDADE
				 */
				
				create.setEnabled(false);
			}
		});
		tabelaClientes.setBackground(Color.LIGHT_GRAY);
		tabelaClientes.setCellSelectionEnabled(true);
		tabelaClientes.setColumnSelectionAllowed(true);
	}
	
	private void adicionar() {
		String sqlCommand = "INSERT INTO aps.clientes (nomecliente,dataemissao,email,celular,atividade,cnpj,endereco,bairro,cidade,estado) VALUES (?,?,?,?,?,?,?,?,?,?);";
			try {
				pst = conexao.prepareStatement(sqlCommand);
				
				/**
				 * MONTANDO OS CAMPOS PARA O INSERT
				 */
				
				pst.setString(1, nomeClientes.getText());
				pst.setString(2, txtDataEmissao.getText());
				pst.setString(3, txtEmail.getText());
				pst.setString(4, txtCelular.getText());
				pst.setString(5, comboBoxTipo.getSelectedItem().toString());
				pst.setString(6, txtCnpj.getText());
				pst.setString(7, txtendereco.getText());
				pst.setString(8, txtBairro.getText());
				pst.setString(9, txtCidade.getText());
				pst.setString(10, txtEstado.getText());
				
				/**
				 * VERIFICAÇÃO DE CAMPOS OBRIGATÓRIOS
				 */
				
				if (verificacaoCamposObrigatorios()) {
					int adicionar = pst.executeUpdate();
					
					if(adicionar > 0) {
						JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso!");
						
						/**
						 * ZERAR OS CAMPOS APÓS O INSERT
						 */
						
						nomeClientes.setText(null);
						txtDataEmissao.setText(null);
						txtEmail.setText(null);
						txtCelular.setText(null);
						comboBoxTipo.setSelectedItem(null);
						txtCnpj.setText(null);
						txtendereco.setText(null);
						txtBairro.setText(null);
						txtCidade.setText(null);
						txtEstado.setText(null);
					}					
				} else {
					JOptionPane.showMessageDialog(null, "Preencha Todos os Campos Obrigatórios(*)");
				}				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
			tabelaClientes.setVisible(false);
	}
	
	private void pesquisarTelefone() {
		String sqlCommand = "SELECT * FROM aps.clientes where celular like ?";
			try {
				pst = conexao.prepareStatement(sqlCommand);
				
				/**
				 * MONTANDO A QUERY PARA O SELECT 
				 */
				
				pst.setString(1, txtTelClientes.getText() + "%");
				rs = pst.executeQuery();
				
				/**
				 * POPULANDO A TABELA QUE EXISTE NA QUERY
				 */
				
				tabelaClientes.setModel(DbUtils.resultSetToTableModel(rs));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
			tabelaClientes.setVisible(true);
	}
	
	private void pesquisarCpnj() {
		String sqlCommand = "SELECT * FROM aps.clientes where cnpj like ?";
		try {
			pst = conexao.prepareStatement(sqlCommand);
			
			/**
			 * MONTANDO A QUERY PARA O SELECT 
			 */
			
			pst.setString(1, txtCNPJFiltro.getText() + "%");
			rs = pst.executeQuery();
			
			/**
			 * POPULANDO A TABELA QUE EXISTE NA QUERY
			 */
			
			tabelaClientes.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
		tabelaClientes.setVisible(true);
	}
	
	private void alterar() {
		String sqlCommand = "UPDATE aps.clientes SET nomecliente=?,dataemissao=?,email=?,celular=?,atividade=?,endereco=?,bairro=?,cidade=?,estado=? WHERE cnpj=?;";
			try {
				pst = conexao.prepareStatement(sqlCommand);
				
				/**
				 * MONTANDO A QUERY PARA O UPDATE 
				 */
				pst.setString(1, nomeClientes.getText());
				pst.setString(2, txtDataEmissao.getText());
				pst.setString(3, txtEmail.getText());
				pst.setString(4, txtCelular.getText());
				pst.setString(5, comboBoxTipo.getSelectedItem().toString());
				pst.setString(6, txtendereco.getText());
				pst.setString(7, txtBairro.getText());
				pst.setString(8, txtCidade.getText());
				pst.setString(9, txtEstado.getText());
				pst.setString(10, txtCnpj.getText());
				
				/**
				 * VERIFICAÇÃO DE CAMPOS OBRIGATÓRIOS
				 */
				
				if (verificacaoCamposObrigatorios()) {
					int atualizado = pst.executeUpdate();
					
					if(atualizado > 0) {
						JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");
						
						/**
						 * ZERAR OS CAMPOS APÓS O UPDATE
						 */
						
						nomeClientes.setText(null);
						txtDataEmissao.setText(null);
						txtEmail.setText(null);
						txtCelular.setText(null);
						comboBoxTipo.setSelectedItem(null);
						txtCnpj.setText(null);
						txtendereco.setText(null);
						txtBairro.setText(null);
						txtCidade.setText(null);
						txtEstado.setText(null);
						
						create.setEnabled(true);
					}					
				} else {
					JOptionPane.showMessageDialog(null, "Preencha Todos os Campos Obrigatórios(*)");
				}				
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
	}
	
	private void deletar() {
		
		/**
		 * LOGICA CONTRA USUARIO BURRO
		 */
		
		int confirmacaoDelecao = JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja remover este cliente?", "Atenção!", JOptionPane.YES_NO_OPTION);
		
		if(confirmacaoDelecao == JOptionPane.YES_OPTION) {
			String sqlCommand = "DELETE FROM aps.clientes WHERE cnpj = ?";
				try {
					pst = conexao.prepareStatement(sqlCommand);
					
					pst.setString(1, txtCnpj.getText());
					
					int apagar = pst.executeUpdate();
					if (apagar > 0) {
						JOptionPane.showMessageDialog(null, "Cliente removido com sucesso!");
						
						/**
						 * ZERAR OS CAMPOS APÓS O DELETE
						 */
						
						nomeClientes.setText(null);
						txtDataEmissao.setText(null);
						txtEmail.setText(null);
						txtCelular.setText(null);
						comboBoxTipo.setSelectedItem(null);
						txtCnpj.setText(null);
						txtendereco.setText(null);
						txtBairro.setText(null);
						txtCidade.setText(null);
						txtEstado.setText(null);
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
		}
	}
	
	private boolean verificacaoCamposObrigatorios() {
		if(nomeClientes.getText().isEmpty() || txtDataEmissao.getText().isEmpty() || txtCnpj.getText().isEmpty() || txtCelular.getText().isEmpty() || txtEmail.getText().isEmpty()) {
			return false;
		} else {
			return true;
		}	
	}
}
