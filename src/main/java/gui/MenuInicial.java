package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import Objetos.*;
import Colecoes.*;
import GerenciadorDeArquivos.ArquivosCSV;
import GerenciadorDeArquivos.ArquivosJson;

public class MenuInicial extends JFrame implements ActionListener {
    private ColecaoPortos colecaoPortos;
    private ColecaoNavio colecaoNavio;
    private ColecaoCarga colecaoCarga;
    private ColecaoTipoCarga colecaoTipoCarga;
    private ColecaoCliente colecaoCliente;
    private ColecaoDistancia colecaoDistancia;
    private ColecaoViagens colecaoViagens;

    private JButton cadastrarNavioButton;
    private JButton cadastrarCarga;
    private JButton naviosCadastradosButton;
    private JButton cadastrarPortoButton;
    private JButton portosCadastradosButton;
    private JButton cadastrarCliente;
    private JButton clientesCadastrados;
    private JButton cadastrarViagem;
    private JButton cadastrarTipo;
    private JButton alterarTipoCarga;
    private JButton cargasCadastradas;
    private JButton novoFrete;
    private ArquivosJson json;
    private JButton salvarSair;
    private JButton carregarDadosSalvos;
    private ArquivosCSV arquivosCSV;
    private JButton carregarDadosIniciais;

    public MenuInicial() {
        super("Menu Inicial");
        setLayout(null);
        this.setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        colecaoNavio = new ColecaoNavio();
        colecaoCliente = new ColecaoCliente();
        colecaoTipoCarga = new ColecaoTipoCarga();
        colecaoPortos = new ColecaoPortos();
        colecaoCarga = new ColecaoCarga();
        colecaoDistancia = new ColecaoDistancia();
        colecaoViagens = new ColecaoViagens();

        cadastrarNavioButton = new JButton("Cadastrar Navio");
        naviosCadastradosButton = new JButton("Navios Cadastrados");
        cadastrarPortoButton = new JButton("Cadastrar Porto");
        portosCadastradosButton = new JButton("Portos Cadastrados");
        cadastrarCliente = new JButton("Cadastrar Cliente");
        clientesCadastrados = new JButton("Clientes Cadastrados");
        cadastrarViagem = new JButton("Cadastrar Viagem");
        cadastrarTipo = new JButton("Cadastrar Tipo de Carga");
        cadastrarCarga = new JButton("Cadastrar Carga");
        alterarTipoCarga = new JButton("Alterar Situacao Carga");
        cargasCadastradas = new JButton("Cargas Cadastradas");
        salvarSair = new JButton("Salvar e Sair");
        carregarDadosSalvos = new JButton("Carregar Dados Salvos");
        carregarDadosIniciais = new JButton("Carregar Dados Iniciais");
        novoFrete = new JButton("novo Frete");

        int x = 10;
        int y = 10;
        int width = 180;
        int height = 30;

        cadastrarCarga.setBounds(x, y, width, height);
        cargasCadastradas.setBounds(x, y + 40, width, height);
        alterarTipoCarga.setBounds(x, y + 80, width, height);
        cadastrarViagem.setBounds(x, y + 120, width, height);
        cadastrarTipo.setBounds(x, y + 160, width, height);

        cadastrarCliente.setBounds(x + 210, y, width, height);
        clientesCadastrados.setBounds(x + 210, y + 40, width, height);
        cadastrarNavioButton.setBounds(x + 210, y + 80, width, height);
        naviosCadastradosButton.setBounds(x + 210, y + 120, width, height);
        cadastrarPortoButton.setBounds(x + 210, y + 160, width, height);
        portosCadastradosButton.setBounds(x + 210, y + 200, width, height);
        salvarSair.setBounds(x + 210, y + 240, width, height);
        carregarDadosSalvos.setBounds(x, y + 200, width, height);
        carregarDadosIniciais.setBounds(x, y + 240, width, height);
        novoFrete.setBounds(x + 250 + width, y, width, height);

        cargasCadastradas.addActionListener(this);
        alterarTipoCarga.addActionListener(this);
        cadastrarCarga.addActionListener(this);
        cadastrarViagem.addActionListener(this);
        cadastrarNavioButton.addActionListener(this);
        naviosCadastradosButton.addActionListener(this);
        cadastrarPortoButton.addActionListener(this);
        portosCadastradosButton.addActionListener(this);
        cadastrarCliente.addActionListener(this);
        clientesCadastrados.addActionListener(this);
        cadastrarTipo.addActionListener(this);
        salvarSair.addActionListener(this);
        carregarDadosSalvos.addActionListener(this);
        carregarDadosIniciais.addActionListener(this);
        novoFrete.addActionListener(this);
        this.add(cargasCadastradas);
        this.add(alterarTipoCarga);
        this.add(cadastrarCarga);
        this.add(cadastrarViagem);
        this.add(cadastrarTipo);
        this.add(cadastrarCliente);
        this.add(clientesCadastrados);
        this.add(cadastrarNavioButton);
        this.add(naviosCadastradosButton);
        this.add(cadastrarPortoButton);
        this.add(portosCadastradosButton);
        this.add(salvarSair);
        this.add(carregarDadosSalvos);
        this.add(carregarDadosIniciais);
        this.add(novoFrete);

        setVisible(true);
    }

