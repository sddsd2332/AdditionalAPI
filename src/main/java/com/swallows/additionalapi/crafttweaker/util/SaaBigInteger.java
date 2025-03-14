package com.swallows.additionalapi.crafttweaker.util;

import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.math.BigInteger;

@ZenRegister
@ZenClass("mods.additionalapi.BigInteger")
@SuppressWarnings("unused")
public class SaaBigInteger {

    /*
    * 大数加法
    */
    @ZenMethod
    public static String Add (String a, String b) {
        if(!a.matches("-?\\d+") || !b.matches("-?\\d+")){
            return null;
        }
        BigInteger A = new BigInteger(a);
        BigInteger B = new BigInteger(b);
        return A.add(B).toString();
    }

    /*
     * 大数减法
     */
    @ZenMethod
    public static String Subtract (String a, String b) {
        if(!a.matches("-?\\d+") || !b.matches("-?\\d+")){
            return null;
        }
        BigInteger A = new BigInteger(a);
        BigInteger B = new BigInteger(b);
        return A.subtract(B).toString();
    }

    /*
     * 大数乘法
     */
    @ZenMethod
    public static String Multiply (String a, String b) {
        if(!a.matches("-?\\d+") || !b.matches("-?\\d+")){
            return null;
        }
        BigInteger A = new BigInteger(a);
        BigInteger B = new BigInteger(b);
        return A.multiply(B).toString();
    }

    /*
     * 大数除法
     */
    @ZenMethod
    public static String Divide (String a, String b) {
        if(!a.matches("-?\\d+") || !b.matches("-?\\d+")){
            return null;
        }
        BigInteger A = new BigInteger(a);
        BigInteger B = new BigInteger(b);
        return A.divide(B).toString();
    }

    /*
     * 大数取余
     */
    @ZenMethod
    public static String Remainder (String a, String b) {
        if(!a.matches("-?\\d+") || !b.matches("-?\\d+")){
            return null;
        }
        BigInteger A = new BigInteger(a);
        BigInteger B = new BigInteger(b);
        return A.remainder(B).toString();
    }

    /*
     * 大数阶乘
     */
    @ZenMethod
    public static String Pow (String a, int b) {
        if(!a.matches("-?\\d+")){
            return null;
        }
        BigInteger A = new BigInteger(a);
        return A.pow(b).toString();
    }

    /*
     * 取负数
     */
    @ZenMethod
    public static String Negate (String a) {
        if(!a.matches("-?\\d+")){
            return null;
        }
        BigInteger A = new BigInteger(a);
        return A.negate().toString();
    }

    /*
     * 比较大小
     */
    @ZenMethod
    public static int CompareTo (String a, String b) {
        if(!a.matches("-?\\d+") || !b.matches("-?\\d+")){
            return -2;
        }
        BigInteger A = new BigInteger(a);
        BigInteger B = new BigInteger(b);
        return A.compareTo(B);
    }

    /*
     * 大数取小
     */
    @ZenMethod
    public static String Min (String a, String b) {
        if(!a.matches("-?\\d+") || !b.matches("-?\\d+")){
            return null;
        }
        BigInteger A = new BigInteger(a);
        BigInteger B = new BigInteger(b);
        return A.min(B).toString();
    }

    /*
     * 大数取大
     */
    @ZenMethod
    public static String Max (String a, String b) {
        if(!a.matches("-?\\d+") || !b.matches("-?\\d+")){
            return null;
        }
        BigInteger A = new BigInteger(a);
        BigInteger B = new BigInteger(b);
        return A.max(B).toString();
    }

    /*
     * int转String
     */
    @ZenMethod
    public static String toString (int a) {
        return String.valueOf(a);
    }

    /*
     * long转String
     */
    @ZenMethod
    public static String toString (long a) {
        return String.valueOf(a);
    }
}
