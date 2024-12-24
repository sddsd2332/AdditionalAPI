package com.swallows.additionalapi.crafttweaker.util;

import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.security.SecureRandom;

@ZenClass("mods.additionalapi.SecureRandom")
@SuppressWarnings("unused")
public class SaaSecureRandom {

    static SecureRandom secureRandom = new SecureRandom();

    @ZenMethod
    public static int nextInt() {
        return secureRandom.nextInt();
    }

    @ZenMethod
    public static int nextInt(int maximum) {
        return secureRandom.nextInt(maximum);
    }

    @ZenMethod
    public static int nextInt(int minimum, int maximum) {
        return minimum + secureRandom.nextInt(maximum - minimum);
    }

    @ZenMethod
    public static long nextLong() {
        return secureRandom.nextLong();
    }

    @ZenMethod
    public static long nextLong(long maximum) {
        return Math.abs(secureRandom.nextLong()) % maximum;
    }

    @ZenMethod
    public static long nextLong(long minimum, long maximum) {
        return minimum + Math.abs(secureRandom.nextLong()) % (maximum - minimum);
    }

    @ZenMethod
    public static float nextFloat() {
        return secureRandom.nextFloat();
    }

    @ZenMethod
    public static float nextFloat(float maximum) {
        return secureRandom.nextFloat() * maximum;
    }

    @ZenMethod
    public static float nextFloat(float minimum, float maximum) {
        return minimum + secureRandom.nextFloat() * (maximum - minimum);
    }

    @ZenMethod
    public static double nextDouble() {
        return secureRandom.nextDouble();
    }

    @ZenMethod
    public static double nextDouble(double maximum) {
        return secureRandom.nextDouble() * maximum;
    }

    @ZenMethod
    public static double nextDouble(double minimum, double maximum) {
        return minimum + secureRandom.nextDouble() * (maximum - minimum);
    }

    @ZenMethod
    public static boolean nextBool () {
        return secureRandom.nextBoolean();
    }

    @ZenMethod
    public static double nextGaussian () {
        return secureRandom.nextGaussian();
    }

    @ZenMethod
    public static double nextGaussian(double mean, double stdDev) {
        return mean + stdDev * secureRandom.nextGaussian();
    }

    @ZenMethod
    public static double nextExponential(double lambda) {
        return -Math.log(1.0 - secureRandom.nextDouble()) / lambda;
    }
}
