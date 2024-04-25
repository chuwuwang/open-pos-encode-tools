package com.pos.encode.algorithm;

@SuppressWarnings("unused")
public final class AlgorithmUtil {

    private AlgorithmUtil() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static byte[] xor(final byte[] src, final byte[] des) {
        byte[] bytes = new byte[src.length];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (src[i] ^ des[i]);
        }
        return bytes;
    }

}