import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import calculator.Arithmetic;


public class DesktopGUI extends JFrame
{
    private JPanel contentPane;
    private JTextField InputBox;
    private JLabel Formula;

    private JPanel NumberPad;
    private JButton a0Button;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton decimalButton;

    private JPanel FourFunction;
    private JButton add;
    private JButton subtract;
    private JButton multiply;
    private JButton divide;
    private JButton equals;

    private JPanel ClearPad;
    private JButton backButton;
    private JButton cButton;
    private JButton CEButton;

    private JTabbedPane FunctionTabs;
    private JButton button2;
    private JButton ROOTButton;
    private JButton button7;
    private JPanel stdTab;
    private JPanel trigTab;
    private JButton SINButton;
    private JButton TANButton;
    private JButton COSButton;
    private JButton SECButton;
    private JButton COTButton;
    private JButton CSCButton;
    private JPanel SidePanel;
    private JButton button8;
    private JButton button9;
    private JButton x2Button;
    private JButton SQRTButton;
    private JButton lnButton;
    private JButton log10Button;
    private JButton a1XButton;
    private JComboBox comboBox1;
    private JButton eXButton;
    private JButton invertButton;
    private JButton HYPButton;
    private JButton xButton;
    private JButton πButton;
    private JButton eButton;
    private JButton x3Button;
    private JButton CBRTButton;



    public DesktopGUI()
    {
        a0Button.addActionListener(this::AddItem);
        a1Button.addActionListener(this::AddItem);
        a2Button.addActionListener(this::AddItem);
        a3Button.addActionListener(this::AddItem);
        a4Button.addActionListener(this::AddItem);
        a5Button.addActionListener(this::AddItem);
        a6Button.addActionListener(this::AddItem);
        a7Button.addActionListener(this::AddItem);
        a8Button.addActionListener(this::AddItem);
        a9Button.addActionListener(this::AddItem);
        decimalButton.addActionListener(this::AddItem);

        add.addActionListener(this::AddItem);
        subtract.addActionListener(this::AddItem);
        multiply.addActionListener(this::AddItem);
        divide.addActionListener(this::AddItem);
        equals.addActionListener(e -> {
            try { InputBox.setText(Double.toString(Arithmetic.Solve(InputBox.getText()))); }
            catch (Exception ex) { InputBox.setText("Error"); }
        });

        backButton.addActionListener(e -> { if (!InputBox.getText().isEmpty()) InputBox.setText( InputBox.getText().substring(0, InputBox.getText().length() - 1) ); });
        cButton.addActionListener(e -> InputBox.setText(""));
        CEButton.addActionListener(e -> InputBox.setText(""));
    }

    public void AddItem(ActionEvent e) { InputBox.setText(InputBox.getText() + ((JButton)e.getSource()).getText()); }

    public static void main(String[] args)
    {
        DesktopGUI frame = new DesktopGUI();
        frame.setTitle("Calculator");
        frame.setContentPane(frame.contentPane);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.Formula.setVisible(true);
    }

}
