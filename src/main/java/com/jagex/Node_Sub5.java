package com.jagex;

public class Node_Sub5 extends Node {
    static boolean aBoolean562;
    static byte[] aByteArray572;
    static int anInt372;
    static int anInt379;
    static Class86[] aClass86Array557;
    static int anInt368;
    static int[] anIntArray576;
    static int anInt564;
    static float[] aFloatArray565;
    static boolean[] aBooleanArray578;
    static float[] aFloatArray559;
    static float[] aFloatArray558;
    static float[] aFloatArray567;
    static float[] aFloatArray581;
    static float[] aFloatArray566;
    static float[] aFloatArray577;
    static Class94[] aClass94Array560;
    static int[] anIntArray554;
    static int[] anIntArray569;
    static Class101[] aClass101Array570;
    static Class93[] aClass93Array555;

    static {
        aBoolean562 = false;
    }

    byte[][] aByteArrayArray582;
    byte[] aByteArray573;
    int anInt563;
    int anInt579;
    int anInt568;
    float[] aFloatArray580;
    int anInt378;
    int anInt556;
    int anInt377;
    int anInt574;
    boolean aBoolean571;
    boolean aBoolean561;
    int anInt575;

    Node_Sub5(byte[] var1) {
        this.method395(var1);
    }

    static int method397() {
        int var0 = aByteArray572[anInt372] >> anInt379 & 1;
        ++anInt379;
        anInt372 += anInt379 >> 3;
        anInt379 &= 7;
        return var0;
    }

    static int method396(int var0) {
        int var1 = 0;

        int var2;
        int var3;
        for (var2 = 0; var0 >= 8 - anInt379; var0 -= var3) {
            var3 = 8 - anInt379;
            int var4 = (1 << var3) - 1;
            var1 += (aByteArray572[anInt372] >> anInt379 & var4) << var2;
            anInt379 = 0;
            ++anInt372;
            var2 += var3;
        }

        if (var0 > 0) {
            var3 = (1 << var0) - 1;
            var1 += (aByteArray572[anInt372] >> anInt379 & var3) << var2;
            anInt379 += var0;
        }

        return var1;
    }

    static void method402(byte[] var0) {
        aByteArray572 = var0;
        anInt372 = 0;
        anInt379 = 0;
    }

    static boolean method401(ReferenceTable var0) {
        if (!aBoolean562) {
            byte[] var1 = var0.unpack(0, 0);
            if (var1 == null) {
                return false;
            }

            method393(var1);
            aBoolean562 = true;
        }

        return true;
    }

    static Node_Sub5 method399(ReferenceTable var0, int var1, int var2) {
        if (!method401(var0)) {
            var0.method913(var1, var2);
            return null;
        }
        byte[] var3 = var0.unpack(var1, var2);
        return var3 == null ? null : new Node_Sub5(var3);
    }

