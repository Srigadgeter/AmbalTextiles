/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ambaltextiles.databaseWorks;

import ambaltextiles.AddCustomer;
import ambaltextiles.MonthlySales;
import ambaltextiles.Payments;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Sridhar
 */
public class DatabaseFunctions {

    DatabaseMetaData md;
    PreparedStatement ps;
    Connection cn;
    Statement s;
    ResultSet r;
    AddCustomer addCust;
    Payments pay;
    MonthlySales month;
    DecimalFormat df;

    public void createBillKeyTable() throws SQLException, ClassNotFoundException {
        cn = DBUtil.getDBConnection();
        md = cn.getMetaData();
        r = md.getTables(null, null, "BILLKEY", null);
        if (!r.next()) {
            // table creation if doesn't exists
            ps = cn.prepareStatement("create table billkey(s_no int not null,"
                    + "keypass varchar(20),"
                    + "customer_id int not null,"
                    + "invoicenumber varchar(20) not null,"
                    + "invoicenumbertaxless varchar(20) not null,"
                    + "payment_number int not null"
                    + ")");
            ps.execute();
            cn.commit();
            // setting initial fields
            ps = cn.prepareStatement("insert into billkey values(1, 'rsk', 1, '0', '0', 0)");
            ps.execute();
            cn.commit();
        }
    }

    public void createCustomersListTable() throws SQLException, ClassNotFoundException {
        cn = DBUtil.getDBConnection();
        md = cn.getMetaData();
        r = md.getTables(null, null, "CUSTOMERSLIST", null);
        if (!r.next()) {
            // table creation if doesn't exists
            ps = cn.prepareStatement("create table customerslist("
                    + "customer_id int,"
                    + "company_name varchar(35),"
                    + "address_line1 varchar(30),"
                    + "address_line2 varchar(30),"
                    + "address_line3 varchar(30),"
                    + "gstin_number varchar(20),"
                    + "state_code varchar(5),"
                    + "phone_number varchar(11),"
                    + "balance varchar(20)"
                    + ")");
            ps.execute();
            cn.commit();
        }
    }

    public void createPaymentsListTable() throws SQLException, ClassNotFoundException {
        cn = DBUtil.getDBConnection();
        md = cn.getMetaData();
        r = md.getTables(null, null, "PAYMENTSLIST", null);
        if (!r.next()) {
            // table creation if doesn't exists
            ps = cn.prepareStatement("create table paymentslist("
                    + "payment_number int not null,"
                    + "customer_name varchar(35),"
                    + "dates varchar(10),"
                    + "invoice_number varchar(20),"
                    + "particulars varchar(25),"
                    + "voucher_type varchar(20),"
                    + "debit varchar(20),"
                    + "credit varchar(20),"
                    + "balance varchar(20),"
                    + "days varchar(10)"
                    + ")");
            ps.execute();
            cn.commit();
        }
    }

    public String currentPassword() throws SQLException, ClassNotFoundException {
        String key = "";
        cn = DBUtil.getDBConnection();
        s = cn.createStatement();
        r = s.executeQuery("select keypass from billkey where s_no = 1");
        while (r.next()) {
            key = r.getString(1);
        }
        return key;
    }

    public void updatePassword(String newPass) throws SQLException, ClassNotFoundException {
        cn = DBUtil.getDBConnection();
        ps = cn.prepareStatement("update billkey set keypass = ? where s_no = ?");
        ps.setString(1, newPass);
        ps.setString(2, "1");
        ps.executeUpdate();
        cn.commit();
    }

    public void insertionAccount(String name, String adrs1, String adrs2, String adrs3, String tin, String state, String ph) throws SQLException, ClassNotFoundException {
        int id = 0;

        cn = DBUtil.getDBConnection();

        s = cn.createStatement();
        r = s.executeQuery("select customer_id from billkey where s_no = 1");
        while (r.next()) {
            id = r.getInt(1);
        }

        ps = cn.prepareStatement("insert into customerslist values(?,?,?,?,?,?,?,?,?)");
        ps.setInt(1, id);
        ps.setString(2, name.toUpperCase());
        ps.setString(3, adrs1.toUpperCase());
        ps.setString(4, adrs2.toUpperCase());
        ps.setString(5, adrs3.toUpperCase());
        ps.setString(6, tin.toUpperCase());
        ps.setString(7, state.toUpperCase());
        ps.setString(8, ph.toUpperCase());
        ps.setString(9, "0");
        ps.execute();
        cn.commit();

        ps = cn.prepareStatement("update billkey set customer_id = ? where s_no = ?");
        ps.setInt(1, (id + 1));
        ps.setString(2, "1");
        ps.executeUpdate();
        cn.commit();
    }

