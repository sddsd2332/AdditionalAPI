package com.swallows.additionalapi.crafttweaker.util;

import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ZenExpansion("crafttweaker.util.Math")
@SuppressWarnings("unused")
public class SaaMath {

    @ZenMethod
    public static double pow(double a, double b) {
        return Math.pow(a, b);
    }

    @ZenMethod
    public static double cbrt(double a) {
        return Math.cbrt(a);
    }
}
