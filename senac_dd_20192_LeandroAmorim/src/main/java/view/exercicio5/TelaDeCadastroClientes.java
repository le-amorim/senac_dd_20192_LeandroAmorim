package view.exercicio5;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import controller.aula05.ClienteController;
import controller.aula05.EnderecoController;
import controller.aula05.TelefoneController;
import model.vo.aula5.Cliente;
import model.vo.aula5.Endereco;
import model.vo.aula5.Telefone;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;

public class TelaDeCadastroClientes extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtCodPais;
	private JTextField txtDDD;
	private JTextField txtNumero;
	private JTable tblTelefone;
	private JLabel lblNome;
	private JLabel lblSobrenome;
	private JLabel lblCpf;
	private JLabel lblEndereco;
	private JComboBox cbEndereco;
	private JButton btnSalvar;
	private JLabel lblAdicionarTelefone;
	private JLabel lblCodigo;
	private JComboBox cbTipo;
	private JFormattedTextField txtCPF;
	private Cliente novoCliente = null;
	private JButton btnAdicionarTelefone;
	private ArrayList<Telefone> telefonesDoNovoCliente;
	private ArrayList<Endereco> todosOsEnderecos;
	private String[] tipos = { TelefoneController.TIPO_TELEFONE_FIXO, TelefoneController.TIPO_TELEFONE_MOVEL,
			TelefoneController.SELECIONE_UM_TIPO };
	private String[] colunasTabelaTelefones = { "CódPais", "DDD", "Número", "Tipo" };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDeCadastroClientes frame = new TelaDeCadastroClientes();
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
	public TelaDeCadastroClientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 484);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 35, 46, 14);
		contentPane.add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(49, 32, 86, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setBounds(159, 35, 80, 14);
		contentPane.add(lblSobrenome);

		txtSobrenome = new JTextField();
		txtSobrenome.setBounds(235, 32, 100, 20);
		contentPane.add(txtSobrenome);
		txtSobrenome.setColumns(10);

		lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(396, 35, 29, 14);
		contentPane.add(lblCpf);

		MaskFormatter mascaraCpf;
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
			txtCPF = new JFormattedTextField(mascaraCpf);
		} catch (ParseException e) {
		}
		txtCPF.setBounds(430, 32, 100, 20);
		contentPane.add(txtCPF);
		txtCPF.setColumns(10);

		lblEndereco = new JLabel("Endereco");
		lblEndereco.setBounds(10, 74, 66, 25);
		contentPane.add(lblEndereco);

		consultarEnderecos();
		cbEndereco = new JComboBox(todosOsEnderecos.toArray());
		cbEndereco.setToolTipText("");
		cbEndereco.setBounds(69, 75, 440, 23);
		cbEndereco.setSelectedIndex(-1);
		contentPane.add(cbEndereco);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 145, 520, 2);
		contentPane.add(separator);

		tblTelefone = new JTable();
		tblTelefone.setBorder(new LineBorder(new Color(0, 0, 0)));
		tblTelefone.setBounds(20, 265, 490, 175);
		tblTelefone.setModel(new DefaultTableModel(new Object[][] { colunasTabelaTelefones, }, colunasTabelaTelefones));
		contentPane.add(tblTelefone);

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				ClienteController clienteControladora = new ClienteController();
				String nomeDigitado = txtNome.getText();
				String sobrenomeDigitado = txtSobrenome.getText();
				String cpfDigitado = txtCPF.getText().replace("-", "").replace(".", "");
				Endereco enderecoSelecionado = (Endereco) cbEndereco.getSelectedItem();

				String mensagem = clienteControladora.validarCamposSalvar(nomeDigitado, sobrenomeDigitado, cpfDigitado,
						enderecoSelecionado);

				if (mensagem.isEmpty()) {
					novoCliente = new Cliente(nomeDigitado, sobrenomeDigitado, cpfDigitado, new ArrayList<Telefone>(),
							enderecoSelecionado);
					novoCliente = clienteControladora.salvar(novoCliente);

					if (novoCliente.getId() > 0) {
						btnAdicionarTelefone.setEnabled(true);
						cbTipo.setEnabled(true);
						btnSalvar.setEnabled(false);
						limparCampo();
					}
				} else {
					JOptionPane.showMessageDialog(null, mensagem, "Atenção", JOptionPane.WARNING_MESSAGE);
				}
			}

			private void limparCampo() {
				txtNome.setText("");
				txtSobrenome.setText("");
				txtCPF.setText("");

			}
		});
		btnSalvar.setBounds(224, 111, 89, 23);
		contentPane.add(btnSalvar);

		lblAdicionarTelefone = new JLabel(
				"                                                                          Cadastrar Telefone");
		lblAdicionarTelefone.setOpaque(true);
		lblAdicionarTelefone.setBackground(SystemColor.textHighlight);
		lblAdicionarTelefone.setForeground(SystemColor.desktop);
		lblAdicionarTelefone.setBounds(0, 158, 540, 14);
		contentPane.add(lblAdicionarTelefone);

		lblCodigo = new JLabel("Código País:");
		lblCodigo.setBounds(10, 193, 72, 14);
		contentPane.add(lblCodigo);

		txtCodPais = new JTextField();
		txtCodPais.setBounds(75, 190, 29, 20);
		contentPane.add(txtCodPais);
		txtCodPais.setColumns(10);

		JLabel lblDdd = new JLabel("DDD:");
		lblDdd.setBounds(114, 193, 29, 14);
		contentPane.add(lblDdd);

		txtDDD = new JTextField();
		txtDDD.setColumns(10);
		txtDDD.setBounds(140, 190, 29, 20);
		contentPane.add(txtDDD);

		JLabel lblNumero = new JLabel("Número");
		lblNumero.setBounds(179, 193, 46, 14);
		contentPane.add(lblNumero);

		cbTipo = new JComboBox(tipos);
		cbTipo.setEnabled(false);
		cbTipo.setSelectedIndex(2);
		cbTipo.setBounds(347, 190, 162, 20);
		contentPane.add(cbTipo);

		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(224, 190, 86, 20);
		contentPane.add(txtNumero);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(320, 193, 46, 14);
		contentPane.add(lblTipo);

		btnAdicionarTelefone = new JButton("AdicionarTelefone");
		btnAdicionarTelefone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelefoneController telController = new TelefoneController();

				String codigoDigitado = txtCodPais.getText();
				String dddDigitado = txtDDD.getText();
				String numeroDigitado = txtNumero.getText();
				String tipoSelecionado = cbTipo.getSelectedItem().toString();
				boolean ativo = true;
				String mensagem = telController.validarCamposTelefone(codigoDigitado, dddDigitado, numeroDigitado,
						tipoSelecionado);

				if (mensagem.isEmpty()) {
					Telefone novoTelefone = new Telefone(novoCliente, codigoDigitado, dddDigitado, numeroDigitado,
							tipoSelecionado, ativo);
					JOptionPane.showMessageDialog(null, "Telefone adicionado com Sucesso");
					mensagem = telController.salvarTelefone(novoTelefone);

					if (mensagem.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Telefone Adicionado com Sucesso");
						limparCampoTelefone();
					} else {
						JOptionPane.showMessageDialog(null, mensagem);
					}

					atualizarTabelaTelefonesDoCliente();
				}else {
					JOptionPane.showMessageDialog(null, mensagem);
				}

			}
		});
		btnAdicionarTelefone.setEnabled(false);
		btnAdicionarTelefone.setBounds(200, 231, 142, 23);
		contentPane.add(btnAdicionarTelefone);

		JLabel lblCadastrarCliente = new JLabel(
				"                                                                          Cadastrar Cliente");
		lblCadastrarCliente.setOpaque(true);
		lblCadastrarCliente.setForeground(Color.BLACK);
		lblCadastrarCliente.setBackground(SystemColor.textHighlight);
		lblCadastrarCliente.setBounds(0, 11, 540, 14);
		contentPane.add(lblCadastrarCliente);
	}

	protected void atualizarTabelaTelefonesDoCliente() {
		// consultar a lista de telefones do cliente
		TelefoneController telController = new TelefoneController();

		if (novoCliente != null && novoCliente.getId() > 0) {
			telefonesDoNovoCliente = telController.consultarTelefonesDoCliente(novoCliente.getId());
		}
		limparTabela();
		limparCampoTelefone();
		// atualizar a tabela (JTable) de telefones
		DefaultTableModel model = (DefaultTableModel) tblTelefone.getModel();
		for (Telefone telefone : telefonesDoNovoCliente) {
			String[] novaLinha = new String[4];
			novaLinha[0] = telefone.getCodigoPais();
			novaLinha[1] = telefone.getDdd();
			novaLinha[2] = telefone.getNumero();
			novaLinha[3] = telefone.getTipoLinha();
			model.addRow(novaLinha);
		}
	}

	private void limparTabela() {
		tblTelefone.setModel(new DefaultTableModel(new Object[][] { colunasTabelaTelefones, }, colunasTabelaTelefones));
	}

	protected void limparCampoTelefone() {
		txtCodPais.setText("");
		txtDDD.setText("");
		txtNumero.setText("");
		cbTipo.setSelectedItem(2);

	}

	private void consultarEnderecos() {
		EnderecoController endController = new EnderecoController();
		todosOsEnderecos = endController.consultarTodos();

	}
}
