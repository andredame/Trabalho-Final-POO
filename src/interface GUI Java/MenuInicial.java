import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuInicial extends JFrame implements ActionListener {
    private JPanel nomeEmpresa;
    private int xBotao;
    private int yBotao;
    private int widthBotao;
    private int heightBotao;
    private Color colorBackground;
    private Color colorOfButton;
    private Color colorOfLetter;
    private Font fonte; 

    private JButton navio;
    private JButton porto;
    private JButton carga;
    private JButton cliente;
    

    public MenuInicial(){
        super();

        
        colorOfButton = Color.DARK_GRAY;
        colorOfLetter = Color.WHITE;
        fonte=new Font("Serif", Font.BOLD, 20);
        xBotao= 35;
        yBotao=100;
        widthBotao=200;
        heightBotao=40;

        setNomeEmpresa();
        setButtonPorto();
        setButtonNavio();
        setButtonCarga();
        setButtonCliente();
        this.add(nomeEmpresa);
        this.add(porto);
        this.add(cliente);
        this.add(carga);
        this.add(navio);
        this.getContentPane().setBackground(colorBackground);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 600);
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

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
    private void setButtonPorto(){
        porto = new JButton();
        porto.setBounds(xBotao, yBotao, widthBotao, heightBotao);
        porto.setBackground(Color.LIGHT_GRAY);
        porto.setText("Cadastrar porto");
        porto.addActionListener(this);

    }
    private void setButtonNavio(){
        navio = new JButton();
        navio.setBounds(xBotao, yBotao+100, widthBotao, heightBotao);
        navio.setBackground(Color.LIGHT_GRAY);
        navio.setText("Cadastrar navio");
        navio.addActionListener(this);
    }
    private void setButtonCarga(){
        carga = new JButton();
        carga.setBounds(xBotao+210, yBotao, widthBotao, heightBotao);
        carga.setBackground(Color.LIGHT_GRAY);
        carga.setText("Cadastrar Carga");
        carga.addActionListener(this);
    }
    private void setButtonCliente(){
        cliente = new JButton();
        cliente.setBounds(xBotao+210, yBotao+100, widthBotao, heightBotao);
        cliente.setBackground(Color.LIGHT_GRAY);
        cliente.setText("Cadastrar Cliente");
        cliente.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == porto){
            PortoFrame pFrame = new PortoFrame();
            dispose();
        }
        if (e.getSource() == navio){
            NavioFrame pFrame = new NavioFrame();
            dispose();
        }
        if (e.getSource() == carga){
            PortoFrame cFrame = new PortoFrame();
            dispose();
        }
        if (e.getSource() == cliente){
            ClienteFrame clienteF = new ClienteFrame();
            dispose();
        }
    }
    public static void main(String[] args) {
        MenuInicial menu = new MenuInicial();
    }
}
