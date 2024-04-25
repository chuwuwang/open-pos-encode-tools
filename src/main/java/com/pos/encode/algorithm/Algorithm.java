package com.pos.encode.algorithm;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.Security;

public final class Algorithm {

    public static final String DES = "DES";
    public static final String DES_EDE = "DES" + "ede";

    // mode
    public static final String ECB = "ECB";
    public static final String CBC = "CBC";
    public static final String CFB = "CFB";
    public static final String OFB = "OFB";

    /**
     * padding java ISO10126Padding, NoPadding, P KCS5Padding
     */
    public static final String NoPadding = "NoPadding";
    public static final String PKCS5Padding = "PKC" + "S5Padding";
    public static final String ISO10126Padding = "ISO10126Padding";
    /**
     * padding bc ISO10126d2Padding, ZeroBytePadding, P KCS7Padding, ISO7816d4Padding, X923Padding, TBCPadding
     */
    public static final String TBCPadding = "TBCPadding";
    public static final String X923Padding = "X923Padding";
    public static final String PKCS7Padding = "PKC" + "S7Padding";
    public static final String ZeroBytePadding = "ZeroBytePadding";
    public static final String ISO7816d4Padding = "ISO7816-4Padding";
    public static final String ISO10126d2Padding = "ISO10126-2Padding";

    protected static void initBC() {
        BouncyCastleProvider provider = new BouncyCastleProvider();
        Security.addProvider(provider);
    }

}