    static void method393(byte[] var0) {
        method402(var0);
        anInt564 = 1 << method396(4);
        anInt368 = 1 << method396(4);
        aFloatArray565 = new float[anInt368];

        int var1;
        int var2;
        int var3;
        int var4;
        int var5;
        for (var1 = 0; var1 < 2; ++var1) {
            var2 = var1 != 0 ? anInt368 : anInt564;
            var3 = var2 >> 1;
            var4 = var2 >> 2;
            var5 = var2 >> 3;
            float[] var6 = new float[var3];

            for (int var7 = 0; var7 < var4; ++var7) {
                var6[var7 * 2] = (float) Math.cos((double) (var7 * 4) * 3.141592653589793D / (double) var2);
                var6[var7 * 2 + 1] = -((float) Math.sin((double) (var7 * 4) * 3.141592653589793D / (double) var2));
            }

            float[] var8 = new float[var3];

            for (int var9 = 0; var9 < var4; ++var9) {
                var8[var9 * 2] = (float) Math.cos((double) (var9 * 2 + 1) * 3.141592653589793D / (double) (var2 * 2));
                var8[var9 * 2 + 1] = (float) Math.sin((double) (var9 * 2 + 1) * 3.141592653589793D / (double) (var2 * 2));
            }

            float[] var10 = new float[var4];

            for (int var11 = 0; var11 < var5; ++var11) {
                var10[var11 * 2] = (float) Math.cos((double) (var11 * 4 + 2) * 3.141592653589793D / (double) var2);
                var10[var11 * 2 + 1] = -((float) Math.sin((double) (var11 * 4 + 2) * 3.141592653589793D / (double) var2));
            }

            int[] var12 = new int[var5];
            int var13 = PickableNode.method726(var5 - 1);

            for (int var14 = 0; var14 < var5; ++var14) {
                int var17 = var14;
                int var18 = var13;

                int var19;
                for (var19 = 0; var18 > 0; --var18) {
                    var19 = var19 << 1 | var17 & 1;
                    var17 >>>= 1;
                }

                var12[var14] = var19;
            }

            if (var1 != 0) {
                aFloatArray558 = var6;
                aFloatArray581 = var8;
                aFloatArray577 = var10;
                anIntArray569 = var12;
            } else {
                aFloatArray559 = var6;
                aFloatArray567 = var8;
                aFloatArray566 = var10;
                anIntArray554 = var12;
            }
        }

        var1 = method396(8) + 1;
        aClass86Array557 = new Class86[var1];

        for (var2 = 0; var2 < var1; ++var2) {
            aClass86Array557[var2] = new Class86();
        }

        var2 = method396(6) + 1;

        for (var3 = 0; var3 < var2; ++var3) {
            method396(16);
        }

        var2 = method396(6) + 1;
        aClass101Array570 = new Class101[var2];

        for (var3 = 0; var3 < var2; ++var3) {
            aClass101Array570[var3] = new Class101();
        }

        var3 = method396(6) + 1;
        aClass93Array555 = new Class93[var3];

        for (var4 = 0; var4 < var3; ++var4) {
            aClass93Array555[var4] = new Class93();
        }

        var4 = method396(6) + 1;
        aClass94Array560 = new Class94[var4];

        for (var5 = 0; var5 < var4; ++var5) {
            aClass94Array560[var5] = new Class94();
        }

        var5 = method396(6) + 1;
        aBooleanArray578 = new boolean[var5];
        anIntArray576 = new int[var5];

        for (int var21 = 0; var21 < var5; ++var21) {
            aBooleanArray578[var21] = method397() != 0;
            method396(16);
            method396(16);
            anIntArray576[var21] = method396(8);
        }

    }

    static float method400(int var0) {
        int var1 = var0 & 2097151;
        int var2 = var0 & Integer.MIN_VALUE;
        int var3 = (var0 & 2145386496) >> 21;
        if (var2 != 0) {
            var1 = -var1;
        }

        return (float) ((double) var1 * Math.pow(2.0D, (double) (var3 - 788)));
    }

    void method395(byte[] var1) {
        Buffer var2 = new Buffer(var1);
        this.anInt568 = var2.readInt();
        this.anInt378 = var2.readInt();
        this.anInt377 = var2.readInt();
        this.anInt574 = var2.readInt();
        if (this.anInt574 < 0) {
            this.anInt574 = ~this.anInt574;
            this.aBoolean571 = true;
        }

        int var3 = var2.readInt();
        this.aByteArrayArray582 = new byte[var3][];

        for (int var4 = 0; var4 < var3; ++var4) {
            int var5 = 0;

            int var6;
            do {
                var6 = var2.readUByte();
                var5 += var6;
            } while (var6 >= 255);

            byte[] var7 = new byte[var5];
            var2.readBytes(var7, 0, var5);
            this.aByteArrayArray582[var4] = var7;
        }

    }

