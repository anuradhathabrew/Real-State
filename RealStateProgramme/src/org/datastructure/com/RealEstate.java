package org.datastructure.com;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.swing.JFrame;
import javax.swing.JOptionPane;




//import org.eclipse.swt.widgets.Decorations;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.graphics.Point;
//import org.omg.CORBA.Object;


public class RealEstate extends javax.swing.JFrame{
	
	
	public static Text textLotNumber;
	public static Text textFirstName;
	public static Text textLastName;
	public static Text textPrice;
	public static Text textSquareFeet;
	public static Text textNumberOfBedRooms;

	private static Label lblNextHouseDisplayed;
	private static Label lblLotNumber;
	private static Label lblFirstNumber;
	private static Label lblLastName;
	private static Label lblPrice;
	private static Label lblSquareFeet;
	private static Label label;
	
	private static Button btnReset;
	private static Button btnNext;
	private static Button btnAdd;
	private static Button btnDelete;
	private static Button btnSortedList;
	private static Button btnFind;
	      
	
	
	private List<House> houses;
    private int row = 0;
    private Boolean checkAdd = true;
	
	public RealEstate(){
		initComponents();
		setLocationRelativeTo(null);

        House fm = new House();
        houses = fm.readFile();
	}

	private void initComponents(){
		
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setMinimumSize(new Point(447, 533));
		shell.setImage(SWTResourceManager.getImage("C:\\Users\\user\\workspace\\RealStateProgramme\\icon\\RealEstate.ico"));
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		shell.setSize(432, 533);
		//this.setMaximumSize(new Dimension(447 , 533));
		shell.setText("Real Estate Programme");
		
		//setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		
		lblNextHouseDisplayed = new Label(shell, SWT.NONE);
		lblLotNumber = new Label(shell, SWT.RIGHT);
		lblFirstNumber = new Label(shell, SWT.RIGHT);
		lblLastName = new Label(shell, SWT.RIGHT);
		label = new Label(shell, SWT.RIGHT);
		lblPrice = new Label(shell, SWT.RIGHT);
		lblSquareFeet = new Label(shell, SWT.RIGHT);
		
		btnReset = new Button(shell, SWT.NONE);
		btnNext = new Button(shell, SWT.NONE);
		btnAdd = new Button(shell, SWT.NONE);
		btnDelete = new Button(shell, SWT.NONE);
		btnSortedList = new Button(shell, SWT.NONE);
		btnFind = new Button(shell, SWT.NONE);

		textFirstName = new Text(shell, SWT.BORDER | SWT.MULTI);
		textLastName = new Text(shell, SWT.BORDER | SWT.MULTI);
		textLotNumber = new Text(shell, SWT.BORDER | SWT.MULTI);
		textPrice = new Text(shell, SWT.BORDER | SWT.MULTI);
		textSquareFeet = new Text(shell, SWT.BORDER | SWT.MULTI);
		textNumberOfBedRooms = new Text(shell, SWT.BORDER | SWT.MULTI);
		
		
		
		lblNextHouseDisplayed.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		lblNextHouseDisplayed.setForeground(SWTResourceManager.getColor(30, 144, 255));
		lblNextHouseDisplayed.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		lblNextHouseDisplayed.setBounds(10, 10, 411, 21);
		lblNextHouseDisplayed.setText("Next House Displayed");
		
		
		lblLotNumber.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		lblLotNumber.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblLotNumber.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		lblLotNumber.setBounds(49, 63, 152, 21);
		lblLotNumber.setText("Lot Number:");
		
		
		lblFirstNumber.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		lblFirstNumber.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblFirstNumber.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		lblFirstNumber.setBounds(110, 116, 91, 21);
		lblFirstNumber.setText("First Name:");
		
		lblLastName.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		lblLastName.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblLastName.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		lblLastName.setBounds(110, 170, 91, 21);
		lblLastName.setText("Last Name:");		
		
		lblPrice.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		lblPrice.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblPrice.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		lblPrice.setBounds(151, 223, 50, 21);
		lblPrice.setText("Price:");		
		
		lblSquareFeet.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		lblSquareFeet.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblSquareFeet.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		lblSquareFeet.setBounds(33, 329, 168, 21);
		lblSquareFeet.setText("Number of Bedrooms:");
		
		
		btnReset.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				btn_ResetActionPerformed(e);
			}
		});
		
		
		btnReset.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD));
		btnReset.setBounds(0, 369, 216, 40);
		btnReset.setText("Reset");
		
		
		btnNext.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				btn_nextActionPerformed(e);
			}
		});
		btnNext.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD));
		btnNext.setText("Next");
		btnNext.setBounds(218, 369, 213, 40);
		
		
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				btn_addActionPerformed(e);
				/*//set data to house file 
				House house =new House();
				house.setFirstName(textFirstName.getText());
				house.setLastName(textLastName.getText());
				house.setLotNumber(textLotNumber.getText());
				house.setNumberOfBedRooms(textNumberOfBedRooms.getText());
				house.setPrice(textPrice.getText());
				house.setSquareFeet(textSquareFeet.getText());
				house.writeTofile();
				
				List<House> houseList=null;
				houseList= (List<House>) house.readFile();
				int i=1;
				for ( House house1 : houseList) {
			        System.out.println("House #"+i+" Lot Number : " +house1.getLotNumber()+"  "+" Price  : "+house1.getPrice());
			        i++;
				}
				
				
				SortedList sortdata = new SortedList();
				
				sortdata.setFirstNameL(textFirstName.getText());
				sortdata.setLastNameL(textLastName.getText());
				sortdata.setLotNumberL(textLotNumber.getText());
				sortdata.setSquareFeetL(textSquareFeet.getText());
				sortdata.setPriceL(textPrice.getText());
				sortdata.setNumberOfBedRoomsL(textNumberOfBedRooms.getText());
				
				
				//put data into array list
//				ArrayList<String> mylist = new ArrayList<String>();
//				mylist.addAll(0,sortdata.setFirstNameL(textFirstName.getText()));
//				mylist.addAll(1,sortdata.setLastNumberL(textLastNumber.getText()));
//				mylist.addAll(2,sortdata.setLotNumberL(textLastNumber.getText()));
//				mylist.addAll(3,sortdata.setSquareFeetL(textLastNumber.getText()));
//				mylist.addAll(4,sortdata.setPriceL(textLastNumber.getText()));
//				mylist.addAll(5,sortdata.setNumberOfBedRoomsL(textLastNumber.getText()));
				
//				
*/				
				
				}
		});
		
		
		btnAdd.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD));
		btnAdd.setText("Add");
		btnAdd.setBounds(0, 410, 216, 40);
		/*btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
			}
		});*/
		
		
		btnDelete.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				btn_deleteActionPerformed(e);
			}
		});
		btnDelete.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD));
		btnDelete.setText("Delete");
		btnDelete.setBounds(218, 410, 213, 40);
		
		
		btnSortedList.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				btn_sortedListActionPerformed(e);
			}
		});
		btnSortedList.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD));
		btnSortedList.setText("Sorted List");
		btnSortedList.setBounds(0, 451, 216, 40);
		
		
		btnFind.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				btn_findActionPerformed(e);
			}
		});
		btnFind.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD));
		btnFind.setText("Find");
		btnFind.setBounds(218, 451, 213, 40);
		
		
		textLotNumber.setBounds(207, 50, 214, 47);
		
		textFirstName.setBounds(207, 103, 214, 47);
		
		textLastName.setBounds(207, 157, 214, 47);
				
		textPrice.setBounds(207, 210, 214, 47);
				
		textSquareFeet.setBounds(207, 263, 214, 47);
		
		
		label.setText("Square Feet:");
		label.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		label.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		label.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		label.setBounds(106, 276, 95, 21);
		
		
		textNumberOfBedRooms.setBounds(207, 316, 214, 47);

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	/**
	 * Main Function of the Application .....
	 */
	public static void main(String[] args) {
		
		java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RealEstate().setVisible(true);
                /*
                RealEstate myFrame = new RealEstate();
                myFrame.setVisible(true);
                myFrame.setExtendedState(myFrame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
                */
            }
        });
		
	}


	
	private void btn_ResetActionPerformed(SelectionEvent e){
		
		textFirstName.setText("");
        textLastName.setText("");
        textLotNumber.setText("");
        textPrice.setText("");
        textSquareFeet.setText("");
        textNumberOfBedRooms.setText("");
        
        
		lblNextHouseDisplayed.setText("Next House Displayed : ");

        row = 0;

        checkAdd = true;
	}


	
	private void btn_nextActionPerformed(SelectionEvent evt) {

        checkAdd = false;
        
        houses = new House().readFile();
        if (!(houses.isEmpty())) {
            House house = houses.get(row);
            lblNextHouseDisplayed.setText("Next House Displayed : " + (row + 1));

            textFirstName.setText(house.getFirstName());
            textLastName.setText(house.getLastName());
            textLotNumber.setText(house.getLotNumber() + "");
            textNumberOfBedRooms.setText(house.getNumberOfBedRooms() + "");
            textPrice.setText(house.getPrice() + "");
            textSquareFeet.setText(house.getSquareFeet() + "");

            Integer i = houses.size();
            if (--i != row) {
                row++;
            }
        }
    }//event_btn_nextActionPerformed

    private void btn_addActionPerformed(SelectionEvent evt) {
    	
        if (checkAdd && !(textLotNumber.getText().equals(""))) {

            House house = new House();
            house.setFirstName(textFirstName.getText());
            house.setLastName(textLastName.getText());
            house.setLotNumber(textLotNumber.getText());
            house.setNumberOfBedRooms(textNumberOfBedRooms.getText());
            house.setPrice(textPrice.getText());
            house.setSquareFeet(textSquareFeet.getText());
            /*
            house.setLotNumber(Long.parseLong(textLotNumber.getText()));
            house.setNoOfBedroom(Integer.parseInt(textNumberOfBedRooms.getText()));
            house.setPrice(Long.parseLong(textPrice.getText()));
            house.setSquareFeet(Long.parseLong(textSquareFeet.getText()));
            */
            
            Boolean bol = false;
            /////////////////////////////////////////////////  Meka balanna ///////////////////////////////////////////////
            houses = new House().readFile();
            for (House h : houses) {
            	if (Objects.equals(h.getLotNumber(), house.getLotNumber())) {
	                    bol = true;
	        	}
	        }

            if (bol) {
                JOptionPane.showMessageDialog(rootPane, "Error in Lot Number", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                House fm = new House();
                fm.saveHouseFile(house);

                House hf = new House();
                houses = hf.readFile();

                JOptionPane.showMessageDialog(rootPane, "Successfully Added", "Success", JOptionPane.INFORMATION_MESSAGE);

                clear();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "You need to rest befor add or Check Lot Number !", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//event_btn_addActionPerformed
 
    private void btn_deleteActionPerformed(SelectionEvent evt) {
    	
    	JOptionPane.showMessageDialog(rootPane, "Error No Recode Selected !", "Error", JOptionPane.QUESTION_MESSAGE );
    	
    	if (textLotNumber.getText().equals("")){
    		 JOptionPane.showMessageDialog(rootPane, "Lot Number can't be empty !", "Error", JOptionPane.WARNING_MESSAGE);
    	}
    	else if (checkAdd) {
            JOptionPane.showMessageDialog(rootPane, "Error No Recode Selected !", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            List<House> newList = new ArrayList<>();

            for (House h : houses) {
                if (!(h.getLotNumber().toString().equals(textLotNumber.getText()))) {
                    newList.add(h);
                }
            }

            JOptionPane.showMessageDialog(rootPane, "Successfully Delete", "Success", JOptionPane.INFORMATION_MESSAGE);

            textFirstName.setText("");
            textLastName.setText("");
            textLotNumber.setText("");
            textNumberOfBedRooms.setText("");
            textPrice.setText("");
            textSquareFeet.setText("");

            lblNextHouseDisplayed.setText("Next House Displayed : ");

            row = 0;

            checkAdd = true;
            System.out.println(newList.size());
            House hf = new House();
            hf.saveHouseList(newList);

            houses = hf.readFile();
        }
    }//event_btn_deleteActionPerformed

    private void btn_sortedListActionPerformed(SelectionEvent evt) {
    	
    	House hf = new House();
        houses = hf.readFile();
        
        ListHouse lh = new ListHouse(this, rootPaneCheckingEnabled,houses);
        ///////////////////////////////////////  Sorted Data window  ///////////////////////////////////////////////
        lh.setVisible(true);//lh.setVisible(true);

        //House hf = new House();
        //houses = hf.readFile();

        SortedList sl = new SortedList();
        sl.setHouses(houses);

        houses = sl.getShortHouses();

        hf.saveHouseList(houses);
    }//event_btn_sortedListActionPerformed

    private void btn_findActionPerformed(SelectionEvent evt) {

    	if (textLotNumber.getText().equals("")){
   		 JOptionPane.showMessageDialog(rootPane, "Lot Number can't be empty !", "Error", JOptionPane.WARNING_MESSAGE);
	   	}
	   	else{
	        textFirstName.setText("");
	        textLastName.setText("");
	        //        jTextField_lotNumber.setText("");
	        textNumberOfBedRooms.setText("");
	        textPrice.setText("");
	        textSquareFeet.setText("");
	
	        //lblNextHouseDisplayed.setText("Next House Displayed : ");
	
	        row = 0;
	
	        checkAdd = true;
	
	        try {
	            Long lotNumber = Long.parseLong(textLotNumber.getText());
	
	            House hf = new House();
	            List<House> houses = hf.readFile();
	            Boolean v = false;
	            //            System.out.println("l "+lotNumber);
	            for (House h : houses) {
	                    //System.out.println("s "+h.getLotNumber());
	            		//System.out.println(lotNumber + "-"+ h.getLotNumber());
	                if (Objects.equals(Long.parseLong(h.getLotNumber()),lotNumber)) {
	                    textFirstName.setText(h.getFirstName());
	                    textLastName.setText(h.getLastName());
	                    textNumberOfBedRooms.setText(h.getNumberOfBedRooms());
	                    textPrice.setText(h.getPrice());
	                    textSquareFeet.setText(h.getSquareFeet());
	                    lblNextHouseDisplayed.setText("Next House Displayed : " + h.getLotNumber());
	                    v = true;
	                }
	                
	            }
	
	            if (!v) {
	                JOptionPane.showMessageDialog(rootPane, "No Result to Show", "Information ", JOptionPane.INFORMATION_MESSAGE);
	            }
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(rootPane, "Lot number Error !", "Error ", JOptionPane.ERROR_MESSAGE);
	        }
   		}
    }//event_btn_findActionPerformed
    
    
    
    
    
    // Clear Controls in the form ..
    private void clear(){

    	textFirstName.setText("");
        textLastName.setText("");
        textLotNumber.setText("");
        textPrice.setText("");
        textSquareFeet.setText("");
        textNumberOfBedRooms.setText("");
        
        lblNextHouseDisplayed.setText("Next House Displayed : ");

        row = 0;

        checkAdd = true;
    }
}





















