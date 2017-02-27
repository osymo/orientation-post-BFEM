package ClasseDeRequete;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import ClasseDeBase.Surveillant;
import ClasseDeRequete.SurveillantStatement.AllData;


public class AdminStatement {
	static Connection conn = Connect.connection();
	static Statement state;
	static ResultSet result;
	
	public static AllData SelectAllSurveillant() {
		AllData surveillant = null;
		try {
			state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			result = state.executeQuery("SELECT * FROM surveillant");
			ResultSetMetaData meta = result.getMetaData();
			int i = 0;
			while(result.next()){
				i++;
			}
			result.beforeFirst();
			String[] title = new String[meta.getColumnCount()];
			Object[][] obj = new Object[i][];
			for (int j = 1; j <= meta.getColumnCount(); j++) {
				title[j - 1] = meta.getColumnName(j);
			}
			Object[] creer = new Object[meta.getColumnCount()];
			int s=0;
			while (result.next()) {
				for (int j = 1; j <= meta.getColumnCount(); j++) {
					creer[j-1] = result.getObject(j).toString();
				}
				obj[s] = creer;
				creer = creer.clone();
				s++;
			}
			surveillant = new AllData(title, obj);
			state.close();
			result.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return surveillant;
	}
	public static boolean addSurveillant(Surveillant s){
		try {
			state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			state.executeUpdate("INSERT INTO surveillant VALUES('" + s.getNoss() + "','" + s.getPrenom() + "','" 
					+ s.getNom() + "' ,'" + s.getLogin() + "','"
					+ s.getPassword() + "'," + s.getPhone() + ",'" + s.getEmail() + "','"+s.getEtablissement()+"'"+")");
			state.close();
			return true;
		} catch (SQLException e) {
		}
		return false;
	}
	public static boolean removeSurveillant(String noss){
		try {
			state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			state.executeUpdate("DELETE FROM surveillant WHERE noss='"+noss+"'");
			state.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}	
	}
	public static boolean UpdateSurveillant(int noss,Surveillant s){
		try {
			state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			state.executeUpdate("UPDATE surveillant SET noss='"+ s.getNoss() + "',sur_prenom='" + s.getPrenom() + "',sur_nom='"
					+ s.getNom() + "',sur_login='" + s.getLogin() + "',sur_password='" + s.getPassword() + "',sur_telephone="
					+ s.getPhone()+",sur_email='"+ s.getEmail()+"',Etablissement_sur='"+s.getEtablissement() +"' WHERE noss="+noss);
			state.close();
			return true;
		} catch (Exception e2) {
			return false;
		}
	}
	public static Surveillant findSurveillant(int noss){
		Surveillant s = null;
		try {
			state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			result = state.executeQuery("SELECT * FROM surveillant WHERE num_sur="+noss);
			result.first();
			s = new Surveillant(result.getObject(1).toString(),result.getObject(2).toString(),result.getObject(3).toString(),
					result.getObject(4).toString(), result.getObject(5).toString(), result.getObject(6).toString(),noss+"", 
					result.getObject(8).toString());
			state.close();
		} catch (SQLException e1) {
		}
		return s;
	}
	public  static boolean changeProfile(String noss,String newLogin,String newPassword){
		try {
			state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			state.executeUpdate("UPDATE surveillant SET sur_login='"+newLogin+"', sur_password='"+newPassword+"' WHERE noss='"+noss+"'");
			state.close();
			return true;
		} catch (Exception e2) {
			return false;
		}
	}
	public static int studentCount(){
		int i = 0;
		try {
			state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			result = state.executeQuery("SELECT * FROM eleve");
			while(result.next()){
				i++;
			}
		} catch (Exception e) {
		}
		return i;
	}
	
	public static int surveillantCount(){
		int i = 0;
		try {
			state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			result = state.executeQuery("SELECT * FROM surveillant");
			while(result.next()){
				i++;
			}
		} catch (Exception e) {
		}
		return i;
	}
	public static int studentCount(String serie){
		int i = 0;
		try {
			state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			result = state.executeQuery("SELECT * FROM eleve WHERE serie_oriente='"+serie+"'");
			while(result.next()){
				i++;
			}
		} catch (Exception e) {
		}
		return i;
	}
	
	
}







