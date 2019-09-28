package models;


public class Table {

    Integer tableID;

	String tableNum;


	public Table(Integer tableID, String tableNum) {
		super();
		this.tableID = tableID;
		this.tableNum = tableNum;
	}

	public Table()
    {
        	
    }

	public Integer getTableID() {
		return tableID;
	}

	public void setTableID(Integer tableID) {
		this.tableID = tableID;
	}

	public String getTableNum() {
		return tableNum;
	}

	public void setTableNum(String tableNum) {
		this.tableNum = tableNum;
	}
    


}
   