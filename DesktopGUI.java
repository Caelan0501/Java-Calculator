import javax.swing.*;
import java.awt.event.ActionEvent;

import calculator.Arithmetic;

public class DesktopGUI extends JFrame
{
    private JPanel contentPane;
    private JButton Clear;
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
    private JButton Root;
    private JButton Power;
    private JTabbedPane Tabs;
    private JPanel StandardTab;

    public DesktopGUI()
    {
        decimal.addActionListener(this::AddText);
        zero.addActionListener(this::AddText);
        one.addActionListener(this::AddText);
        two.addActionListener(this::AddText);
        three.addActionListener(this::AddText);
        four.addActionListener(this::AddText);
        five.addActionListener(this::AddText);
        six.addActionListener(this::AddText);
        seven.addActionListener(this::AddText);
        eight.addActionListener(this::AddText);
        nine.addActionListener(this::AddText);

        Add.addActionListener(this::AddText);
        Subtract.addActionListener(this::AddText);
        Multiply.addActionListener(this::AddText);
        Divide.addActionListener(this::AddText);
        Mod.addActionListener(this::AddText);
        Power.addActionListener(this::AddText);
        Root.addActionListener(this::AddText);
        LPAREN.addActionListener(this::AddText);
        RPAREN.addActionListener(this::AddText);
        negation.addActionListener(this::AddText);

        backButton.addActionListener(_ -> TextField.setText(TextField.getText().substring(0, TextField.getText().length() - 1)));
        Clear.addActionListener(_ -> TextField.setText(""));

        Equal.addActionListener(_ -> {
            try { TextField.setText(Double.toString(Arithmetic.Solve(TextField.getText()))); }
            catch (Exception ex) { TextField.setText("Error"); }
        });
    }

    public void AddText(ActionEvent e) { TextField.setText(TextField.getText() + ((JButton) e.getSource()).getText()); }

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
