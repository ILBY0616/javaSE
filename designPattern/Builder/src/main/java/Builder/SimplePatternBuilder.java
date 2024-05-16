package Builder;

public class SimplePatternBuilder extends PatternBuilder {

    @Override
    public void buildTile() {
        pattern.setTile("简约地砖");
    }

    @Override
    public void buildCoat() {
        pattern.setCoat("简约涂料");
    }

    @Override
    public void buildFloor() {
        pattern.setFloor("简约地板");
    }

    @Override
    public void buildCeiling() {
        pattern.setCeiling("简约吊顶");
    }
}
