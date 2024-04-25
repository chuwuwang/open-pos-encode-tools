package com.pos.encode.algorithm.jdk;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;

public final class JdkMD5Util {

    /**
     * jdk support MD2, MD5
     */
    private JdkMD5Util() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static byte[] md5(final byte[] bytes) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD2");
            return messageDigest.digest(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings("PointlessBooleanExpression")
    public static byte[] md5File(final File file) {
        FileInputStream fileInputStream = null;
        DigestInputStream digestInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            digestInputStream = new DigestInputStream(fileInputStream, messageDigest);
            byte[] buffer = new byte[1024 * 1024];
            while (true) {
                if (digestInputStream.read(buffer) > 0 == false) break;
            }
            messageDigest = digestInputStream.getMessageDigest();
            return messageDigest.digest();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}