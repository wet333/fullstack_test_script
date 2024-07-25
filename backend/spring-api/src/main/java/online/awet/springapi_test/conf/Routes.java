package online.awet.springapi_test.conf;

public class Routes {

    public static final String PUBLIC = "/";
    public static final String PRIVATE = "/private";

    // Auth Endpoints
    public static final String AUTH_REGISTER = "/register";
    public static final String AUTH_LOGIN = "/login";
    public static final String AUTH_LOGOUT = PRIVATE + "/logout";
    public static final String AUTH_UNREGISTER = PRIVATE + "/unregister";
    public static final String AUTH_USER = PRIVATE + "/user";

    // Test Endpoints
    public static final String TEST = "/test";
    public static final String HOME = "/home";

}
