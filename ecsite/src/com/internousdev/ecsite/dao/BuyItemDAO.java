package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.util.DBConnector;

public class BuyItemDAO {

	public BuyItemDTO getBuyItemInfo(){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		BuyItemDTO buyItemDTO = new BuyItemDTO();

		String sql = "SELECT id,item_name,item_price FROM item_info_transaction";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				buyItemDTO.setId(rs.getInt("id"));
				buyItemDTO.setItemName(rs.getString("item_name"));
				buyItemDTO.setItemPrice(rs.getString("item_price"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return buyItemDTO;
	}
	//item_stock(在庫)からcount(購入個数)を引き、その結果のヒット件数をBuyItemActionに返す。
	public int checkUnique(String count, String id){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int num = 0;

		String sql = "SELECT * FROM item_info_transaction WHERE item_stock - ? >= 0 AND item_name = ?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, count);
			ps.setString(2, id);
			ResultSet rs = ps.executeQuery();
			//select文のヒット件数を確認している。
			//ヒット件数確認方法が不明だったため、右記URLを参考にしている。https://hacknote.jp/archives/15721/
			rs.last();
			num = rs.getRow();
			rs.beforeFirst();
		}catch(Exception e){
			e.printStackTrace();
		}
		return num;
	}

	//item_stock(在庫)からcount(購入個数)を引き、その結果のヒット件数をBuyItemActionに返す。
	public int checkStock(String id){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int num = 0;

		String sql = "SELECT item_stock FROM item_info_transaction WHERE  id = ?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				num = rs.getInt("item_stock");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return num;
	}
}
