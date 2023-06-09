import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DadosFrame extends JFrame implements ActionListener{
    private JButton dadosPadrao;
    private JButton carregarDados;
    private JPanel nomeEmpresa;
    private int xBotao;
    private int yBotao;
    private int widthBotao;
    private int heightBotao;
    private Color colorBackground;
    private Color colorOfButton;
    private Color colorOfLetter;
    private Font fonte; 
    
    
    
    public DadosFrame(){
        super();
        this.setTitle("FrameInicio");

        //Cores e fonte 
        colorBackground = Color.LIGHT_GRAY;
        colorOfButton = Color.DARK_GRAY;
        colorOfLetter = Color.WHITE;
        fonte=new Font("Serif", Font.BOLD, 20);
        
 
        //Panel para ter o nome 
        nomeEmpresa=new JPanel();
        nomeEmpresa.setBounds(0, 10, 500, 40);
        JLabel label= new JLabel("Empresa ACME");
        label.setFont(fonte);
        label.setForeground(colorOfLetter);
        nomeEmpresa.add(label);
        nomeEmpresa.setBackground(colorOfButton);

        //Botoes 
        this.xBotao=75; //posicao eixo x botao
        this.yBotao=160; //posicao do botao
        this.widthBotao=350; //largura eixo x botao
        this.heightBotao=40; //altura eixo x botao
        setButtonCarregarDados();
        setButtonDadosPadrao();

        // metodos para o frame 
        this.add(nomeEmpresa);
        this.getContentPane().setBackground(colorBackground);
        this.add(dadosPadrao);
        this.add(carregarDados);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 600);
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource() == dadosPadrao ){
            ClienteFrame f = new ClienteFrame();
            dispose();
            
       }
    }
    private void setButtonCarregarDados(){
        //Botao de carregar dados
        this.carregarDados = new JButton("Carregar dados");
        this.carregarDados.setBounds(xBotao, yBotao+80, widthBotao, heightBotao);
        this.carregarDados.setFont(fonte);
        this.carregarDados.setFocusable(false);
        this.carregarDados.setForeground(colorOfLetter);
        this.carregarDados.addActionListener(this);
        this.carregarDados.setBackground(colorOfButton);
    }
    private void setButtonDadosPadrao(){
        //Botao de carregar dados
        this.dadosPadrao = new JButton("Iniciar dados Padrão");
        
        dadosPadrao.setBounds(xBotao,yBotao, widthBotao, heightBotao);
        dadosPadrao.setFont(fonte);
        dadosPadrao.setFocusable(false);
        dadosPadrao.setForeground(colorOfLetter);
        dadosPadrao.addActionListener(this);
        dadosPadrao.setBackground(colorOfButton);
    }
    
    public static void main(String[] args) {
        DadosFrame porto= new DadosFrame();
    }
}