    Node_Sub10_Sub1 method398(int[] var1) {
        if (var1 != null && var1[0] <= 0) {
            return null;
        }
        if (this.aByteArray573 == null) {
            this.anInt563 = 0;
            this.aFloatArray580 = new float[anInt368];
            this.aByteArray573 = new byte[this.anInt378];
            this.anInt556 = 0;
            this.anInt579 = 0;
        }

        for (; this.anInt579 < this.aByteArrayArray582.length; ++this.anInt579) {
            if (var1 != null && var1[0] <= 0) {
                return null;
            }

            float[] var2 = this.method394(this.anInt579);
            if (var2 != null) {
                int var3 = this.anInt556;
                int var4 = var2.length;
                if (var4 > this.anInt378 - var3) {
                    var4 = this.anInt378 - var3;
                }

                for (int var5 = 0; var5 < var4; ++var5) {
                    int var6 = (int) (128.0F + var2[var5] * 128.0F);
                    if ((var6 & -256) != 0) {
                        var6 = ~var6 >> 31;
                    }

                    this.aByteArray573[var3++] = (byte) (var6 - 128);
                }

                if (var1 != null) {
                    var1[0] -= var3 - this.anInt556;
                }

                this.anInt556 = var3;
            }
        }

        this.aFloatArray580 = null;
        byte[] var7 = this.aByteArray573;
        this.aByteArray573 = null;
        return new Node_Sub10_Sub1(this.anInt568, var7, this.anInt377, this.anInt574, this.aBoolean571);
    }

