package gui;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import Objetos.*;
import Colecoes.*;


public class MenuInicial extends JFrame implements ActionListener{
    private ColecaoPortos colecaoPortos;
    private ColecaoNavio colecaoNavio;
    private ColecaoCarga colecaoCarga;
    private ColecaoTipoCarga colecaoTipoCarga;
    private ColecaoCliente colecaoCliente;
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

    public MenuInicial() {
        super("Menu Inicial");
        setLayout(new FlowLayout());
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        colecaoNavio = new ColecaoNavio();
        colecaoCliente=new ColecaoCliente();
        colecaoTipoCarga = new ColecaoTipoCarga();
        colecaoPortos = new ColecaoPortos();
        colecaoCarga = new ColecaoCarga();


        cadastrarNavioButton = new JButton("Cadastrar Navio");
        naviosCadastradosButton = new JButton("Navios Cadastrados");
        cadastrarPortoButton = new JButton("Cadastrar Porto");
        portosCadastradosButton = new JButton("Portos Cadastrados");
        cadastrarCliente = new JButton("Cadastrar Cliente");
        clientesCadastrados=new JButton("Clientes Cadastrados");
        cadastrarViagem =new JButton("Cadastrar Viagem");
        cadastrarTipo = new JButton("Cadastrar Tipo de Carga");
        cadastrarCarga = new JButton("Cadastrar Carga");
        alterarTipoCarga = new JButton ("Alterar Situacao Carga");


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
        setVisible(true);
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
                    null
                );

