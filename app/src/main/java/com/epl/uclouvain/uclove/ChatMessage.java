package com.epl.uclouvain.uclove;

/**
 * Created by delphine on 02/05/16.
 */
public class ChatMessage {

    private String login1;
    private String login2;
    private String msg;
    private String msg_date;

    public ChatMessage() {

        super();
        this.login1 = login1;
        this.login2 = login2;
        this.msg = msg;
        this.msg_date = msg_date;
    }

    public String getLogin1()  { return login1; }

    public void setLogin1(String login1){ this.login1 = login1;}

    public String getLogin2() {return login2; }

    public void setLogin2 (String login2) { this.login2 = login2; }

    public String getMsg() { return msg; }

    public void setMsg(String msg)  {this.msg = msg;}

    public String getMsg_date() { return msg_date; }

    public void setMsg_date(String msg_date) {this.msg_date = msg_date; }

}