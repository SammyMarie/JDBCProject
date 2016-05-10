package uk.co.sammy.tables;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.lang.System.*;
import uk.co.sammy.utilities.DBConnector;
import uk.co.sammy.mainClass.ConnectionManager;

public class TradeManager {

	private static Connection conn = ConnectionManager.getInstance().getConnection();
	
	public static void displayAllRows(String tradeActivity) throws SQLException{
		
		String sqlQuery = "{call GetTradesByCompany(?)}";
		
		ResultSet rs = null;

		try (
				CallableStatement stmnt = conn.prepareCall(sqlQuery);
				){

			stmnt.setString(1, tradeActivity);
			rs = stmnt.executeQuery();
			
			while(rs.next()){

				StringBuffer buff = new StringBuffer();

				buff.append("Trades_ID: " + rs.getInt("Trades_ID"));

				buff.append("  TradingCompany: " + rs.getString("TradingCompany"));

				buff.append("   TradeQuantity: " + rs.getInt("TradeQuantity"));

				buff.append("   TradeActivity: " + rs.getString("TradeActivity")); 

				buff.append("   TradeTime: " + rs.getTimestamp("TradeTime"));

				out.println(buff.toString());
			}
			
		} catch (SQLException se) {

			DBConnector.processException(se);
		}finally{
			if(rs != null)
				rs.close();
		}
	}

	public static TradeInfoBean getRow(String tradeActivity) throws SQLException{
		
		String sqlQuery = "{call GetTradesByTradeActivity(?)}";

		ResultSet rs = null;

		try (
				CallableStatement stmnt = conn.prepareCall(sqlQuery);
				){

			stmnt.setString(1, tradeActivity);
			rs = stmnt.executeQuery();
			
			if (rs.next()) {
				
				TradeInfoBean tiBean = new TradeInfoBean();
				
				tiBean.setTrades_ID(rs.getInt("Trades_ID"));
				tiBean.setCompanyName(rs.getString("TradingCompany"));
				tiBean.setTradeQuantity(rs.getInt("TradeQuantity"));
				tiBean.setTradeActivity(tradeActivity);
				tiBean.setTradeTime(rs.getTimestamp("TradeTime"));
				
				return tiBean;
			} else {
				
				return null;
			}
		} catch (SQLException se) {

			DBConnector.processException(se);
			return null;
		}finally{
			if(rs != null)
				rs.close();
		}
	}
}