                if (option == JOptionPane.OK_OPTION) {
                    int codCliente = Integer.parseInt(codTextField.getText());
                    String nomeCliente = nomeTextField.getText();
                    String emailCliente = emailTextField.getText();

                    if (colecaoCliente.procuraId(codCliente) || colecaoCliente.procuraEmail(emailCliente)) {
                        JOptionPane.showMessageDialog(this, "Cliente com o mesmo código ou email já foi cadastrado. Por favor, verifique os dados inseridos.");
                        continue;
                    }
                    Cliente c=new Cliente(codCliente,nomeCliente,emailCliente);
                    colecaoCliente.addCliente(c);
                    JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso!");
                    break;
                } else {
                    break; 
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Entrada inválida. Por favor, insira um valor numérico válido para o código do cliente.");
            }
        }
    }

    private void trocarSituacaoCarga(){
        while (true) {
            try{
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
                        null
                    );
                if(option == JOptionPane.OK_OPTION){
                    int codCarga = Integer.parseInt(codCargaTextField.getText());
                    Carga carga = colecaoCarga.getCargaCod(codCarga);
                    if(carga != null){
                        //if (carga.getSituacao() == Situacao.FINALIZADO){
                            exibirInformacoesCarga(carga);
                        break;
                        //}
                        
                    }else{
                        JOptionPane.showMessageDialog(this, "Não existe uma Carga com esse código.");
                        break;
                    }
                }else{
                    break;
                }
            }catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Entrada inválida. Por favor, insira um valor numérico válido para o código da carga.");
            }
            
        }

    }

    private void exibirInformacoesCarga(Carga carga) {
        
        JRadioButton locadoRadioButton = new JRadioButton("Locado");
        JRadioButton pendenteRadioButton = new JRadioButton("pendente");
        JRadioButton canceladoRadioButton = new JRadioButton("Cancelado");
        JRadioButton finalizadoRadioButton = new JRadioButton("Finalizado");
        ButtonGroup situacaoButtonGroup = new ButtonGroup();
        situacaoButtonGroup.add(locadoRadioButton);
        situacaoButtonGroup.add(pendenteRadioButton);
        situacaoButtonGroup.add(canceladoRadioButton);
        situacaoButtonGroup.add(finalizadoRadioButton);

        
    
        Object[] message = {
            
                    "Código da Carga:", carga.getIdentificador(),
                    "Codigo Cliente:",carga.getCliente(),
                    "Origem:", carga.getOrigem(),
                    "Peso:", carga.getPeso(),
                    "Destino:", carga.getDestino(),
                    "Valor Declarado:", carga.getValorDeclarado(),
                    "Tempo Máximo:", carga.getTempoMaximo(),
                    "Tipo de Carga:", carga.getTipoCarga(),
                    "Situação:",carga.getSituacao(),
                   "Alterar Situacao da Carga",
                   locadoRadioButton,
                   pendenteRadioButton,
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
                    null
                );
                if (option == JOptionPane.OK_OPTION) {
                    if(locadoRadioButton.isSelected()){
                        carga.setSituacao(Situacao.LOCADO);
                    }else if(pendenteRadioButton.isSelected()){
                        carga.setSituacao(Situacao.PENDENTE);
                    }else if(finalizadoRadioButton.isSelected()){
                        carga.setSituacao(Situacao.FINALIZADO);
                    }else if(canceladoRadioButton.isSelected()){
                        carga.setSituacao(Situacao.CANCELADO);
                    }
                }
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
                    null
                );

                if (option == JOptionPane.OK_OPTION) {
                    int codCarga = Integer.parseInt(codCargaTextField.getText());
                    int cliente = Integer.parseInt(clienteTextField.getText());
                    String origem = origemTextField.getText();
                    String destino = destinoTextField.getText();
                    int peso = Integer.parseInt(pesoTextField.getText());
                    double valorDeclarado = Double.parseDouble(valorDeclaradoTextField.getText());
                    int tempoMaximo = Integer.parseInt(tempoMaximoDeclaradoTextField.getText());
                    int tipoCarga = Integer.parseInt(tipoCargaTextField.getText());
                    
                    if (rapidoRadioButton.isSelected()) {
                        Carga carga = new Carga(tipoCarga, cliente, origem, destino, peso, valorDeclarado, tempoMaximo, destino, Prioridade.RAPIDO, Situacao.PENDENTE);
                        colecaoCarga.addCarga(carga);
                    } else if (baratoRadioButton.isSelected()) {
                        Carga carga = new Carga(tipoCarga, cliente, origem, destino, peso, valorDeclarado, tempoMaximo, destino, Prioridade.BARATO, Situacao.PENDENTE);
                        colecaoCarga.addCarga(carga);
                    }
                    

                    JOptionPane.showMessageDialog(this, "Carga cadastrada com sucesso!");
                    break;
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Entrada inválida. Por favor, insira um valor numérico válido para os campos necessários."+ e.getMessage());
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

                JTextField origemTextField = new JTextField("* obrigatorio para tipo perecivel",20);
                JTextField tempoMaximoTextField = new JTextField("*obrigatorio para tipo perecivel",20);
                JTextField setorTextField = new JTextField("* obrigatorio para tipo Duravel",20);
                JTextField materialTextField = new JTextField("*obrigatorio para tipo Duravel",20);
                JTextField ipiTextField = new JTextField("*obrigatorio para tipo Duravel",20);

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

                int option = JOptionPane.showOptionDialog(this, message, "Cadastrar Tipo de Carga", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

                if (option == JOptionPane.OK_OPTION) {
                    int numero = Integer.parseInt(numeroTextField.getText());

                    if (colecaoTipoCarga.procurarNumeroCarga(numero)) {
                        JOptionPane.showMessageDialog(this, "Tipo de carga com esse número já foi cadastrado. Por favor, digite outro número.");
                    } else {
                        String descricao = descricaoTextField.getText();
                        String categoria = "";
                        String origem = "";
                        String setor = "";
                        int tempoMaximo =0 ;
                        String material = "";
                        double ipi = 0;

                        if (perecivelRadioButton.isSelected()) {
                            
                            origem = origemTextField.getText();
                            tempoMaximo = Integer.parseInt(tempoMaximoTextField.getText());
                            Perecivel perecivel = new Perecivel(numero,descricao,origem,tempoMaximo);
                            colecaoTipoCarga.addTipoCarga(perecivel);
                        } else if (duravelRadioButton.isSelected()) {
                            categoria = "DURAVEL";
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
                JOptionPane.showMessageDialog(this, "Entrada inválida. Por favor, insira um valor numérico válido para o número do tipo de carga.");
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
        if (colecaoCliente.getCliente().size() ==0){
            sb.append("Nenhum cliente cadastrado.");
        }
        JOptionPane.showMessageDialog(this, sb.toString());
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

                int option = JOptionPane.showOptionDialog(this,message, "Cadastrar Porto", JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE,null, null,null);

                if (option == JOptionPane.OK_OPTION) {
                    int id = Integer.parseInt(idTextField.getText());

                    if (colecaoPortos.getPortoPorId(id)) {
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
                null
            );

            if (option == JOptionPane.OK_OPTION) {
                String nomeCliente = nomeClienteTextField.getText();
                String origem = origemTextField.getText();
                String destino = destinoTextField.getText();
                TipoCarga tipoCarga;
                if (option1RadioButton.isSelected()) {
                    //tipoCarga = (Perecivel) new ;
                } else if (option2RadioButton.isSelected()) {
                    //tipoCarga = "Durável";
                }
                
                
                //JOptionPane.showMessageDialog(this, mensagem);
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
         if (colecaoPortos.getPortos().size() ==0){
            sb.append("Nenhum Porto cadastrado.");
        }
        JOptionPane.showMessageDialog(this, sb.toString());
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

            int option = JOptionPane.showOptionDialog(this,message,"Cadastrar Navio",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE,null,null,null);

            if (option == JOptionPane.OK_OPTION) {
                String nome = nomeTextField.getText();

                if (colecaoNavio.getNavios() != null && navioJaCadastrado(nome)) {
                    JOptionPane.showMessageDialog(this, "Navio com esse nome já foi cadastrado. Por favor, digite outro nome.");
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
        if (colecaoNavio.getNavios().size() ==0){
            sb.append("Nenhum Navio cadastrado.");
        }
        JOptionPane.showMessageDialog(this, sb.toString());
    }

    public static void main(String[] args) {
        new MenuInicial();  
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() ==cadastrarPortoButton){
            cadastrarPorto();
        }
        if(e.getSource() == portosCadastradosButton){
            exibirPortosCadastrados();
        }
        if(e.getSource() ==cadastrarNavioButton){
            cadastrarNavio();
        }
        if(e.getSource() ==naviosCadastradosButton){
            exibirNaviosCadastrados();
        }
        if(e.getSource() ==cadastrarCliente){
            cadastrarCliente();
        }
        if(e.getSource() ==clientesCadastrados){
            exibirClientesCadastrados();
        }
         if(e.getSource() == cadastrarViagem){
            cadastrarViagem();
         }
         if(e.getSource() == cadastrarTipo){
            cadastrarNovoTipoDeCarga();
        }
         if(e.getSource() == cadastrarCarga){
            cadastrarCarga();
        }
        if(e.getSource() == alterarTipoCarga){
            trocarSituacaoCarga();
        }
    }
    
}
