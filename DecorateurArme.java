public abstract class DecorateurArme implements Soldat {

    public int durabilit√© = 0;

    protected Soldat soldat;

    public abstract int force();

    public abstract boolean parer(int force);

    public abstract int getDurability();
}