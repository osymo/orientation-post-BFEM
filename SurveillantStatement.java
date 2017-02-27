package ClasseDeRequete;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import ClasseDeBase.Eleve;
import ClasseDeBase.Serie;

public class SurveillantStatement {
	static Connection conn = Connect.connection();
	static Statement state;
	static ResultSet result;

	public static boolean insertStudent(Eleve e,String serie_orientee) {
		try {
			int i=incrementNbrPlacee(serie_orientee);
			if(i==-1)
				return false;
			state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			state.executeUpdate("INSERT INTO eleve VALUES(" + e.getNumeroTable() + ",'" + e.getPrenom() + "','" 
					+ e.getNom() + "'," + e.getMoyenneClasse() + ",'" + e.getDateNaissance() + "','"
					+ e.getLieuNaissance() + "','" + e.getEtablissement() + "','" + e.getProfil() + "','"+serie_orientee+"'"+")");
			
			state.close();
			return true;
		} catch (SQLException e1) {
		}
		return false;
	}
	public static Eleve findStudent(int num){
		Eleve e = null;
		try {
			state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			result = state.executeQuery("SELECT * FROM eleve WHERE num_table="+num);
			result.first();
			e = new Eleve(num,result.getObject(2).toString(),result.getObject(3).toString(),Integer.parseInt(result.getObject(4).toString()),
					result.getObject(5).toString(), result.getObject(6).toString(), result.getObject(7).toString(), 
					result.getObject(8).toString(),result.getObject(9).toString());
			state.close();
		} catch (SQLException e1) {
		}
		return e;
	}
	//called for displaying all student 
	public static AllData SelectAllStudent(String etablissement) {
		AllData student = null;
		try {
			state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			result = state.executeQuery("SELECT * FROM eleve WHERE Etabli_el = '" + etablissement+"'");
			ResultSetMetaData meta = result.getMetaData();
			int i = 0;
			while(result.next()){
				i++;
			}
			result.beforeFirst();
			String[] title = {"Numéro","Prénom","Nom","Moyenne","Date Naissance","Lieu Naissance","Ecole","Profil","Série"};
			Object[][] obj = new Object[i][];
//			for (int j = 1; j <= meta.getColumnCount(); j++) {
//				title[j - 1] = meta.getColumnName(j);
//			}
			Object[] creer = new Object[meta.getColumnCount()];
			int s=0;
			while (result.next()) {
				for (int j = 1; j <= meta.getColumnCount(); j++) {
					creer[j-1] = result.getObject(j).toString();
				}
				obj[s] = creer;
				creer = creer.clone();
				++s;
			}
			student = new AllData(title, obj);
			state.close();
			result.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return student;
	}
	//for deleting a student
	public static boolean removeStudent(int id){
		try {
			state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			state.executeUpdate("DELETE FROM eleve WHERE num_table="+id);
			state.close();
			return true;
		} catch (Exception e) {
			return false;
		}	
	}
	//for updating a student
	public static boolean UpdateEleve(String oldSerie,int num,Eleve e){
		try {
			System.out.println(oldSerie);
			System.out.println(e.orienter());
			removeStudent(num);
			decrementNbrPlacee(oldSerie);
			if(e.orienter().equals("plein")){
				 insertStudent(e, oldSerie);
				return false;
			}
			boolean success = insertStudent(e, e.orienter());
			if(!success){
				JOptionPane.showMessageDialog(null, "Le numéro de table existe déjà", "Erreur !",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
			return true;
		} catch (Exception e2) {
			return false;
		}
	}
	//for seeing student in a domain
	public static AllData SelectStudentFromSerie(String etablissement, String serie){
		AllData student = null;
		try {
			state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			result = state.executeQuery("SELECT * FROM eleve WHERE serie_oriente = '"+serie+"' AND Etabli_el='"+etablissement+"'");
			ResultSetMetaData meta = result.getMetaData();
			int i = 0;
			while(result.next()){
				i++;
			}
			result.beforeFirst();
			String[] title = {"Numéro","Prénom","Nom","Moyenne","Date Naissance","Lieu Naissance","Ecole","Profil","Série"};
			Object[][] obj = new Object[i][];
			/*for (int j = 1; j <= meta.getColumnCount(); j++) {
				title[j - 1] = meta.getColumnName(j);
			}*/
			Object[] creer = new Object[meta.getColumnCount()];
			int s=0;
			while (result.next()) {
				for (int j = 1; j <= meta.getColumnCount(); j++) {
					creer[j-1] = result.getObject(j).toString();
				}
				obj[s] = creer;
				s++;
			}
			student = new AllData(title, obj);
			state.close();
			result.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}
	public static class AllData {
		private String[] title;
		private Object[][] tableau;
		
		public AllData(String[] title, Object[][] tableau) {
			this.title = title;
			this.tableau = tableau;
		}
		public String[] getTitle() {
			return title;
		}

		public void setTitle(String[] title) {
			this.title = title;
		}

		public Object[][] getTableau() {
			return tableau;
		}

		public void setTableau(Object[][] tableau) {
			this.tableau = tableau;
		}
	}
	//returning max_places for each serie
	public static boolean getMaxPlace(Serie serie){
		try {
			
			state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			result = state.executeQuery("SELECT nbr_places,nbr_places_occupees from serie WHERE nom_serie='"+serie.getSerie()+"'");
			result.first();
			int nbr_max = Integer.parseInt(result.getObject(1).toString());
			int nbr_occupees = Integer.parseInt(result.getObject(2).toString());
			int res = nbr_max-nbr_occupees;
			state.close();
			result.close();
			if(res<=0)
				return false;
			else
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//update nbr_places_ocuppees when we insert a student
	public static int incrementNbrPlacee(String s){
		try {
			state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			result = state.executeQuery("SELECT nbr_places_occupees from serie WHERE nom_serie='"+s+"'");
			result.first();
			int nbr_max = Integer.parseInt(result.getObject(1).toString());
			nbr_max+=1;
			state.executeUpdate("UPDATE serie SET nbr_places_occupees="+nbr_max+" WHERE nom_serie='"+s+"'");
			state.close();
			return 1;
		} catch (SQLException e) {
			return -1;
		}
	}
	public static void decrementNbrPlacee(String s){
		try {
			state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			result = state.executeQuery("SELECT nbr_places_occupees from serie WHERE nom_serie='"+s+"'");
			result.first();
			int nbr_max = Integer.parseInt(result.getObject(1).toString());
			nbr_max-=1;
			state.executeUpdate("UPDATE serie SET nbr_places_occupees="+nbr_max+" WHERE nom_serie='"+s+"'");
			state.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


//number of student in  serie
	public static int numberOfStudent(String etablissement, String serie){
		int i = 0;
		try {
			state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			result = state.executeQuery("SELECT * FROM eleve WHERE serie_oriente = '"+serie+"' AND Etabli_el='"+etablissement+"'");
			while(result.next()){
				i++;
			}
		} catch (Exception e) {
		}
		return i;
	}

//number of student 
	public static int studentCount(String etablissement){
		int i = 0;
		try {
			state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			result = state.executeQuery("SELECT * FROM eleve WHERE Etabli_el='"+etablissement+"'");
			while(result.next()){
				i++;
			}
		} catch (Exception e) {
		}
		return i;
	}
//les eleves ayant reusit suivant le tour premier moyenne ou deuxieme
public static AllData reussit(String etablissement, String serie,String tour){
		AllData student = null;
		try {
			state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			result = state.executeQuery("SELECT * FROM eleve WHERE serie_oriente = '"+serie+"', Etabli_el='"+etablissement+"' AND profil='"+tour+"'");
			ResultSetMetaData meta = result.getMetaData();
			int i = 0;
			while(result.next()){
				i++;
			}
			result.beforeFirst();
			String[] title = {"Numéro","Prénom","Nom","Moyenne","Date Naissance","Lieu Naissance","Ecole","Profil","Série"};
			Object[][] obj = new Object[i][];
			/*for (int j = 1; j <= meta.getColumnCount(); j++) {
				title[j - 1] = meta.getColumnName(j);
			}*/
			Object[] creer = new Object[meta.getColumnCount()];
			int s=0;
			while (result.next()) {
				for (int j = 1; j <= meta.getColumnCount(); j++) {
					creer[j-1] = result.getObject(j).toString();
				}
				obj[s] = creer;
				s++;
			}
			student = new AllData(title, obj);
			state.close();
			result.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}
}
