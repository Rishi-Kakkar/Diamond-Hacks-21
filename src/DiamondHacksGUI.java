import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.util.List;
import java.awt.event.*;

public class DiamondHacksGUI implements ActionListener {

    public static void main(String args[]) {
        DiamondHacksProgram program = new DiamondHacksProgram();

        JFrame frame = new JFrame();

        JButton button = new JButton("Show Listings");

        JPanel resultsPanel = new JPanel();

        JPanel panel = new JPanel();

        JLabel resultsLabel = new JLabel("Enter data below...");
        resultsPanel.add(resultsLabel);

        JLabel companiesLabel = new JLabel("Enter companies you would like to search through here. (Separate with commas, no spaces)");
        JTextField companiesText = new JTextField(100);
        panel.add(companiesLabel);
        panel.add(companiesText);

        JLabel positionsLabel = new JLabel("Enter keywords for positions you would like to search for here. (Separate with commas, no spaces)");
        JTextField positionsText = new JTextField(100);
        panel.add(positionsLabel);
        panel.add(positionsText);

        String companiesString = companiesText.getText();
        String positionsString = positionsText.getText();

        panel.add(button);
        button.setPreferredSize(new Dimension(100, 50));

        panel.setBorder(BorderFactory.createEmptyBorder(450, 450, 150, 450));
        panel.setBorder(BorderFactory.createLineBorder(Color.black,1));
        panel.setLayout(new GridLayout(0, 1));
        resultsPanel.setBorder(BorderFactory.createEmptyBorder(600, 600, 200, 600));
        resultsPanel.setLayout(new GridLayout(0, 1));
        resultsPanel.setBorder(BorderFactory.createLineBorder(Color.black,1));

        frame.add(panel, BorderLayout.SOUTH);
        frame.add(resultsPanel, BorderLayout.NORTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("TrabaJob");
        frame.pack();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                List<String> companiesKeyword = program.Keyword(companiesText.getText(), positionsText.getText());
                String[] companyName = program.CompanyResult(companiesKeyword);
                String[] positionName = program.PositionResult(companiesKeyword);

                resultsLabel.setText("<html>");
                for (int i = 0; i < companyName.length; i++) {
                    resultsLabel.setText(resultsLabel.getText() + companyName[i] + " - " + positionName[i] + "<br/>");
                }
                resultsLabel.setText(resultsLabel.getText() + "</html>");

            }
        });
    }

    public void actionPerformed(ActionEvent e) {
    }
}
