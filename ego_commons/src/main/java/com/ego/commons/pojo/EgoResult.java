package com.ego.commons.pojo;

import lombok.Data;

@Data
public class EgoResult {
    // 页面200  成功，400、500 失败
    private int status;
    // 服务端向客户端发送的数据
    private Object data;
    // 服务端向客户端发送的消息
    private String msg;

    public static EgoResult ok(){
        EgoResult er = new EgoResult();
        er.setStatus(200);
        er.setMsg("ok");
        return er;
    }
    public static EgoResult ok(Object data){
        EgoResult er = new EgoResult();
        er.setStatus(200);
        er.setMsg("ok");
        er.setData(data);
        return er;
    }

    public static EgoResult ok(String msg){
        EgoResult er = new EgoResult();
        er.setStatus(200);
        er.setMsg(msg);
        return er;
    }

    public static EgoResult error(String msg){
        EgoResult er = new EgoResult();
        er.setStatus(400);
        er.setMsg(msg);
        return er;
    }
}
