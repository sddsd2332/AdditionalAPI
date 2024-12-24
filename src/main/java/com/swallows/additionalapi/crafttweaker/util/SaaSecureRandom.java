package com.swallows.additionalapi.crafttweaker.util;

import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.security.SecureRandom;

@ZenClass("mods.additionalapi.SecureRandom")
@SuppressWarnings("unused")
public class SaaSecureRandom {

    static SecureRandom secureRandom = new SecureRandom();

    @ZenMethod
    public static int nextInt () {
        return secureRandom.nextInt();
    }

    @ZenMethod
    public static int nextInt (int maximum) {
        return secureRandom.nextInt(maximum);
    }

    @ZenMethod
    public static int nextInt (int minimum, int maximum) {
        return secureRandom.nextInt(minimum, maximum);
    }

    @ZenMethod
    public static long nextLong () {
        return secureRandom.nextLong();
    }

    @ZenMethod
    public static long nextLong (long maximum) {
        return secureRandom.nextLong(maximum);
    }

    @ZenMethod
    public static long nextLong (long minimum, long maximum) {
        return secureRandom.nextLong(minimum, maximum);
    }

    @ZenMethod
    public static float nextFloat () {
        return secureRandom.nextFloat();
    }

    @ZenMethod
    public static float nextFloat (float maximum) {
        return secureRandom.nextFloat(maximum);
    }

    @ZenMethod
    public static float nextFloat (float minimum, float maximum) {
        return secureRandom.nextFloat(minimum, maximum);
    }

    @ZenMethod
    public static double nextDouble () {
        return secureRandom.nextDouble();
    }

    @ZenMethod
    public static double nextDoublet (double maximum) {
        return secureRandom.nextDouble(maximum);
    }

    @ZenMethod
    public static double nextDouble (double minimum, double maximum) {
        return secureRandom.nextDouble(minimum, maximum);
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
    public static double nextGaussian (double mean, double stdDev) {
        return secureRandom.nextGaussian(mean, stdDev);
    }

    @ZenMethod
    public static double nextExponential () {
        return secureRandom.nextExponential();
    }
}
