package Builder;

public class PastoralPatternBuilder extends PatternBuilder {
    @Override
    public void buildTile() {
        pattern.setTile("田园地砖");
    }

    @Override
    public void buildCoat() {
        pattern.setCoat("田园涂料");
    }

    @Override
    public void buildFloor() {
        pattern.setFloor("田园地板");
    }

    @Override
    public void buildCeiling() {
        pattern.setCeiling("田园吊顶");
    }
}
