package com.wll.inspection.service;

import com.wll.inspection.Test.FabricManagerTest;
import com.wll.inspection.fabric.ChaincodeManager;

import java.util.Map;

public class FabricService {

    //由于区块链的特性，这里service不是接口类，方便开发
    private static ChaincodeManager Manager;

    static {
        try{
            Manager = FabricManagerTest.obtain().getManager(1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String HashUpload(String id,String imageHash){
        String[] args = {id,imageHash};
        Map<String, String> jsonObject;
        try{
            jsonObject = Manager.invoke("hashupload",args);
        }catch(Exception e){
            e.printStackTrace();
            return "***********错误**********";
        }
        String result = jsonObject.get("data").toString();
        return result;
    }

    public static String QueryHash(String id){
        String[] args = {id};
        Map<String, String> jsonObject;
        try {
            jsonObject = Manager.invoke("query", args);
        } catch (Exception e) {
            e.printStackTrace();
            return "***********错误**********";
        }
        String result = jsonObject.get("data").toString();
        return result;
    }
}
