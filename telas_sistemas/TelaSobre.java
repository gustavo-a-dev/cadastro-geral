package telas_sistemas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import javax.swing.JDesktopPane;
import javax.swing.ImageIcon;

public class TelaSobre extends JFrame {

	private JPanel telaSobre;

	/**
	 * CRIAÇÃO DA TELA
	 */
	public TelaSobre() {
		setResizable(false);
		setTitle("Sobre");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 517, 341);
		telaSobre = new JPanel();
		telaSobre.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(telaSobre);
		telaSobre.setLayout(null);
		
		JLabel lblNome = new JLabel("Controle de Ordem de Serviços");
		lblNome.setForeground(Color.BLACK);
		lblNome.setFont(new Font("Bitstream Vera Sans", Font.BOLD, 12));
		lblNome.setBounds(12, 12, 300, 27);
		telaSobre.add(lblNome);
		
		JLabel lblDesenvolvimento = new JLabel("Desenvolvido por Gustavo Marquesani da Costa");
		lblDesenvolvimento.setForeground(Color.BLACK);
		lblDesenvolvimento.setFont(new Font("Bitstream Vera Sans", Font.BOLD, 12));
		lblDesenvolvimento.setBounds(12, 59, 426, 27);
		telaSobre.add(lblDesenvolvimento);
		
		JLabel lblLincenca = new JLabel("Sob lincença de Bitway Sistemas e UNIFAL-MG");
		lblLincenca.setForeground(Color.BLACK);
		lblLincenca.setFont(new Font("Bitstream Vera Sans", Font.BOLD, 12));
		lblLincenca.setBounds(12, 98, 426, 27);
		telaSobre.add(lblLincenca);
		
		JLabel lblObjetivo = new JLabel("Projeto Desenvolvido para fins Acadêmicos.");
		lblObjetivo.setForeground(Color.BLACK);
		lblObjetivo.setFont(new Font("Bitstream Vera Sans", Font.BOLD, 12));
		lblObjetivo.setBounds(12, 272, 426, 27);
		telaSobre.add(lblObjetivo);
		
		JLabel lbLinux = new JLabel("Linux");
		lbLinux.setIcon(new ImageIcon("/home/gustavo/Desktop/Gnulinux.png"));
		lbLinux.setBounds(345, 120, 160, 184);
		telaSobre.add(lbLinux);
		
		JLabel lblProjeto = new JLabel("Projeto Desenvolvido em Java/PostgreSQL");
		lblProjeto.setForeground(Color.BLACK);
		lblProjeto.setFont(new Font("Bitstream Vera Sans", Font.BOLD, 12));
		lblProjeto.setBounds(12, 149, 426, 27);
		telaSobre.add(lblProjeto);
	}
}
