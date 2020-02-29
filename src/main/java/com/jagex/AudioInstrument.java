package com.jagex;

import java.util.Random;

public class AudioInstrument {
    static int[] anIntArray1791;
    static int[] anIntArray1776;
    static int[] anIntArray1777;
    static int[] anIntArray1775;
    static int[] anIntArray1778;
    static int[] anIntArray1773;
    static int[] anIntArray1780;
    static int[] anIntArray1779;

    static {
        anIntArray1791 = new int[32768];
        Random var0 = new Random(0L);

        int var1;
        for (var1 = 0; var1 < 32768; ++var1) {
            anIntArray1791[var1] = (var0.nextInt() & 2) - 1;
        }

        anIntArray1777 = new int[32768];

        for (var1 = 0; var1 < 32768; ++var1) {
            anIntArray1777[var1] = (int) (Math.sin((double) var1 / 5215.1903D) * 16384.0D);
        }

        anIntArray1776 = new int[220500];
        anIntArray1775 = new int[5];
        anIntArray1778 = new int[5];
        anIntArray1773 = new int[5];
        anIntArray1780 = new int[5];
        anIntArray1779 = new int[5];
    }

    AudioEnvelope pitchEnvelope;
    int[] anIntArray1792;
    int anInt1790;
    int anInt1787;
    AudioEnvelope anAudioEnvelope1782;
    int[] oscillatorPitch;
    AudioEnvelope anAudioEnvelope1789;
    AudioEnvelope anAudioEnvelope1786;
    AudioEnvelope anAudioEnvelope1788;
    int[] anIntArray1772;
    AudioEnvelope anAudioEnvelope1784;
    int anInt1771;
    int anInt1783;
    AudioEnvelope anAudioEnvelope1785;
    AudioEnvelope anAudioEnvelope1781;
    Class99 aClass99_1770;
    AudioEnvelope anAudioEnvelope1774;

    AudioInstrument() {
        this.anIntArray1792 = new int[]{0, 0, 0, 0, 0};
        this.oscillatorPitch = new int[]{0, 0, 0, 0, 0};
        this.anIntArray1772 = new int[]{0, 0, 0, 0, 0};
        this.anInt1771 = 0;
        this.anInt1783 = 100;
        this.anInt1790 = 500;
        this.anInt1787 = 0;
    }

    final void method1298(Buffer var1) {
        this.pitchEnvelope = new AudioEnvelope();
        this.pitchEnvelope.method1511(var1);
        this.anAudioEnvelope1782 = new AudioEnvelope();
        this.anAudioEnvelope1782.method1511(var1);
        int var2 = var1.readUByte();
        if (var2 != 0) {
            --var1.caret;
            this.anAudioEnvelope1789 = new AudioEnvelope();
            this.anAudioEnvelope1789.method1511(var1);
            this.anAudioEnvelope1788 = new AudioEnvelope();
            this.anAudioEnvelope1788.method1511(var1);
        }

        var2 = var1.readUByte();
        if (var2 != 0) {
            --var1.caret;
            this.anAudioEnvelope1786 = new AudioEnvelope();
            this.anAudioEnvelope1786.method1511(var1);
            this.anAudioEnvelope1784 = new AudioEnvelope();
            this.anAudioEnvelope1784.method1511(var1);
        }

        var2 = var1.readUByte();
        if (var2 != 0) {
            --var1.caret;
            this.anAudioEnvelope1785 = new AudioEnvelope();
            this.anAudioEnvelope1785.method1511(var1);
            this.anAudioEnvelope1781 = new AudioEnvelope();
            this.anAudioEnvelope1781.method1511(var1);
        }

        for (int var3 = 0; var3 < 10; ++var3) {
            int var4 = var1.readSmart();
            if (var4 == 0) {
                break;
            }

            this.anIntArray1792[var3] = var4;
            this.oscillatorPitch[var3] = var1.method1046();
            this.anIntArray1772[var3] = var1.readSmart();
        }

        this.anInt1771 = var1.readSmart();
        this.anInt1783 = var1.readSmart();
        this.anInt1790 = var1.readUShort();
        this.anInt1787 = var1.readUShort();
        this.aClass99_1770 = new Class99();
        this.anAudioEnvelope1774 = new AudioEnvelope();
        this.aClass99_1770.method547(var1, this.anAudioEnvelope1774);
    }

