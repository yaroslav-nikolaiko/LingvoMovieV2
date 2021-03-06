package lingvo.movie.entity.lookup;

/**
 * Created by yaroslav on 01.03.15.
 */
public enum Language implements LookupItem {
    en("English"),
    ru("Russian");

    String description;
    Language(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getName() {
        return name();
    }
}
