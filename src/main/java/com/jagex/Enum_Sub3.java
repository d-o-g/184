package com.jagex;

public enum Enum_Sub3 implements EnumType {
    anEnum_Sub3_827(3, 0),
    anEnum_Sub3_828(1, 1),
    anEnum_Sub3_826(2, 2),
    anEnum_Sub3_825(0, 3);

    static String currentDomain;
    public final int anInt619;
    final int anInt824;

    Enum_Sub3(int var3, int var4) {
        this.anInt619 = var3;
        this.anInt824 = var4;
    }

    static int method686(int var0, int var1) {
        int var2 = var0 + var1 * 57;
        var2 ^= var2 << 13;
        int var3 = var2 * (var2 * var2 * 15731 + 789221) + 1376312589 & Integer.MAX_VALUE;
        return var3 >> 19 & 255;
    }

    public int getOrdinal() {
        return this.anInt824;
    }
}
