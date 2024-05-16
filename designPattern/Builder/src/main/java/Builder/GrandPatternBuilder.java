package Builder;

public class GrandPatternBuilder extends PatternBuilder {
    @Override
    public void buildTile() {
        pattern.setTile("豪华地砖");
    }

    @Override
    public void buildCoat() {
        pattern.setCoat("豪华涂料");
    }

    @Override
    public void buildFloor() {
        pattern.setFloor("豪华地板");
    }

    @Override
    public void buildCeiling() {
        pattern.setCeiling("豪华吊顶");
    }
}
