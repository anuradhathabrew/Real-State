package org.datastructure.com;

import java.util.List;


public class SortedList{// extends javax.swing.JDialog{
	/*String  lastNameL;
	 String  priceL;
	 String  squareFeetL;
	 String  numberOfBedRoomsL;
	String  lotNumberL;
	
	String  firstNameL;
	 public String getFirstNameL() {
		return firstNameL;
	}
	public void setFirstNameL(String firstNameL) {
		this.firstNameL = firstNameL;
	}
	public String getLastNameL() {
		return lastNameL;
	}
	public void setLastNameL(String lastNameL) {
		this.lastNameL = lastNameL;
	}
	public String getPriceL() {
		return priceL;
	}
	public void setPriceL(String priceL) {
		this.priceL = priceL;
	}
	public String getSquareFeetL() {
		return squareFeetL;
	}
	public void setSquareFeetL(String squareFeetL) {
		this.squareFeetL = squareFeetL;
	}
	public String getNumberOfBedRoomsL() {
		return numberOfBedRoomsL;
	}
	public void setNumberOfBedRoomsL(String numberOfBedRoomsL) {
		this.numberOfBedRoomsL = numberOfBedRoomsL;
	}
	public String getLotNumberL() {
		return lotNumberL;
	}
	public void setLotNumberL(String lotNumberL) {
		this.lotNumberL = lotNumberL;
	}
	
	*/
	//////////////////////////////////////////////////////////////////////
	private List<House> houses;

    public void setHouses(List<House> houses) {
        this.houses = houses;
    }

    public List<House> getShortHouses() {

        for (int i = houses.size()-1; i >=0; i--) {
            for (int j = 0; j < houses.size()-1; j++) {
                if (Long.parseLong(houses.get(j).getLotNumber()) > Long.parseLong(houses.get(j+1).getLotNumber())) {
                    House house = houses.get(j);
                    houses.set(j, houses.get(j+1));
                    houses.set(j+1, house);
                }
            }
        }
        return houses;
    }
	
    
}