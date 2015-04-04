package org.datastructure.com;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.datastructure.com.House;

//import org.eclipse.swt.widgets.Text;


public class House  {
	
	String  FirstName;
	String  lastName;
	String  lotNumber;
	String  price;
	String  squareFeet;
	String  numberOfBedRooms;
	
	
	public String getLotNumber() {
		return lotNumber;
	}
	public void setLotNumber(String lotNumber) {
		this.lotNumber = lotNumber;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getSquareFeet() {
		return squareFeet;
	}
	public void setSquareFeet(String squareFeet) {
		this.squareFeet = squareFeet;
	}
	public String getNumberOfBedRooms() {
		return numberOfBedRooms;
	}
	public void setNumberOfBedRooms(String numberOfBedRooms) {
		this.numberOfBedRooms = numberOfBedRooms;
	}
	
	
	

	/*
	
	public int writeTofileold(){
		try {
            File file = new File("HouseDetails");
            BufferedWriter output = new BufferedWriter(new FileWriter(file));
            output.write(this.lotNumber+"#"+this.FirstName+"#"+this.price+"#"+this.squareFeet+"#"+this.numberOfBedRooms);
            output.close();
            System.out.println("done");
        } catch (
        		IOException e ) {
            e.printStackTrace();
        }catch (Exception exp) {
        	exp.printStackTrace();
        }
		return 1;
	}
	public int writeTofile(){
		try(
				PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("HouseDetails", true)))) {
		    	out.println(this.lotNumber+"#"+this.FirstName+"#"+this.lastName+"#"+this.price+"#"+this.squareFeet+"#"+this.numberOfBedRooms);
		}catch (IOException e) {
		    //exception handling left as an exercise for the reader
		}
           
          
            System.out.println("done");
        
		return 1;
	}
	*/
	/*public List<House> readFile(){
		List<House> houseList = new ArrayList<House>();
		// The name of the file to open.
        String fileName = "HouseDetail.txt";
        // This will reference one line at a time
        String line = null;
        try {
        // FileReader reads text files in the default encoding.
        FileReader fileReader =
        new FileReader(fileName);
        // Always wrap FileReader in BufferedReader.
        BufferedReader bufferedReader =
        new BufferedReader(fileReader);
        while((line = bufferedReader.readLine()) != null) {
        	String [] objDetails=line.split("#");
        	House house =new House();
        	house.setLotNumber(objDetails[0]);
        	house.setFirstName(objDetails[1]);
        	house.setLastName(objDetails[2]);
        	house.setPrice(objDetails[3]);
        	house.setSquareFeet(objDetails[4]);
        	house.setNumberOfBedRooms(objDetails[5]);
        	houseList.add(house);
        	System.out.println(line);
        }
        // Always close files.
        bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
        System.out.println( "Unable to open file '" +fileName + "'");
        }
        catch(IOException ex) {
        System.out.println( "Error reading file '"+ fileName + "'");
        // Or we could just do this:
        // ex.printStackTrace();
        
        }
		return houseList;
	}*/
	//////////////////////////////////////////////////////////////////////////////////////////////
	public List<House> readFile() {
        List<House> houses = new ArrayList<>();
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("HouseDetails"));

            String line;
            while ((line = br.readLine()) != null) {
//                System.out.println("line " + line);
                String[] rows = line.split("\t");
//                System.out.println("rows " + Arrays.toString(rows));

                House house = new House();
                house.setLotNumber(rows[0]);
                house.setFirstName(rows[1]);
                house.setLastName(rows[2]);
                house.setPrice(rows[3]);
                house.setSquareFeet(rows[4]);
                house.setNumberOfBedRooms(rows[5]);

                houses.add(house);
            }

        } catch (FileNotFoundException e) {
            if (e.getMessage().equals("HouseData (The system cannot find the file specified)")) {
                BufferedWriter output = null;
                try {
                    File file = new File("HouseDetails");
                    output = new BufferedWriter(new FileWriter(file));
                } catch (IOException ex) {
                    Logger.getLogger(House.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        if (output != null) {
                            output.close();
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(House.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(House.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return houses;
    }

    public void saveHouseFile(House house) {
        try {
        	/*File file = new File("HouseDetails");
            BufferedWriter output = new BufferedWriter(new FileWriter(file));
            output.write(house.getLotNumber() + "\t" + house.getFirstName() + "\t" + house.getLastName() + "\t" + house.getPrice() + "\t" + house.getSquareFeet() + "\t" + house.getNumberOfBedRooms() + "\n");
            output.close();
            System.out.println("done");
            */
            FileWriter fw = new FileWriter("HouseDetails", true);
            fw.write(house.getLotNumber() + "\t" + house.getFirstName() + "\t" + house.getLastName() + "\t" + house.getPrice() + "\t" + house.getSquareFeet() + "\t" + house.getNumberOfBedRooms() + "\n");
            fw.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
    
     public void saveHouseList(List<House> house) {
        String text = "";
        for (House h : house) {
            text += h.getLotNumber() + "\t" + h.getFirstName() + "\t" + h.getLastName() + "\t" + h.getPrice() + "\t" + h.getSquareFeet() + "\t" + h.getNumberOfBedRooms() + "\n";
        }
//        System.out.println(text);
        try {
            BufferedWriter output = null;
            File file = new File("HouseDetails");
            output = new BufferedWriter(new FileWriter(file));
            output.write(text);
            output.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}

	
	

