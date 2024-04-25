package com.pos.encode.algorithm;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD2Digest;
import org.bouncycastle.crypto.digests.MD4Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.io.DigestInputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public final class MD5Util {

    /**
     * BC support MD2, MD4, MD5
     */
    private MD5Util() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static byte[] md2(final byte[] bytes) {
        MD2Digest digest = new MD2Digest();
        return hashCalculator(bytes, digest);
    }

    public static byte[] md4(final byte[] bytes) {
        MD4Digest digest = new MD4Digest();
        return hashCalculator(bytes, digest);
    }

    public static byte[] md5(final byte[] bytes) {
        MD5Digest digest = new MD5Digest();
        return hashCalculator(bytes, digest);
    }

    @SuppressWarnings("PointlessBooleanExpression")
    public static byte[] md5File(final File file) {
        FileInputStream fileInputStream = null;
        DigestInputStream digestInputStream;
        try {
            MD5Digest digest = new MD5Digest();
            fileInputStream = new FileInputStream(file);
            digestInputStream = new DigestInputStream(fileInputStream, digest);
            byte[] buffer = new byte[1024 * 1024];
            while (true) {
                if (digestInputStream.read(buffer) > 0 == false) break;
            }
            int digestSize = digest.getDigestSize();
            byte[] dataBytes = new byte[digestSize];
            digest.doFinal(dataBytes, 0);
            return dataBytes;
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

    public static byte[] hashCalculator(final byte[] bytes, final Digest digest) {
        try {
            digest.update(bytes, 0, bytes.length);
            int digestSize = digest.getDigestSize();
            byte[] dataBytes = new byte[digestSize];
            digest.doFinal(dataBytes, 0);
            return dataBytes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}