    float[] method394(int var1) {
        method402(this.aByteArrayArray582[var1]);
        method397();
        int var2 = method396(PickableNode.method726(anIntArray576.length - 1));
        boolean var3 = aBooleanArray578[var2];
        int var4 = var3 ? anInt368 : anInt564;
        boolean var5 = false;
        boolean var6 = false;
        if (var3) {
            var5 = method397() != 0;
            var6 = method397() != 0;
        }

        int var7 = var4 >> 1;
        int var8;
        int var9;
        int var10;
        if (var3 && !var5) {
            var8 = (var4 >> 2) - (anInt564 >> 2);
            var9 = (anInt564 >> 2) + (var4 >> 2);
            var10 = anInt564 >> 1;
        } else {
            var8 = 0;
            var9 = var7;
            var10 = var4 >> 1;
        }

        int var11;
        int var12;
        int var13;
        if (var3 && !var6) {
            var11 = var4 - (var4 >> 2) - (anInt564 >> 2);
            var12 = (anInt564 >> 2) + (var4 - (var4 >> 2));
            var13 = anInt564 >> 1;
        } else {
            var11 = var7;
            var12 = var4;
            var13 = var4 >> 1;
        }

        Class94 var14 = aClass94Array560[anIntArray576[var2]];
        int var15 = var14.anInt708;
        int var16 = var14.anIntArray706[var15];
        boolean var17 = !aClass101Array570[var16].method557();

        for (var16 = 0; var16 < var14.anInt707; ++var16) {
            Class93 var18 = aClass93Array555[var14.anIntArray705[var16]];
            float[] var19 = aFloatArray565;
            var18.method501(var19, var4 >> 1, var17);
        }

        int var20;
        if (!var17) {
            var16 = var14.anInt708;
            var20 = var14.anIntArray706[var16];
            aClass101Array570[var20].method558(aFloatArray565, var4 >> 1);
        }

        int var22;
        if (var17) {
            for (var16 = var4 >> 1; var16 < var4; ++var16) {
                aFloatArray565[var16] = 0.0F;
            }
        } else {
            var16 = var4 >> 1;
            var20 = var4 >> 2;
            var22 = var4 >> 3;
            float[] var24 = aFloatArray565;

            int var25;
            for (var25 = 0; var25 < var16; ++var25) {
                var24[var25] *= 0.5F;
            }

            for (var25 = var16; var25 < var4; ++var25) {
                var24[var25] = -var24[var4 - var25 - 1];
            }

            float[] var26 = var3 ? aFloatArray558 : aFloatArray559;
            float[] var27 = var3 ? aFloatArray581 : aFloatArray567;
            float[] var28 = var3 ? aFloatArray577 : aFloatArray566;
            int[] var29 = var3 ? anIntArray569 : anIntArray554;

            int var30;
            float var31;
            float var32;
            float var33;
            float var34;
            for (var30 = 0; var30 < var20; ++var30) {
                var31 = var24[var30 * 4] - var24[var4 - var30 * 4 - 1];
                var32 = var24[var30 * 4 + 2] - var24[var4 - var30 * 4 - 3];
                var33 = var26[var30 * 2];
                var34 = var26[var30 * 2 + 1];
                var24[var4 - var30 * 4 - 1] = var31 * var33 - var32 * var34;
                var24[var4 - var30 * 4 - 3] = var31 * var34 + var32 * var33;
            }

            float var35;
            float var36;
            for (var30 = 0; var30 < var22; ++var30) {
                var31 = var24[var16 + var30 * 4 + 3];
                var32 = var24[var16 + var30 * 4 + 1];
                var33 = var24[var30 * 4 + 3];
                var34 = var24[var30 * 4 + 1];
                var24[var16 + var30 * 4 + 3] = var31 + var33;
                var24[var16 + var30 * 4 + 1] = var32 + var34;
                var35 = var26[var16 - 4 - var30 * 4];
                var36 = var26[var16 - 3 - var30 * 4];
                var24[var30 * 4 + 3] = (var31 - var33) * var35 - (var32 - var34) * var36;
                var24[var30 * 4 + 1] = (var32 - var34) * var35 + (var31 - var33) * var36;
            }

            var30 = PickableNode.method726(var4 - 1);

            int var47;
            int var48;
            int var49;
            int var50;
            for (var47 = 0; var47 < var30 - 3; ++var47) {
                var48 = var4 >> var47 + 2;
                var49 = 8 << var47;

                for (var50 = 0; var50 < 2 << var47; ++var50) {
                    int var51 = var4 - var48 * var50 * 2;
                    int var52 = var4 - var48 * (var50 * 2 + 1);

                    for (int var37 = 0; var37 < var4 >> var47 + 4; ++var37) {
                        int var38 = var37 * 4;
                        float var39 = var24[var51 - 1 - var38];
                        float var40 = var24[var51 - 3 - var38];
                        float var41 = var24[var52 - 1 - var38];
                        float var42 = var24[var52 - 3 - var38];
                        var24[var51 - 1 - var38] = var39 + var41;
                        var24[var51 - 3 - var38] = var40 + var42;
                        float var43 = var26[var37 * var49];
                        float var44 = var26[var37 * var49 + 1];
                        var24[var52 - 1 - var38] = (var39 - var41) * var43 - (var40 - var42) * var44;
                        var24[var52 - 3 - var38] = (var40 - var42) * var43 + (var39 - var41) * var44;
                    }
                }
            }

            for (var47 = 1; var47 < var22 - 1; ++var47) {
                var48 = var29[var47];
                if (var47 < var48) {
                    var49 = var47 * 8;
                    var50 = var48 * 8;
                    var35 = var24[var49 + 1];
                    var24[var49 + 1] = var24[var50 + 1];
                    var24[var50 + 1] = var35;
                    var35 = var24[var49 + 3];
                    var24[var49 + 3] = var24[var50 + 3];
                    var24[var50 + 3] = var35;
                    var35 = var24[var49 + 5];
                    var24[var49 + 5] = var24[var50 + 5];
                    var24[var50 + 5] = var35;
                    var35 = var24[var49 + 7];
                    var24[var49 + 7] = var24[var50 + 7];
                    var24[var50 + 7] = var35;
                }
            }

            for (var47 = 0; var47 < var16; ++var47) {
                var24[var47] = var24[var47 * 2 + 1];
            }

            for (var47 = 0; var47 < var22; ++var47) {
                var24[var4 - 1 - var47 * 2] = var24[var47 * 4];
                var24[var4 - 2 - var47 * 2] = var24[var47 * 4 + 1];
                var24[var4 - var20 - 1 - var47 * 2] = var24[var47 * 4 + 2];
                var24[var4 - var20 - 2 - var47 * 2] = var24[var47 * 4 + 3];
            }

            for (var47 = 0; var47 < var22; ++var47) {
                var32 = var28[var47 * 2];
                var33 = var28[var47 * 2 + 1];
                var34 = var24[var16 + var47 * 2];
                var35 = var24[var16 + var47 * 2 + 1];
                var36 = var24[var4 - 2 - var47 * 2];
                float var53 = var24[var4 - 1 - var47 * 2];
                float var54 = var33 * (var34 - var36) + var32 * (var35 + var53);
                var24[var16 + var47 * 2] = (var34 + var36 + var54) * 0.5F;
                var24[var4 - 2 - var47 * 2] = (var34 + var36 - var54) * 0.5F;
                var54 = var33 * (var35 + var53) - var32 * (var34 - var36);
                var24[var16 + var47 * 2 + 1] = (var35 - var53 + var54) * 0.5F;
                var24[var4 - 1 - var47 * 2] = (-var35 + var53 + var54) * 0.5F;
            }

            for (var47 = 0; var47 < var20; ++var47) {
                var24[var47] = var24[var16 + var47 * 2] * var27[var47 * 2] + var24[var16 + var47 * 2 + 1] * var27[var47 * 2 + 1];
                var24[var16 - 1 - var47] = var24[var16 + var47 * 2] * var27[var47 * 2 + 1] - var24[var16 + var47 * 2 + 1] * var27[var47 * 2];
            }

            for (var47 = 0; var47 < var20; ++var47) {
                var24[var47 + (var4 - var20)] = -var24[var47];
            }

            for (var47 = 0; var47 < var20; ++var47) {
                var24[var47] = var24[var20 + var47];
            }

            for (var47 = 0; var47 < var20; ++var47) {
                var24[var20 + var47] = -var24[var20 - var47 - 1];
            }

            for (var47 = 0; var47 < var20; ++var47) {
                var24[var16 + var47] = var24[var4 - var47 - 1];
            }

            float[] var10000;
            for (var47 = var8; var47 < var9; ++var47) {
                var32 = (float) Math.sin(((double) (var47 - var8) + 0.5D) / (double) var10 * 0.5D * 3.141592653589793D);
                var10000 = aFloatArray565;
                var10000[var47] *= (float) Math.sin(1.5707963267948966D * (double) var32 * (double) var32);
            }

            for (var47 = var11; var47 < var12; ++var47) {
                var32 = (float) Math.sin(((double) (var47 - var11) + 0.5D) / (double) var13 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
                var10000 = aFloatArray565;
                var10000[var47] *= (float) Math.sin(1.5707963267948966D * (double) var32 * (double) var32);
            }
        }

        float[] var21 = null;
        if (this.anInt563 > 0) {
            var20 = var4 + this.anInt563 >> 2;
            var21 = new float[var20];
            int var23;
            if (!this.aBoolean561) {
                for (var22 = 0; var22 < this.anInt575; ++var22) {
                    var23 = var22 + (this.anInt563 >> 1);
                    var21[var22] += this.aFloatArray580[var23];
                }
            }

            if (!var17) {
                for (var22 = var8; var22 < var4 >> 1; ++var22) {
                    var23 = var21.length - (var4 >> 1) + var22;
                    var21[var23] += aFloatArray565[var22];
                }
            }
        }

        float[] var46 = this.aFloatArray580;
        this.aFloatArray580 = aFloatArray565;
        aFloatArray565 = var46;
        this.anInt563 = var4;
        this.anInt575 = var12 - (var4 >> 1);
        this.aBoolean561 = var17;
        return var21;
    }
}