    private void novoFrete() {
        while (true) {
            try {
                JTextField codigoBarra = new JTextField(10);

                Object[] message = {
                        "Codigo da Carga:", codigoBarra,
                };

                int option = JOptionPane.showOptionDialog(this, message, "Fretar Carga", JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE, null, null, null);

                if (option == JOptionPane.OK_OPTION) {
                    Carga cargaAlocar = colecaoCarga.getCargaCod(Integer.parseInt(codigoBarra.getText()));

                    if (cargaAlocar != null) {
                        if (cargaAlocar.getSituacao() == Situacao.LOCADO
                                || cargaAlocar.getSituacao() == Situacao.FINALIZADO) {
                            JOptionPane.showMessageDialog(this,
                                    "Carga indisponivel para ser Locada");
                        } else {
                            try {

                                Cliente cliente = colecaoCliente.procuraId(cargaAlocar.getCliente());
                                Distancia distancia = colecaoDistancia.procuraRota(cargaAlocar.getOrigem(),
                                        cargaAlocar.getDestino());
                                Porto porto = colecaoPortos.getPortoPorId(cargaAlocar.getDestino());
                                TipoCarga tipoCarga = colecaoTipoCarga.procurarNumeroCarga(cargaAlocar.getTipoCarga());
                                Navio navio = colecaoNavio.selecionaNavioIdeal(cargaAlocar, distancia);
                                Frete frete = new Frete(distancia, cargaAlocar, porto, navio, tipoCarga);
                                frete.calculaFrete();
                                double valorFrete = frete.getValorDoFrete();
                            } catch (Exception e) {

                            }

                        }

                    } else {
                        JOptionPane.showMessageDialog(this, "Carga Não Encontrada no Sistena!");
                        break;
                    }
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this,
                        "Entrada inválida. Por favor, insira um valor numérico válido para o ID.");
            }
        }
    }

    private void salvarESair() {
        try {
            JTextField arquivoTextField = new JTextField(10);
            Object[] message = {
                    "Nome do Arquivo:", arquivoTextField
            };
            int option = JOptionPane.showOptionDialog(
                    this,
                    message,
                    "Salvar e sair",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    null);
            String nomeDoArquivoEscolhidoPeloCliente = "A";// CASO DE BUG
            if (option == JOptionPane.OK_OPTION) {
                nomeDoArquivoEscolhidoPeloCliente = arquivoTextField.getText();
            }

            ArquivosJson json = new ArquivosJson(colecaoCarga, colecaoPortos, null, colecaoNavio, colecaoTipoCarga,
                    colecaoCliente, null, nomeDoArquivoEscolhidoPeloCliente);
            json.salvar();
            JOptionPane.showMessageDialog(this, "Dados Salvos com sucesso");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ERRO AO SALVAR");
        }
    }

