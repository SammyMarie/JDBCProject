package uk.co.sammy.mainClass;

import uk.co.sammy.tables.TradeInfoBean;
import uk.co.sammy.tables.TradeManager;
import uk.co.sammy.utilities.DBType;
import uk.co.sammy.utilities.InputHelper;
import static java.lang.System.*;
import java.sql.SQLException;

public class MainTest {

	public static void main(String... args) throws SQLException{
		
		out.println("Starting Application...");
		
		ConnectionManager.getInstance().setDBType(DBType.MYSQL);
		
		String trading = InputHelper.getStringInput("Enter Trade Company : ");
		
		int display = InputHelper.getInputs("Enter 1 to display all rows, 2 to display a single row: ");
		
		switch (display) {
		
			case 1:
				TradeManager.displayAllRows(trading);
				break;
				
			case 2:
				
				TradeInfoBean beans = TradeManager.getRow(trading);
				
				if (beans == null) {
					
					err.println("Now rows were found!");
				} else {
					
					out.println("Trades_ID: " + beans.getTrades_ID());
					out.println("TradingCompany: " + beans.getCompanyName());
					out.println("TradeQuantity: " + beans.getTradeQuantity());
					out.println("TradeActivity: " + beans.getTradeActivity());
					out.println("TradeTime: " + beans.getTradeTime());
				}
				
			default:
				break;
		}		
		
		ConnectionManager.getInstance().close();
	}
}
