package com.burcu.utility;

import java.util.UUID;

public class CodeGenerator {

    /**
     * Bu method ile kullanıcı üye olduğunda mail adresine iletilmek üzere
     * aktivasyon kodu oluşturulur.
     * @return
     */
    public static String createActivationCode(){
        String code= UUID.randomUUID().toString();
        String [] codeArray=code.split("-");
        String activationCode="";
        for(String data: codeArray){
            activationCode+=data.charAt(0);
        }
        return activationCode.toUpperCase();
    }
}
