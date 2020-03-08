package remote;

import model.Resobj;
import retrofit2.Call;
import retrofit2.http.GET;

public interface UserService {

    @GET("login/{username}/{password}")
    Call login(@Path("username") String username, @Path("password") String password);

}
