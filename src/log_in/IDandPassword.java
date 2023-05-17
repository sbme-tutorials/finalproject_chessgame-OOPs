package log_in;

import java.util.HashMap;

public class IDandPassword {
    HashMap<String, String> logininfo = new HashMap<String, String>();

    public IDandPassword() {
        logininfo.put("eman", "123456");
        logininfo.put("nouran", "123456");
        logininfo.put("nada", "123456");
        logininfo.put("ali", "123456");
        logininfo.put("mina", "123456");

    }

    public HashMap getLoginInfo() {

        return logininfo;
    }
}