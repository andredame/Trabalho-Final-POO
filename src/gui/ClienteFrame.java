package gui;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClienteFrame extends JFrame implements ActionListener {

    private JPanel nomeEmpresa;
    private int xBotao;
    private int yBotao;
    private int widthBotao;
    private int heightBotao;
    private Color colorOfButton;
    private Color colorOfLetter;
    private Font fonte;
    private JButton selectButton;
    private JButton voltarMenu;
    //TextField
    private JTextField codField;
    private JTextField nomeField;
    private JTextField emailField;

    private JPanel cod;
    private JPanel email;
    private JPanel nome;
    private JLabel errorMessage;


   

    public ClienteFrame(){
        super();
        colorOfButton = Color.DARK_GRAY;
        colorOfLetter = Color.WHITE;
        fonte=new Font("Serif", Font.BOLD, 20);

        xBotao=100;
        yBotao=150;
        widthBotao=300;
        heightBotao=40;
        setNomeEmpresa();
        setDescricaoPagina();
        setNomePanel();
        setCodPanel();
        setEmailPanel();
        setButtonSelect();
        setButtonBack();
        setErrorMessage();
        this.add(errorMessage);
        errorMessage.setVisible(false);

        this.add(nomeEmpresa);
        this.add(cod);
        this.add(email);
        this.add(nome);
        this.add(selectButton);
        this.add(voltarMenu);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 600);
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

    }
    private void setDescricaoPagina(){
        JPanel descricaoPagina = new JPanel();
        JLabel label = new JLabel("Cadastrar Cliente");
        label.setForeground(colorOfButton);
        label.setFont(new Font ("",Font.BOLD, 20));
        descricaoPagina.add(label);
        descricaoPagina.setBounds(0, 100, 500, 40);
        this.add(descricaoPagina);
    }
    private void setNomePanel(){
        nome=new JPanel();
        JLabel label= new JLabel("Nome:");
        label.setForeground(colorOfLetter);
        nomeField= new JTextField(11);
        nome.setBackground(colorOfButton);
        nome.setBounds(xBotao,yBotao,widthBotao,heightBotao);
        nome.add(label);
        nome.add(nomeField);
        
    }
    private void setCodPanel(){

        JLabel label= new JLabel("Codigo:");
        label.setForeground(colorOfLetter);
        codField= new JTextField(11);
        cod=new JPanel();
        cod.setBounds(xBotao,yBotao+75,widthBotao,heightBotao);
        cod.setBackground(colorOfButton);
        cod.add(label);
        cod.add(codField);


    }
    private void setEmailPanel(){

        email=new JPanel();
        email.setBounds(xBotao,yBotao+150,widthBotao,heightBotao);
        JLabel label= new JLabel("Email:");
        label.setForeground(colorOfLetter);
        emailField= new JTextField(11);
        email.setBackground(colorOfButton);
        email.add(label);
        email.add(emailField);
        
        
    }
    private void setButtonSelect(){
        //Botao de carregar dados
        selectButton = new JButton("Cadastrar");
        selectButton.setBounds(150, 400, 200, 40);
        selectButton.setFont(fonte);
        selectButton.setFocusable(false);
        selectButton.setForeground(colorOfLetter);
        selectButton.addActionListener(this);
        selectButton.setBackground(colorOfButton);

    }
    private void setButtonBack(){
        //Botao de carregar dados
        voltarMenu = new JButton("Voltar Menu");
        
        voltarMenu.setBounds(15, 55, 100, 25);
        voltarMenu.setFont(new Font("Serif", Font.BOLD, 10));
        voltarMenu.setFocusable(false);
        voltarMenu.setForeground(colorOfLetter);
        voltarMenu.addActionListener(this);
        voltarMenu.setBackground(colorOfButton);
    }


    private void setNomeEmpresa(){
        //Panel para ter o nome 
        nomeEmpresa=new JPanel();
        nomeEmpresa.setBounds(0, 10, 500, 40);
        JLabel label= new JLabel("Empresa ACME");
        label.setFont(fonte);
        label.setForeground(colorOfLetter);
        nomeEmpresa.add(label);
        nomeEmpresa.setBackground(colorOfButton);
        
    }
    private void setErrorMessage(){
        errorMessage = new JLabel("Erro ao Cadastrar");
        errorMessage.setBackground(Color.BLACK);
        errorMessage.setForeground(Color.RED);
        errorMessage.setFont(new Font("Serif", Font.BOLD, 15));
        errorMessage.setBounds(175, 300, 500, 400);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == selectButton){
            try{
                int cod = Integer.parseInt(codField.getText());
                String nome = nomeField.getText();
                String email = nomeField.getText();
                //Cliente novoCliente = new Cliente(cod,nome,email);

                //Adicionar CLiente na colecao
                errorMessage.setVisible(false);
            }
            catch(NumberFormatException except){
                errorMessage.setVisible(true);
            }
        }
        if(e.getSource() == voltarMenu){
            MenuInicial menu = new MenuInicial();
            dispose();
        }
    }
   
}
