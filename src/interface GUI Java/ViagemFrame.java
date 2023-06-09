import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViagemFrame extends JFrame implements ActionListener {
    private JPanel nomeEmpresa;
    private JRadioButton option1RadioButton;
    private JRadioButton option2RadioButton;
    private JPanel panelCliente;
    private JPanel  panelCarga;
    private JPanel  panelViagem;
    private JButton selectButton;

    private JButton dadosPadrao;
    private JButton carregarDados;

    private int xBotao;
    private int yBotao;
    private int widthBotao;
    private int heightBotao;
    
    private Color colorOfButton;
    private Color colorOfLetter;
    private Font fonte;

    public ViagemFrame() {
        super();

        //Cores e fonte 

        colorOfButton = Color.DARK_GRAY;
        colorOfLetter = Color.WHITE;
        fonte=new Font("Serif", Font.BOLD, 20);
        //Botoes 
        xBotao=75; //posicao eixo x botao
        yBotao=350; //posicao do botao
        widthBotao=350; //largura eixo x botao
        heightBotao=40; //altura eixo x botao

        setNomeEmpresa();
        setFieldNomeCliente();
        setPanelCarga();
        setButtonSelect();
        setOrigemDestinoField();

        // Add the panel to the frame
        this.add(panelViagem);
        this.add(panelCarga);
        this.add(selectButton);
        this.add(panelCliente);
        this.add(nomeEmpresa);
        this.setSize(500, 600);
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);



    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // Check if Option 1 is selected
        if (option1RadioButton.isSelected()) {
            System.out.println("Option 1 selected");
        }

        // Check if Option 2 is selected
        if (option2RadioButton.isSelected()) {
            System.out.println("Option 2 selected");
        }
    }
    private void setFieldNomeCliente(){
        // Create the panel
        panelCliente = new JPanel();
        panelCliente.setLayout(new FlowLayout());
        panelCliente.setBounds(35, 100, 400, 40);
        panelCliente.setBackground(Color.LIGHT_GRAY);

        JLabel nomeCliente=new JLabel("Nome do Cliente:");
        nomeCliente.setFont(fonte);
        nomeCliente.setBackground(colorOfButton);
        JTextField fieldNomeCliente=new JTextField(20);
        fieldNomeCliente.setFont(new Font("Serif", Font.BOLD, 15));


        panelCliente.add(nomeCliente);
        panelCliente.add(fieldNomeCliente);
    }

    private void setPanelCarga(){
        JLabel tipoCarga=new JLabel("Escolha o tipo de Carga:");
        tipoCarga.setFont(fonte);
        tipoCarga.setBackground(colorOfButton);
        

        //Create the radio buttons
       option1RadioButton = new JRadioButton("Perecivel");
       option2RadioButton = new JRadioButton("Duravel");
       option1RadioButton.setBackground(Color.LIGHT_GRAY);
       option2RadioButton.setBackground(Color.LIGHT_GRAY);
        //Create a ButtonGroup and add the radio buttons to it
       ButtonGroup buttonGroup = new ButtonGroup();
       buttonGroup.add(option1RadioButton);
       buttonGroup.add(option2RadioButton);

        //Add the radio buttons to the panel
        panelCarga = new JPanel();
        panelCarga.setLayout(new FlowLayout());
        panelCarga.setBounds(35, 175, 400, 40);
        panelCarga.setBackground(Color.LIGHT_GRAY);
        panelCarga.add(tipoCarga);
        panelCarga.add(option1RadioButton);
        panelCarga.add(option2RadioButton);
    }
    private void setButtonSelect(){
        //Botao de carregar dados
        selectButton = new JButton("Selecionar");
        selectButton.setBounds(xBotao, yBotao+80, widthBotao, heightBotao);
        selectButton.setFont(fonte);
        selectButton.setFocusable(false);
        selectButton.setForeground(colorOfLetter);
        selectButton.addActionListener(this);
        selectButton.setBackground(colorOfButton);
    }
    private void setOrigemDestinoField(){
        //Panel digitar Origem e Destino 
        panelViagem = new JPanel();
        panelViagem.setLayout(new FlowLayout());
        panelViagem.setBounds(35, 250, 400, 40);
        panelViagem.setBackground(Color.LIGHT_GRAY);
        JLabel origem = new JLabel("Origem:");
        origem.setFont(new Font("Serif", Font.BOLD, 20));
        JLabel destino = new JLabel("Destino:");
        destino.setFont(new Font("Serif", Font.BOLD, 20));
        JTextField barraOrigem=new JTextField(8);
        JTextField barraDestino=new JTextField(8);
        panelViagem.add(origem);
        panelViagem.add(barraOrigem);
        panelViagem.add(destino);
        panelViagem.add(barraDestino);
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
}
