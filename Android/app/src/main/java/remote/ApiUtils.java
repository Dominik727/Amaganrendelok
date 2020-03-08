package remote;

public class ApiUtils {

    public static final String BASE_URL = "http://maganrendelo.herokuapp.com/";

    public static UserService getUserService() {
        return RetrofitClient.getClient(BASE_URL).create(UserService.class);
    }
}
