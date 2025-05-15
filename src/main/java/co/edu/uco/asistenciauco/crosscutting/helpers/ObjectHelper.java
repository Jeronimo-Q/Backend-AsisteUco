package co.edu.uco.asistenciauco.crosscutting.helpers;

public final class ObjectHelper {

    private static final ObjectHelper instance = new ObjectHelper();

    private ObjectHelper() {
        super();
    }

    public static ObjectHelper getObjectHelper() {
        return instance;
    }

    public static <T> boolean isNull(final T object) {
        return object == null;
    }

    public static <T> T getDefault(final T object, final T defaultObject) {
        return isNull(object) ? defaultObject : object;
    }
}