    private void carregarDadosIniciais() {
        // Falta pegar entrada do usuario
        try {
            JTextField arquivoTextField = new JTextField(10);
            Object[] message = {
                    "Digite o Prefixo do arquivo:", arquivoTextField
            };
            int option = JOptionPane.showOptionDialog(
                    this,
                    message,
                    "Carregar Dados Iniciais",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    null);
            String nomeDoArquivoEscolhidoPeloCliente = "A";// CASO DE BUG
            if (option == JOptionPane.OK_OPTION) {
                nomeDoArquivoEscolhidoPeloCliente = arquivoTextField.getText();
            }
            ArquivosCSV csv = new ArquivosCSV(nomeDoArquivoEscolhidoPeloCliente);
            boolean confirmaSeLeu = csv.leArquivos();

            if (confirmaSeLeu) {
                this.colecaoCarga = csv.getColecaoCarga();
                this.colecaoCliente = csv.getColecaoClientes();
                this.colecaoNavio = csv.getColecaoNavios();
                this.colecaoTipoCarga = csv.getColecaoTipoCarga();
                this.colecaoPortos = csv.getColecaoPortos();
                this.colecaoDistancia = csv.getColecaoDistancias();
                this.colecaoViagens = csv.getColecaoViagens();
                JOptionPane.showMessageDialog(this, "Dados carregados com sucesso");
            } else {
                JOptionPane.showMessageDialog(this, "Dados NÃO carregados, tente novamente ");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ERRO AO SALVAR");
        }

    }

    private void carregarDadosSalvosDoSave() {
        try {
            JTextField arquivoTextField = new JTextField(10);
            Object[] message = {
                    "Nome do Arquivo:", arquivoTextField
            };
            int option = JOptionPane.showOptionDialog(
                    this,
                    message,
                    "Carregar dados Do Save",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    null);
            String nomeDoArquivoEscolhidoPeloCliente = "A";// CASO DE BUG
            if (option == JOptionPane.OK_OPTION) {
                nomeDoArquivoEscolhidoPeloCliente = arquivoTextField.getText();
            }
            ArquivosJson json = new ArquivosJson(nomeDoArquivoEscolhidoPeloCliente);
            boolean confirmaSeLeu = json.carregar();
            if (confirmaSeLeu) {
                this.colecaoCarga = json.getColecaoCarga();
                this.colecaoCliente = json.getColecaoCliente();
                this.colecaoNavio = json.getColecaoNavio();
                this.colecaoTipoCarga = json.getColecaoTipoCarga();
                this.colecaoPortos = json.getColecaoPorto();
                this.colecaoDistancia = json.getColecaoDistancia();
                this.colecaoViagens = json.getColecaoViagem();
                JOptionPane.showMessageDialog(this, "Dados carregados com sucesso");
            } else {
                JOptionPane.showMessageDialog(this, "Dados NÃO carregados, tente novamente ");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ERRO AO SALVAR");
        }
    }

    private void cadastrarCliente() {
        while (true) {
            try {
                JTextField codTextField = new JTextField(10);
                JTextField nomeTextField = new JTextField(10);
                JTextField emailTextField = new JTextField(10);

                Object[] message = {
                        "Código do cliente:", codTextField,
                        "Nome do cliente:", nomeTextField,
                        "Email do cliente:", emailTextField
                };

                int option = JOptionPane.showOptionDialog(
                        this,
                        message,
                        "Cadastrar Cliente",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        null,
                        null);

                if (option == JOptionPane.OK_OPTION) {
                    int codCliente = Integer.parseInt(codTextField.getText());
                    String nomeCliente = nomeTextField.getText();
                    String emailCliente = emailTextField.getText();

                    if (colecaoCliente.containsId(codCliente) || colecaoCliente.procuraEmail(emailCliente)) {
                        JOptionPane.showMessageDialog(this,
                                "Cliente com o mesmo código ou email já foi cadastrado. Por favor, verifique os dados inseridos.");
                        continue;
                    }
                    Cliente c = new Cliente(codCliente, nomeCliente, emailCliente);
                    colecaoCliente.addCliente(c);
                    JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso!");
                    break;
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this,
                        "Entrada inválida. Por favor, insira um valor numérico válido para o código do cliente.");
            }
        }
    }

    private void CodCarga() {
        while (true) {
            try {
                JTextField codCargaTextField = new JTextField(10);
                Object[] message = {
                        "Código da Carga:", codCargaTextField,
                };
                int option = JOptionPane.showOptionDialog(
                        this,
                        message,
                        "Trocar situacao Carga",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        null,
                        null);
                if (option == JOptionPane.OK_OPTION) {
                    int codCarga = Integer.parseInt(codCargaTextField.getText());
                    Carga carga = colecaoCarga.getCargaCod(codCarga);
                    if (carga != null) {
                        if (carga.getSituacao() != Situacao.FINALIZADO) {
                            trocarSituacaoCarga(carga);
                            break;
                        } else {
                            JOptionPane.showMessageDialog(this, "Não pode ser alterada, Carga já finalizada");
                            break;
                        }

                    } else {
                        JOptionPane.showMessageDialog(this, "Não existe uma Carga com esse código.");
                        break;
                    }
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this,
                        "Entrada inválida. Por favor, insira um valor numérico válido para o código da carga.");
            }

        }

    }

    private void trocarSituacaoCarga(Carga carga) {

        JRadioButton locadoRadioButton = new JRadioButton("Locado");
        JRadioButton pendenteRadioButton = new JRadioButton("Pendente");
        JRadioButton canceladoRadioButton = new JRadioButton("Cancelado");
        JRadioButton finalizadoRadioButton = new JRadioButton("Finalizado");
        ButtonGroup situacaoButtonGroup = new ButtonGroup();
        situacaoButtonGroup.add(locadoRadioButton);
        situacaoButtonGroup.add(pendenteRadioButton);
        situacaoButtonGroup.add(canceladoRadioButton);
        situacaoButtonGroup.add(finalizadoRadioButton);

        Object[] message = {

                "Código da Carga:", carga.getIdentificador(),
                "Codigo Cliente:", carga.getCliente(),
                "Origem:", carga.getOrigem(),
                "Peso:", carga.getPeso(),
                "Destino:", carga.getDestino(),
                "Valor Declarado:", carga.getValorDeclarado(),
                "Tempo Máximo:", carga.getTempoMaximo(),
                "Tipo de Carga:", carga.getTipoCarga(),
                "Situação:", carga.getSituacao(),
                "Alterar Situacao da Carga",
                pendenteRadioButton,
                locadoRadioButton,
                finalizadoRadioButton,
                canceladoRadioButton
        };
        int option = JOptionPane.showOptionDialog(
                this,
                message,
                "Cadastrar Carga",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                null);
        if (option == JOptionPane.OK_OPTION) {
            if (locadoRadioButton.isSelected()) {
                carga.setSituacao(Situacao.LOCADO);
            } else if (pendenteRadioButton.isSelected()) {
                carga.setSituacao(Situacao.PENDENTE);
            } else if (finalizadoRadioButton.isSelected()) {
                carga.setSituacao(Situacao.FINALIZADO);
            } else if (canceladoRadioButton.isSelected()) {
                carga.setSituacao(Situacao.CANCELADO);
            }
        }
    }

    private void exibirCargasCadastradas() {

        StringBuilder sb = new StringBuilder();

        for (Carga carga : colecaoCarga.getCargas()) {
            sb.append("Identificador: ").append(carga.getIdentificador()).append("\n");
            sb.append("Cliente: ").append(carga.getCliente()).append("\n");
            sb.append("Origem: ").append(carga.getOrigem()).append("\n");
            sb.append("Destino: ").append(carga.getDestino()).append("\n");
            sb.append("Peso: ").append(carga.getPeso()).append("\n");
            sb.append("Valor Declarado: ").append(carga.getValorDeclarado()).append("\n");
            sb.append("Tempo Máximo: ").append(carga.getTempoMaximo()).append("\n");
            sb.append("Tipo de Carga: ").append(carga.getTipoCarga()).append("\n");
            sb.append("Prioridade: ").append(carga.getPrioridade()).append("\n");
            sb.append("Situação: ").append(carga.getSituacao()).append("\n");
            sb.append("--------------------\n");
        }

        if (colecaoCarga.getCargas().isEmpty()) {
            sb.append("Nenhuma carga cadastrada.");
        }

        JTextArea textArea = new JTextArea(sb.toString());
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400, 300));

        JOptionPane.showMessageDialog(null, scrollPane, "Cargas Cadastradas", JOptionPane.PLAIN_MESSAGE);
        System.out.println(sb);
    }

