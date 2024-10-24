import javax.swing.*;

import calculator.*;

public class DesktopGUI extends JFrame
{
    private JPanel contentPane;
    private JButton Clear;
    private JButton button1;
    private JButton one;
    private JButton negation;
    private JButton two;
    private JButton zero;
    private JButton three;
    private JButton decimal;
    private JTextField TextField;
    private JButton nine;
    private JButton six;
    private JButton eight;
    private JButton RPAREN;
    private JButton five;
    private JButton Mod;
    private JButton four;
    private JButton seven;
    private JButton LPAREN;
    private JButton backButton;
    private JButton Equal;
    private JButton Add;
    private JButton Subtract;
    private JButton Multiply;
    private JButton Divide;
    private JButton ln;
    private JButton ABS;
    private JButton CE;
    private JButton PiButton;
    private JButton Root;
    private JButton Power;
    private JButton log;

    public DesktopGUI()
    {

    }

    public static void main(String[] args)
    {
        DesktopGUI frame = new DesktopGUI();
        frame.setTitle("Calculator");
        frame.setContentPane(frame.contentPane);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