    public void updateAccount(int id, String name, String adrs1, String adrs2, String adrs3, String tin, String state, String ph) throws SQLException, ClassNotFoundException {
        cn = DBUtil.getDBConnection();

        if (!name.equals("")) {
            ps = cn.prepareStatement("update customerslist set company_name = ? where customer_id = ?");
            ps.setString(1, name.toUpperCase());
            ps.setInt(2, id);
            ps.executeUpdate();
            cn.commit();
        }
        if (!adrs1.equals("")) {
            ps = cn.prepareStatement("update customerslist set address_line1 = ? where customer_id = ?");
            ps.setString(1, adrs1.toUpperCase());
            ps.setInt(2, id);
            ps.executeUpdate();
            cn.commit();
        }
        if (!adrs2.equals("")) {
            ps = cn.prepareStatement("update customerslist set address_line2 = ? where customer_id = ?");
            ps.setString(1, adrs2.toUpperCase());
            ps.setInt(2, id);
            ps.executeUpdate();
            cn.commit();
        }
        if (!adrs3.equals("")) {
            ps = cn.prepareStatement("update customerslist set address_line3 = ? where customer_id = ?");
            ps.setString(1, adrs3.toUpperCase());
            ps.setInt(2, id);
            ps.executeUpdate();
            cn.commit();
        }
        if (!tin.equals("")) {
            ps = cn.prepareStatement("update customerslist set gstin_number = ? where customer_id = ?");
            ps.setString(1, tin.toUpperCase());
            ps.setInt(2, id);
            ps.executeUpdate();
            cn.commit();
        }
        if (!state.equals("")) {
            ps = cn.prepareStatement("update customerslist set state_code = ? where customer_id = ?");
            ps.setString(1, state.toUpperCase());
            ps.setInt(2, id);
            ps.executeUpdate();
            cn.commit();
        }
        if (!ph.equals("")) {
            ps = cn.prepareStatement("update customerslist set phone_number = ? where customer_id = ?");
            ps.setString(1, ph.toUpperCase());
            ps.setInt(2, id);
            ps.executeUpdate();
            cn.commit();
        }
    }

    public ArrayList<AddCustomer> findAll() throws SQLException, ClassNotFoundException {
        ArrayList<AddCustomer> list = new ArrayList<>();
        cn = DBUtil.getDBConnection();
        s = cn.createStatement();
        r = s.executeQuery("select * from customerslist order by company_name");
        while (r.next()) {
            addCust = new AddCustomer();
            addCust.setCustid(String.valueOf(r.getInt(1)));
            addCust.setN(r.getString(2));
            addCust.setA1(r.getString(3));
            addCust.setA2(r.getString(4));
            addCust.setA3(r.getString(5));
            addCust.setT(r.getString(6));
            addCust.setSc(r.getString(7));
            addCust.setPho(r.getString(8));
            list.add(addCust);
        }
        return list;
    }

    public String findInvoiceNumber() throws SQLException, ClassNotFoundException {
        String num = "";
        cn = DBUtil.getDBConnection();
        s = cn.createStatement();
        r = s.executeQuery("select invoicenumber from billkey where s_no = 1");
        while (r.next()) {
            num = r.getString(1);
        }
        return num;
    }

    public String findInvoiceNumberTaxless() throws SQLException, ClassNotFoundException {
        String num = "";
        cn = DBUtil.getDBConnection();
        s = cn.createStatement();
        r = s.executeQuery("select invoicenumbertaxless from billkey where s_no = 1");
        while (r.next()) {
            num = r.getString(1);
        }
        return num;
    }

