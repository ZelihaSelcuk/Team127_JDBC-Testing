package manage;

public class QueryManage {


    private String query01 = "select user_id from u168183796_qaloantec.deposits where amount between 100 and 500;";
    private String query02= "SELECT name FROM u168183796_qaloantec.cron_schedules Limit 2";
    private String query03 = "select firstname,lastname from users where not country_code='TR' and id=11";
    private String query04= "select user_id, group_concat(browser,'-',os) as browser_os from u168183796_qaloantec.user_logins group by user_id";
    private String updateQuery05 = "update users set mobile='111111111' where username like '%e_'";
    private String preparedQuery05 = "update users set mobile=? where username like ?";
    private String preparedQuery06 = "insert into u168183796_qaloantec.admin_password_resets (id,email,token,status) VALUES (?,?,?,?)";
    private String Query88 = "insert into u168183796_qaloantec.categories (id,name, description) values (?,?,?)";
    private String preparedQuery08 ="update admin_notifications set is_read=? where  id=?";
   private String preparedQuery09 = "insert into update_logs (id, version, update_log, created_at) VALUES (?,?,?,?)";
   private  String preparedQuer09Update = "update update_logs set update_log=? where version=? and id=?";





//------------ GETTER------------------


    public String getQuery01() {
        return query01;
    }

    public String getQuery02() {
        return query02;
    }

    public String getQuery03() { return query03; }

    public String getQuery04() { return query04; }

    public String getPreparedQuery05() {return preparedQuery05;}

    public String getUpdateQuery05() {return updateQuery05;}

    public String getPreparedQuery06() {return preparedQuery06;}

    public String getQuery88() {
        return Query88;
    }

    public String getPreparedQuery08() {return preparedQuery08;}

    public String getPreparedQuery09() {return preparedQuery09;}

    public String getPreparedQuer09Update() {return preparedQuer09Update;}
}
