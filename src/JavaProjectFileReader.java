import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;




public class JavaProjectFileReader extends JFrame implements ActionListener{
	
		JFrame f;   
		JMenuBar mb;   
		JMenu file, edit, help ; 
		JMenuItem cut, copy, paste, selectAll,new1, open,save,exit,about,contactUs;   
		JTextArea write;
		String output="";
		JScrollPane pane;
		
	
		
	  
	JavaProjectFileReader()
	{
		f = new JFrame("Tuxum"); 
		pane=new JScrollPane(write);
		
		//file option
		new1 = new JMenuItem("New");
		open = new JMenuItem("Open");
		save = new JMenuItem("Save");
		exit = new JMenuItem("Exit");
		
		// edit option
		selectAll = new JMenuItem("Select all");
		cut = new JMenuItem("Cut");     
		copy = new JMenuItem("Copy");      
		paste = new JMenuItem("Paste");       
		
		
		//help option
		contactUs = new JMenuItem("Contact Us");
		about = new JMenuItem("About");
		
		
	       
	       
	       
	       
	       
		//Action events
		new1.addActionListener(this);
		open.addActionListener(this);
		save.addActionListener(this);
		exit.addActionListener(this);
		cut.addActionListener(this);      
		copy.addActionListener(this);      
		paste.addActionListener(this);       
		selectAll.addActionListener(this);   
		contactUs.addActionListener(this);
		about.addActionListener(this);
		
		mb = new JMenuBar();       
		mb.setBounds(5, 5, 460, 15);  
		
		file = new JMenu("File");        
		edit = new JMenu("Edit");        
		help = new JMenu("Help");
		
		file.add(new1);
		file.add(open);
		file.add(save);
		file.add(exit);
		
		edit.add(selectAll);
		edit.add(cut);      
		edit.add(copy);     
		edit.add(paste);     
		 
		help.add(about);
		help.add(contactUs);
	
		mb.add(file);   
   		mb.add(edit);   
		mb.add(help); 
		
		write = new JTextArea();     
		write.setBounds(5, 30, 460, 460);     
		
		f.add(mb);    
		 
		
		f.setLayout(null);     
		f.setSize(487,487);   
		f.setVisible(true);
	
    	JScrollPane scroll= new JScrollPane(write);
    	scroll.setBounds(5, 30, 460, 460);
    	f.add(scroll);
	
		
		
	      
	
	}

	
	public void actionPerformed(ActionEvent e) {
		
		
		//action for file_contain
		if (e.getSource() == new1)
		{
			output="";
			write.setText(null);
		}
		
		//to save data
		if (e.getSource() == save)
		{
			JFileChooser choose=new JFileChooser();
			choose.showSaveDialog(null);
	    	try{
	    	    PrintWriter writer = new PrintWriter(choose.getSelectedFile());
	    	    writer.println(write.getText());
	    	   
	    	    writer.close();
	    	} catch (IOException e1) {
	    	   
	    	}
		}
		
		
		// to open txt file
		if (e.getSource() == open)
		{
			JFileChooser choose=new JFileChooser();
			choose.showOpenDialog(getJMenuBar());
			choose.setDialogTitle(output);
		    InputStream is = null;
			try {
				is = new FileInputStream(choose.getSelectedFile());
				int length=is.available();
				
				for (int i=0;i<length;i++)
				{
					output=output+(char)is.read();
				}
				
				is.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			write.setText(output);
			output="";
		}
		
		//for exit
		if (e.getSource() == exit)
		{
			 System.exit(0);
		}
		
		//action for edit_contain
		if (e.getSource() == selectAll) 
		{           
			write.selectAll();        
		}
		if (e.getSource() == cut) 
		{   
			write.cut();     
		}        
		if (e.getSource() == paste) 
		{            
			write.paste();        
		}        
		if (e.getSource() == copy)
		{         
			write.copy(); 
			
		}  
		if (e.getSource() == file)
		{         
			write.copy();        
		}
		
		//action for help_contain
		if (e.getSource() == about) 
		{           
			String aboutTuxum="Version 1.1\n \t \t \t \t Tusum by Blaze Rule ";
			JOptionPane.showMessageDialog( null,aboutTuxum,
	                "Tuxum", JOptionPane.PLAIN_MESSAGE );
		}
		
		if (e.getSource() == contactUs) 
		{           
			String contactTuxum="Er.Krishesh Shrestha\nshrestha.krishesh@gmail.com\n*17122*9804185934*100#";        
			JOptionPane.showMessageDialog( null,contactTuxum,
	                "Contact", JOptionPane.PLAIN_MESSAGE );
		}
	}
	 
	


	public static void main(String[] args) {      
	    	new JavaProjectFileReader();     
	 }

}
