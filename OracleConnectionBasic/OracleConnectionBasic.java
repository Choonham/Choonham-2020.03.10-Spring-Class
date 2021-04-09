	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private Connection conn = null;
	
	private ResultSet rs = null;
	
	private int n = 0; //INSERT, UPDATE, DELETE 의 결과 값을 저장	
	
	private final String oracleDriverPath = "oracle.jdbc.driver.OracleDriver";
	private final String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private final String user = "chicago_nyj";
	private final String pwd = "1234";
	
	public JDBCClass() {
		// TODO Auto-generated constructor stub
	}
	
	public void connectOracle() {
		try {
			Class.forName(oracleDriverPath);
			this.conn = DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	