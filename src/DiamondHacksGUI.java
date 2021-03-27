import javax.swing.*;
import java.awt.*;

public class DiamondHacksGUI {
    public static void main(String args[]) {
        DiamondHacksProgram program = new DiamondHacksProgram();

        JFrame frame = new JFrame();

        JButton button = new JButton("Show Listings");

        JPanel panel = new JPanel();

        JLabel companiesLabel = new JLabel("Companies.");
        JTextField companiesText = new JTextField("Enter companies you would like to search through here. (Separate with commas)", 100);
        panel.add(companiesLabel);
        panel.add(companiesText);

        JLabel positionsLabel = new JLabel("Positions.");
        JTextField positionsText = new JTextField("Enter keywords for positions you would like to search for here. (Separate with commas)", 100);
        panel.add(positionsLabel);
        panel.add(positionsText);

        panel.add(button);
        button.addActionListener(new ActionListener())

        panel.setBorder(BorderFactory.createEmptyBorder(600, 600, 200, 600));
        panel.setLayout(new GridLayout(0, 1));

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("<insert program name here>");
        frame.pack();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);

        String getText(companiesText);
        String getText(positionsText);

        List<String> companiesKeyword = program.Keyword(companiesString);
    }
}
