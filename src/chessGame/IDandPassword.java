package chessGame;

import java.util.HashMap;

public class IDandPassword {
    HashMap<String,String> logininfo = new HashMap<String,String>();

    IDandPassword (){
        logininfo.put("eman","123456");
        logininfo.put("nouran","123456");

    }

    protected HashMap getLoginInfo() {

        return logininfo;
    }
}
