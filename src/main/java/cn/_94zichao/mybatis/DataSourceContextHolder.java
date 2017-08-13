
package cn._94zichao.mybatis;


public class DataSourceContextHolder {
	

	
	 private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();
	 
	 
	 public static void setDataSourceType(String dataSourceType) {
	        contextHolder.set(dataSourceType);  
	  } 
	 
	  public static String getDataSourceType() {
	        return contextHolder.get();  
	  }  


	  
	  public static void setMaster(){
		  clearDataSourceType(); 
	  }
	  
	  public static void clearDataSourceType() {  
	        contextHolder.remove();  
	  }


	public static void setSource(String s) {
		setDataSourceType(s);
	}
}

