package Mark1;

import java.sql.*;

public class SQLDriver {

	public void main(String args[]) throws SQLException {
		
		String url = "????";
		SQLCommands sqc = new SQLCommands(url, "uret01", "rowan");
		
		sqc.viewTable("pariphae_cablocal");
	}
}
