package Director;

import Builder.PatternBuilder;
import Product.Pattern;

public class PatternDirector {
    private PatternBuilder patternBuilder;

    public void setPatternBuilder(PatternBuilder patternBuilder) {
        this.patternBuilder = patternBuilder;
    }

    public Pattern constructPattern() {
        patternBuilder.buildTile();
        patternBuilder.buildCoat();
        patternBuilder.buildFloor();
        patternBuilder.buildCeiling();
        return patternBuilder.getPattern();
    }

}
