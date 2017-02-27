package ClasseDeRequete;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import ClasseDeBase.Surveillant;

public class ConnectionStatement {
	static Connection conn = Connect.connection();
	static Statement state;
	static ResultSet result;
	
	public static boolean adminIsRight(String log,String pass){
		try {
			state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			result = state.executeQuery("SELECT admin_login,admin_password FROM admin");
			result.first();
			String lr = result.getObject(1).toString();
			String pr = result.getString(2).toString();
			if(lr.equals(log) && pr.equals(pass))
				return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	public static Surveillant survIsRight(String login,String password){
		Surveillant surveillant = null;
		try {
			state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			result = state.executeQuery("SELECT * FROM surveillant");
			while (result.next()) {
				if(login.equals(result.getObject(4).toString()) && password.equals(result.getObject(5).toString())){
					surveillant  = new Surveillant(result.getObject(2).toString(), result.getObject(3).toString(),
							result.getObject(5).toString(), result.getObject(4).toString(), result.getObject(6).toString(), result.getObject(7).toString(), result.getObject(1).toString(), result.getObject(8).toString());
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Erreur lors de l'enregistrement");
		}
		return surveillant;
	}
}



















