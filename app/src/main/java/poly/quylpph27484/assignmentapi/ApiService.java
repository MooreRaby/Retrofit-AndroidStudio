package poly.quylpph27484.assignmentapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("albums")
    Call<List<Albums>> getUsers( @Query("userId") int userId);

    @GET("albums")
    Call<List<Albums>> filter( @Query("title") int title);


}