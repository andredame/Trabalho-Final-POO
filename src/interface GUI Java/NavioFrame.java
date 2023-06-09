import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NavioFrame extends JFrame implements ActionListener{

    private JPanel nomeEmpresa;
    private int xBotao;
    private int yBotao;
    private int widthBotao;
    private int heightBotao;
    private Color colorOfButton;
    private Color colorOfLetter;
    private Font fonte;
    private JPanel nome;
    private JTextField nomeField;
    private JPanel velocidade;
    private JTextField velocidadeField;
    private JPanel autonomia;
    private JTextField autonomiaField;
    private JPanel CustoMilha;
    private JTextField CustoMilhaField; 
    private JButton selectButton;
    private JButton voltarMenu;
    private JLabel errorMessage;

    public NavioFrame(){
        super();
        colorOfButton = Color.DARK_GRAY;
        colorOfLetter = Color.WHITE;
        fonte=new Font("Serif", Font.BOLD, 20);
        xBotao=100;
        yBotao=150;
        widthBotao=300;
        heightBotao=40;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 600);
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        setDescricaoPagina();
        setButtonBack();
        this.add(voltarMenu);
        setButtonSelect();
        this.add(selectButton);
        setNomeEmpresa();
        this.add(nomeEmpresa);
        setNomePanel();
        this.add(nome);
        setVelocidadePanel();
        this.add(velocidade);
        setAutonomiaPanel();
        this.add(autonomia);
        setCustoMilhaPanel();
        this.add(CustoMilha);
        setErrorMessage();
        this.add(errorMessage);
        errorMessage.setVisible(false);
        
    }
    private void setDescricaoPagina(){
        JPanel descricaoPagina = new JPanel();
        JLabel label = new JLabel("Cadastrar Navio");
        label.setFont(new Font ("",Font.BOLD, 20));
        label.setForeground(colorOfButton);
        descricaoPagina.add(label);
        descricaoPagina.setBounds(0, 100, 500, 40);
        this.add(descricaoPagina);
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
    private void setVelocidadePanel(){
        velocidade=new JPanel();
        JLabel label= new JLabel("Velocidade:");
        label.setForeground(colorOfLetter);
        velocidadeField= new JTextField(11);
        velocidade.setBackground(colorOfButton);
        velocidade.setBounds(xBotao,yBotao+75,widthBotao,heightBotao);
        velocidade.add(label);
        velocidade.add(velocidadeField);
        
    }
    private void setAutonomiaPanel(){
        autonomia=new JPanel();
        JLabel label= new JLabel("Autonomia:");
        label.setForeground(colorOfLetter);
        autonomiaField= new JTextField(11);
        autonomia.setBackground(colorOfButton);
        autonomia.setBounds(xBotao,yBotao+150,widthBotao,heightBotao);
        autonomia.add(label);
        autonomia.add(autonomiaField);
    }
    private void setCustoMilhaPanel(){
        CustoMilha=new JPanel();
        JLabel label= new JLabel("Custo por milha:");
        label.setForeground(colorOfLetter);
        CustoMilhaField= new JTextField(11);
        CustoMilha.setBackground(colorOfButton);
        CustoMilha.setBounds(xBotao,yBotao+225,widthBotao,heightBotao);
        CustoMilha.add(label);
        CustoMilha.add(CustoMilhaField);
    }
    private void setButtonSelect(){
        //Botao de carregar dados
        selectButton = new JButton("Cadastrar");
        selectButton.setBounds(150, 445, 200, 40);
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
    private void setErrorMessage(){
        errorMessage = new JLabel("Erro ao Cadastrar");
        errorMessage.setForeground(Color.RED);
        errorMessage.setFont(new Font("Serif", Font.BOLD, 15));
        errorMessage.setBounds(175, 300, 500, 400);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == selectButton){
            try{
                String n =nomeField.getText();
                double v= Double.parseDouble(velocidadeField.getText());
                double auto = Double.parseDouble(autonomiaField.getText());
                double custo = Double.parseDouble(CustoMilhaField.getText());
                //Navio n = new Navio(n,v,auto,custo);
                //ColecaoNavio.add(n);
                errorMessage.setVisible(false);
                
            }catch(NumberFormatException except){
                errorMessage.setVisible(true);
            }
        }
        if(e.getSource() == voltarMenu){
            MenuInicial menu = new MenuInicial();
            dispose();
        }
    }
}
