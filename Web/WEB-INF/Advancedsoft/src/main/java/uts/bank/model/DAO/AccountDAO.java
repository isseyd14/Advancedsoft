package uts.bank.model.DAO;
import uts.bank.model.Account;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {

    protected Connection getConnection(){
        Connection con;
        try{
            String url="jdbc:mysql://advancedsoftwareserver.mysql.database.azure.com:3306/bank?useSSL=false";
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, "advancedsoftware", "Welcome1!");
            return con;
        } catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException("Error connecting to the database", e);
        }
    }

    public void addAccount(Account account)throws SQLException{
        String sql = "INSERT INTO account (Email, name, type, avaliable_funds, current_funds) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);) {

            stmt.setString(1, account.getAccountEmail());
            stmt.setString(2, account.getAccountName());
            stmt.setString(3, account.getAccountType());
            stmt.setDouble(4, account.getAccountAvailableFunds());
            stmt.setDouble(5, account.getAccountCurrentFunds());


            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //find all accounts by customer email
    public List<Account> findaccounts(String customerEmail) {
        List<Account> account = new ArrayList<>();
        String sql = "SELECT * FROM account WHERE Email = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);){
            stmt.setString(1, customerEmail);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                int accountNumber = Integer.parseInt(rs.getString("account_id"));
                String accountEmail = rs.getString("Email");
                String accountName = rs.getString("name");
                String accountType = rs.getString("type");
                double accountAvaliableFunds = rs.getDouble("avaliable_funds");
                double accountCurrentFunds = rs.getDouble("current_funds");
                account.add(new Account(accountNumber, accountEmail, accountName, accountType, accountAvaliableFunds, accountCurrentFunds));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    public void deleteAccount(String accountName) throws SQLException {
        String sql = "DELETE FROM account WHERE name = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);) {

            stmt.setString(1, accountName);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getNextAccountId() throws SQLException {
            int accountid = 0;
            String sql = "SELECT acccount_id FROM account ORDER BY account_id DESC FETCH FIRST ROW ONLY";
            try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);) {
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    accountid = rs.getInt(accountid);
                }

            return accountid;
        }
    }
}