    private void cadastrarCarga() {
        while (true) {
            try {

                JTextField codCargaTextField = new JTextField(10);
                JTextField clienteTextField = new JTextField(10);
                JTextField origemTextField = new JTextField(10);
                JTextField destinoTextField = new JTextField(10);
                JTextField pesoTextField = new JTextField(10);
                JTextField valorDeclaradoTextField = new JTextField(10);
                JTextField tempoMaximoDeclaradoTextField = new JTextField(10);
                JTextField tipoCargaTextField = new JTextField(10);
                JRadioButton rapidoRadioButton = new JRadioButton("Rápido");
                JRadioButton baratoRadioButton = new JRadioButton("Barato");
                ButtonGroup situacaoButtonGroup = new ButtonGroup();
                situacaoButtonGroup.add(rapidoRadioButton);
                situacaoButtonGroup.add(baratoRadioButton);

                Object[] message = {
                        "Código da Carga:", codCargaTextField,
                        "Codigo Cliente:", clienteTextField,
                        "Origem:", origemTextField,
                        "Peso:", pesoTextField,
                        "Destino:", destinoTextField,
                        "Valor Declarado:", valorDeclaradoTextField,
                        "Tempo Máximo:", tempoMaximoDeclaradoTextField,
                        "Tipo de Carga:", tipoCargaTextField,
                        "Situação:",
                        rapidoRadioButton,
                        baratoRadioButton,

                };

                int option = JOptionPane.showOptionDialog(
                        this,
                        message,
                        "Cadastrar Carga",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        null,
                        null);

                if (option == JOptionPane.OK_OPTION) {

                    int codCarga = Integer.parseInt(codCargaTextField.getText());
                    int cliente = Integer.parseInt(clienteTextField.getText());
                    int origem = Integer.parseInt(clienteTextField.getText());
                    int destino = Integer.parseInt(clienteTextField.getText());
                    int peso = Integer.parseInt(pesoTextField.getText());
                    double valorDeclarado = Double.parseDouble(valorDeclaradoTextField.getText());
                    int tempoMaximo = Integer.parseInt(tempoMaximoDeclaradoTextField.getText());
                    int tipoCarga = Integer.parseInt(tipoCargaTextField.getText());

                    if (colecaoCarga.containsCod(codCarga) && colecaoCliente.containsId(cliente)
                            && colecaoDistancia.containsRota(origem, destino)
                            && colecaoTipoCarga.containsTipoCarga(tipoCarga)) {

                        if (rapidoRadioButton.isSelected()) {
                            Carga carga = new Carga(codCarga, cliente, origem, destino, peso, valorDeclarado,
                                    tempoMaximo,
                                    tipoCarga, Prioridade.RAPIDO, Situacao.PENDENTE);
                            colecaoCarga.addCarga(carga);
                        } else if (baratoRadioButton.isSelected()) {
                            Carga carga = new Carga(codCarga, cliente, origem, destino, peso, valorDeclarado,
                                    tempoMaximo,
                                    tipoCarga, Prioridade.BARATO, Situacao.PENDENTE);
                            colecaoCarga.addCarga(carga);
                        }

                        JOptionPane.showMessageDialog(this, "Carga cadastrada com sucesso!");
                        break;
                    } else {
                        JOptionPane.showMessageDialog(this,
                                "Carga Não cadastrada, alguma informação disponibilizada está errada");
                        break;
                    }
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this,
                        "Entrada inválida. Por favor, insira um valor numérico válido para os campos necessários."
                                + e.getMessage());
            }
        }
    }

