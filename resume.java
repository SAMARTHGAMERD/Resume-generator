import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class resume extends JFrame {
    private JLabel nameLabel;
    private JLabel dobLabel;
    private JLabel educationLabel;
    private JLabel hobbiesLabel;
    private JLabel languagesLabel;
    private JTextField dobField;
    private JTextField educationField;
    private JTextField hobbiesField;
    private JTextField languagesField;
    private JLabel detailededuLabel;
    private JLabel areaofinterestLabel;
    private JLabel experienceLabel;
    private JLabel emailidLabel;
    private JTextField emailidField;
    private JLabel personaldetailsLabel;
    private JLabel achievementsLabel;
    private JLabel imageLabel;
    private JTextArea experienceField;
    private JTextArea detailededuField;
    private JButton uploadImageButton;
    private JButton selectTemplate;
    private JButton select1;
    private JButton select2;
    private JPanel resumePanel;
    private JTextField nameField;
    private JTextArea areaofinterestField;
    private JTextArea personaldetailsField;
    private JTextArea achievementsField;
    private File selectedImageFile;


    public resume() {
        setContentPane(resumePanel);
        setTitle("Resume Form");
        setSize(600,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);



        detailededuField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    updateTextAreaAsList(detailededuField);
                }
            }
        });

        // Add key listener to arearofinterest to listen for Enter key press
        areaofinterestField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    updateTextAreaAsList(areaofinterestField);
                }
            }
        });

        // Add key listener to educationalDetailsArea to listen for Enter key press
        achievementsField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    updateTextAreaAsList(achievementsField);
                }
            }
        });

        // Add key listener to educationalDetailsArea to listen for Enter key press
        personaldetailsField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    updateTextAreaAsList(personaldetailsField);
                }
            }
        });

        // Add key listener to educationalDetailsArea to listen for Enter key press
        experienceField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    updateTextAreaAsList(experienceField);
                }
            }
        });
        setVisible(true);

        uploadImageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Choose Image");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "gif");
                fileChooser.setFileFilter(filter);

                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    selectedImageFile = fileChooser.getSelectedFile();
                    ImageIcon imageIcon = new ImageIcon(selectedImageFile.getAbsolutePath());
                    // Clear image label in the form window
                    imageLabel.setIcon(null);
                }
            }
        });

        selectTemplate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateTemplate1HTML();
                generateTemplate2HTML();
                //generateTemplate3HTML();
            }
        });



        select1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateResumeHTML1();
            }
        });

        select2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateResumeHTML2();
            }
        });


    }


