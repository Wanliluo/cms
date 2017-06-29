package com.cms.common.util;


import com.cms.common.entity.face.Person;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;


/**
* 生成密码的加密算法
* user:ouym
* date: 2014/9/13
* time: 14:28
*/
public class PasswordHelper {
    private RandomNumberGenerator randomNumberGenerator =
            new SecureRandomNumberGenerator();
    private String algorithmName = "md5";
    private final int hashIterations = 2;
    public void encryptPassword(Person person) {

        person.setSalt(randomNumberGenerator.nextBytes().toHex());

        String newPassword = new SimpleHash(
                algorithmName,
                person.getPassword(),
                ByteSource.Util.bytes(person.retCredentialsSalt()),
                hashIterations).toHex();
        person.setPassword(newPassword);
    }


}

