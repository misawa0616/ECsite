package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dao.UserListDAO;
import com.internousdev.ecsite.dto.UserListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListDeleteCompleteAction extends ActionSupport {
	private UserListDAO userListDAO = new UserListDAO();
	private ArrayList<UserListDTO> userList = new ArrayList<UserListDTO>();
	private String message;

	public String delete() throws SQLException{
		int res = userListDAO.UserDelete();
		if(res > 0){
			userList = null;
			setMessage("ユーザー情報を正しく削除しました。");
		}else if(res == 0){
			setMessage("ユーザー情報の削除に失敗しました。");
		}
		String result = SUCCESS;
		return result;
	}
	public ArrayList<UserListDTO> getUserList(){
		return this.userList;
	}
	public String getMessage(){
		return this.message;
	}
	public void setMessage(String message){
		this.message = message;
	}
}