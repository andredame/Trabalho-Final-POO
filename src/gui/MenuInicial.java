package gui;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Objetos.*;
import Colecoes.*;


public class MenuInicial extends JFrame implements ActionListener{
    private ColecaoPortos colecaoPortos;
    private Frota frota;
    private Freguesia freguesia;
    private  JButton cadastrarNavioButton;
    private JButton naviosCadastradosButton;
    private JButton cadastrarPortoButton;
    private JButton portosCadastradosButton;
    private JButton cadastrarCliente;
    private JButton clientesCadastrados;


    public MenuInicial() {
        super("Menu Inicial");
        setLayout(new FlowLayout());
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        frota = new Frota();
        freguesia=new Freguesia();


        colecaoPortos = new ColecaoPortos();


        cadastrarNavioButton = new JButton("Cadastrar Navio");
        naviosCadastradosButton = new JButton("Navios Cadastrados");
        cadastrarPortoButton = new JButton("Cadastrar Porto");
        portosCadastradosButton = new JButton("Portos Cadastrados");
        cadastrarCliente = new JButton("Cadastrar Cliente");
        clientesCadastrados=new JButton("Clientes Cadastrados");

        
        cadastrarNavioButton.addActionListener(this);
        naviosCadastradosButton.addActionListener(this);
        cadastrarPortoButton.addActionListener(this);
        portosCadastradosButton.addActionListener(this);
        cadastrarCliente.addActionListener(this);
        clientesCadastrados.addActionListener(this);
        add(cadastrarCliente);
        add(clientesCadastrados);
        add(cadastrarNavioButton);
        add(naviosCadastradosButton);
        add(cadastrarPortoButton);
        add(portosCadastradosButton);
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

                    if (freguesia.procuraId(codCliente) || freguesia.procuraEmail(emailCliente)) {
                        JOptionPane.showMessageDialog(this, "Cliente com o mesmo código ou email já foi cadastrado. Por favor, verifique os dados inseridos.");
                        continue;
                    }
                    Cliente c=new Cliente(codCliente,nomeCliente,emailCliente);
                    freguesia.addCliente(c);
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
    private void exibirClientesCadastrados() {
        StringBuilder sb = new StringBuilder();
        for (Cliente cliente : freguesia.getCliente()) {
            sb.append("Código: ").append(cliente.getCod()).append("\n");
            sb.append("Nome: ").append(cliente.getNome()).append("\n");
            sb.append("Email: ").append(cliente.getEmail()).append("\n");
            sb.append("--------------------\n");
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

                    if (colecaoPortos.getPortoPorId(id) != null) {
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




    private void exibirPortosCadastrados() {
        StringBuilder sb = new StringBuilder();
        for (Porto porto : colecaoPortos.getPortos()) {
            sb.append("ID: ").append(porto.getId()).append("\n");
            sb.append("Nome: ").append(porto.getNome()).append("\n");
            sb.append("País: ").append(porto.getPais()).append("\n");
            sb.append("--------------------\n");
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

                if (frota.getNavios() != null && navioJaCadastrado(nome)) {
                    JOptionPane.showMessageDialog(this, "Navio com esse nome já foi cadastrado. Por favor, digite outro nome.");
                    continue;
                }

                double velocidade = Double.parseDouble(velocidadeTextField.getText());
                double autonomia = Double.parseDouble(autonomiaTextField.getText());
                double custoPorMilhaBasico = Double.parseDouble(custoTextField.getText());

                Navio navio = new Navio(nome, velocidade, autonomia, custoPorMilhaBasico);
                frota.addNavio(navio);

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
        for (Navio navio : frota.getNavios()) {
            if (navio.getNome().equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
    }

    private void exibirNaviosCadastrados() {
        StringBuilder sb = new StringBuilder();
        for (Navio navio : frota.getNavios()) {
            sb.append("Nome: ").append(navio.getNome()).append("\n");
            sb.append("Velocidade: ").append(navio.getVelocidade()).append(" nós\n");
            sb.append("Autonomia: ").append(navio.getAutonomia()).append(" milhas\n");
            sb.append("Custo por milha: ").append(navio.getCustoPorMilhaBasico()).append("\n");
            sb.append("--------------------\n");
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
         
    }
    
}
