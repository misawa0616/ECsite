package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class UserIdCheck {
	public boolean isExists;

	public boolean getUserId(String loginUserId) throws SQLException{
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "SELECT * FROM login_user_transaction WHERE login_id = ?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,loginUserId);
			ResultSet rs = ps.executeQuery();
			//レコードが存在した場合、isExistsはtrueを代入。存在しない場合、isExistsはFalseを代入。
			isExists = rs.next();

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return isExists;
	}
}