    final int[] method1299(int var1, int var2) {
        Statics31.method1139(anIntArray1776, 0, var1);
        if (var2 < 10) {
            return anIntArray1776;
        }
        double var3 = (double) var1 / ((double) var2 + 0.0D);
        this.pitchEnvelope.method1510();
        this.anAudioEnvelope1782.method1510();
        int var5 = 0;
        int var6 = 0;
        int var7 = 0;
        if (this.anAudioEnvelope1789 != null) {
            this.anAudioEnvelope1789.method1510();
            this.anAudioEnvelope1788.method1510();
            var5 = (int) ((double) (this.anAudioEnvelope1789.end - this.anAudioEnvelope1789.start) * 32.768D / var3);
            var6 = (int) ((double) this.anAudioEnvelope1789.start * 32.768D / var3);
        }

        int var8 = 0;
        int var9 = 0;
        int var10 = 0;
        if (this.anAudioEnvelope1786 != null) {
            this.anAudioEnvelope1786.method1510();
            this.anAudioEnvelope1784.method1510();
            var8 = (int) ((double) (this.anAudioEnvelope1786.end - this.anAudioEnvelope1786.start) * 32.768D / var3);
            var9 = (int) ((double) this.anAudioEnvelope1786.start * 32.768D / var3);
        }

        int var11;
        for (var11 = 0; var11 < 5; ++var11) {
            if (this.anIntArray1792[var11] != 0) {
                anIntArray1775[var11] = 0;
                anIntArray1778[var11] = (int) ((double) this.anIntArray1772[var11] * var3);
                anIntArray1773[var11] = (this.anIntArray1792[var11] << 14) / 100;
                anIntArray1780[var11] = (int) ((double) (this.pitchEnvelope.end - this.pitchEnvelope.start) * 32.768D * Math.pow(1.0057929410678534D, (double) this.oscillatorPitch[var11]) / var3);
                anIntArray1779[var11] = (int) ((double) this.pitchEnvelope.start * 32.768D / var3);
            }
        }

        int var12;
        int var13;
        int var14;
        int var15;
        int[] var10000;
        for (var11 = 0; var11 < var1; ++var11) {
            var12 = this.pitchEnvelope.method1509(var1);
            var13 = this.anAudioEnvelope1782.method1509(var1);
            if (this.anAudioEnvelope1789 != null) {
                var14 = this.anAudioEnvelope1789.method1509(var1);
                var15 = this.anAudioEnvelope1788.method1509(var1);
                var12 += this.method1300(var7, var15, this.anAudioEnvelope1789.anInt2027) >> 1;
                var7 = var7 + var6 + (var14 * var5 >> 16);
            }

            if (this.anAudioEnvelope1786 != null) {
                var14 = this.anAudioEnvelope1786.method1509(var1);
                var15 = this.anAudioEnvelope1784.method1509(var1);
                var13 = var13 * ((this.method1300(var10, var15, this.anAudioEnvelope1786.anInt2027) >> 1) + 32768) >> 15;
                var10 = var10 + var9 + (var14 * var8 >> 16);
            }

            for (var14 = 0; var14 < 5; ++var14) {
                if (this.anIntArray1792[var14] != 0) {
                    var15 = anIntArray1778[var14] + var11;
                    if (var15 < var1) {
                        var10000 = anIntArray1776;
                        var10000[var15] += this.method1300(anIntArray1775[var14], var13 * anIntArray1773[var14] >> 15, this.pitchEnvelope.anInt2027);
                        var10000 = anIntArray1775;
                        var10000[var14] += (var12 * anIntArray1780[var14] >> 16) + anIntArray1779[var14];
                    }
                }
            }
        }

        int var16;
        if (this.anAudioEnvelope1785 != null) {
            this.anAudioEnvelope1785.method1510();
            this.anAudioEnvelope1781.method1510();
            var11 = 0;
            boolean var20 = true;

            for (var14 = 0; var14 < var1; ++var14) {
                var15 = this.anAudioEnvelope1785.method1509(var1);
                var16 = this.anAudioEnvelope1781.method1509(var1);
                if (var20) {
                    var12 = (var15 * (this.anAudioEnvelope1785.end - this.anAudioEnvelope1785.start) >> 8) + this.anAudioEnvelope1785.start;
                } else {
                    var12 = (var16 * (this.anAudioEnvelope1785.end - this.anAudioEnvelope1785.start) >> 8) + this.anAudioEnvelope1785.start;
                }

                var11 += 256;
                if (var11 >= var12) {
                    var11 = 0;
                    var20 = !var20;
                }

                if (var20) {
                    anIntArray1776[var14] = 0;
                }
            }
        }

        if (this.anInt1771 > 0 && this.anInt1783 > 0) {
            var11 = (int) ((double) this.anInt1771 * var3);

            for (var12 = var11; var12 < var1; ++var12) {
                var10000 = anIntArray1776;
                var10000[var12] += anIntArray1776[var12 - var11] * this.anInt1783 / 100;
            }
        }

        if (this.aClass99_1770.anIntArray743[0] > 0 || this.aClass99_1770.anIntArray743[1] > 0) {
            this.anAudioEnvelope1774.method1510();
            var11 = this.anAudioEnvelope1774.method1509(var1 + 1);
            var12 = this.aClass99_1770.method548(0, (float) var11 / 65536.0F);
            var13 = this.aClass99_1770.method548(1, (float) var11 / 65536.0F);
            if (var1 >= var12 + var13) {
                var14 = 0;
                var15 = var13;
                if (var13 > var1 - var12) {
                    var15 = var1 - var12;
                }

                int var17;
                while (var14 < var15) {
                    var16 = (int) ((long) anIntArray1776[var14 + var12] * (long) Class99.anInt742 >> 16);

                    for (var17 = 0; var17 < var12; ++var17) {
                        var16 += (int) ((long) anIntArray1776[var14 + var12 - 1 - var17] * (long) Class99.anIntArrayArray738[0][var17] >> 16);
                    }

                    for (var17 = 0; var17 < var14; ++var17) {
                        var16 -= (int) ((long) anIntArray1776[var14 - 1 - var17] * (long) Class99.anIntArrayArray738[1][var17] >> 16);
                    }

                    anIntArray1776[var14] = var16;
                    var11 = this.anAudioEnvelope1774.method1509(var1 + 1);
                    ++var14;
                }

                var15 = 128;

                while (true) {
                    if (var15 > var1 - var12) {
                        var15 = var1 - var12;
                    }

                    int var18;
                    while (var14 < var15) {
                        var17 = (int) ((long) anIntArray1776[var14 + var12] * (long) Class99.anInt742 >> 16);

                        for (var18 = 0; var18 < var12; ++var18) {
                            var17 += (int) ((long) anIntArray1776[var14 + var12 - 1 - var18] * (long) Class99.anIntArrayArray738[0][var18] >> 16);
                        }

                        for (var18 = 0; var18 < var13; ++var18) {
                            var17 -= (int) ((long) anIntArray1776[var14 - 1 - var18] * (long) Class99.anIntArrayArray738[1][var18] >> 16);
                        }

                        anIntArray1776[var14] = var17;
                        var11 = this.anAudioEnvelope1774.method1509(var1 + 1);
                        ++var14;
                    }

                    if (var14 >= var1 - var12) {
                        while (var14 < var1) {
                            var17 = 0;

                            for (var18 = var14 + var12 - var1; var18 < var12; ++var18) {
                                var17 += (int) ((long) anIntArray1776[var14 + var12 - 1 - var18] * (long) Class99.anIntArrayArray738[0][var18] >> 16);
                            }

                            for (var18 = 0; var18 < var13; ++var18) {
                                var17 -= (int) ((long) anIntArray1776[var14 - 1 - var18] * (long) Class99.anIntArrayArray738[1][var18] >> 16);
                            }

                            anIntArray1776[var14] = var17;
                            this.anAudioEnvelope1774.method1509(var1 + 1);
                            ++var14;
                        }
                        break;
                    }

                    var12 = this.aClass99_1770.method548(0, (float) var11 / 65536.0F);
                    var13 = this.aClass99_1770.method548(1, (float) var11 / 65536.0F);
                    var15 += 128;
                }
            }
        }

        for (var11 = 0; var11 < var1; ++var11) {
            if (anIntArray1776[var11] < -32768) {
                anIntArray1776[var11] = -32768;
            }

            if (anIntArray1776[var11] > 32767) {
                anIntArray1776[var11] = 32767;
            }
        }

        return anIntArray1776;
    }

    final int method1300(int var1, int var2, int var3) {
        if (var3 == 1) {
            return (var1 & 32767) < 16384 ? var2 : -var2;
        }
        if (var3 == 2) {
            return anIntArray1777[var1 & 32767] * var2 >> 14;
        }
        if (var3 == 3) {
            return (var2 * (var1 & 32767) >> 14) - var2;
        }
        return var3 == 4 ? var2 * anIntArray1791[var1 / 2607 & 32767] : 0;
    }
}
