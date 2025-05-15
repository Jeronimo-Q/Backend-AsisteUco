package co.edu.uco.asistenciauco.crosscutting.helpers;

import static co.edu.uco.asistenciauco.crosscutting.helpers.ObjectHelper.getObjectHelper;

public final class TextHelper {

    public static final String EMPTY = "";
    public static final String UNDERLINE = "_";

    private TextHelper() {
        super();
    }

    public static final boolean isNull(final String string) {
        return getObjectHelper().isNull(string);
    }

    public static final String getDefault(final String string, final String defaultValue) {
        return getObjectHelper().getDefault(string, defaultValue);
    }

    public static final String getDefault(final String string) {
        return getDefault(string, EMPTY);
    }

    public static boolean isEmpty(final String string) {
        return EMPTY.equals(getDefault(string));
    }

    public static boolean isEmptyApplyingTrim(final String string) {
        return isEmpty(applyTrim(string));
    }

    public static final String applyTrim(final String string) {
        return getDefault(string).trim();
    }

    public static final boolean isNullOrEmpty(final String string) {
        return isNull(string) || EMPTY.equals(applyTrim(string));
    }

    public static final String concatenate(final String... strings) {
        final var sb = new StringBuilder(EMPTY);

        if (!getObjectHelper().isNull(strings)) {
            for (final var string : strings) {
                sb.append(applyTrim(string));
            }
        }

        return sb.toString();
    }

}
