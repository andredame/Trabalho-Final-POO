import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PortoFrame extends JFrame implements ActionListener{
    private JPanel nomeEmpresa;
    private int xBotao;
    private int yBotao;
    private int widthBotao;
    private int heightBotao;
    private Color colorOfButton;
    private Color colorOfLetter;
    private Font fonte; 

    private JPanel nome;
    private JPanel id;
    private JPanel pais;
    private JButton selectButton;
    private JButton voltarMenu;
    private JTextField fieldNome;
    private JTextField fieldId;
    private JTextField fieldPais;
    private JLabel errorMessage;

    
    

    

    public PortoFrame(){
        super();
        colorOfButton = Color.DARK_GRAY;
        colorOfLetter = Color.WHITE;
        fonte=new Font("Serif", Font.BOLD, 20);

        xBotao=100;
        yBotao=150;
        widthBotao=300;
        heightBotao=40;


        setNome();
        setId();
        setPais();
        setNomeEmpresa();
        setButtonSelect();
        setDescricaoPagina();
        setButtonBack();

        setErrorMessage();
        this.add(errorMessage);
        errorMessage.setVisible(false);
        this.add(nome);
        this.add(nomeEmpresa);
        this.add(id);
        this.add(pais);
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
        JLabel label = new JLabel("Cadastrar Porto");
        label.setForeground(colorOfButton);
        label.setFont(new Font ("",Font.BOLD, 20));
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
    private void setNome(){
        nome=new JPanel();
        JLabel label= new JLabel("Nome:");
        label.setForeground(colorOfLetter);
        fieldNome= new JTextField(11);
        nome.setBackground(colorOfButton);
        nome.setBounds(xBotao,yBotao,widthBotao,heightBotao);
        nome.add(label);
        nome.add(fieldNome);
        
    }
    private void setId(){

        JLabel label= new JLabel("ID:");
        label.setForeground(colorOfLetter);
        fieldId= new JTextField(11);
        id=new JPanel();
        id.setBounds(xBotao,yBotao+75,widthBotao,heightBotao);
        id.setBackground(colorOfButton);
        id.add(label);
        id.add(fieldId);
    }
    private void setPais(){
        pais=new JPanel();
        pais.setBounds(xBotao,yBotao+150,widthBotao,heightBotao);
        JLabel label= new JLabel("País:");
        label.setForeground(colorOfLetter);
        fieldPais= new JTextField(11);
        pais.setBackground(colorOfButton);
        pais.add(label);
        pais.add(fieldPais);
        
        
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
                String nome = fieldNome.getText();
                int id =Integer.parseInt(fieldId.getText());
                String pais = fieldPais.getText();
                //Porto p = new Porto(nome,id,pais);
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
