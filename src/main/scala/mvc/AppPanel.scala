//package mvc;
//
//import tools.Utilities;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.beans.*;
//import java.io.*;
//
//public class AppPanel extends JPanel implements ActionListener, PropertyChangeListener {
//
//    protected Model model;
//    protected View view;
//    protected JPanel controlPanel;
//    protected AppFactory af;
//
//    private JFrame frame;
//    public static int FRAME_WIDTH = 500;
//    public static int FRAME_HEIGHT = 300;
//
//    public AppPanel(AppFactory factory) {
//        af = factory;
//        model = af.makeModel();
//        model.addPropertyChangeListener(this);
//        controlPanel = new JPanel();
//        view = af.makeView(model);
//        model.changed();
//
//        setLayout((new GridLayout(1, 2)));
//        add(controlPanel);
//        add(view);
//
//        view.setBackground(Color.WHITE);
//
//        frame = new JFrame();
//        Container cp = frame.getContentPane();
//        cp.add(this);
//        frame.setJMenuBar(createMenuBar());
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setTitle(af.getTitle());
//        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
//        frame.setLocationRelativeTo(null);
//    }
//
//    protected JMenuBar createMenuBar() {
//        JMenuBar result = new JMenuBar();
//        // add file, edit, and help menus
//        JMenu fileMenu =
//                Utilities.makeMenu("File", new String[] {"New",  "Save", "Save As", "Open", "Quit"}, this);
//        result.add(fileMenu);
//
//        JMenu editMenu =
//                Utilities.makeMenu("Edit", af.getEditCommands(), this);
//        result.add(editMenu);
//
//        JMenu helpMenu =
//                Utilities.makeMenu("Help", new String[] {"About", "Help"}, this);
//        result.add(helpMenu);
//
//        return result;
//    }
//
//    public void display() {
//        frame.setVisible(true);
//    }
//
//    @Override
//    public void propertyChange(PropertyChangeEvent evt){ }
//
//    public void actionPerformed(ActionEvent ae) {
//        try{
//            String cmmd = ae.getActionCommand();
//            Boolean saved = model.getUnsavedChanges();
//            switch(cmmd) {
//                case "Save":
//                    Utilities.save(model, false);
//                    break;
//                case "Save As":
//                    Utilities.save(model, true);
//                    break;
//                case "Open":
//                    if (!saved)
//                        saved = !Utilities.confirm("Open without saving?");
//                    if (saved) {
//                        String fName = Utilities.getFileName(null, true);
//                        ObjectInputStream is = new ObjectInputStream(new FileInputStream(fName));
//                        model = (Model) is.readObject();
//                        model.initSupport();
//                        view.setModel(model);
//                        model.changed();
//                        is.close();
//                    }
//                    break;
//                case "New":
//                    if (!saved)
//                        saved = !Utilities.confirm("Open without saving?");
//                    if (saved) {
//                        model = af.makeModel();
//                        view.setModel(model);
//                        model.changed();
//                    }
//                    break;
//                case "Quit":
//                    if (!saved)
//                        saved = !Utilities.confirm("Exit without saving?");
//                    if (saved) {
//                        System.exit(1);
//                    }
//                    break;
//                case "About":
//                    Utilities.inform(af.about());
//                    break;
//                case "Help":
//                    Utilities.inform(af.getHelp());
//                    break;
//                default:
//                    for (String s : af.getEditCommands()) {
//                        if (cmmd == s) {
//                            af.makeEditCommand(model, cmmd, null).execute();
//                        }
//                    }
//            }
//        }catch (Exception e) {
//            handleException(e);
//        }
//        revalidate();
//        repaint();
//    }
//
//    protected void handleException(Exception e){
//        Utilities.error(e);
//    }
//}
