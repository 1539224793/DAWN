package cn.dawn.dao;


import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class BaseDao {

	private static String driver;
	private static String url;
	private static String username;
	private static String password;

	Connection con=null;
	PreparedStatement pstmt=null;
	public ResultSet rs=null;
	/**
	 * 锟斤拷态锟斤拷锟斤拷锟�
	 */
	static{
		Properties pro=new Properties();
		String pathurl="database.properties";
		InputStream is=BaseDao.class.getClassLoader().getResourceAsStream(pathurl);
		try {
			pro.load(is);
			driver=pro.getProperty("driver");
			url=pro.getProperty("url");
			username=pro.getProperty("username");
			password=pro.getProperty("password");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 锟斤拷锟斤拷锟斤拷
	 * @return
	 * @throws Exception
	 */
	public  Connection getConnection(){
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,username, password);
			return con;	
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 锟截闭凤拷锟斤拷
	 * @throws Exception
	 */
	public  void allClose(){
		 try {
	            // 閲婃斁璧勬簮
	            
	            	pstmt.close();
	            	con.close();
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

	}
	/**
	 * 锟斤拷删锟侥凤拷锟斤拷
	 * @param sql
	 * @return
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public int exeUpDate(String sql,Object...obj){
		getConnection();
		try {
			pstmt = getConnection().prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				pstmt.setObject(1+i, obj[i]);
			}
			int result = pstmt.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			allClose();
		}
		
		return 0;
	}
	/**
	 * 锟斤拷询锟斤拷锟斤拷
	 * @param sql
	 * @return
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public ResultSet exeQuery(String sql,Object...obj){
		getConnection();
		try {
			pstmt = getConnection().prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				pstmt.setObject(1+i, obj[i]);
			}
			rs = pstmt.executeQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	
	
}
