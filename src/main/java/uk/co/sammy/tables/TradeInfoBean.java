package uk.co.sammy.tables;

import java.sql.Timestamp;

public class TradeInfoBean {

	private int tradesID;
	private String companyName;
	private String tradeActivity;
	private long tradeQuantity;
	private Timestamp TradeTime;
	
	public void setTrades_ID(int trades_ID) {
		this.tradesID = trades_ID;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public void setTradeActivity(String tradeActivity) {
		this.tradeActivity = tradeActivity;
	}
	
	public void setTradeQuantity(long tradeQuantity) {
		this.tradeQuantity = tradeQuantity;
	}
	
	public void setTradeTime(Timestamp tradeTime) {
		TradeTime = tradeTime;
	}
	
	public int getTrades_ID() {
		return tradesID;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	
	public String getTradeActivity() {
		return tradeActivity;
	}
	
	public long getTradeQuantity() {
		return tradeQuantity;
	}
	
	public Timestamp getTradeTime() {
		return TradeTime;
	}
}
