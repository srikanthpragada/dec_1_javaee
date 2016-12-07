package jdbc;

import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.Predicate;

import oracle.jdbc.rowset.OracleFilteredRowSet;

public class FilterDemo {
	static class TitlePredicate implements Predicate {
		@Override
		public boolean evaluate(RowSet rs) {
			try {
				if (rs.getString("job_title").length() > 15)
					return true;
				else
					return false;
			} catch (Exception ex) {
				return false;
			}
		}

		@Override
		public boolean evaluate(Object arg0, int arg1) throws SQLException {
			return false;
		}

		@Override
		public boolean evaluate(Object arg0, String arg1) throws SQLException {
			return false;
		}

	}

	static class MinSalaryPredicate implements Predicate {
		@Override
		public boolean evaluate(RowSet rs) {
			try {
				if (rs.getInt("min_salary") > 5000)
					return true;
				else
					return false;
			} catch (Exception ex) {
				return false;
			}
		}

		@Override
		public boolean evaluate(Object arg0, int arg1) throws SQLException {
			return false;
		}

		@Override
		public boolean evaluate(Object arg0, String arg1) throws SQLException {
			return false;
		}

	}

	public static void main(String[] args) throws Exception {

		try (FilteredRowSet rs = new OracleFilteredRowSet()) {
			rs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
			rs.setUsername("hr");
			rs.setPassword("hr");
			rs.setCommand("select * from jobs");
			rs.execute();

			// System.out.println("Jobs with MinSalary > 10000");
			rs.setFilter(new MinSalaryPredicate());
			while (rs.next()) {
				System.out.println(rs.getString("job_title") + ":" + rs.getString("min_salary"));
			}
			
			
			rs.setFilter(new TitlePredicate());
            rs.beforeFirst();
			while (rs.next()) {
				System.out.println(rs.getString("job_title"));
			}
			
		}

	}

}
