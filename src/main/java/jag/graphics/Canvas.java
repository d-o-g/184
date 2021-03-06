package jag.graphics;

import jag.Vertex;
import jag.audi.DefaultAudioSystemProvider;
import jag.game.stockmarket.StockMarketOfferNameComparator;
import jag.game.type.ItemDefinition;
import jag.js5.ReferenceTable;
import jag.opcode.ClassStructure;
import jag.statics.Statics5;
import jag.worldmap.WorldMapIcon_Sub2;

import java.awt.*;

public final class Canvas extends java.awt.Canvas {

    public final Component aComponent793;

    public Canvas(Component var1) {
        this.aComponent793 = var1;
    }

    public static Sprite[] method643(ReferenceTable var0, int var1, int var2) {
        return !Vertex.method534(var0, var1, var2) ? null : Sprite.method194();
    }

    public static void method640(String var0, boolean var1) {
        var0 = var0.toLowerCase();
        short[] var2 = new short[16];
        int var3 = 0;

        for (int var4 = 0; var4 < Statics5.anInt838; ++var4) {
            ItemDefinition var5 = ItemDefinition.get(var4);
            if ((!var1 || var5.stockMarketable) && var5.noteTemplateId == -1 && var5.name.toLowerCase().contains(var0)) {
                if (var3 >= 250) {
                    DefaultAudioSystemProvider.anInt142 = -1;
                    WorldMapIcon_Sub2.grandExchangeSearchResults = null;
                    return;
                }

                if (var3 >= var2.length) {
                    short[] var8 = new short[var2.length * 2];

                    System.arraycopy(var2, 0, var8, 0, var3);

                    var2 = var8;
                }

                var2[var3++] = (short) var4;
            }
        }

        WorldMapIcon_Sub2.grandExchangeSearchResults = var2;
        ClassStructure.anInt748 = 0;
        DefaultAudioSystemProvider.anInt142 = var3;
        String[] var6 = new String[DefaultAudioSystemProvider.anInt142];

        for (int var7 = 0; var7 < DefaultAudioSystemProvider.anInt142; ++var7) {
            var6[var7] = ItemDefinition.get(var2[var7]).name;
        }

        short[] var10 = WorldMapIcon_Sub2.grandExchangeSearchResults;
        StockMarketOfferNameComparator.method328(var6, var10, 0, var6.length - 1);
    }

    public final void update(Graphics var1) {
        this.aComponent793.update(var1);
    }

    public final void paint(Graphics var1) {
        this.aComponent793.paint(var1);
    }
}