    private void cadastrarNovoTipoDeCarga() {
        while (true) {
            try {
                JTextField numeroTextField = new JTextField(10);
                JTextField descricaoTextField = new JTextField(10);
                JRadioButton perecivelRadioButton = new JRadioButton("Perecível");
                JRadioButton duravelRadioButton = new JRadioButton("Durável");
                ButtonGroup categoriaButtonGroup = new ButtonGroup();
                categoriaButtonGroup.add(perecivelRadioButton);
                categoriaButtonGroup.add(duravelRadioButton);

                JPanel categoriaPanel = new JPanel();
                categoriaPanel.setLayout(new GridLayout(1, 2));
                categoriaPanel.add(perecivelRadioButton);
                categoriaPanel.add(duravelRadioButton);

                JTextField origemTextField = new JTextField("* obrigatorio para tipo perecivel", 20);
                JTextField tempoMaximoTextField = new JTextField("*obrigatorio para tipo perecivel", 20);
                JTextField setorTextField = new JTextField("* obrigatorio para tipo Duravel", 20);
                JTextField materialTextField = new JTextField("*obrigatorio para tipo Duravel", 20);
                JTextField ipiTextField = new JTextField("*obrigatorio para tipo Duravel", 20);

                JPanel perecivelPanel = new JPanel();
                perecivelPanel.setLayout(new GridLayout(3, 2));
                perecivelPanel.add(new JLabel("Origem:"));
                perecivelPanel.add(origemTextField);
                perecivelPanel.add(new JLabel("Tempo Máximo:"));
                perecivelPanel.add(tempoMaximoTextField);

                JPanel duravelPanel = new JPanel();
                duravelPanel.setLayout(new GridLayout(3, 5));
                duravelPanel.add(new JLabel("Setor:*Duravel"));
                duravelPanel.add(setorTextField);
                duravelPanel.add(new JLabel("Material:*duravel"));
                duravelPanel.add(materialTextField);
                duravelPanel.add(new JLabel("IPI:*duravel"));
                duravelPanel.add(ipiTextField);

                Object[] message = {
                        "Número do tipo de carga:", numeroTextField,
                        "Descrição:", descricaoTextField,
                        "Categoria:", categoriaPanel,
                        perecivelPanel,
                        duravelPanel
                };

                int option = JOptionPane.showOptionDialog(this, message, "Cadastrar Tipo de Carga",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

                if (option == JOptionPane.OK_OPTION) {
                    int numero = Integer.parseInt(numeroTextField.getText());

                    if (colecaoTipoCarga.containsTipoCarga(numero)) {
                        JOptionPane.showMessageDialog(this,
                                "Tipo de carga com esse número já foi cadastrado. Por favor, digite outro número.");
                    } else {
                        String descricao = descricaoTextField.getText();

                        String origem = "";
                        String setor = "";
                        int tempoMaximo = 0;
                        String material = "";
                        double ipi = 0;

                        if (perecivelRadioButton.isSelected()) {

                            origem = origemTextField.getText();
                            tempoMaximo = Integer.parseInt(tempoMaximoTextField.getText());
                            Perecivel perecivel = new Perecivel(numero, descricao, origem, tempoMaximo);
                            colecaoTipoCarga.addTipoCarga(perecivel);
                        } else if (duravelRadioButton.isSelected()) {

                            setor = setorTextField.getText();
                            material = materialTextField.getText();
                            ipi = Double.parseDouble(ipiTextField.getText());
                            Duravel duravel = new Duravel(numero, descricao, setor, material, ipi);
                            colecaoTipoCarga.addTipoCarga(duravel);
                        }

                        JOptionPane.showMessageDialog(this, "Tipo de carga cadastrado com sucesso!");
                        break;
                    }
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this,
                        "Entrada inválida. Por favor, insira um valor numérico válido para o número do tipo de carga.");
            }
        }
    }

    private void exibirClientesCadastrados() {
        StringBuilder sb = new StringBuilder();

        for (Cliente cliente : colecaoCliente.getCliente()) {
            sb.append("Código: ").append(cliente.getCod()).append("\n");
            sb.append("Nome: ").append(cliente.getNome()).append("\n");
            sb.append("Email: ").append(cliente.getEmail()).append("\n");
            sb.append("--------------------\n");
        }

        if (colecaoCliente.getCliente().isEmpty()) {
            sb.append("Nenhum cliente cadastrado.");
        }

        JTextArea textArea = new JTextArea(sb.toString());
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400, 300));