//##########################################################################################################

    private void updateTextAreaAsList(JTextArea textArea) {
        String currentText = textArea.getText();
        String[] lines = currentText.split("\n");
        String lastLine = lines[lines.length - 1];
        String updatedText = currentText.substring(0, currentText.lastIndexOf(lastLine)) +
                "<li>" + lastLine + "</li>\n";
        textArea.setText(updatedText);
    }

    //###################################################################################################

    private void generateTemplate1HTML()
    {
        if (selectedImageFile == null || !selectedImageFile.exists())
        {
            JOptionPane.showMessageDialog(this, "Please upload an image.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        ImageIcon imageIcon = new ImageIcon(selectedImageFile.getAbsolutePath());
        if (imageIcon.getIconWidth() == -1 || imageIcon.getIconHeight() == -1)
        {
            JOptionPane.showMessageDialog(this, "Invalid image file.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Generate HTML here with the collected data
        String template1 =
                "<html>" +
                        "<head>" +
                        "<style>" +
                        "   * {" +
                        "       font-family: Arial, Helvetica, sans-serif;" +
                        "   }" +
                        "   #heading {" +
                        "       text-align: center;" +
                        "       font-size: 30px;" +
                        "   }" +
                        "   .table {" +
                        "       width: 1000px;" +
                        "       margin: auto;" +
                        "       padding-left: 30px;" +
                        "       border-collapse: collapse;" +
                        "       font-size: 20px;" +
                        "   }" +
                        "   .table th, .table td {" +
                        "       border: 1px solid #ddd;" +
                        "       padding: 8px;" +
                        "   }" +
                        "   .table th {" +
                        "       background-color: #f2f2f2;" +
                        "       text-align: left;" +
                        "   }" +
                        "   #myimg {" +
                        "       height: 250px;" +
                        "       width: 200px;" +
                        "       padding: 30px;" +
                        "   }" +
                        "   .tab2 {" +
                        "       width: 1000px;" +
                        "       margin: auto;" +
                        "       border: 1px solid #ddd;" +
                        "       border-collapse: collapse;" +
                        "   }" +
                        "   .tablehead {" +
                        "       background-color: rgb(50, 136, 190);" +
                        "       border: 1px solid #ddd;" +
                        "       border-collapse: collapse;" +
                        "       font-size: 20px;" +
                        "       padding-left: 30px;" +
                        "       height: 60px;" +
                        "   }" +
                        "   .tabexp {" +
                        "       font-size: 20px;" +
                        "       border: 1px solid #ddd;" +
                        "       border-collapse: collapse;" +
                        "       padding-left: 30px;" +
                        "   }" +
                        "</style>" +
                        "<h1 id='heading'>RESUME</h1>" +
                        "</head>" +
                        "<title>MyResume</title>" +
                        "<body>" +
                        "<table class='table'>" +
                        "<tbody>" +
                        "<tr>" +
                        "<td class='table'>" +
                        "<strong>Name</strong>" +
                        "</td>" +
                        "<td class='table'>" +
                        "xxx" +
                        "</td>" +
                        "<td rowspan='7'><img src='" + selectedImageFile.toURI().toString() + "' alt='image' id='myimg'></td>" +
                        "</tr>" +
                        "<tr >" +
                        "<td class='table'>" +
                        "<strong>Designation</strong>" +
                        "</td>" +
                        "<td class='table'>" +
                        "xxx" +
                        "</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td class='table'>" +
                        "<strong>Education</strong>" +
                        "</td>" +
                        "<td class='table'>" +
                        "xxx" +
                        "</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td class='table'>" +
                        "<strong>Experience</strong>" +
                        "</td>" +
                        "<td class='table'>" +
                        "xxx" +
                        "</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td class='table'>" +
                        "<Strong>Area of Intrest</Strong>" +
                        "</td>" +
                        "<td class='table'>" +
                        "xxx" +
                        "</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td class='table'>" +
                        "<strong>Date of Birth</strong>" +
                        "</td>" +
                        "<td class='table'>" +
                        "xxx" +
                        "</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td class='table'>" +
                        "<strong>Email ID</strong>" +
                        "</td>" +
                        "<td class='table'>" +
                        "xxx" +
                        "</td>" +
                        "</tr>" +
                        "</tbody>" +
                        "</table>" +
                        "<br>" +
                        "<table class='tab2'>" +
                        "<tr>" +
                        "<td class='tablehead'>" +
                        "<Strong>Educational Details</Strong>" +
                        "</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td class='tabexp'>" +
                        "<li>" +
                        "Lorem ipsum dolor sit amet consectetur, adipisicing elit." +
                        "</li>" +
                        "<li>" +
                        "Lorem ipsum dolor sit amet consectetur, adipisicing elit." +
                        "</li>" +
                        "<li>" +
                        "Lorem ipsum dolor sit amet consectetur, adipisicing elit." +
                        "</li>" +
                        "</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td class='tablehead'>" +
                        "<strong>Personal Details</strong>" +
                        "</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td class='tabexp'>" +
                        "<li>" +
                        "Lorem ipsum dolor sit amet consectetur, adipisicing elit." +
                        "</li>" +
                        "<li>" +
                        "Lorem ipsum dolor sit amet consectetur, adipisicing elit." +
                        "</li>" +
                        "<li>" +
                        "Lorem ipsum dolor sit amet consectetur, adipisicing elit." +
                        "</li>" +
                        "</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td class='tablehead'>" +
                        "<strong>Professional Experience</strong>" +
                        "</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td class='tabexp'>" +
                        "<li>" +
                        "Lorem ipsum dolor sit amet consectetur, adipisicing elit." +
                        "</li>" +
                        "<li>" +
                        "Lorem ipsum dolor sit amet consectetur, adipisicing elit." +
                        "</li>" +
                        "<li>" +
                        "Lorem ipsum dolor sit amet consectetur, adipisicing elit." +
                        "</li>" +
                        "</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td class='tablehead'>" +
                        "<strong>Personal Details</strong>" +
                        "</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td class='tabexp'>" +
                        "Lorem ipsum dolor sit amet consectetur adipisicing elit. Totam ducimus obcaecati ratione consectetur necessitatibus cumque rem qui voluptatum ipsam nisi omnis culpa accusantium alias molestiae perspiciatis, sit ut consequatur corrupti itaque." +
                        "</td>" +
                        "</tr>" +
                        "<tr >" +
                        "<td class='tablehead'>" +
                        "<strong>Contact Details</strong>" +
                        "</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td class='tabexp'>" +
                        "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Commodi explicabo velit nobis soluta neque esse, laborum laboriosam aspernatur similique. Cupiditate officia vitae quo, fuga fugiat corrupti quod reiciendis quam animi!" +
                        "</td>" +
                        "</tr>" +
                        "</table>" +
                        "</body>" +
                        "</html>";



        // Open the HTML content in a browser
        SwingUtilities.invokeLater(() -> {
            JFrame template1Frame = new JFrame("Template 1");
            JEditorPane editorPane = new JEditorPane();
            editorPane.setContentType("text/html");
            editorPane.setText(template1);
            editorPane.setEditable(false); // Make the editorPane non-editable
            editorPane.setCaret(null); // Disable the caret
            JScrollPane scrollPane = new JScrollPane(editorPane);
            template1Frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
            template1Frame.setSize(500, 500);
            template1Frame.setLocationRelativeTo(null);
            template1Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            template1Frame.setVisible(true);

        });

    }

//#####################################################################################################
//####################################################################################################

    private void generateTemplate2HTML()
    {
        // Generate HTML here with the collected data
        String template2 =
                "<html lang='en'>" +
                        "<head>" +
                        "  <meta charset='UTF-8'>" +
                        "  <meta name='viewport' content='width=device-width, initial-scale=1.0'>" +
                        "  <title>Teacher Resume</title>" +
                        "  <link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'>" +
                        "</head>" +
                        "<body>" +
                        "  <div class='container py-6'>" +
                        "    <div class='row justify-content-center'>" +
                        "      <div class='col-md-12'>" +
                        "        <div class='card'>" +
                        "          <div class='card-body'>" +
                        "            <h1 class='card-title text-center mb-4'><br>RESUME</h1>" +
                        "            <div class='row'>" +
                        "              <div class='d-flex flex-column  text-center  col-md-4  '>" +
                        "                <img src= '"+ selectedImageFile.toURI().toString() +"' alt='Image' class='img-fluid '>" +
                        "                <h2 class='text-center'>Your Name</h2>" +
                        "                <p class='text-center lead'>Date of Birth: xx-xx-xxxx</p>" +
                        "                <div class='card mt-3'>" +
                        "                  <div class='card-body'>" +
                        "                    <h5 class='card-title'>Contact details</h5>" +
                        "                    <p class='card-text'>xxxxxxxxxxxxxxxxxxxxx@gmail.com</p>" +
                        "                  </div>" +
                        "                </div>" +
                        "                <div class='card mt-3'>" +
                        "                  <div class='card-body'>" +
                        "                    <h5 class='card-title'>Achievements</h5>" +
                        "                    <p class='card-text'>xxxxxxxxxxxxx</p>" +
                        "                  </div>" +
                        "                </div>" +
                        "                <div class='card mt-3'>" +
                        "                  <div class='card-body'>" +
                        "                    <h5 class='card-title'>Experience</h5>" +
                        "                    <p class='card-text'>xxxxxxxxxxxxxxx</p>" +
                        "                  </div>" +
                        "                </div>" +
                        "                <div class='card mt-3'>" +
                        "                  <div class='card-body'>" +
                        "                    <h5 class='card-title'>Hobbies</h5>" +
                        "                    <p class='card-text'>xxxxxxxxxxxxxx</p>" +
                        "                  </div>" +
                        "                </div>" +
                        "              </div>" +
                        "              <div class='col-md-8'>" +
                        "                <div class='card'>" +
                        "                  <div class='card-body'>" +
                        "                    <h5 class='card-title'>Education</h5>" +
                        "                    <p class='card-text'>xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx</p>" +
                        "                  </div>" +
                        "                </div>" +
                        "                <div class='card mt-3'>" +
                        "                  <div class='card-body'>" +
                        "                    <h5 class='card-title'>Languages</h5>" +
                        "                    <p class='card-text'>xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx</p>" +
                        "                  </div>" +
                        "                </div>" +
                        "                <div class='card mt-3'>" +
                        "                  <div class='card-body'>" +
                        "                    <h5 class='card-title'>Educational Details</h5>" +
                        "                    <p class='card-text'>" +
                        "                      <ul>" +
                        "                        <li>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Officia ipsa facere, aperiam consectetur ducimus repellat eaque aut vero architecto. Maiores.</li>" +
                        "                          <li>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla at tortor vel lacus vehicula tristique. Fusce consectetur mi vel nisl suscipit tristique.</li>" +
                        "                          <li>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla at tortor vel lacus vehicula tristique. Fusce consectetur mi vel nisl suscipit tristique.</li>" +
                        "                      </ul>" +
                        "                    </p>" +
                        "                  </div>" +
                        "                </div>" +
                        "                <div class='card mt-3'>" +
                        "                  <div class='card-body'>" +
                        "                    <h5 class='card-title'>Personal Details</h5>" +
                        "                    <p class='card-text'>" +
                        "                      <ul>" +
                        "                        <li>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Officia ipsa facere, aperiam consectetur ducimus repellat eaque aut vero architecto. Maiores.</li>" +
                        "                          <li>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla at tortor vel lacus vehicula tristique. Fusce consectetur mi vel nisl suscipit tristique.</li>" +
                        "                          <li>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla at tortor vel lacus vehicula tristique. Fusce consectetur mi vel nisl suscipit tristique.</li>" +
                        "                      </ul>" +
                        "                    </p>" +
                        "                  </div>" +
                        "                </div>" +
                        "                <div class='card mt-3'>" +
                        "                  <div class='card-body'>" +
                        "                    <h5 class='card-title'>Professional Details</h5>" +
                        "                    <p class='card-text'>" +
                        "                      <ul>" +
                        "                        <li>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Officia ipsa facere, aperiam consectetur ducimus repellat eaque aut vero architecto. Maiores.</li>" +
                        "                          <li>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla at tortor vel lacus vehicula tristique. Fusce consectetur mi vel nisl suscipit tristique.</li>" +
                        "                          <li>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla at tortor vel lacus vehicula tristique. Fusce consectetur mi vel nisl suscipit tristique.</li>" +
                        "                      </ul>" +
                        "                    </p>" +
                        "                  </div>" +
                        "                </div>" +
                        "              </div>" +
                        "            </div>" +
                        "          </div>" +
                        "        </div>" +
                        "      </div>" +
                        "    </div>" +
                        "  </div>" +
                        "</body>" +
                        "</html>";

        SwingUtilities.invokeLater(() -> {
            JFrame template1Frame = new JFrame("Template 2");
            JEditorPane editorPane = new JEditorPane();
            editorPane.setContentType("text/html");
            editorPane.setText(template2);
            editorPane.setEditable(false); // Make the editorPane non-editable
            editorPane.setCaret(null); // Disable the caret
            JScrollPane scrollPane = new JScrollPane(editorPane);
            template1Frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
            template1Frame.setSize(500, 500);
            template1Frame.setLocationRelativeTo(null);
            template1Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            template1Frame.setVisible(true);


        });
    }

    //*********************************************************************************************************************
//*********************************************************************************************************************
    private void generateResumeHTML1()
    {
        String name = nameField.getText();
        String dob = dobField.getText();
        String education = educationField.getText();
        String hobbies = hobbiesField.getText();
        String languages = languagesField.getText();
        String email = emailidField.getText();
        String aoi = areaofinterestField.getText();
        String dedu = detailededuField.getText();
        String experience = experienceField.getText();
        String achievements = achievementsField.getText();
        String personaldetails = personaldetailsField.getText();
        try {
            FileWriter writer = new FileWriter("C:\\Users\\LENOVO\\OneDrive\\Desktop\\myresume1.html");


            writer.write("<html>\n");
            writer.write("<head>\n");
            writer.write("<style>\n");
            writer.write("   * {\n");
            writer.write("       font-family: Arial, Helvetica, sans-serif;\n");
            writer.write("   }\n");
            writer.write("   #heading {\n");
            writer.write("       text-align: center;\n");
            writer.write("       font-size: 30px;\n");
            writer.write("   }\n");
            writer.write("   .table {\n");
            writer.write("       width: 1000px;\n");
            writer.write("       margin:auto;\n");
            writer.write("       border-collapse: collapse;\n");
            writer.write("       padding-left: 30px;\n");
            writer.write("       font-size: 20px;\n");
            writer.write("   }\n");
            writer.write("   .table th, .table td {\n");
            writer.write("       border: 1px solid #ddd;\n");
            writer.write("       padding: 8px;\n");
            writer.write("   }\n");
            writer.write("   .table th {\n");
            writer.write("       background-color: #f2f2f2;\n");
            writer.write("       text-align: left;\n");
            writer.write("   }\n");
            writer.write("   #myimg {\n");
            writer.write("       height: 250px;\n");
            writer.write("       width: 200px;\n");
            writer.write("       padding: 30px;\n");
            writer.write("   }\n");
            writer.write("   .tab2 {\n");
            writer.write("       width: 1000px;\n");
            writer.write("       margin:auto;\n");
            writer.write("       border: 1px solid #ddd;\n");
            writer.write("       border-collapse: collapse;\n");
            writer.write("   }\n");
            writer.write("   .tablehead {\n");
            writer.write("       background-color: rgb(50, 136, 190);\n");
            writer.write("       border: 1px solid #ddd;\n");
            writer.write("       border-collapse: collapse;\n");
            writer.write("       font-size: 20px;\n");
            writer.write("       padding-left: 30px;\n");
            writer.write("       height: 60px;\n");
            writer.write("   }\n");
            writer.write("   .tabexp {\n");
            writer.write("       font-size: 20px;\n");
            writer.write("       border: 1px solid #ddd;\n");
            writer.write("       border-collapse: collapse;\n");
            writer.write("       padding-left: 30px;\n");
            writer.write("   }\n");
            writer.write("</style>\n");
            writer.write("</head>\n");
            writer.write("<body>\n");
            writer.write("<h1 id='heading'>RESUME</h1>\n");
            writer.write("<table class='table'>\n");
            writer.write("<tbody>\n");
            writer.write("<tr>\n");
            writer.write("<td class=\'table\'><strong>Name</strong></td>\n");
            writer.write("<td class=\'table\'>" + name + "</td>\n");
            writer.write("<td rowspan=\'7\'><img src=\'" + selectedImageFile.toURI().toString() + "\' alt=\'image\' id=\'myimg\'></td>\n");
            writer.write("</tr>\n");

            writer.write("<tr>\n");
            writer.write("<td class=\'table\'><strong>Date of birth</strong></td>\n");
            writer.write("<td class=\'table\'>" + dob + "</td>\n");
            writer.write("</tr>\n");

            writer.write("<tr>\n");
            writer.write("<td class=\'table\'><strong>Education</strong></td>\n");
            writer.write("<td class=\'table\'>" + education + "</td>\n");
            writer.write("</tr>\n");

            writer.write("<tr>\n");
            writer.write("<td class=\'table\'><strong>Hobbies</strong></td>\n");
            writer.write("<td class=\'table\'>" + hobbies + "</td>");
            writer.write("</tr>\n");

            writer.write("<tr>\n");
            writer.write("<td class=\'table\'><strong>Languages</strong></td>\n");
            writer.write("<td class=\'table\'>" + languages + "</td>\n");
            writer.write("</tr>\n");
            writer.write("</tbody>\n");
            writer.write("</table>\n");
            writer.write("<table class=\'tab2\'>\n");
            writer.write("<tr>\n");
            writer.write("<td class=\'tablehead\'><strong>Educational Details</strong></td>\n");
            writer.write("</tr>\n");
            writer.write("<tr>\n");
            writer.write("<td class=\'tabexp\'>" + dedu + "</td>\n");
            writer.write("</tr>\n");
            writer.write("<tr>\n");
            writer.write("<td class=\'tablehead\'><strong>Personal Details</strong></td>\n");
            writer.write("</tr>\n");
            writer.write("<tr>\n");
            writer.write("<td class=\'tabexp\'>" + personaldetails + "</td>\n");
            writer.write("</tr>\n");
            writer.write("<tr>\n");
            writer.write("<td class=\'tablehead\'><strong>Professional Details/Experience</strong></td>\n");
            writer.write("</tr>\n");
            writer.write("<tr>\n");
            writer.write("<td class=\'tabexp\'>" + experience + "</td>");
            writer.write("</tr>\n");

            writer.write("<tr>\n");
            writer.write("<td class=\'tablehead\'><strong>Contact Details (Email id)</strong></td>\n");
            writer.write("</tr>\n");
            writer.write("<tr>\n");
            writer.write("<td class=\'tabexp\'>" + email + "</td>");
            writer.write("</tr>\n");
            //added one
            writer.write("<tr>\n");
            writer.write("<td class=\'tablehead\'><strong>Achievements</strong></td>\n");
            writer.write("</tr>\n");
            writer.write("<tr>\n");
            writer.write("<td class=\'tabexp\'>" + achievements + "</td>");
            writer.write("</tr>\n");
            //one more added
            writer.write("<tr>\n");
            writer.write("<td class=\'tablehead\'><strong>Area Of Interest</strong></td>\n");
            writer.write("</tr>\n");
            writer.write("<tr>\n");
            writer.write("<td class=\'tabexp\'>" + aoi + "</td>");
            writer.write("</tr>\n");

            writer.write("</table>\n");
            writer.write("</body>\n");
            writer.write("</html>\n");

            writer.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Eroror writing html file.", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private void generateResumeHTML2()
    {
        String name = nameField.getText();
        String dob = dobField.getText();
        String education = educationField.getText();
        String hobbies = hobbiesField.getText();
        String languages = languagesField.getText();
        String email = emailidField.getText();
        //String aoi = areaofinterestField.getText();
        String dedu = detailededuField.getText();
        String experience = experienceField.getText();
        String achievements = achievementsField.getText();
        String personaldetails = personaldetailsField.getText();
        try
        {
            FileWriter writer = new FileWriter("C:\\Users\\LENOVO\\OneDrive\\Desktop\\myresume2.html");

            writer.write("   <html lang=\"en\">\n");
            writer.write("   <head>\n");
            writer.write("     <meta charset=\"UTF-8\">\n");
            writer.write("     <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
            writer.write("     <title> myresume2</title>\n");
            writer.write("     <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\n");
            writer.write("   </head>\n");
            writer.write("   <body>\n");
            writer.write("   \n");
            writer.write("     <div class=\"container py-6\">\n");
            writer.write("       <div class=\"row justify-content-center\">\n");
            writer.write("         <div class=\"col-md-12\">\n");
            writer.write("           <div class=\"card\">\n");
            writer.write("             <div class=\"card-body\">\n");
            writer.write("               <h1 class=\"card-title text-center mb-4\"><br>RESUME</h1>\n");
            writer.write("               <div class=\"row\">\n");
            writer.write("                 <div class=\"d-flex flex-column  text-center  col-md-3  \">\n");
            writer.write("                   <img src=\""+selectedImageFile.toURL().toString()+"\" alt=\" Image\" class=\"img-fluid \">\n");
            writer.write("                   <h2 class=\"text-center\">"+name+"</h2>\n");



            writer.write("                   <p class=\"text-center lead\"><strong>Date of Birth:</strong> "+dob+"</p>\n");
            writer.write("   \n");
            writer.write("                   <div class=\"card mt-3\">\n");
            writer.write("                     <div class=\"card-body\">\n");
            writer.write("                       <h5 class=\"card-title\">Contact details</h5>\n");
            writer.write("                       <p class=\"card-text\">"+email+"</p> \n");
            writer.write("                     </div>\n");
            writer.write("                   </div>\n");
            writer.write("   \n");
            writer.write("                   <div class=\"card mt-3\">\n");
            writer.write("                     <div class=\"card-body\">\n");
            writer.write("                       <h5 class=\"card-title\">Achievements</h5>\n");
            writer.write("                       <p class=\"card-text\">"+achievements+"</p> \n");
            writer.write("                     </div>\n");
            writer.write("                   </div>\n");
            writer.write("   \n");



            writer.write("                   <div class=\"card mt-3\">\n");
            writer.write("                     <div class=\"card-body\">\n");
            writer.write("                       <h5 class=\"card-title\">Hobbies</h5>\n");
            writer.write("                       <p class=\"card-text\">"+hobbies+"</p>\n");
            writer.write("                     </div>\n");
            writer.write("                   </div>\n");
            writer.write("   \n");
            writer.write("                 </div>\n");
            writer.write("                 <div class=\"col-md-9\">\n");
            writer.write("                   <div class=\"card\">\n");
            writer.write("                     <div class=\"card-body\">\n");
            writer.write("                       <h5 class=\"card-title\">Education</h5>\n");
            writer.write("                       <p class=\"card-text\">"+education+"</p>\n");
            writer.write("                     </div>\n");
            writer.write("                   </div>\n");
            writer.write("                   \n");
            writer.write("                   <div class=\"card mt-3\">\n");
            writer.write("                     <div class=\"card-body\">\n");
            writer.write("                       <h5 class=\"card-title\">Languages</h5>\n");
            writer.write("                       <p class=\"card-text\">"+languages+"</p>\n");
            writer.write("                     </div>\n");
            writer.write("                   </div>\n");
            writer.write("                   <div class=\"card mt-3\">\n");
            writer.write("                     <div class=\"card-body\">\n");
            writer.write("                       <h5 class=\"card-title\">Educational Details</h5>\n");
            writer.write("                       <p class=\"card-text\">\n");
            writer.write("                         <ul>\n");
            writer.write(""+dedu+"");
            writer.write("                         </ul>\n");
            writer.write("                       </p>\n");
            writer.write("                     </div>\n");
            writer.write("                   </div>\n");

            writer.write("                   <div class=\"card mt-3\">\n");
            writer.write("                     <div class=\"card-body\">\n");
            writer.write("                       <h5 class=\"card-title\">Experience/Profestional details </h5>\n");
            writer.write("                       <p class=\"card-text\">"+experience+"</p> \n");
            writer.write("                     </div>\n");
            writer.write("                   </div>\n");
            writer.write("   \n");

            writer.write("                   <div class=\"card mt-3\">\n");
            writer.write("                     <div class=\"card-body\">\n");
            writer.write("                       <h5 class=\"card-title\">Personal Details</h5>\n");
            writer.write("                       <p class=\"card-text\">\n");
            writer.write("                         <ul>\n");
            writer.write(""+personaldetails+"");
            writer.write("                         </ul>\n");
            writer.write("   \n");
            writer.write("                       </p>\n");
            writer.write("                     </div>\n");
            writer.write("                   </div>\n");

            writer.write("                 </div>\n");
            writer.write("               </div>\n");
            writer.write("             </div>\n");
            writer.write("           </div>\n");
            writer.write("         </div>\n");
            writer.write("       </div>\n");
            writer.write("     </div>\n");
            writer.write("   \n");
            writer.write("   </body>\n");
            writer.write("   </html>\n");

            writer.close();
        }
        catch (IOException ex)
        {
            JOptionPane.showMessageDialog(this, "Eroror writing html file.", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }




    public static void main(String args[])
    {
        new resume();
    }
}




