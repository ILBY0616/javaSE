package Builder;

import Product.Pattern;

public abstract class PatternBuilder {
    protected Pattern pattern = new Pattern();

    public abstract void buildTile();

    public abstract void buildCoat();

    public abstract void buildFloor();

    public abstract void buildCeiling();

    public Pattern getPattern() {
        return pattern;
    }
}
