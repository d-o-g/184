package com.jagex;

import java.util.Calendar;

public class Class49 {
    static final String[] aStringArray448;
    static final double aDouble437;
    static int[] anIntArray445;
    static int[][] anIntArrayArray443;
    static int anInt436;
    static Class48[] aClass48Array435;
    static Calendar aCalendar438;
    static boolean aBoolean439;
    static boolean aBoolean449;
    static int anInt440;
    static Class98 aClass98_446;
    static int anInt442;
    static int anInt441;
    static int[] anIntArray447;

    static {
        anIntArray445 = new int[5];
        anIntArrayArray443 = new int[5][5000];
        ScriptEvent.intStack = new int[1000];
        ScriptEvent.stringStack = new String[1000];
        anInt436 = 0;
        aClass48Array435 = new Class48[50];
        aCalendar438 = Calendar.getInstance();
        aStringArray448 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        aBoolean439 = false;
        aBoolean449 = false;
        anInt440 = 0;
        aDouble437 = Math.log(2.0D);
    }

    static boolean method297(String var0, int var1) {
        return Class26.method191(var0, var1);
    }

    public static int method298(CharSequence var0, CharSequence var1, Class149 var2) {
        int var3 = var0.length();
        int var4 = var1.length();
        int var5 = 0;
        int var6 = 0;
        char var7 = 0;
        char var8 = 0;

        while (var5 - var7 < var3 || var6 - var8 < var4) {
            if (var5 - var7 >= var3) {
                return -1;
            }

            if (var6 - var8 >= var4) {
                return 1;
            }

            char var9;
            if (var7 != 0) {
                var9 = var7;
                boolean var14 = false;
            } else {
                var9 = var0.charAt(var5++);
            }

            char var10;
            if (var8 != 0) {
                var10 = var8;
                boolean var15 = false;
            } else {
                var10 = var1.charAt(var6++);
            }

            var7 = Class62.method347(var9);
            var8 = Class62.method347(var10);
            var9 = Class54.method322(var9, var2);
            var10 = Class54.method322(var10, var2);
            if (var10 != var9 && Character.toUpperCase(var9) != Character.toUpperCase(var10)) {
                var9 = Character.toLowerCase(var9);
                var10 = Character.toLowerCase(var10);
                if (var10 != var9) {
                    return Node_Sub19.method858(var9, var2) - Node_Sub19.method858(var10, var2);
                }
            }
        }

        int var16 = Math.min(var3, var4);

        char var12;
        int var17;
        for (var17 = 0; var17 < var16; ++var17) {
            if (var2 == Class149.aClass149_1187) {
                var5 = var3 - 1 - var17;
                var6 = var4 - 1 - var17;
            } else {
                var6 = var17;
                var5 = var17;
            }

            char var11 = var0.charAt(var5);
            var12 = var1.charAt(var6);
            if (var11 != var12 && Character.toUpperCase(var11) != Character.toUpperCase(var12)) {
                var11 = Character.toLowerCase(var11);
                var12 = Character.toLowerCase(var12);
                if (var12 != var11) {
                    return Node_Sub19.method858(var11, var2) - Node_Sub19.method858(var12, var2);
                }
            }
        }

        var17 = var3 - var4;
        if (var17 != 0) {
            return var17;
        }
        for (int var18 = 0; var18 < var16; ++var18) {
            var12 = var0.charAt(var18);
            char var13 = var1.charAt(var18);
            if (var13 != var12) {
                return Node_Sub19.method858(var12, var2) - Node_Sub19.method858(var13, var2);
            }
        }

        return 0;
    }
}
