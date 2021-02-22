package telas_sistemas;

import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

import classes_de_conexao.Conexao;
import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;


public class TelaOS extends JInternalFrame {
	
	private Connection conexao = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	private String os;
	private JRadioButton rdbtnOrdemServico;
	private JRadioButton rdbtnOrcamento;
	private JButton btnPesquisarOS;
	private JButton pesquisaCnpj;
	private JButton create;
	private String tipo;
	private JTextField txtNumeroOS;
	private JTextField txtData;
	private JTable table;
	private JComboBox comboBox;
	private JTextField txtCnpj;
	private JTextField textEquipamento;
	private JTextField textDefeito;
	private JTextField textServico;
	private JTextField textTecnico;
	private JTextField textValorTotal;
	private JTextField textCliente;
	
	public TelaOS() throws SQLException{
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent e) {
				rdbtnOrcamento.setSelected(true);
				tipo = "Orçamento"; 
			}
		});
		
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
		setTitle("Ordem de Serviços");
		setNormalBounds(new Rectangle(0, 0, 621, 523));
		setBounds(0, 0, 621, 523);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Entrega OK", "Orçamento REPROVADO", "Aguardando Aprovação", "Aguardando peças", "Abandonado pelo cliente", "Na bancada", "Retornou"}));
		comboBox.setBounds(91, 164, 197, 24);
		desktopPane.add(comboBox);
		
		JLabel lblSituao = new JLabel("Situação: ");
		lblSituao.setBounds(10, 169, 87, 15);
		desktopPane.add(lblSituao);
		
		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBounds(0, 0, 330, 203);
		desktopPane.add(desktopPane_1);
		desktopPane_1.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblNumeroOS = new JLabel("Nº OS:");
		lblNumeroOS.setBounds(12, 12, 70, 15);
		desktopPane_1.add(lblNumeroOS);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(175, 12, 70, 15);
		desktopPane_1.add(lblData);
		
		txtNumeroOS = new JTextField();
		txtNumeroOS.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumeroOS.setEditable(false);
		txtNumeroOS.setBounds(12, 45, 114, 19);
		desktopPane_1.add(txtNumeroOS);
		txtNumeroOS.setColumns(10);
		
		txtData = new JTextField();
		txtData.setEditable(false);
		txtData.setBounds(175, 45, 114, 19);
		desktopPane_1.add(txtData);
		txtData.setColumns(10);
		
		rdbtnOrcamento = new JRadioButton("Orçamento");
		rdbtnOrcamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tipo = "Orçamento";
			}
		});
		rdbtnOrcamento.setBounds(8, 101, 126, 23);
		desktopPane_1.add(rdbtnOrcamento);
		
		rdbtnOrdemServico = new JRadioButton("Ordem de Serviço");
		rdbtnOrdemServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tipo = "Ordem de Serviço";
			}
		});
		rdbtnOrdemServico.setBounds(175, 101, 158, 23);
		desktopPane_1.add(rdbtnOrdemServico);
		
		btnPesquisarOS = new JButton("");
		btnPesquisarOS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pesquisar_os();
			}
		});
		btnPesquisarOS.setEnabled(false);
		btnPesquisarOS.setIcon(new ImageIcon("/home/gustavo/Downloads/510861-32.png"));
		btnPesquisarOS.setBackground(Color.WHITE);
		btnPesquisarOS.setBounds(78, 8, 58, 25);
		desktopPane_1.add(btnPesquisarOS);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 0, 333, 207);
		desktopPane_1.add(scrollPane_2);
		
		JDesktopPane desktopPane_2 = new JDesktopPane();
		desktopPane_2.setBounds(331, 0, 280, 203);
		desktopPane.add(desktopPane_2);
		desktopPane_2.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblCNPJCliente = new JLabel("CNPJ do Cliente");
		lblCNPJCliente.setBounds(12, 124, 114, 15);
		desktopPane_2.add(lblCNPJCliente);
		
		txtCnpj = new JTextField();
		txtCnpj.setBounds(12, 156, 167, 19);
		desktopPane_2.add(txtCnpj);
		txtCnpj.setColumns(10);
		
		pesquisaCnpj = new JButton("");
		pesquisaCnpj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pesquisarCpnj();
			}
		});
		pesquisaCnpj.setForeground(Color.WHITE);
		pesquisaCnpj.setBackground(Color.LIGHT_GRAY);
		pesquisaCnpj.setIcon(new ImageIcon("/home/gustavo/Downloads/2203508-32.png"));
		pesquisaCnpj.setBounds(207, 112, 61, 42);
		desktopPane_2.add(pesquisaCnpj);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 293, 203);
		desktopPane_2.add(scrollPane_1);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int setar = table.getSelectedRow();
				
				textCliente.setText(table.getModel().getValueAt(setar, 0).toString());
			}
		});
		scrollPane_1.setViewportView(table);
		table.setBackground(Color.LIGHT_GRAY);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Nome cliente", "CNPJ", "Atvidade", "Telefone"
			}
		));
		
		JDesktopPane desktopPane_3 = new JDesktopPane();
		desktopPane_3.setBounds(0, 200, 611, 291);
		desktopPane.add(desktopPane_3);
		
		JLabel lblEquipamento = new JLabel("Equipamento*");
		lblEquipamento.setBounds(28, 57, 108, 15);
		desktopPane_3.add(lblEquipamento);
		
		JLabel lblDefeito = new JLabel("Defeito");
		lblDefeito.setBounds(66, 94, 70, 15);
		desktopPane_3.add(lblDefeito);
		
		JLabel lblServicos = new JLabel("Serviço");
		lblServicos.setBounds(66, 124, 70, 15);
		desktopPane_3.add(lblServicos);
		
		JLabel lblTecnico = new JLabel("Técnico");
		lblTecnico.setBounds(66, 155, 70, 15);
		desktopPane_3.add(lblTecnico);
		
		textEquipamento = new JTextField();
		textEquipamento.setBounds(154, 55, 424, 19);
		desktopPane_3.add(textEquipamento);
		textEquipamento.setColumns(10);
		
		textDefeito = new JTextField();
		textDefeito.setColumns(10);
		textDefeito.setBounds(154, 92, 424, 19);
		desktopPane_3.add(textDefeito);
		
		textServico = new JTextField();
		textServico.setColumns(10);
		textServico.setBounds(154, 122, 424, 19);
		desktopPane_3.add(textServico);
		
		textTecnico = new JTextField();
		textTecnico.setBounds(152, 153, 157, 19);
		desktopPane_3.add(textTecnico);
		textTecnico.setColumns(10);
		
		JLabel lblValorTotal = new JLabel("Valor Total:");
		lblValorTotal.setBounds(369, 155, 99, 15);
		desktopPane_3.add(lblValorTotal);
		
		textValorTotal = new JTextField();
		textValorTotal.setBounds(464, 153, 114, 19);
		desktopPane_3.add(textValorTotal);
		textValorTotal.setColumns(10);
		
		create = new JButton(" ");
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				emitirOS();
			}
		});
		create.setIcon(new ImageIcon("/home/gustavo/Downloads/1904677-48.png"));
		create.setBounds(12, 194, 117, 85);
		desktopPane_3.add(create);
		
		JButton update = new JButton(" ");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atualizar_os();
			}
		});
		update.setIcon(new ImageIcon("/home/gustavo/Downloads/172618-48.png"));
		update.setBounds(162, 194, 117, 85);
		desktopPane_3.add(update);
		
		JButton delete = new JButton(" ");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deletar_os();
			}
		});
		delete.setIcon(new ImageIcon("/home/gustavo/Downloads/4115238-48.png"));
		delete.setBounds(315, 194, 117, 85);
		desktopPane_3.add(delete);
		
		JButton print = new JButton(" ");
		print.setIcon(new ImageIcon("/home/gustavo/Downloads/172530-48.png"));
		print.setBounds(461, 194, 117, 85);
		desktopPane_3.add(print);
		
		JLabel lblNomeDoCliente = new JLabel("Nome do Cliente*");
		lblNomeDoCliente.setBounds(12, 23, 124, 15);
		desktopPane_3.add(lblNomeDoCliente);
		
		textCliente = new JTextField();
		textCliente.setEditable(false);
		textCliente.setColumns(10);
		textCliente.setBounds(154, 21, 424, 19);
		desktopPane_3.add(textCliente);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 611, 291);
		desktopPane_3.add(scrollPane);
		
		formWindowActivated(null);
		
	}
	
	private void pesquisarCpnj() {
		String sqlCommand = "SELECT nomecliente, cnpj, atividade, celular FROM aps.clientes where cnpj like ?";
		try {
			pst = conexao.prepareStatement(sqlCommand);
			
			/**
			 * MONTANDO A QUERY PARA O SELECT 
			 */
			
			pst.setString(1, txtCnpj.getText() + "%");
			rs = pst.executeQuery();
			
			/**
			 * POPULANDO A TABELA QUE EXISTE NA QUERY
			 */
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
		btnPesquisarOS.setEnabled(true);
		table.setVisible(true);
	}
	
	private void emitirOS() {
		String sqlCommand = "insert into aps.ordemservico (dataos,tipo, situacao, equipamento, defeito, servico, tecnico, valor, nomecliente) values (?,?,?,?,?,?,?,?,?)";
		
		try {
			pst = conexao.prepareStatement(sqlCommand);
			
			pst.setString(1, txtData.getText());
			pst.setString(2, tipo);
			pst.setString(3, comboBox.getSelectedItem().toString());
			pst.setString(4, textEquipamento.getText());
			pst.setString(5, textDefeito.getText());
			pst.setString(6, textServico.getText());
			pst.setString(7, textTecnico.getText());
			pst.setString(8, textValorTotal.getText());
			pst.setString(9, textCliente.getText());
			
			/**
			 * VERIFICAÇÃO DE CAMPOS OBRIGATÓRIOS
			 */
			
			if (verificacaoCamposObrigatorios()) {

				int adicionar = pst.executeUpdate();
				
				if(adicionar > 0) {					
					JOptionPane.showMessageDialog(null, "Ordem de Serviço adicionada com sucesso!");
					
					/**
					 * ZERAR OS CAMPOS APÓS O INSERT
					 */
					
					comboBox.setSelectedItem(null);
					textEquipamento.setText(null);
					textDefeito.setText(null);
					textServico.setText(null);
					textTecnico.setText(null);
					textValorTotal.setText(null);
					textCliente.setText(null);
				}					
			} else {
				JOptionPane.showMessageDialog(null, "Preencha Todos os Campos Obrigatórios(*)");
			}				
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}	
	}
	
	private void atualizar_os() {
		String sqlCommand = "update aps.ordemservico set dataos=?,tipo=?, situacao=?, equipamento=?, defeito=?, servico=?, tecnico=?, valor=? where os= " + os;
			try {
				pst = conexao.prepareStatement(sqlCommand);
				
				pst.setString(1, txtData.getText());
				pst.setString(2, tipo);
				pst.setString(3, comboBox.getSelectedItem().toString());
				pst.setString(4, textEquipamento.getText());
				pst.setString(5, textDefeito.getText());
				pst.setString(6, textServico.getText());
				pst.setString(7, textTecnico.getText());
				pst.setString(8, textValorTotal.getText());
				
				//pst.setString(9, txtNumeroOS.getText());
				
				/**
				 * VERIFICAÇÃO DE CAMPOS OBRIGATÓRIOS
				 */
				
				if (verificacaoCamposObrigatorios()) {
					int atualizar = pst.executeUpdate();
					
					if(atualizar > 0) {
						JOptionPane.showMessageDialog(null, "Ordem de Serviço atualizada com sucesso!");
						
						/**
						 * ZERAR OS CAMPOS APÓS O UPDATE
						 */
						
						txtNumeroOS.setText(null);
						txtData.setText(null);
						textCliente.setText(null);
						comboBox.setSelectedItem(null);
						textEquipamento.setText(null);
						textDefeito.setText(null);
						textServico.setText(null);
						textTecnico.setText(null);
						textValorTotal.setText(null);
						textCliente.setText(null);
						
						pesquisaCnpj.setEnabled(true);
						create.setEnabled(true);
						table.setEnabled(true);
					}					
				} else {
					JOptionPane.showMessageDialog(null, "Preencha Todos os Campos Obrigatórios(*)");
				}				
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
				System.out.println(e);
			}
	}
	
	private void deletar_os() {
		int confirmarDelecao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja apagar esta OS?", "Atenção!", JOptionPane.YES_NO_OPTION);
		
		if (confirmarDelecao == JOptionPane.YES_OPTION) {
			String sqlCommand = "DELETE FROM aps.ordemservico WHERE os= " + os;
			try {
				pst = conexao.prepareStatement(sqlCommand);
				
				//pst.setString(1, txtNumeroOS.getText());
				
				int apagar = pst.executeUpdate();
				if (apagar > 0) {
					JOptionPane.showMessageDialog(null, "Ordem de serviço removida com sucesso!");
					
					/**
					 * ZERAR OS CAMPOS APÓS O DELETE
					 */
					
					txtNumeroOS.setText(null);
					txtData.setText(null);
					textCliente.setText(null);
					tipo = null;
					comboBox.setSelectedItem(null);
					textEquipamento.setText(null);
					textDefeito.setText(null);
					textServico.setText(null);
					textTecnico.setText(null);
					textValorTotal.setText(null);
					textCliente.setText(null);
					
					pesquisaCnpj.setEnabled(true);
					create.setEnabled(true);
					table.setEnabled(true);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
				System.out.println(e);
			}
		}
	}
	
	private void pesquisar_os() {
		os = JOptionPane.showInputDialog("Numero da OS");
		
		String sqlCommand = "SELECT * FROM aps.ordemservico WHERE os= " + os;
			try {
				pst = conexao.prepareStatement(sqlCommand);
				
				rs = pst.executeQuery();
				if(rs.next()) {
					
					/**
					 * POPULAR A TELA 
					 */
					
					txtNumeroOS.setText(rs.getString(1));
					txtData.setText(rs.getString(2));
					String tipo = rs.getString(3);
					if (tipo.equals("Ordem de Serviço")) {
						rdbtnOrdemServico.setSelected(true);
						rdbtnOrcamento.setSelected(false);
					} else {
						rdbtnOrcamento.setSelected(true);
						rdbtnOrdemServico.setSelected(false);
					}
					comboBox.setSelectedItem(rs.getString(4));
					textEquipamento.setText(rs.getString(5));
					textDefeito.setText(rs.getString(6));
					textServico.setText(rs.getString(7));
					textTecnico.setText(rs.getString(8));
					textValorTotal.setText(rs.getString(9));
					
					pesquisaCnpj.setEnabled(false);
					create.setEnabled(false);
					table.setEnabled(false);
				} else {
					JOptionPane.showMessageDialog(null, "OS não cadastrada!");
					create.setEnabled(true);
					txtNumeroOS.setText(null);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
	}
	
	
	private boolean verificacaoCamposObrigatorios() {
		if(textCliente.getText().isEmpty() || textEquipamento.getText().isEmpty()) {
			return false;
		} else {
			return true;
		}	
	}
	
	private void formWindowActivated(java.awt.event.WindowEvent evt) {
		Date date = new Date();
		DateFormat format = DateFormat.getDateInstance(DateFormat.SHORT);
		txtData.setText(format.format(date));
	}
}