        JOptionPane.showMessageDialog(null, scrollPane, "Clientes Cadastrados", JOptionPane.PLAIN_MESSAGE);
        System.out.println(sb);
    }

    private void cadastrarPorto() {
        while (true) {
            try {
                JTextField idTextField = new JTextField(10);
                JTextField nomeTextField = new JTextField(10);
                JTextField paisTextField = new JTextField(10);

                Object[] message = {
                        "ID do porto:", idTextField,
                        "Nome do porto:", nomeTextField,
                        "País do porto:", paisTextField
                };

                int option = JOptionPane.showOptionDialog(this, message, "Cadastrar Porto",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

                if (option == JOptionPane.OK_OPTION) {
                    int id = Integer.parseInt(idTextField.getText());

                    if (colecaoPortos.containsPorto(id)) {
                        JOptionPane.showMessageDialog(this,
                                "Porto com esse ID já foi cadastrado. Por favor, digite outro ID.");
                    } else {
                        String nome = nomeTextField.getText();
                        String pais = paisTextField.getText();

                        Porto porto = new Porto(id, nome, pais);
                        colecaoPortos.addPorto(porto);
                        JOptionPane.showMessageDialog(this, "Porto cadastrado com sucesso!");
                        break;
                    }
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this,
                        "Entrada inválida. Por favor, insira um valor numérico válido para o ID.");
            }
        }
    }

    private void cadastrarViagem() {
        try {
            JTextField nomeClienteTextField = new JTextField(10);
            JTextField origemTextField = new JTextField(10);
            JTextField destinoTextField = new JTextField(10);
            JRadioButton option1RadioButton = new JRadioButton("Perecível");
            JRadioButton option2RadioButton = new JRadioButton("Durável");

            ButtonGroup buttonGroup = new ButtonGroup();
            buttonGroup.add(option1RadioButton);
            buttonGroup.add(option2RadioButton);

            Object[] message = {
                    "Nome do cliente:", nomeClienteTextField,
                    "Origem:", origemTextField,
                    "Destino:", destinoTextField,
                    "Tipo de Carga:", option1RadioButton, option2RadioButton
            };

            int option = JOptionPane.showOptionDialog(
                    this,
                    message,
                    "Cadastrar Viagem",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    null);

            if (option == JOptionPane.OK_OPTION) {
                String nomeCliente = nomeClienteTextField.getText();
                String origem = origemTextField.getText();
                String destino = destinoTextField.getText();
                TipoCarga tipoCarga;
                if (option1RadioButton.isSelected()) {
                    // tipoCarga = (Perecivel) new ;
                } else if (option2RadioButton.isSelected()) {
                    // tipoCarga = "Durável";
                }

                // JOptionPane.showMessageDialog(this, mensagem);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Entrada inválida. Por favor, insira um valor válido.");
        }
    }

    private void exibirPortosCadastrados() {
        StringBuilder sb = new StringBuilder();

        for (Porto porto : colecaoPortos.getPortos()) {
            sb.append("ID: ").append(porto.getId()).append("\n");
            sb.append("Nome: ").append(porto.getNome()).append("\n");
            sb.append("País: ").append(porto.getPais()).append("\n");
            sb.append("--------------------\n");
        }

        if (colecaoPortos.getPortos().isEmpty()) {
            sb.append("Nenhum Porto cadastrado.");
        }

        JTextArea textArea = new JTextArea(sb.toString());
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400, 300));

        JOptionPane.showMessageDialog(null, scrollPane, "Portos Cadastrados", JOptionPane.PLAIN_MESSAGE);
        System.out.println(sb);
    }

    private void cadastrarNavio() {
        while (true) {
            try {
                JTextField nomeTextField = new JTextField(10);
                JTextField velocidadeTextField = new JTextField(10);
                JTextField autonomiaTextField = new JTextField(10);
                JTextField custoTextField = new JTextField(10);

                Object[] message = {
                        "Nome do navio:", nomeTextField,
                        "Velocidade do navio (em nós):", velocidadeTextField,
                        "Autonomia do navio (em milhas):", autonomiaTextField,
                        "Custo por milha do navio:", custoTextField
                };

                int option = JOptionPane.showOptionDialog(this, message, "Cadastrar Navio",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

                if (option == JOptionPane.OK_OPTION) {
                    String nome = nomeTextField.getText();

                    if (colecaoNavio.getNavios() != null && navioJaCadastrado(nome)) {
                        JOptionPane.showMessageDialog(this,
                                "Navio com esse nome já foi cadastrado. Por favor, digite outro nome.");
                        continue;
                    }

                    double velocidade = Double.parseDouble(velocidadeTextField.getText());
                    double autonomia = Double.parseDouble(autonomiaTextField.getText());
                    double custoPorMilhaBasico = Double.parseDouble(custoTextField.getText());

                    Navio navio = new Navio(nome, velocidade, autonomia, custoPorMilhaBasico);
                    colecaoNavio.addNavio(navio);

                    JOptionPane.showMessageDialog(this, "Navio cadastrado com sucesso!");
                    break;
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Entrada inválida. Por favor, insira um valor numérico válido.");
            }
        }
    }

    private boolean navioJaCadastrado(String nome) {
        for (Navio navio : colecaoNavio.getNavios()) {
            if (navio.getNome().equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
    }

    private void exibirNaviosCadastrados() {
        StringBuilder sb = new StringBuilder();

        for (Navio navio : colecaoNavio.getNavios()) {
            sb.append("Nome: ").append(navio.getNome()).append("\n");
            sb.append("Velocidade: ").append(navio.getVelocidade()).append(" nós\n");
            sb.append("Autonomia: ").append(navio.getAutonomia()).append(" milhas\n");
            sb.append("Custo por milha: ").append(navio.getCustoPorMilhaBasico()).append("\n");
            sb.append("--------------------\n");
        }

        if (colecaoNavio.getNavios().isEmpty()) {
            sb.append("Nenhum Navio cadastrado.");
        }

        JTextArea textArea = new JTextArea(sb.toString());
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400, 300));

        JOptionPane.showMessageDialog(null, scrollPane, "Navios Cadastrados", JOptionPane.PLAIN_MESSAGE);
        System.out.println(sb);
    }

    public static void main(String[] args) {
        new MenuInicial();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cadastrarPortoButton) {
            cadastrarPorto();
        }
        if (e.getSource() == portosCadastradosButton) {
            exibirPortosCadastrados();
        }
        if (e.getSource() == cadastrarNavioButton) {
            cadastrarNavio();
        }
        if (e.getSource() == naviosCadastradosButton) {
            exibirNaviosCadastrados();
        }
        if (e.getSource() == cadastrarCliente) {
            cadastrarCliente();
        }
        if (e.getSource() == clientesCadastrados) {
            exibirClientesCadastrados();
        }
        if (e.getSource() == cadastrarViagem) {
            cadastrarViagem();
        }
        if (e.getSource() == cadastrarTipo) {
            cadastrarNovoTipoDeCarga();
        }
        if (e.getSource() == cadastrarCarga) {
            cadastrarCarga();
        }
        if (e.getSource() == alterarTipoCarga) {
            CodCarga();
        }
        if (e.getSource() == cargasCadastradas) {
            exibirCargasCadastradas();
        }
        if (e.getSource() == salvarSair) {
            salvarESair();
        }
        if (e.getSource() == carregarDadosSalvos) {
            carregarDadosSalvosDoSave();
        }
        if (e.getSource() == carregarDadosIniciais) {
            carregarDadosIniciais();
        }
    }

}