    public void updateInvoiceNumber(String invoiceNumber) throws SQLException, ClassNotFoundException {
        cn = DBUtil.getDBConnection();
        ps = cn.prepareStatement("update billkey set invoicenumber = ? where s_no = ?");
        ps.setString(1, invoiceNumber);
        ps.setString(2, "1");
        ps.executeUpdate();
        cn.commit();
    }

    public void updateInvoiceNumberTaxless(String invoiceNumber) throws SQLException, ClassNotFoundException {
        cn = DBUtil.getDBConnection();
        ps = cn.prepareStatement("update billkey set invoicenumbertaxless = ? where s_no = ?");
        ps.setString(1, invoiceNumber);
        ps.setString(2, "1");
        ps.executeUpdate();
        cn.commit();
    }

    public String getCustomerData(String name, Boolean Adrs1, Boolean Adrs2, Boolean Adrs3, Boolean tin, Boolean state, Boolean phone) throws SQLException, ClassNotFoundException {
        String option = "";
        cn = DBUtil.getDBConnection();
        s = cn.createStatement();
        if (Adrs1) {
            r = s.executeQuery("select address_line1 from customerslist where company_name = '" + name + "'");
        }
        if (Adrs2) {
            r = s.executeQuery("select address_line2 from customerslist where company_name = '" + name + "'");
        }
        if (Adrs3) {
            r = s.executeQuery("select address_line3 from customerslist where company_name = '" + name + "'");
        }
        if (tin) {
            r = s.executeQuery("select gstin_number from customerslist where company_name = '" + name + "'");
        }
        if (state) {
            r = s.executeQuery("select state_code from customerslist where company_name = '" + name + "'");
        }
        if (phone) {
            r = s.executeQuery("select phone_number from customerslist where company_name = '" + name + "'");
        }
        while (r.next()) {
            option = r.getString(1);
        }
        return option;
    }

    public ArrayList<String> findCustomersWithSearchLetters(String searchText) throws SQLException, ClassNotFoundException {
        ArrayList<String> list = new ArrayList<>();
        cn = DBUtil.getDBConnection();
        s = cn.createStatement();
        r = s.executeQuery("select company_name from customerslist where company_name like '" + searchText + "%'");
        while (r.next()) {
            list.add(r.getString(1));
        }
        return list;
    }

    public void insertPaymentDetails(String name, String dates, String invoiceNumber, String particulars, String voucherType, String debit, String credit) throws SQLException, ClassNotFoundException {
        Double amount = 0.0, d = 0.0, c = 0.0;
        int num = 0;
        String balance;
        df = new DecimalFormat("0.00");

        cn = DBUtil.getDBConnection();

        d = Double.parseDouble(debit);
        c = Double.parseDouble(credit);

        s = cn.createStatement();

        r = s.executeQuery("select payment_number from billkey where s_no = 1");
        while (r.next()) {
            num = r.getInt(1);
        }
        num += 1;

        r = s.executeQuery("select balance from customerslist where company_name = '" + name + "'");
        while (r.next()) {
            amount = Double.parseDouble(r.getString(1));
        }
        balance = df.format(amount + d - c);

        ps = cn.prepareStatement("insert into paymentslist values(?,?,?,?,?,?,?,?,?,?)");
        ps.setInt(1, num);
        ps.setString(2, name);
        ps.setString(3, dates);
        ps.setString(4, invoiceNumber);
        ps.setString(5, particulars.toUpperCase());
        ps.setString(6, voucherType.toUpperCase());
        ps.setString(7, df.format(d));
        ps.setString(8, df.format(c));
        ps.setString(9, balance); // empty balance field
        ps.setString(10, ""); // empty overdue by days field
        ps.execute();
        cn.commit();

        ps = cn.prepareStatement("update billkey set payment_number = ? where s_no = ?");
        ps.setInt(1, num);
        ps.setString(2, "1");
        ps.executeUpdate();
        cn.commit();

        ps = cn.prepareStatement("update customerslist set balance = ? where company_name = ?");
        ps.setString(1, balance);
        ps.setString(2, name);
        ps.executeUpdate();
        cn.commit();
    }

