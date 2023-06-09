package gui;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SegundoFrame extends JFrame implements ActionListener{
    private JPanel nomeEmpresa;
    private JButton novoTransporte;
    private JButton transpCadastrados;
    private int xBotao;
    private int yBotao;
    private int widthBotao;
    private int heightBotao;
    
    

    public SegundoFrame(){
        super();
        this.setTitle("SegundoFrame");

        //Cores e fonte 
        Color colorBackground = Color.lightGray;
        Color colorOfButton = Color.DARK_GRAY;
        Color colorOfLetter = Color.WHITE;
        Font f=new Font("Serif", Font.BOLD, 20);
        
 
        //Panel para ter o nome 
        nomeEmpresa=new JPanel();
        nomeEmpresa.setBounds(0, 10, 500, 40);
        JLabel label= new JLabel("Empresa ACME");
        label.setFont(f);
        label.setForeground(colorOfLetter);
        nomeEmpresa.add(label);
        nomeEmpresa.setBackground(colorOfButton);

        //Botoes 
        int xBotao=75; //posicao eixo x botao
        int yBotao=160; //posicao do botao
        int widthBotao=350; //largura eixo x botao
        int heightBotao=40; //altura eixo x botao

        //Botao de carregar dados
        novoTransporte = new JButton("Solicitar novo transporte");
        novoTransporte.setBounds(xBotao,yBotao, widthBotao, heightBotao);
        novoTransporte.setFont(f);
        novoTransporte.setFocusable(false);
        novoTransporte.setForeground(colorOfLetter);
        novoTransporte.addActionListener(this);
        novoTransporte.setBackground(colorOfButton);


        //Botao de carregar dados
        transpCadastrados = new JButton("Visualizar Transporte cadastrados");
        transpCadastrados.setBounds(xBotao, yBotao+80, widthBotao, heightBotao);
        transpCadastrados.setFont(f);
        transpCadastrados.setFocusable(false);
        transpCadastrados.setForeground(colorOfLetter);
        transpCadastrados.addActionListener(this);
        transpCadastrados.setBackground(colorOfButton);


        // metodos para o frame 
        this.add(transpCadastrados);
        this.add(novoTransporte);
        this.add(nomeEmpresa);
        this.getContentPane().setBackground(colorBackground);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 600);
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        




    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == novoTransporte ){
            System.out.println(e.getSource());
       }
       if (e.getSource() == transpCadastrados ){
        System.out.println(e.getSource());
   }
    }
    public static void main(String[] args) {
        SegundoFrame p = new SegundoFrame();
    }
}
