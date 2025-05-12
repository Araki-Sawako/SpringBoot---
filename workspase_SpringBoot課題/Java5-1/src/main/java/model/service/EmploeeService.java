package model.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import model.bean.EmployeeBean;

public class EmploeeService {
	
	public EmployeeBean employeeData;

	/**
	 * ・社員情報管理サービス
	 * 
	 * @authors.nanaumi
	 * @simce 2019/03/15
	 * 
	 */
	
	public class EmployeeService{
		
		/** ドライバーのクラス名 */
		private static final String POSTGRES_DRIVER="org.postgresql.Driver";
		/** ・JDMC接続先情報（※ポート番号【5432】は環境によって異なる場合があります）*/
		private static final String JDBC_CONNECTION= "jdbc:postgresql://localhost:5432/lesson_db";
		/** ・ユーザー名 */
		private static final String USER="postgres";
		/** ・パスワード */
		private static final String PASS="postgres";
		/** ・タイムフォーマット */
		private static final String TIME_FORMAT="yyyy/MM/dd hh:mm:ss";
		
		EmployeeBean emploeeData=null;
		
		//送信されたIDとPassWordを元に社員情報を検索するためのメソッド
		public EmployeeBean search(String id,String password) {
			
			Connection connection =null;
			Statement statement =null;
			ResultSet resultSet =null;
			
			try {
				//データベースに接続
				Class.forName(POSTGRES_DRIVER);
				connection=DriverManager.getConnection(JDBC_CONNECTION, USER, PASS);
				statement=connection.createStatement();
				
				//ログインタイムの生成
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat sdFormat=new SimpleDateFormat(TIME_FORMAT);
				String login_time=sdFormat.format(cal.getTime());
				
				//任意のユーザーのロングタイムをUPDATEする。プリペアドステートメントを作成してください
				String SQL_UPDATE="UPDATE employee_table SET login_time=? where id=?";
				PreparedStatement psExecuteUpdate=connection.prepareStatement(SQL_UPDATE);
				psExecuteUpdate.setString(1, login_time);
				psExecuteUpdate.setString(2, id);
				psExecuteUpdate.executeUpdate();
				
				// 渡ってきたIDとPassWordで検索をかけるためのSQL文を記述しましょう。
				String SELECT_SQL = "select * from employee_table WHERE id = ? and password = ? ";
				// PreparedStatementで
				PreparedStatement psExecuteQuery = connection.prepareStatement(SELECT_SQL);
				psExecuteQuery.setString(1, id);
				psExecuteQuery.setString(2, password);
				resultSet = psExecuteQuery.executeQuery();
				
				while (resultSet.next()) {
					//column1,2,3という変数にName,Comment,Login_Timeを代入してください。
					String column1 = resultSet.getString("name");
					String column2 = resultSet.getString("comment");
					String column3 = resultSet.getString("login_time");
	 
					//ShohinBeanに取得したデータをいれていきましょう
					employeeData = new EmployeeBean();
					employeeData.setName(column1);
					employeeData.setComment(column2);
					employeeData.setLogin_Time(column3);
				}
				// forName()で例外発生
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
	 
				// getConnection()、createStatement()、executeQuery()で例外発生
			} catch (SQLException e) {
				e.printStackTrace();
	 
			} finally {
				try {
	 
					if (resultSet != null) {
						resultSet.close();
					}
					if (statement != null) {
						statement.close();
					}
					if (connection != null) {
						connection.close();
					}
	 
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return employeeData;
		
	 
			
		}

}

	public EmployeeBean search(String id, String password) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}
