package com.jagex;

import java.util.Iterator;

public final class IterableNodeTable implements Iterable {
    int size;
    int index;
    Node[] buckets;
    Node tail;
    Node head;

    public IterableNodeTable(int var1) {
        this.index = 0;
        this.size = var1;
        this.buckets = new Node[var1];

        for (int var2 = 0; var2 < var1; ++var2) {
            Node var3 = this.buckets[var2] = new Node();
            var3.next = var3;
            var3.previous = var3;
        }

    }

    static String getStringParameter(IterableNodeTable var0, int var1, String var2) {
        if (var0 == null) {
            return var2;
        }
        ObjectNode var3 = (ObjectNode) var0.lookup((long) var1);
        return var3 == null ? var2 : (String) var3.value;
    }

    public Node lookup(long key) {
        Node var3 = this.buckets[(int) (key & (long) (this.size - 1))];

        for (this.head = var3.next; var3 != this.head; this.head = this.head.next) {
            if (this.head.key == key) {
                Node var4 = this.head;
                this.head = this.head.next;
                return var4;
            }
        }

        this.head = null;
        return null;
    }

    public Node method234() {
        Node var1;
        if (this.index > 0 && this.buckets[this.index - 1] != this.tail) {
            var1 = this.tail;
            this.tail = var1.next;
            return var1;
        }
        do {
            if (this.index >= this.size) {
                return null;
            }

            var1 = this.buckets[this.index++].next;
        } while (var1 == this.buckets[this.index - 1]);

        this.tail = var1.next;
        return var1;
    }

    public void method236() {
        for (int var1 = 0; var1 < this.size; ++var1) {
            Node var2 = this.buckets[var1];

            while (true) {
                Node var3 = var2.next;
                if (var3 == var2) {
                    break;
                }

                var3.unlink();
            }
        }

        this.head = null;
        this.tail = null;
    }

    public void method237(Node var1, long var2) {
        if (var1.previous != null) {
            var1.unlink();
        }

        Node var4 = this.buckets[(int) (var2 & (long) (this.size - 1))];
        var1.previous = var4.previous;
        var1.next = var4;
        var1.previous.next = var1;
        var1.next.previous = var1;
        var1.key = var2;
    }

    public Iterator iterator() {
        return new IterableNodeTableIterator(this);
    }

    public Node method235() {
        this.index = 0;
        return this.method234();
    }
}
