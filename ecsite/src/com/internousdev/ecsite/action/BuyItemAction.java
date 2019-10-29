package com.internousdev.ecsite.action;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;
	private BuyItemDAO buyItemDAO = new BuyItemDAO();
	private int count;
	private String pay;
	private String errorMessage;

	public String execute() throws SQLException{
		String result = SUCCESS;
		session.put("count", count);
		int intCount = Integer.parseInt(session.get("count").toString());
		int intPrice = Integer.parseInt(session.get("buyItem_price").toString());
    	//ヒット件数がないならERRORを返しページが進まずerrorMessageが追加されたbuyItem.jspを返す。
//    	int num = buyItemDAO.checkUnique(session.get("count").toString(), session.get("id").toString());
//    	if (num < 1){
//    		result = ERROR;
//    		errorMessage = "在庫が足りません。";
//    	}
		int itemStockByDB = buyItemDAO.checkStock(session.get("id").toString());

		if(itemStockByDB < intCount) {
			result = ERROR;
    		errorMessage = "在庫が足りません。";
		}
		session.put("total_price", intCount * intPrice);
		String payment;
		if(pay.equals("1")){

			payment = "現金払い";
			session.put("pay", payment);
		}else{

			payment = "クレジットカード";
			session.put("pay", payment);
		}

		return result;
	}
	public void setCount(int count){
		this.count = count;
	}
	public void setPay(String pay){
		this.pay = pay;
	}
	public Map<String, Object> getSession(){
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
	public String getErrorMessage(){
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage){
		this.errorMessage = errorMessage;
	}
}