    public ArrayList<Payments> findPaymentDetails(String customerName) throws SQLException, ClassNotFoundException {
        String days = "";
        long difference = 0, noOfDays = 0;
        ArrayList<Payments> list = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date billDates = null, today;

        cn = DBUtil.getDBConnection();

        s = cn.createStatement();
        r = s.executeQuery("select payment_number, dates from paymentslist where not invoice_number = '-'");
        while (r.next()) {
            try {
                billDates = sdf.parse(r.getString(2));
                today = new Date();

                difference = today.getTime() - billDates.getTime();
                noOfDays = TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS);
                days = String.valueOf(noOfDays);

                ps = cn.prepareStatement("update paymentslist set days = ? where payment_number = ?");
                ps.setString(1, days);
                ps.setString(2, r.getString(1));
                ps.executeUpdate();
                cn.commit();
            } catch (ParseException ex) {
                // don't do anything
            }
        }

        s = cn.createStatement();
        r = s.executeQuery("select * from paymentslist where customer_name = '" + customerName + "' order by payment_number");
        while (r.next()) {
            pay = new Payments();
            pay.setDt(r.getString(3));
            pay.setInum(r.getString(4));
            pay.setPart(r.getString(5));
            pay.setVtype(r.getString(6));
            pay.setDeb(r.getString(7));
            pay.setCre(r.getString(8));
            pay.setBal(r.getString(9));
            pay.setDy(r.getString(10));
            list.add(pay);
        }
        return list;
    }

    public ArrayList<MonthlySales> findPaymentsByDates(String fromD, String toD, Boolean tax) throws SQLException, ClassNotFoundException {
        ArrayList<MonthlySales> list = new ArrayList<>();
        cn = DBUtil.getDBConnection();
        s = cn.createStatement();
        if (tax) {
            r = s.executeQuery("select * from paymentslist where dates between '" + fromD + "' and '" + toD + "' and not invoice_number = '-' and invoice_number not like 'TL%' order by payment_number");
        } else {
            r = s.executeQuery("select * from paymentslist where dates between '" + fromD + "' and '" + toD + "' and invoice_number like 'TL%' order by payment_number");
        }
        while (r.next()) {
            month = new MonthlySales();
            month.setDt(r.getString(3));
            month.setName(r.getString(2));
            month.setInum(r.getString(4));
            month.setPart(r.getString(5));
            month.setVtype(r.getString(6));
            month.setDeb(r.getString(7));
            list.add(month);
        }
        return list;
    }

    public ArrayList<Payments> findPaymentDetailsByDates(String customerName, String fromD, String toD) throws SQLException, ClassNotFoundException {
        String days = "";
        long difference = 0, noOfDays = 0;
        ArrayList<Payments> list = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date billDates = null, today;

        cn = DBUtil.getDBConnection();

        s = cn.createStatement();
        r = s.executeQuery("select payment_number, dates from paymentslist where not invoice_number = '-'");
        while (r.next()) {
            try {
                billDates = sdf.parse(r.getString(2));
                today = new Date();

                difference = today.getTime() - billDates.getTime();
                noOfDays = TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS);
                days = String.valueOf(noOfDays);

                ps = cn.prepareStatement("update paymentslist set days = ? where payment_number = ?");
                ps.setString(1, days);
                ps.setString(2, r.getString(1));
                ps.executeUpdate();
                cn.commit();
            } catch (ParseException ex) {
                // don't do anything
            }
        }

        s = cn.createStatement();
        r = s.executeQuery("select * from paymentslist where dates between '" + fromD + "' and '" + toD + "' and customer_name = '" + customerName + "' order by payment_number");
        while (r.next()) {
            pay = new Payments();
            pay.setDt(r.getString(3));
            pay.setInum(r.getString(4));
            pay.setPart(r.getString(5));
            pay.setVtype(r.getString(6));
            pay.setDeb(r.getString(7));
            pay.setCre(r.getString(8));
            pay.setBal(r.getString(9));
            pay.setDy(r.getString(10));
            list.add(pay);
        }
        return list;
    }

}
